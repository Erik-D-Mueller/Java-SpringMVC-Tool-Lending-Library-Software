package com.techelevator.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.ui.ModelMap;

import com.techelevator.model.dao.ReservationDAO;
import com.techelevator.model.dao.ToolDAO;
import com.techelevator.model.domain.Member;
import com.techelevator.model.domain.ShoppingCart;

@Controller

@SessionAttributes({"userName", "currentUser", "shoppingCart", "member", "confNum"})


public class CheckoutController {
	
	@Autowired
	private ReservationDAO reservationDAO;
	
	@Autowired
	private ToolDAO toolDAO;
	
	@RequestMapping(path="/checkOut", method=RequestMethod.POST)
	public String checkOut(HttpSession session, ModelMap model) {
		
		ShoppingCart cart = (ShoppingCart)model.get("shoppingCart");

		int memberId = ((Member)model.get("member")).getMemberId();
				
		int confirmationNum = reservationDAO.saveNewReservation(cart, memberId);
		
		model.addAttribute("confNum", confirmationNum);
				
		return "redirect:/checkoutConfirmation";
	}

	@RequestMapping(path="/checkoutConfirmation", method=RequestMethod.GET)
	
	

	

public String confirmCheckout(HttpSession session, HttpServletRequest request, ModelMap model) {		
		
		
		String name = ((Member)model.get("member")).getMemberName();
		request.setAttribute("memberName", name);
		
		// model.remove("member") doesn't work, so instead I have to "overwrite" in order to clear the member off of "currently serving" after they're checked out
		Member member = new Member();
		model.addAttribute("member", member);

		// I want to erase the items in the shopping cart after the car has been checked out, for some reason model.remove() is not working, so I'm "overwriting" instead
		ShoppingCart cart = new ShoppingCart();
		model.addAttribute(cart);		
		






		request.setAttribute("confNum", model.get("confNum"));
		request.setAttribute("reservations", toolDAO.getToolsByReservationId((int)model.get("confNum")));
		
		return "checkoutConfirmation";
	}

}
