package com.techelevator.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.techelevator.model.ReservationDAO;

@Controller
public class ReservationController {

	@Autowired
	private ReservationDAO reservationDAO;

	@RequestMapping(path = "/toolHistory", method = RequestMethod.POST)
	public String displayToolHistory(HttpServletRequest request) {

		if (request.getParameter("searchString") != null && !request.getParameter("searchString").isEmpty()) {

			if (request.getParameter("searchType").equals("driversLicense")) {
				request.setAttribute("reservedTools",
						reservationDAO.searchToolsByDriversLicense(request.getParameter("searchString")));
			}
			if (request.getParameter("searchType").equals("toolId")) {
				request.setAttribute("reservedTools",
						reservationDAO.searchToolsByToolNumber(Integer.parseInt(request.getParameter("searchString"))));
			}
			if (request.getParameter("searchType").equals("userName")) {
				request.setAttribute("reservedTools",
						reservationDAO.searchToolsByName(request.getParameter("searchString")));

			}
		}
		return "toolHistory";
	}

	@RequestMapping(path = { "/", "/toolHistory" }, method = RequestMethod.GET)
	public String displayToolHistoryFirst(HttpServletRequest request) {
		return "toolHistory";
	}

	@RequestMapping("/checkedOutTools")
	public String displayCheckedOutTools(HttpServletRequest request) {

		request.setAttribute("allCheckedOutTools", reservationDAO.getAllCheckedOutTools());

		return "checkedOutTools";
	}
}
