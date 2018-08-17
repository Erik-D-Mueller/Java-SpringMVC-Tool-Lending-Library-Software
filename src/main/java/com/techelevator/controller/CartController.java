package com.techelevator.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.ui.ModelMap;

import com.techelevator.model.dao.MemberDAO;
import com.techelevator.model.dao.ToolDAO;
import com.techelevator.model.domain.Member;
import com.techelevator.model.domain.ShoppingCart;
import com.techelevator.model.domain.Tool;

@Controller
@SessionAttributes({"member", "memberName", "shoppingCart"})
public class CartController {
	
	Member member;
	
	@Autowired
	private MemberDAO memberDAO;
	
	@Autowired
	private ToolDAO toolDAO;
	
	@RequestMapping(path="/chooseMember", method=RequestMethod.GET)
	public String choseMemberAndRedirect(HttpServletRequest request, ModelMap map) {
				
		map.addAttribute("member", request.getParameter("memberId"));
		map.addAttribute("memberName", memberDAO.getMemberById(Integer.parseInt(request.getParameter("memberId"))).getUserName());
		
		return "redirect:/availableToolList";
	}
	
	@RequestMapping(path="/viewCart", method=RequestMethod.POST)
	public String viewCart(HttpServletRequest request, ModelMap model) {
		
		Tool toolToAdd = toolDAO.getToolById(Integer.parseInt(request.getParameter("tool_id")));

		ShoppingCart cart = getActiveShoppingCart(model);
		List<Tool> tools = cart.getItems();
		tools.add(toolToAdd);
		cart.setItems(tools);
		request.setAttribute("tools", tools);
		
		model.put("shoppingCart", cart);		
		
		return "viewCart";
	}
	
	@RequestMapping(path="/viewCart", method=RequestMethod.GET)
	public String viewCartWithNoMember(HttpServletRequest request, ModelMap model) {
		if (model.get("shoppingCart") != null) {
			ShoppingCart cart = getActiveShoppingCart(model);
			List<Tool> tools = cart.getItems();
			
			request.setAttribute("tools", tools);
		}
		
		return "viewCart";
	}
	
	private ShoppingCart getActiveShoppingCart(ModelMap model) {
		if(model.get("shoppingCart") == null) {
			model.addAttribute("shoppingCart", new ShoppingCart());
		}
		return (ShoppingCart)model.get("shoppingCart");
	}
	
}
