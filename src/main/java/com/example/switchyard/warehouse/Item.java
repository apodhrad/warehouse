package com.example.switchyard.warehouse;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@XmlRootElement
@JsonIgnoreProperties(ignoreUnknown = true)
public class Item {

	private String itemId;
	private String description;
	private int quantity;

	public Item(String id, String description, int quantity) {
		this.itemId = id;
		this.description = description;
		this.quantity = quantity;
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String id) {
		this.itemId = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Item: " + description + "(" + itemId + "); quantity: " + quantity;
	}

}
