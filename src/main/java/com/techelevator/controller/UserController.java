package com.techelevator.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.techelevator.model.dao.ToolDAO;
import com.techelevator.model.dao.UserDAO;
import com.techelevator.model.domain.User;


@SessionAttributes({"userName", "currentUser", "shoppingCart", "member", "confNum"})

@Controller
public class UserController {

	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private ToolDAO toolDAO;

	@RequestMapping(path = "/users/new", method = RequestMethod.GET)
	public String displayNewUserForm(ModelMap modelHolder) {
		if (!modelHolder.containsAttribute("user")) {
			modelHolder.addAttribute("user", new User());
		}
		return "newUser";
	}

	@RequestMapping(path = "/users", method = RequestMethod.POST)
	public String createUser(@Valid @ModelAttribute User user, BindingResult result, RedirectAttributes flash) {
		if (result.hasErrors()) {
			flash.addFlashAttribute("user", user);
			flash.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "user", result);
			return "redirect:/users/new";
		}

		userDAO.saveUser(user.getUserName(), user.getPassword(), user.getDriversLicense(), user.getRole());
		return "redirect:/login";
	}
	
	@RequestMapping(path = "/userProfile", method = RequestMethod.GET)
	public String viewUserProfile(HttpSession session, HttpServletRequest request) {
		User userInSession = (User) session.getAttribute("currentUser");
		System.out.println(userInSession.getDriversLicense());
		request.setAttribute("listOfTools", 
				toolDAO.getToolsCheckedOutToMemberByName(userInSession.getUserName()));
		
		return "userProfile";
	}
	
	@RequestMapping(path = "/changeDL", method = RequestMethod.POST)
	public String changeDriversLicense(HttpServletRequest request, HttpSession session) {
		User userInSession = (User) session.getAttribute("currentUser");
		String newDriverLicense = (String) request.getParameter("newDL");
		
//		System.out.println("Your user in session is " + userInSession.getUserName());
//		System.out.println("Your new driver's license is " + newDriverLicense);
	
		userDAO.updateDL(userInSession.getUserName(), newDriverLicense);
		
		return "redirect:/confirmProfileChange";
	}
	
	@RequestMapping(path = "/changePassword", method = RequestMethod.POST)
	public String changePassword(HttpServletRequest request, HttpSession session) {
		User userInSession = (User) session.getAttribute("currentUser");
		
		//changed newPasswordJSP to password
		String newPassword = (String) request.getParameter("password");
		
//		System.out.println("Your user in session is " + userInSession.getUserName());
//		System.out.println("Your password is " + newPassword);
		
		userDAO.updatePassword(userInSession.getUserName(), newPassword);
		
		return "redirect:/confirmProfileChange";
	}
	
	@RequestMapping(path = "/confirmProfileChange", method = RequestMethod.GET)
	public String confirmProfileChange(HttpServletRequest request, HttpSession session, ModelMap model) {
		
		User userInSession = (User) session.getAttribute("currentUser");
//		System.out.println(userInSession.getDriversLicense());
		User updatedUser = userDAO.getUserByUserName(userInSession.getUserName());
//		System.out.println(updatedUser.getDriversLicense());
		session.removeAttribute("currentUser");
		model.addAttribute("currentUser", updatedUser);
//		session.setAttribute("currentUser", updatedUser);
		
		return "profileChangeConfirmation";
	}

}
