package com.M360.api.restproxies;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.jboss.resteasy.client.ClientResponse;

import com.M360.api.domain.Message360;
import com.M360.api.domain.directmail.responses.DMLetter;
import com.M360.api.domain.enums.ExtraService;

public interface DM_LetterProxy {
	
	@POST
	@Path("letters/create.json")
	@Produces("application/json")
	ClientResponse<Message360<DMLetter>> createLetter(
			@PathParam("AccountSid") String accountSid,
			@QueryParam("to") String to,
			@QueryParam("from") String from,
			@QueryParam("attachbyid") String attachbyid,
			@QueryParam("file") String file,
			@QueryParam("color") Boolean color,
			@QueryParam("extraservice") ExtraService extraservice,
			@QueryParam("doublesided") Boolean doublesided,
			@QueryParam("description") String description,
			@QueryParam("template") Boolean template,
			@QueryParam("htmldata") String htmldata
			);
	
	@POST
	@Path("letters/view.json")
	@Produces("application/json")
	ClientResponse<Message360<DMLetter>> viewLetter(
			@PathParam("AccountSid") String accountSid,
			@QueryParam("letterid") String letterid
			);
	
	@POST
	@Path("letters/lists.json")
	@Produces("application/json")//REMAING lettersid and letter id are different 
	ClientResponse<Message360<DMLetter>> listLetter(
			@PathParam("AccountSid") String accountSid,
			@QueryParam("page") Integer page,
			@QueryParam("pagesize") Integer pagesize,
			@QueryParam("lettersid") String lettersid,
			@QueryParam("datecreated") String datecreated
			);
	
	@GET
	@Path("letters/delete/{letterid}.json")
	@Produces("application/json")
	ClientResponse<Message360<DMLetter>> deleteLetter(
			@PathParam("AccountSid") String accountSid,
			@PathParam("letterid") String letterid
			);
	
}
