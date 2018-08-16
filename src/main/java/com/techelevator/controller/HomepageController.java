package com.techelevator.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomepageController {
	@RequestMapping(path = { "/", "/homepage" }, method = RequestMethod.GET)
	public String viewCart(HttpServletRequest request) {
				
		return "homepage";
	}
}
