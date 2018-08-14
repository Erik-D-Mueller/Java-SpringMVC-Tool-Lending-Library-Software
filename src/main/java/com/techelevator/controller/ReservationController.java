package com.techelevator.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.techelevator.model.ReservationDAO;

@Controller
public class ReservationController {

	private ReservationDAO reservationDAO;

	@RequestMapping(path="/toolHistoryByDrivers", method=RequestMethod.GET)
	public String displayToolHistoryByDrivers(HttpServletRequest request) {
	//	request.setAttribute("reservedTools", reservationDAO.searchToolsByDriversLicense(request.getParameter("dlLicense")));
		return "toolHistory";
	}
	
	@RequestMapping(path="/toolHistoryByToolId", method=RequestMethod.GET)
	public String displayToolHistoryByToolId(HttpServletRequest request) {
		
	//	request.setAttribute("reservedTools", reservationDAO.searchToolsByToolNumber(request.getParameter("toolId")));
		return "toolHistory";
	}
	
	@RequestMapping(path="/toolHistoryByName", method=RequestMethod.GET)
	public String displayToolHistoryByName(HttpServletRequest request) {
		
	//	request.setAttribute("reservedTools", reservationDAO.searchToolsByToolNumber(request.getParameter("toolName")));
		return "toolHistory";
	}
}
