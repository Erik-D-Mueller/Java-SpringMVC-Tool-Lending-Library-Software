package com.techelevator.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.ui.ModelMap;

import com.techelevator.model.dao.ReservationDAO;
import com.techelevator.model.domain.Reservation;
import com.techelevator.model.domain.ShoppingCart;
import com.techelevator.model.domain.Tool;

@Controller
@SessionAttributes({"confNum", "reservation", "member", "memberName", "shoppingCart"})
public class CheckoutController {
	
	@Autowired
	private ReservationDAO reservationDAO;
	
	@RequestMapping(path="/checkOut", method=RequestMethod.POST)
	public String checkOut(HttpSession session, ModelMap model) {
		
		ShoppingCart cart = getActiveShoppingCart(model);
		
		List<Tool> tools = cart.getItems();
		
		Reservation reservation = new Reservation();
		
		reservation.setItems(tools);
		
		Integer memberId =  Integer.parseInt((String) model.get("member"));
				
		reservation.setApp_user_id(memberId);

		int confirmationNum = reservationDAO.saveNewReservation(reservation);
		
		model.addAttribute("confNum", confirmationNum);
		model.addAttribute("reservation", reservation);
		
		return "redirect:/checkoutConfirmation";
	}

	@RequestMapping(path="/checkoutConfirmation", method=RequestMethod.GET)
	public String confirmCheckout(HttpSession session, HttpServletRequest request, ModelMap model) {		
		
		request.setAttribute("memberName", model.get("memberName"));
		request.setAttribute("confNum", model.get("confNum"));
		request.setAttribute("reservations", reservationDAO.searchReservationsByReservationNumber((int)model.get("confNum")));
		
		session.invalidate();
		model.clear();
		
		return "checkoutConfirmation";
	}
	
	private ShoppingCart getActiveShoppingCart(ModelMap model) {
		if(model.get("shoppingCart") == null) {
			model.addAttribute("shoppingCart", new ShoppingCart());
		}
		return (ShoppingCart)model.get("shoppingCart");
	}
	
}
