package com.techelevator.model;

import java.util.List;

public interface ToolSearchDAO {

	public List<Tool> searchToolsByName();
	
	public List<Tool> searchToolsByDriversLicense();

	public List<Tool> searchToolsByToolNumber();

}
