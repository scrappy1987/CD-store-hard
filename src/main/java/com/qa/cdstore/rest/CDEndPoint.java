package com.qa.cdstore.rest;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.ws.rs.*;

import com.qa.cdstore.service.CDService;
import com.qa.cdstore.util.JSONUtility;

@Path("/cdstore")
public class CDEndPoint {
			
	@Inject
	private CDService cdService;
	
	@GET
	@Path("/json")
	@Produces({ "application/json" })
	public String getAllCDs() {
		return cdService.getCDAll();
	}
	
	@GET
	@Path("/json/{id}")
	@Produces({ "application/json" })
	public String getCDByID(@PathParam("id") int id) {
		return cdService.getCDByID(id);
	}
	
	@DELETE
	@Path("/json/{id}")
	@Produces({ "application/json" })
	public String deleteCDByID(@PathParam("id") int id) {
		return cdService.deleteCD(id);
	}
	
	@POST
	@Path("json/{id}")
	@Produces({ "application/json" })
	public String createNewCD(String newCDJSON) {
		return cdService.createCD(newCDJSON);
	}
	
	@PUT
	@Path("json/{id}")
	@Produces({ "application/json" })
	public String updateCDByID(@PathParam("id") int id, String updatedCDJSON) {
		return cdService.updateCD(id, updatedCDJSON);
	}
	
	

}
