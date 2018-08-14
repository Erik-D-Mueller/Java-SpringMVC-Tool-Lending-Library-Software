package com.techelevator.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.techelevator.model.ReservationDAO;

@Controller
public class ReservationController {

	private ReservationDAO reservationDAO;

	@RequestMapping(path="/toolHistory", method=RequestMethod.POST)
	public String displayToolHistory(HttpServletRequest request) {
		System.out.println("You hit the controller");
		System.out.println(request.getParameter("searchString"));
		System.out.println(request.getParameter("searchType"));
		if (request.getParameter("searchString") != null && !request.getParameter("searchString").isEmpty() /*&& 
				request.getParameter("searchType") != null && !request.getParameter("searchType").isEmpty()*/) {	
			System.out.println("SearchString is not null");
			if (request.getParameter("searchType").equals("driversLicense")) {
				System.out.println("Drivers License");
				request.setAttribute("reservedTools", reservationDAO.searchToolsByDriversLicense(request.getParameter("driversLicense")));
			}
			if (request.getParameter("searchType").equals("toolId")) {
				System.out.println("Drivers License");
				request.setAttribute("reservedTools", reservationDAO.searchToolsByToolNumber(Integer.parseInt(request.getParameter("toolId"))));
			}
			if (request.getParameter("searchType").equals("userName")) {
				System.out.println("Drivers License");
				request.setAttribute("reservedTools", reservationDAO.searchToolsByName(request.getParameter("userName")));
			}
		} 
		return "toolHistory";
	}
	
	@RequestMapping(path="/toolHistory", method=RequestMethod.GET)
	public String displayToolHistoryFirst(HttpServletRequest request) {
		return "toolHistory";
	}
}
