/**
 * This endpoint allows you to execute the WEB-Services and return to appropriate class
 * @version v1b
 * @since 2015-11-12 12:12:13
 * @author Ytel Inc
 * 
 */


package com.M360.api.restproxies;

import java.util.Date;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.jboss.resteasy.client.ClientResponse;

import com.M360.api.domain.Message360;
import com.M360.api.domain.enums.ConferenceStatus;
import com.M360.api.domain.responses.ConferenceMessages;

public interface ConferenceProxy {

	@POST
	@Path("conferences/viewconference.json")
	@Produces("application/json")
	ClientResponse<Message360<ConferenceMessages>> viewConference(
			@PathParam("AccountSid") String accountSid,
			@QueryParam("conferencesid") String conferencesid
			);
	
	@POST
	@Path("conferences/listconference.json")
	@Produces("application/json")
	ClientResponse<Message360<ConferenceMessages>> listConference(
			@PathParam("AccountSid") String accountSid,
			@QueryParam("Page") Integer page,
			@QueryParam("PageSize") Integer pageSize,
			@QueryParam("FriendlyName") String friendlyName,
			@QueryParam("Status") ConferenceStatus Status,
			@QueryParam("DateCreated") Date dateCreated,
			@QueryParam("DateUpdated") Date dateUpdated
			);
	
	@POST
	@Path("Conferences/addParticipant.json")
	@Produces("application/json")
	ClientResponse<Message360<ConferenceMessages>> addParticipant(
			@PathParam("AccountSid") String accountSid,
			@QueryParam("conferencesid") String conferencesid,
			@QueryParam("participantnumber") String participantnumber,
			@QueryParam("muted") Boolean muted,
			@QueryParam("deaf") Boolean deaf,
			@QueryParam("tocountrycode") Integer tocountrycode
			);
	
	
	@POST
	@Path("conferences/viewparticipant.json")
	@Produces("application/json")
	ClientResponse<Message360<ConferenceMessages>> viewParticipant(
			@PathParam("AccountSid") String accountSid,
			@QueryParam("conferencesid") String conferenceid,
			@QueryParam("participantsid") String participantsid
			);
	
	
	@POST
	@Path("conferences/listparticipant.json")
	@Produces("application/json")
	ClientResponse<Message360<ConferenceMessages>> listParticipant(
			@PathParam("AccountSid") String accountSid,
			@QueryParam("Page") Integer page,
			@QueryParam("PageSize") Integer pageSize,
			@QueryParam("Muted") Boolean muted,
			@QueryParam("deaf") Boolean deaf,
			@QueryParam("conferenceid") String conferenceid
			);
	
	@POST
	@Path("Conferences/deafMuteParticipant.json")
	@Produces("application/json")
	ClientResponse<Message360<ConferenceMessages>> deafMuteParticipant(
			@PathParam("AccountSid") String accountSid,
			@QueryParam("conferencesid") String conferenceSid,
			@QueryParam("participantsid") String participantSid,
			@QueryParam("muted") Boolean muted,
			@QueryParam("deaf") Boolean deaf
			);
	
	@POST
	@Path("Conferences/hangupParticipant.json")
	@Produces("application/json")
	ClientResponse<Message360<ConferenceMessages>> hangupParticipant(
			@PathParam("AccountSid") String accountSid,
			@QueryParam("conferencesid") String conferencesid,
			@QueryParam("participantsid") String participantSid
			);
	
	@POST
	@Path("Conferences/playAudio.json")
	@Produces("application/json")
	ClientResponse<Message360<ConferenceMessages>> playAudio(
			@PathParam("AccountSid") String accountSid,
			@QueryParam("conferencesid") String Conferenceid,
			@QueryParam("participantsid") String participant_Sid,
			@QueryParam("audiourl") String audiourl
			);
	
}
