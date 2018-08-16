package com.techelevator.model.domain;

import java.util.List;

public class Reservation {

	private int tool_id;
	private int reservation_id;
	private int app_user_id;
	private String toolName;
	private String from_date;
	private String to_date;
	private String name;
	
	
	//The shopping cart gets inserted here the moment before final checkout
	public List<Tool> items;

	public List<Tool> getItems() {
		return items;
	}
	
	public void setItems(List<Tool> items) {
	this.items = items;	
	}
	
	public void empty() {
		items.clear();
	}
	
	
	public Reservation() {
		
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		
		this.name = name;
	}
	
	public int getToolId() {
		return tool_id;
	}

	public void setToolId(int toolId) {
		this.tool_id = toolId;
	}

	public String getToolName() {
		return toolName;
	}

	public void setToolName(String toolName) {
		this.toolName = toolName;
	}

	public String getFrom_date() {
		return from_date;
	}

	public void setFrom_date(String from_date) {
		this.from_date = from_date;
	}

	public String getTo_date() {
		return to_date;
	}

	public void setTo_date(String to_date) {
		this.to_date = to_date;
	}

	public int getReservation_id() {
		return reservation_id;
	}
	
	public void setReservation_id(int reservation_id) {
		this.reservation_id=reservation_id;
	}
	
	public int getApp_user_id() {
		return app_user_id;
	}
	
	public void setApp_user_id(int app_user_id) {
		this.app_user_id=app_user_id;
	}
	
}
