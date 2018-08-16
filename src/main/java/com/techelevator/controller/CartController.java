package com.techelevator.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.ui.ModelMap;

import com.techelevator.model.dao.MemberDAO;
import com.techelevator.model.domain.Member;

@Controller
@SessionAttributes({"member"})
public class CartController {
	
	Member member;

	@Autowired
	private MemberDAO memberDAO;
	
	@RequestMapping(path="/chooseMember", method=RequestMethod.GET)
	public String choseMemberAndRedirect(HttpServletRequest request, ModelMap map) {
				
		map.addAttribute("member", request.getParameter("memberId"));
				
		return "redirect:/availableToolList";
	}
	
	@RequestMapping(path="/viewCart", method=RequestMethod.GET)
	public String viewCart(HttpServletRequest request, ModelMap map) {
				
		return "viewCart";
	}
	
	@RequestMapping(path="/checkoutConfirmation", method=RequestMethod.POST)
	public String confirmCheckout(HttpServletRequest request, ModelMap map) {
		
		map.remove("member");
		return "checkoutConfirmation";
	}
	
	
}
