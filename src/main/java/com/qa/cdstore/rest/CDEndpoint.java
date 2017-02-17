package com.qa.cdstore.rest;
import com.qa.cdstore.service.CDService;

import javax.ws.rs.Produces;
import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;

@Path("/cdstore")
public class CDEndpoint {
	@Inject
	private CDService cdService;
	
	@GET
	@Path("/json")
	@Produces({"application/json"})
	public String getAllCDsAsJSON(){
		return cdService.getAllCDs();
	}
	
	@GET
	@Path("/json/{id}")
	@Produces({"application/json"})	
	public String getSingleCDAsJSON(@PathParam("id") Integer id){
		return cdService.getSingleCD(id);
	}
	
	@POST
	@Path("/json")
	@Produces({"application/json"})
	public String addCD(String cd)
	{
		return cdService.addnewCD(cd);
	}
	
	@PUT
	@Path("/json/{id}")
	@Produces({ "application/json" })
	public String updateCD(@PathParam("id") Integer id, String cd){
		return cdService.updateCD(id, cd);
	}
	
	@DELETE
	@Path("/json/{id}")
	@Produces({"application/json"})
	public String deleteCD(@PathParam("id") Integer id){
		return cdService.deleteCD(id);
	}
}
