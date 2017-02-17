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
	public String getCDsAsJson(){
		return cdService.getAllCDs();
	}
	
	@POST
	@Path("/json")
	@Produces({"application/json"})
	public String addCDToStore(String jsonCD){
		return cdService.addNewCD(jsonCD);
	}
	
	@PUT
	@Path("/json/{id}")
	@Produces({ "application/json" })
	public String updateCDFromCDStore(@PathParam("id") Integer id, String cdJson) {
		return cdService.updateCD(id, cdJson);
	}

	@DELETE
	@Path("/json/{id}")
	@Produces({ "application/json" })
	public String deleteCDFromCDStore(@PathParam("id") Integer id) {
		return cdService.deleteCD(id);
	}
	
}
