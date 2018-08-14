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

	@RequestMapping(path= "/toolHistory", method=RequestMethod.POST)
	public String displayToolHistory(HttpServletRequest request) {
		System.out.println("You hit the BIG controller!");
		
		//String temp = request.getParameter("searchString");
		
	//	System.out.println("Your search string in integer is: " + Integer.parseInt(temp));
		System.out.println("Your search parameter is " + request.getParameter("searchString"));
		
		if (request.getParameter("searchString") != null && !request.getParameter("searchString").isEmpty() /*&& 
				request.getParameter("searchType") != null && !request.getParameter("searchType").isEmpty()*/) {	
			System.out.println("You're inside the not-null clause");
			
			if (request.getParameter("searchType").equals("driversLicense")) {
				System.out.println("You selected Drivers License");
				request.setAttribute("reservedTools", reservationDAO.searchToolsByDriversLicense(request.getParameter("searchString")));
			}
			if (request.getParameter("searchType").equals("toolId")) {
				System.out.println("you selected Tool Id");
			//System.out.println("The big long statement says " + reservationDAO.searchToolsByToolNumber(Integer.parseInt(request.getParameter("toolId"))));
				request.setAttribute("reservedTools", reservationDAO.searchToolsByToolNumber(Integer.parseInt(request.getParameter("searchString"))));
			}
			if (request.getParameter("searchType").equals("userName")) {
				System.out.println("You selected UserName");
				System.out.println("The big sql statementn is " + reservationDAO.searchToolsByName(request.getParameter("searchString")) );
				request.setAttribute("reservedTools", reservationDAO.searchToolsByName(request.getParameter("searchString")));
			}
		} 
		return "toolHistory";
	}
	
	@RequestMapping(path= {"/", "/toolHistory"}, method=RequestMethod.GET)
	public String displayToolHistoryFirst(HttpServletRequest request) {
		System.out.println("You hit the little controller!");
		return "toolHistory";
	}
}
