package com.qa.cdstore.rest;

import javax.inject.Inject;
import javax.ws.rs.*;

import com.qa.cdstore.service.CDService;

@Path("/cdstore")
public class CDEndpoint{
	@Inject
	private CDService cdService;
	
	@GET
	@Path("/json")
	@Produces({"app/json"})
	public String getCDs(){
		return cdService.getAllCDs();
	}
	
	@POST
	@Path("/json")
	@Produces({"app/json"})
	public String addNewCD(String cdJSON){
		return cdService.addNewCD(cdJSON);
	}
	
	@PUT
	@Path("/json/{ID}")
	@Produces({"app/json"})
	public String replaceCD(@PathParam("ID") Integer ID, String cdJSON){
		return cdService.replaceCD(ID, cdJSON);
	}
	
	@DELETE
	@Path("/json/{ID}")
	@Produces({"app/json"})
	public String deleteCD(@PathParam("ID") Integer ID){
		return cdService.deleteCD(ID);
	}
}