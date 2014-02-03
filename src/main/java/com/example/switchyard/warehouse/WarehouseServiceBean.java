package com.example.switchyard.warehouse;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Response;

import org.switchyard.component.bean.Service;

@Service(WarehouseService.class)
public class WarehouseServiceBean implements WarehouseService {

	private List<Item> items;

	public WarehouseServiceBean() {
		items = new ArrayList<Item>();
		items.add(new Item("ITEM001", "Item 001", 129.9));
		items.add(new Item("ITEM002", "Item 002", 99.9));
		items.add(new Item("ITEM003", "Item 003", 1199.9));
	}

	@Override
	public List<Item> getItems() {
		return items;
	}

	@Override
	public Response getItem(String id) {
		for (Item item : items) {
			if (item.getItemId().equals(id)) {
				return Response.ok(item).build();
			}
		}
		return Response.ok(new ErrorMessage()).build();
	}

	@Override
	public String getInfo() {
		return "<html>"
				+ "<h1>Warehouse REST API</h1>"
				+ "<h3>Get all items:</h3>"
				+ "<a href=\"http://localhost:8080/warehouse/items\">http://localhost:8080/warehouse/items</a>"
				+ "<h3>Get an item:</h3>"
				+ "<a href=\"http://localhost:8080/warehouse/items/ITEM001\">http://localhost:8080/warehouse/items/ITEM001</a>"
				+ "</html>";
	}

	private class ErrorMessage {

		private String message;

		public ErrorMessage() {
			message = "Item not found";
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}

	}

}
