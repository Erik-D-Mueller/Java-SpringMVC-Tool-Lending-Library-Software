package com.techelevator.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.techelevator.model.dao.ReservationDAO;
import com.techelevator.model.dao.ToolDAO;

@Controller
public class ToolController {

	@Autowired
	private ToolDAO toolDAO;
	
	@Autowired
	private ReservationDAO reservationDAO;

	@RequestMapping("/completeToolList")
	public String displayCompleteToolList(HttpServletRequest request) {
		
		request.setAttribute("allTools", toolDAO.getAllTools());

		return "completeToolList";
	}

	@RequestMapping("/availableToolList")
	public String displayAvailableToolList(HttpServletRequest request) {
		
		request.setAttribute("availableTools", toolDAO.getAllAvailableTools());

		return "availableToolList";
	}
	
	@RequestMapping("/checkedOutTools")
	public String displayCheckedOutTools(HttpServletRequest request) {

		request.setAttribute("allCheckedOutTools", reservationDAO.getAllCheckedOutTools());

		return "checkedOutTools";
	}
}
