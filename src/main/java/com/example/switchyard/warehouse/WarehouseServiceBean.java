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
		return Response.status(404).build();
	}

}
