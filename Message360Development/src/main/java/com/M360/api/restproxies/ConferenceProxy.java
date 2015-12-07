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

	//viewConference
	//curl -X GET 'https://api-dev.message360.com/api/v1b/conferences/viewconference/CF7eba209c-9aaf-42c6-805a-3c3eb623138d.json' -u 'YT94c49d220e5a45dc516f9733460460f5:53ee61684ef2a3805fb4721dfdf9672f'
	
	@POST
	@Path("conferences/viewconference.json")
	@Produces("application/json")
	ClientResponse<Message360<ConferenceMessages>> viewConference(
			@PathParam("AccountSid") String accountSid,
			@QueryParam("conferencesid") String conferencesid
			);
	
	//list conference
	//curl -X POST 'https://api-dev.message360.com/api/v1b/conferences/listconference.json' -u 'YT94c49d220e5a45dc516f9733460460f5:53ee61684ef2a3805fb4721dfdf9672f' -d  
	//'Page=1&PageSize=2&FriendlyName=asd&Status=in-progress&DateCreated=2015-12-07&DateUpdated=2015-12-22'
	
	@POST
	@Path("conferences/listconference.json")
	@Produces("application/json")
	ClientResponse<Message360<ConferenceMessages>> listConference(
			@PathParam("AccountSid") String accountSid,
			@QueryParam("Page") Long page,
			@QueryParam("PageSize") Long pageSize,
			@QueryParam("FriendlyName") String friendlyName,
			@QueryParam("Status") ConferenceStatus Status,
			@QueryParam("DateCreated") Date dateCreated,
			@QueryParam("DateUpdated") Date dateUpdated
			);
	
	
	//addParticepant
	//curl -X POST 'https://api-dev.message360.com/api/v1b/Conferences/addParticipant.json' -u 'YT94c49d220e5a45dc516f9733460460f5:53ee61684ef2a3805fb4721dfdf9672f' -d 
	//'conferencesid=CF7eba209c-9aaf-42c6-805a-3c3eb623138d&participantnumber=8983183436&muted=true&deaf=true&tocountrycode=1'
	
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
	
	
	//viewParticepant
	//curl -X POST 'https://api-dev.message360.com/api/v1b/conferences/viewparticipant.json' -u 'YT94c49d220e5a45dc516f9733460460f5:53ee61684ef2a3805fb4721dfdf9672f' -d  
	//'conferenceid=CF7eba209c-9aaf-42c6-805a-3c3eb623138d&participantsid=sdfsdfds'
	
	@POST
	@Path("conferences/viewparticipant.json")
	@Produces("application/json")
	ClientResponse<Message360<ConferenceMessages>> viewParticipant(
			@PathParam("AccountSid") String accountSid,
			@QueryParam("conferencesid") String conferenceid,
			@QueryParam("participantsid") String participantsid
			);
	
	
	//listParticepant
	//curl -X POST 'https://api-dev.message360.com/api/v1b/conferences/listparticipant.json'  -u 'YT94c49d220e5a45dc516f9733460460f5:53ee61684ef2a3805fb4721dfdf9672f' -d  
	//'Page=2&PageSize=3&Muted=true&deaf=false&conferenceid=CF7eba209c-9aaf-42c6-805a-3c3eb623138d'
	
	@POST
	@Path("conferences/listparticipant.json")
	@Produces("application/json")
	ClientResponse<Message360<ConferenceMessages>> listParticipant(
			@PathParam("AccountSid") String accountSid,
			@QueryParam("Page") Long page,
			@QueryParam("PageSize") Long pageSize,
			@QueryParam("Muted") Boolean muted,
			@QueryParam("deaf") Boolean deaf,
			@QueryParam("conferenceid") String conferenceid
			);
	
	//deaformute participant
	//curl -X POST 'https://api-dev.message360.com/api/v1b/Conferences/deafMuteParticipant.json'  -u 'YT94c49d220e5a45dc516f9733460460f5:53ee61684ef2a3805fb4721dfdf9672f' -d 
	//'conferenceid=CF7eba209c-9aaf-42c6-805a-3c3eb623138d&participantid=fgdfgd&muted=true&deaf=true'
	
	
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
	
	
	
	//hangupParticipant
	//curl -X POST 'https://api-dev.message360.com/api/v1b/Conferences/hangupParticipant.json' -u 'YT94c49d220e5a45dc516f9733460460f5:53ee61684ef2a3805fb4721dfdf9672f' -d  
	//'conference_id=CF7eba209c-9aaf-42c6-805a-3c3eb623138d&call_sid=dfgdfg'
	
	@POST
	@Path("Conferences/hangupParticipant.json")
	@Produces("application/json")
	ClientResponse<Message360<ConferenceMessages>> hangupParticipant(
			@PathParam("AccountSid") String accountSid,
			@QueryParam("conferencesid") String conferencesid,
			@QueryParam("participantsid") String participantSid
			);
	
	//playaudio
	//curl -X POST 'https://api-dev.message360.com/api/v1b/Conferences/playAudio.json' -u 'YT94c49d220e5a45dc516f9733460460f5:53ee61684ef2a3805fb4721dfdf9672f' -d  
	//'Conferenceid=CF7eba209c-9aaf-42c6-805a-3c3eb623138d&participant_Sid=adsfdsf&audiourl=;http://192.168.2.2/audio2.wav'
	
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
