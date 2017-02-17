package com.qa.cdstore.rest;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.qa.cdstore.service.CDService;

@Path("/cdstore")
public class CDEndPoint {

	@Inject
	CDService cdService;

	@GET
	@Path("/json")
	@Produces({ "application/json" })
	public String getCDAsJson() {
		return cdService.getAllCDs();
	}

	@POST
	@Path("/json")
	@Produces({ "application/json" })
	public String addNewCD(String cdJson) {
		return cdService.addNewCD(cdJson);
	}

}
