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
		items.add(new Item("ITEM001", "Item 001", 7));
		items.add(new Item("ITEM002", "Item 002", 23));
		items.add(new Item("ITEM003", "Item 003", 29));
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
				+ "<h3>ItemService</h3><pre>@Path(\"/warehouse\")\n"
				+ "public interface ItemService {\n\n"
				+ "  @GET\n  @Path(\"/items/{itemId}\")\n"
				+ "  Item getItem(@PathParam(\"itemId\") String itemId);\n"
				+ "  }\n}</pre>"
				+ "<h3>Item</h3><pre>@XmlRootElement\n@JsonIgnoreProperties(ignoreUnknown = true)\n"
				+ "public class Item {\n\n"
				+ "  private String itemId;\n  private String description;\n  private int quantity;\n\n"
				+ "  public String getItemId() {\n    return itemId;\n  }\n\n"
				+ "  public void setItemId(String itemId) {\n    this.itemId = itemId;\n  }\n\n"
				+ "  public String getDescription() {\n    return description;\n  }\n\n"
				+ "  public void setDescription(String description) {\n    this.description = description;\n  }\n\n"
				+ "  public int getQuantity() {\n    return quantity;\n  }\n\n"
				+ "  public void setQuantity(int quantity) {\n    this.quantity = quantity;\n  }\n"
				+ "}</pre>"

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
