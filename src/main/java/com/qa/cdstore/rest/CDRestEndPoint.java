package com.qa.cdstore.rest;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.qa.cdstore.service.CDService;

@Path("/CDs")
@RequestScoped
public class CDRestEndPoint {

	@Inject
	CDService cdService;
	
	@GET
	@Path("/json")
	@Produces(MediaType.APPLICATION_JSON)
	public String getAllCDs() {
		return cdService.getCDs();
	}
}
