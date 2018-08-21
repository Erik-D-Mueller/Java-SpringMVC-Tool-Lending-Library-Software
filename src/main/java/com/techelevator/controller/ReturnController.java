package com.techelevator.controller;



import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.techelevator.model.dao.ReservationDAO;
import com.techelevator.model.dao.ToolDAO;
import com.techelevator.model.domain.CheckedOutTool;
import com.techelevator.model.domain.Tool;


@SessionAttributes({"userName", "currentUser", "shoppingCart", "member", "confNum"})


@Controller

public class ReturnController {

	@Autowired
	private ReservationDAO reservationDAO;
	
	@Autowired
	private ToolDAO toolDAO;

	@RequestMapping("/returnTool")
	public String returnTool(HttpServletRequest request) {

		request.setAttribute("InvalidID", false);
		return "returnTool";
	}

	
	
	@RequestMapping(path="/returnConfirmation", method=RequestMethod.POST)
	public String updateReturn(HttpServletRequest request) {
		request.setAttribute("InvalidID", false);
		
		CheckedOutTool toolToReturn = toolDAO.getCheckedOutToolByToolId(Integer.parseInt(request.getParameter("toolId")));
		
		if(toolToReturn.getToolName() == null) {
			
			request.setAttribute("toolReturnError", "The tool associated with that ID is not currently checked out. Please try again");
			return "returnTool";
		}
		
		else {
		reservationDAO.deleteReservation(Integer.parseInt(request.getParameter("toolId")));
		request.setAttribute("toolId", request.getParameter("toolId"));
		return "returnConfirmation";
		}
	
	}
	
//	@RequestMapping(path="/returnConfirmation", method=RequestMethod.POST)
//	public String confirmReturn(HttpServletRequest request) {
//		
//		request.setAttribute("toolId", request.getParameter("toolId"));
//
//		return "returnConfirmation";
//	}

}