package com.techelevator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.techelevator.model.UserDAO;

@Controller
public class ToolController {

	//private ToolDAO toolDAO;

	//@Autowired
	//public UserController(UserDAO userDAO) {
	//	this.userDAO = userDAO;
	//}
	
	
	
	@RequestMapping(path="/completetoolList", method=RequestMethod.GET)
	public String displayCompleteToolList() {
		return "availableToolList";
	}
	
	@RequestMapping(path="/availabletoolList", method=RequestMethod.GET)
	public String displayAvailableToolList() {
		return "competeToolList";
	}
	
	
}
