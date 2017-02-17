package com.qa.cdstore.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.qa.cdstore.service.CDServiceInterface;

@Path("/cdstore")
public class CDEndPoint {
	@Inject
	private CDServiceInterface cdServiceInterface;
	
	@GET
	@Path("/json")
	@Produces({"application/json"})
	public String getCDsAsJson() {
		return cdServiceInterface.getAllCDs();
	}
	
	@POST
	@Path("/json")
	@Produces({"application/json"})
	public String addNewCDToMap(String cdJson) {
		return cdServiceInterface.addNewCD(cdJson);
	}
	
	@PUT
	@Path("/json/{id}")
	@Produces({"application/json"})
	public String replaceCDFromCDStore(@PathParam("id") Integer id, String cdJson) {
		return cdServiceInterface.replaceCD(id, cdJson);
	}
	
	@DELETE
	@Path("/json/{id}")
	@Produces({"application/json"})
	public String deleteCDFromCDStore(@PathParam("id") Integer id) {
		return cdServiceInterface.deleteCD(id);
	}
}
