package com.M360.api.restproxies;

import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.jboss.resteasy.client.ClientResponse;

import com.M360.api.domain.Message360;
import com.M360.api.domain.directmail.responses.DMPostCard;

public interface DM_PostCardProxy {
	
	@POST
	@Path("postcard/create.json")
	@Produces("application/json")
	ClientResponse<Message360<DMPostCard>> createPostCard(
			@PathParam("AccountSid") String accountSid,
			@QueryParam("to") String to,
			@QueryParam("from") String from,
			@QueryParam("attachbyid") String attachbyid,
			@QueryParam("front") String front,
			@QueryParam("back") String back,
			@QueryParam("message") String message,
			@QueryParam("setting") String setting,
			@QueryParam("description") String description,
			@QueryParam("htmldata") String htmldata
			);
	
	@POST
	@Path("postcard/view.json")
	@Produces("application/json")
	ClientResponse<Message360<DMPostCard>> viewPostCard(
			@PathParam("AccountSid") String accountSid,
			@QueryParam("postcardid") String postcardid
			);
	
	@POST
	@Path("postcard/lists.json")
	@Produces("application/json")
	ClientResponse<Message360<DMPostCard>> listPostCard(
			@PathParam("AccountSid") String accountSid,
			@QueryParam("page") Integer page,
			@QueryParam("pagesize") Integer pagesize,
			@QueryParam("postcardsid") String postcardsid,
			@QueryParam("datecreated") String datecreated
			);
	
	@DELETE
	@Path("postcard/delete.json")
	@Produces("application/json")
	ClientResponse<Message360<DMPostCard>> deletePostCard(
			@PathParam("AccountSid") String accountSid,
			@QueryParam("postcardid") String postcardid
			);
}
