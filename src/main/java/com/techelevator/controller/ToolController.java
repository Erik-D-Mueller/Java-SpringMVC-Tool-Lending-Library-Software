package com.techelevator.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.techelevator.model.Tool;
import com.techelevator.model.ToolDAO;
import com.techelevator.model.UserDAO;

@Controller
public class ToolController {

	private ToolDAO toolDAO;

	@Autowired
	public ToolController(ToolDAO toolDAO) {
		this.toolDAO = toolDAO;
	}
	
	
	
	@RequestMapping(path="/completeToolList", method=RequestMethod.GET)
	public String displayCompleteToolList(HttpServletRequest request) {
		request.setAttribute("allTools", toolDAO.getAllTools());

		return "completeToolList";
	}
	
	@RequestMapping(path="/availableToolList", method=RequestMethod.GET)
	public String displayAvailableToolList(HttpServletRequest request) {
		request.setAttribute("availableTools", toolDAO.getAllAvailableTools());
		
		return "availableToolList";
	}
	
	@RequestMapping(path="toolHistoryByDrivers", method=RequestMethod.POST)
	public String displayToolHistoryByDrivers(HttpServletRequest request) {
		
		return "toolHistory";
	}
	@RequestMapping(path="toolHistoryByToolId", method=RequestMethod.POST)
	public String displayToolHistoryByToolId(HttpServletRequest request) {
		
		return "toolHistory";
	}
	@RequestMapping(path="toolHistoryByName", method=RequestMethod.POST)
	public String displayToolHistoryByName(HttpServletRequest request) {
		
		return "toolHistory";
	}
}
