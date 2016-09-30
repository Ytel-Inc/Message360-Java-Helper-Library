/**
 * This endpoint allows you to execute the WEB-Services and return to appropriate class
 * @version v1b
 * @since 2015-11-12 12:12:13
 * @author Ytel Inc
 * 
 */

package com.M360.api.restproxies;


import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.jboss.resteasy.client.ClientResponse;

import com.M360.api.domain.Message360;
import com.M360.api.domain.responses.RecordMessage;

public interface RecordingProxy {
	
	@POST
	@Path("recording/viewrecording.json")
	@Produces("application/json")
	ClientResponse<Message360<RecordMessage>> viewRecording(
			@PathParam("AccountSid") String accountSid,
			@QueryParam("recordingsid") String recordingSid
			);
	
	@POST
	@Path("recording/listrecording.json")
	@Produces("application/json")
	ClientResponse<Message360<RecordMessage>> listRecording(
			@PathParam("AccountSid") String accountSid,
			@QueryParam("page") Integer page,
			@QueryParam("pagesize") Integer pagesize,
			@QueryParam("callsid") String callsid,
			@QueryParam("Datecreated") String dateCreated
			);
	
	@DELETE
	@Path("recording/deleterecording.json")
	@Produces("application/json")
	ClientResponse<Message360<RecordMessage>> deleteRecording(
			@PathParam("AccountSid") String accountSid,
			@QueryParam("recordingsid") String recordingSid
			);
}
