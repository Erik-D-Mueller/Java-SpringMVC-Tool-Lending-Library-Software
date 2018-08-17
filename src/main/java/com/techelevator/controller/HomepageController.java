package com.techelevator.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomepageController {
	
	@RequestMapping(path = { "/", "/homepage" })
	public String viewCart(HttpServletRequest request) {
				
		return "homepage";
	}
}
