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
public class CDEndPoint {

	@Inject
	private CDService cdService;
	
	@GET
	@Path("/json")
	@Produces({"application/json"})
	public String getAllCds()
	{
		return cdService.getAllCds();
	}
	
	@GET
	@Path("/json/{id}")
	@Produces({"application/json"})
	public String getSingleCD(@PathParam("id") int id)
	{
		return cdService.getSingleCD(id);
	}
	
	@DELETE
	@Path("/json/{id}")
	@Produces({"application/json"})
	public String deleteCD(@PathParam("id") int id)
	{
		return cdService.deleteCD(id);
	}
	
	@POST
	@Path("/json")
	@Produces({"application/json"})
	public String addCD(String objJSON)
	{
		return cdService.addCD(objJSON);
	}
	
	@PUT
	@Path("/json/{id}")
	@Produces({"application/json"})
	public String updateCD(@PathParam("id") int id, String objJSON)
	{
		return cdService.updateCD(id,objJSON);
	}
}
