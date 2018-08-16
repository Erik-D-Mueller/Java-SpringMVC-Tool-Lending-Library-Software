package com.techelevator.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.techelevator.model.dao.ReservationDAO;
import com.techelevator.model.domain.Reservation;
import com.techelevator.model.domain.ShoppingCart;
import com.techelevator.model.domain.Tool;


@Controller
@SessionAttributes({"shoppingCart", "member"})
public class ReservationController {

	@Autowired
	private ReservationDAO reservationDAO;
	
	@RequestMapping(path = "/toolHistory", method = RequestMethod.POST)
	public String displayToolHistory(HttpServletRequest request) {
		
		//defaults to false unless found to be true later on
		request.setAttribute("charError", false);
		
		if (request.getParameter("searchString") != null && !request.getParameter("searchString").isEmpty()) {
			
			// This code tests if the searchString only contains numbers
			boolean onlyHasNums = true;
			char[] a = request.getParameter("searchString").toCharArray();
			for (char c: a)
			{
				onlyHasNums = 
			            ((c >= '0') && (c <= '9'));

			    if (!onlyHasNums)
			    {
			        break;
			    }
			}
			
			
			//This code tests if the searchString only contains letters
			boolean onlyHasLetters = true;
			a = request.getParameter("searchString").toCharArray();
			for (char c: a)
			{
				onlyHasLetters = 
						((c >= 'a') && (c <= 'z')) || 
			            ((c >= 'A') && (c <= 'Z'));

			    if (!onlyHasLetters)
			    {
			        break;
			    }
			}
		
			
			//This code tests if the string only contains either numbers or letters (no other character types)
			boolean onlyHasNumsAndLetters = true;
			a = request.getParameter("searchString").toCharArray();
			for (char c: a)
			{
				onlyHasNumsAndLetters = ((c >= 'a') && (c <= 'z')) || 
			            ((c >= 'A') && (c <= 'Z')) || 
			            ((c >= '0') && (c <= '9'));

			    if (!onlyHasNumsAndLetters)
			    {
			        break;
			    }
			}
			
	
			// This chunk sets an error message and error boolean and returns to the jsp, if the string contains the wrong characters
			if(request.getParameter("searchType").equals("driversLicense") && !onlyHasNumsAndLetters)
			{ request.setAttribute("charErrorMsg", "Please only enter numbers and letters for a driver's license search");
			request.setAttribute("charError", true);
			return "toolHistory";
			}
			if( request.getParameter("searchType").equals("toolId") && !onlyHasNums) {
				request.setAttribute("charErrorMsg", "Please only enter numbers for a tool ID search");
				request.setAttribute("charError", true);
				return "toolHistory";
			}
			if(request.getParameter("searchType").equals("userName") && !onlyHasLetters ){
				request.setAttribute("charErrorMsg", "Please only enter letters for a name search");
				request.setAttribute("charError", true);
				return "toolHistory";
			}
				

			
			// This junk actually calls the SQL statements if it's a valid search string
			if (request.getParameter("searchType").equals("driversLicense")) {
				request.setAttribute("reservations",
						reservationDAO.searchToolsByDriversLicense(request.getParameter("searchString")));
			}
			if (request.getParameter("searchType").equals("toolId")) {
				request.setAttribute("reservations",
						reservationDAO.searchToolsByToolNumber(Integer.parseInt(request.getParameter("searchString"))));
			}
			if (request.getParameter("searchType").equals("userName")) {
				request.setAttribute("reservations",
						reservationDAO.searchToolsByName(request.getParameter("searchString")));
			}
		}
		return "toolHistory";
	}

	@RequestMapping(path="/toolHistory", method = RequestMethod.GET)
	public String displayToolHistoryFirst(HttpServletRequest request) {
		return "toolHistory";
	}

	@RequestMapping("/checkedOutTools")
	public String displayCheckedOutTools(HttpServletRequest request) {

		request.setAttribute("allCheckedOutTools", reservationDAO.getAllCheckedOutTools());

		return "checkedOutTools";
	}
	
	@RequestMapping(path="checkOut")
	public String checkOut(HttpSession session, ModelMap model) {
		
		ShoppingCart cart = getActiveShoppingCart(model);
		
		List<Tool> tools = cart.getItems();
		
		Reservation reservation = new Reservation();
		
		reservation.setItems(tools);
		
		int memberId = (int) model.get("member");
				
		reservation.setApp_user_id(memberId);

		int confirmationNum = reservationDAO.saveNewReservation(reservation);
		
		//redirect to confirmation page set confirmation ID and list of tools
		
		return null;
	}
	
	private ShoppingCart getActiveShoppingCart(ModelMap model) {
		if(model.get("shoppingCart") == null) {
			model.addAttribute("shoppingCart", new ShoppingCart());
		}
		return (ShoppingCart)model.get("shoppingCart");
	}
}
