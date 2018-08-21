package com.techelevator.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.techelevator.model.dao.ToolDAO;
import com.techelevator.model.dao.UserDAO;
import com.techelevator.model.domain.User;


@SessionAttributes({"userName", "currentUser", "shoppingCart", "member", "confNum"})


@Controller
public class AuthenticationController {

	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private ToolDAO toolDAO;

	@RequestMapping(path="/login", method=RequestMethod.GET)
	public String displayLoginForm() {

		return "login";
	}
	
	@RequestMapping(path="/login", method=RequestMethod.POST)
	public String login(@RequestParam String userName, 
						@RequestParam String password, 
						@RequestParam(required=false) String destination,
						HttpSession session,
						RedirectAttributes redirectAttribute) {
		redirectAttribute.addFlashAttribute("loginFail", false);
		
		
		
		if(userDAO.searchForUsernameAndPassword(userName, password)) {
			session.setAttribute("currentUser", userDAO.getUserByUserName(userName));
			
			if(destination != null && ! destination.isEmpty()) {
				return "redirect:" + destination;
			} else {
				return "redirect:/";
			}
		} else {
			redirectAttribute.addFlashAttribute("loginFail", true);
			return "redirect:/login";
		}
	}

	@RequestMapping(path="/logout", method=RequestMethod.GET)
	public String logout(ModelMap model, HttpSession session) {
		
		//model.remove("currentUser");
	
		return "redirect:/";
	}
}
