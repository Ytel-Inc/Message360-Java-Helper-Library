/**
 * This endpoint allows you to execute the WEB-Services and return to appropriate class
 * @version v1b
 * @since 2015-11-12 12:12:13
 * @author Ytel Inc
 * 
 */


package com.M360.api.restproxies;


import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.jboss.resteasy.client.ClientResponse;

import com.M360.api.domain.Message360;
import com.M360.api.domain.enums.TranscriptionStatus;
import com.M360.api.domain.responses.TranscriptionMessage;

public interface TranscriptionProxy {
	
	@POST
	@Path("transcriptions/viewtranscription.json")
	@Produces("application/json")
	ClientResponse<Message360<TranscriptionMessage>> viewTranscription(
			@PathParam("AccountSid") String accountSid,
			@QueryParam("transcriptionsid") String transcriptionsid
			);
	
	@POST
	@Path("transcriptions/listtranscription.json")
	@Produces("application/json")
	ClientResponse<Message360<TranscriptionMessage>> listTranscription(
			@PathParam("AccountSid") String accountSid,
			@QueryParam("Page") Integer page,
    		@QueryParam("PageSize") Integer pageSize,
    		@QueryParam("status") TranscriptionStatus transcriptionStatus,
    		@QueryParam("dateTranscribed") String dateTranscribed
			);

	@POST
	@Path("transcriptions/audiourltranscription.json")
	@Produces("application/json")
	ClientResponse<Message360<TranscriptionMessage>> audioTranscriptionUrl(
			@PathParam("AccountSid") String accountSid,
			@QueryParam("audiourl") String audiourl
			);
	
	@POST
	@Path("transcriptions/recordingtranscription.json")
	@Produces("application/json")
	ClientResponse<Message360<TranscriptionMessage>> recordingTranscription(
			@PathParam("AccountSid") String accountSid,
			@QueryParam("recordingSid") String recordingSid
			);
	
	
}
