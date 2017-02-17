package com.qa.cdstore.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.qa.cdstore.service.CDService;

@Path("/cdstore")
public class CDEndpoint {
	
	@Inject
	private CDService cdService;
	
	@GET
	@Path("/json")
	@Produces({ "application/json" })
	public String getAllCDs() {
		return cdService.getAllCDs();
	}
	
	@GET
	@Path("/json/{id}")
	@Produces({ "application/json" })
	public String getCD(@PathParam("id") int id) {
		return cdService.getCD(id);
	}
	
	@DELETE
	@Path("/json/{id}")
	@Produces({ "application/json" })
	public String removeCD(@PathParam("id") int id) {
		return cdService.removeCD(id);
	}
	
	@POST
	@Path("/json")
	@Produces({ "application/json" })
	public String addCD(String json) {
		return cdService.addCD(json);
	}
	
	@PUT
	@Path("/json/{id}")
	@Produces({ "application/json" })
	public String replaceCD(@PathParam("id") int id, String json) {
		return cdService.updateCD(id, json);
	}
}
