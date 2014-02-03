package com.example.switchyard.warehouse;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@XmlRootElement
@JsonIgnoreProperties(ignoreUnknown = true)
public class Item {

	private String itemId;
	private String description;
	private double prize;

	public Item(String id, String description, double prize) {
		this.itemId = id;
		this.description = description;
		this.prize = prize;
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

	public double getPrize() {
		return prize;
	}

	public void setPrize(double prize) {
		this.prize = prize;
	}

	@Override
	public String toString() {
		return "Item: " + description + "(" + itemId + "); prize: " + prize;
	}

}
