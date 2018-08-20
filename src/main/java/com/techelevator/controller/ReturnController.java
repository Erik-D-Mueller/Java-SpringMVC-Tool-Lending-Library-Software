package com.techelevator.controller;



import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.techelevator.model.dao.ReservationDAO;


@SessionAttributes({"userName", "currentUser", "shoppingCart", "member", "confNum"})


@Controller

public class ReturnController {

	@Autowired
	private ReservationDAO reservationDAO;

	@RequestMapping("/returnTool")
	public String returnTool(HttpServletRequest request) {

		return "returnTool";
	}

	@RequestMapping(path="/returnConfirmation", method=RequestMethod.POST)
	public String updateReturn(HttpServletRequest request) {
		
		reservationDAO.deleteReservation(Integer.parseInt(request.getParameter("toolId")));
		request.setAttribute("toolId", request.getParameter("toolId"));
		return "returnConfirmation";
	}
	
//	@RequestMapping(path="/returnConfirmation", method=RequestMethod.POST)
//	public String confirmReturn(HttpServletRequest request) {
//		
//		request.setAttribute("toolId", request.getParameter("toolId"));
//
//		return "returnConfirmation";
//	}
}
