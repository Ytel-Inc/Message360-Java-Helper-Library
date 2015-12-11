/**
 * This endpoint allows you to execute the WEB-Services and return to appropriate class
 * @version v1b
 * @since 2015-11-12 12:12:13
 * @author Ytel Inc
 * 
 */

package com.M360.api.restproxies;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.jboss.resteasy.client.ClientResponse;

import com.M360.api.domain.Message360;
import com.M360.api.domain.responses.RecordMessage;

public interface RecordingProxy {
	
	@GET
	@Path("recording/viewrecording/{RecordingId}.json")
	@Produces("application/json")
	ClientResponse<Message360<RecordMessage>> viewRecording(
			@PathParam("AccountSid") String accountSid,
			@PathParam("RecordingId") String recordingSid
			);
	
	@POST
	@Path("recording/listrecording.json")
	@Produces("application/json")
	ClientResponse<Message360<RecordMessage>> listRecording(
			@PathParam("AccountSid") String accountSid
			);
	
	@POST
	@Path("recording/deleterecording/{RecordingId}.json")
	@Produces("application/json")
	ClientResponse<Message360<RecordMessage>> deleteRecording(
			@PathParam("AccountSid") String accountSid,
			@PathParam("RecordingId") String recordingSid
			);
}
