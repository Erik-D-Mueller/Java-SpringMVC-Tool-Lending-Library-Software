package com.techelevator.model;

import java.util.List;

public interface ToolDAO {

	public List<Tool> getAllTools();
	
	public List<Tool> getAllAvailableTools(String toolName, String to_date, String from_date);


}
