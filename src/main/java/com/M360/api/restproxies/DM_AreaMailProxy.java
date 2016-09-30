package com.M360.api.restproxies;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.jboss.resteasy.client.ClientResponse;

import com.M360.api.domain.Message360;
import com.M360.api.domain.directmail.responses.DMAreaMail;
import com.M360.api.domain.enums.TargetType;

public interface DM_AreaMailProxy {

	@POST
	@Path("areamail/create.json")
	@Produces("application/json")
	ClientResponse<Message360<DMAreaMail>> createAreaMail(
			@PathParam("AccountSid") String accountSid,
			@QueryParam("attachbyid") String attachbyid,
			@QueryParam("front") String front,
			@QueryParam("back") String back,
			@QueryParam("description") String description,
			@QueryParam("routes") String routes,
			@QueryParam("targettype") TargetType targettype,
			@QueryParam("htmldata") String htmldata
			);
	
	@POST //REMAING
	@Path("areamail/view.json")
	@Produces("application/json")
	ClientResponse<Message360<DMAreaMail>> viewAreaMail(
			@PathParam("AccountSid") String accountSid,
			@QueryParam("areamailid") String areamailid
			);
	
	@POST
	@Path("areamail/list.json")
	@Produces("application/json")
	ClientResponse<Message360<DMAreaMail>> listAreaMail(
			@PathParam("AccountSid") String accountSid,
			@QueryParam("page") Integer page,
			@QueryParam("pagesize") Integer pageSize,
			@QueryParam("areamailsid") String areaMailSid,
			@QueryParam("datecreated") String datecreated
			);
	
	@GET//REMAINING
	@Path("areamail/delete/{areamailid}.json")
	@Produces("application/json")
	ClientResponse<Message360<DMAreaMail>> deleteAreaMail(
			@PathParam("AccountSid") String accountSid,
			@PathParam("areamailid") String areamailid
			);
	
	
}
