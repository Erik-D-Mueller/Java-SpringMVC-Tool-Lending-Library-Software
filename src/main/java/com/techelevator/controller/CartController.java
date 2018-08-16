package com.techelevator.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.ui.ModelMap;

import com.techelevator.model.dao.MemberDAO;
import com.techelevator.model.dao.ToolDAO;
import com.techelevator.model.domain.Member;
import com.techelevator.model.domain.ShoppingCart;
import com.techelevator.model.domain.Tool;

@Controller
@SessionAttributes({"member", "memberName"})
public class CartController {
	
	Member member;

	@Autowired
	private MemberDAO memberDAO;
	
	@Autowired
	private ToolDAO toolDAO;
	
	@RequestMapping(path="/chooseMember", method=RequestMethod.GET)
	public String choseMemberAndRedirect(HttpServletRequest request, ModelMap map) {
				
		map.addAttribute("member", request.getParameter("memberId"));
		map.addAttribute("memberName", memberDAO.getMemberById(Integer.parseInt(request.getParameter("memberId"))).getUserName());
		
		return "redirect:/availableToolList";
	}
	
	@RequestMapping(path="/viewCart", method=RequestMethod.GET)
	public String viewCart(HttpServletRequest request, ModelMap map) {
//		Tool toolToAdd = toolDAO.getToolById(request.getAttribute("tool_id"));
//		ShoppingCart newShoppingCart = ShoppingCart.add(toolToAdd);
//		map.put("shoppingCart", request.getAttribute("tool_id"));		
		return "viewCart";
	}
	
	@RequestMapping(path="/checkoutConfirmation", method=RequestMethod.POST)
	public String confirmCheckout(HttpServletRequest request, ModelMap map) {
		
		map.remove("member");
		
		return "checkoutConfirmation";
	}
	
	
}
