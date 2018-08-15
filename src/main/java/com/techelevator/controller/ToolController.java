package com.techelevator.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.techelevator.model.ToolDAO;

@Controller
public class ToolController {

	@Autowired
	private ToolDAO toolDAO;

	@RequestMapping(path = "/completeToolList", method = RequestMethod.GET)
	public String displayCompleteToolList(HttpServletRequest request) {
		request.setAttribute("allTools", toolDAO.getAllTools());

		return "completeToolList";
	}

	@RequestMapping(path = "/availableToolList", method = RequestMethod.GET)
	public String displayAvailableToolList(HttpServletRequest request) {
		request.setAttribute("availableTools", toolDAO.getAllAvailableTools());

		return "availableToolList";
	}
}
