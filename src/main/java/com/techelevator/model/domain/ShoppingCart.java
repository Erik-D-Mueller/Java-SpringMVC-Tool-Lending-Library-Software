package com.techelevator.model.domain;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

	public List<Tool> items = new ArrayList<>();

	public List<Tool> getItems() {
		return items;
	}

	public void setItems(List<Tool> items) {
		this.items = items;
	}

	public void empty() {
		items.clear();
	}

	/**
	 * Verifies that the tool_id number is not already in the cart, then adds it 
	 * 
	 */

	public void addToCart(Tool tool) {

		boolean alreadyHasThatTool = false;

		// This adds the tool only if it's not already in the cart
		for (int i = 0; i < items.size(); i++) {
			if (items.get(i).getToolId() == tool.getToolId()) {
				alreadyHasThatTool = true;
			}
		}
		if (!alreadyHasThatTool) {
			items.add(tool);
		}

	}


}
