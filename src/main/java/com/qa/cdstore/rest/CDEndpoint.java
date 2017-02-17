package com.qa.cdstore.rest;

import javax.ws.rs.*;

import com.qa.cdstore.service.CDService;

import javax.inject.Inject;


@Path("/cdlibrary")
public class CDEndpoint {
		
		@Inject
		private CDService cdService;
		
		@GET
		@Path("/json")
		@Produces({"application/json"})
		public String getCDsAsJson() {
			return cdService.getAllCDs();
		}
		
		@POST
		@Path("/json")
		@Produces({"application/json"})
		public String addNewCDToMap(String cdJson) {
			return cdService.addNewCD(cdJson);
		}
		
		
		@PUT
		@Path("/json/{id}")
		@Produces({"application/json"})
		public String replaceCDFromCDLibrary(@PathParam("id") Integer id, String cdJson) {
			return cdService.replaceCD(id,cdJson);
		}
		
		
		@DELETE
		@Path("json/{id}")
		@Produces({"application/json"})
		public String deleteCDFromCDLibrary(@PathParam("id") Integer id) {
			return cdService.deleteCD(id);
		}
}