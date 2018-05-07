package com.webservice.wadl;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

@Path("/msg")
@Produces("application/xml")
public class Message {

	@Path("/show")
	@GET
	public Employee showMsg(@QueryParam("id")int id){
		return new Employee();
	}
	
	
}
