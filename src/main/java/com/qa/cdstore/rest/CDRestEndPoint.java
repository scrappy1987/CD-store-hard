package com.qa.cdstore.rest;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.qa.cdstore.service.CDService;

@Path("/CDs")
public class CDRestEndPoint {

	@Inject
	private CDService cdService;
	
	@GET
	@Path("/json")
	@Produces(MediaType.APPLICATION_JSON)
	public String getAllCDs() {
		return cdService.getCDs();
	}
	
	@POST
	@Path("/json")
	@Produces({ "application/json" })
	public String addNewCD(String cdJson) {
		return cdService.addCD(cdJson);
	}
}
