package com.techelevator.model.dao;

import java.util.List;

import com.techelevator.model.domain.Tool;

public interface ToolDAO {

	public List<Tool> getAllTools();
	
	public List<Tool> getAllAvailableTools();

	
}
