package com.qa.cdstore.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.qa.cdstore.service.CDServices;

@Path("/store")
public class CDEndPoint
{
	@Inject
	private CDServices service;

	@GET
	@Path("/json")
	@Produces({ "application/json" })
	public String read()
	{
		return service.getCDs();
	}

	@POST
	@Path("/json")
	@Produces({ "application/json" })
	public String create(String Json)
	{
		return service.addCD(Json);
	}

	@PUT
	@Path("/json/{id}")
	@Produces({"application/json"})
	public String update(@PathParam("id") Integer id, String Json)
	{
		return service.updateCD(id, Json);
	}

	@DELETE
	@Path("/json/{id}")
	@Produces({"application/json"})
	public String delete(@PathParam("id") Integer idToDelete)
	{
		return service.deleteCD(idToDelete);
	}
}