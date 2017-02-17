package com.qa.cdstore.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.qa.cdstore.service.DBCDServiceImp;

@Path("/cdstore")
public class CDEndpoint {

	@Inject
	private DBCDServiceImp dbcdServiceImp;

	@GET
	@Path("/json")
	@Produces(MediaType.APPLICATION_JSON)
	public String getCDAsJson() {
		return dbcdServiceImp.getCDs();
	}

	@POST
	@Path("/json")
	@Produces({ "application/json" })
	public String addNewCDToMap(String cdJson) {
		return dbcdServiceImp.addCD(cdJson);
	}
	
	@GET
	@Path("/json/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public String findCD(@PathParam("id") Integer id) {
		return dbcdServiceImp.getSingleCD(id);
	}

	@PUT
	@Path("/json/{id}")
	@Produces({ "application/json" })
	public String replaceCDFromCDStore(@PathParam("id") Integer id, String cdJson) {
		return dbcdServiceImp.replaceCD(id, cdJson);
	}

	@DELETE
	@Path("/json/{id}")
	@Produces({ "application/json" })
	public String deleteCDFromCDStore(@PathParam("id") Integer id) {
		return dbcdServiceImp.deleteCD(id);
	}
	
}
