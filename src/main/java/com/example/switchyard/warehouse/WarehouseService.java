package com.example.switchyard.warehouse;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/")
public interface WarehouseService {

	@GET
	@Path("/items")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Item> getItems();
	

	@GET
	@Path("/items/{itemId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Item getItem(@PathParam("itemId") String itemId);
}
