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
import javax.ws.rs.QueryParam;

import org.jboss.resteasy.client.ClientResponse;

import com.M360.api.domain.Message360;
import com.M360.api.domain.enums.AudioDirection;
import com.M360.api.domain.enums.AudioFormat;
import com.M360.api.domain.enums.CallInterruptStatus;
import com.M360.api.domain.enums.Direction;
import com.M360.api.domain.enums.HttpMethod;
import com.M360.api.domain.responses.CallMessages;

public interface CallProxy {

	@GET
	@Path("Calls/viewCalls/{callSid}.json")
	@Produces("application/json")
	ClientResponse<Message360<CallMessages>> viewCall(
			@PathParam("AccountSid") String accountSid,
			@PathParam("callSid") String callsid
			);
	
	@POST
	@Path("Calls/listCalls.json")
	@Produces("application/json")
	ClientResponse<Message360<CallMessages>> listCalls(
			@PathParam("AccountSid") String accountSid,
    		@QueryParam("To") String to,
    		@QueryParam("From") String from,
    		@QueryParam("StartTime") String startTimeGte,
    		@QueryParam("Page") Long page,
    		@QueryParam("PageSize") Long pageSize
			);
	
	@POST
	//@Path("Calls/makeCall.json")//production
	@Path("calls/makecall.json")//DEVELOPMENT
	@Produces("application/json")
	ClientResponse<Message360<CallMessages>> makeCall(
			@PathParam("AccountSid") String accountSid,
			@QueryParam(value = "FromCountryCode") Integer fromCountryCode,
			@QueryParam(value = "From") String from,
			@QueryParam(value = "ToCountryCode") Integer toCountryCode,
			@QueryParam(value = "To") String to,
			@QueryParam(value = "Url") String url,
			@QueryParam(value = "Method") HttpMethod method,
			@QueryParam(value = "StatusCallBack") String statusCallback,
			@QueryParam(value = "StatusCallBackMethod") HttpMethod StatusCallbackMethod,
			@QueryParam(value = "FallBackUrl") String fallbackUrl,
			@QueryParam(value = "FallBackMethod") HttpMethod fallbackMethod,
			@QueryParam(value = "HeartBeatUrl") String heartbeatUrl,
			@QueryParam(value = "HeartBeatMethod") HttpMethod heartbeatMethod,
			@QueryParam(value = "ForwardedFrom") String forwardedFrom,
			@QueryParam(value = "Timeout") Long timeout,
			@QueryParam(value = "PlayDtmf") String playDtmf,
			@QueryParam(value = "HideCallerId") Boolean HideCallerId,
			@QueryParam(value = "Record") Boolean record,
			@QueryParam(value = "RecordCallBack") Integer recordCallback,
			@QueryParam(value = "RecordCallBackMethod") HttpMethod recordCallbackMethod,
			@QueryParam(value = "Transcribe") Boolean transcribe,
			@QueryParam(value = "TranscribeQuality") String transcribeCallback,
			@QueryParam(value = "StraightToVoicemail") String straightToVoicemail,
			@QueryParam(value = "IfMachine") String ifMachine,
			@QueryParam(value = "IfMachineUrl") String ifMachineUrl,
			@QueryParam(value = "IfMachineMethod") String ifMachineMethod
	);
	
	@POST
	@Path("Calls/interruptCalls.json")//production
	//@Path("calls/interruptcalls.json")//development
	@Produces("application/json")
	ClientResponse<Message360<CallMessages>> interruptCall(
			@PathParam("AccountSid") String accountSid,
			@QueryParam("CallSid") String callSid,
			@QueryParam("Method") HttpMethod method,
			@QueryParam("Status") CallInterruptStatus status,
			@QueryParam("Url") String url
	);
	
	@POST
	@Path("calls/sendDigits.json")
	@Produces("application/json")
	ClientResponse<Message360<CallMessages>> sendDigits(
			@PathParam("AccountSid") String accountSid,
			@QueryParam(value = "CallSid") String callSid,
			@QueryParam(value = "PlayDtmf") String  playDtmf,
			@QueryParam(value = "PlayDtmfDirection") Direction  playDtmfDirection
	);
	
	
	@POST
	@Path("Calls/playAudios.json")
	@Produces("application/json")
	ClientResponse<Message360<CallMessages>> playAudio(
			@PathParam("AccountSid") String accountSid,
			@QueryParam("CallSid") String callSid,
			@QueryParam("Mix") Boolean mix,
			@QueryParam("Length") Long length,
			@QueryParam("Loop") Boolean loop,
			@QueryParam("AudioUrl") String audioUrl
	);
	
	
	@POST
	@Path("Calls/voiceEffect.json")
	@Produces("application/json")
	ClientResponse<Message360<CallMessages>> voiceEffects(
			@PathParam("AccountSid") String accountSid,
			@QueryParam("CallSid") String callSid,
			@QueryParam("AudioDirection") AudioDirection audioDirection,
			@QueryParam("PitchSemiTones") Long pitchSemiTones,
			@QueryParam("PitchOctaves") Long pitchOctaves,
			@QueryParam("Pitch") Long pitch,
			@QueryParam("Rate") Long rate,
			@QueryParam("Tempo") Long tempo
	);
	
	@POST
	@Path("Calls/recordCalls.json")
	@Produces("application/json")
	ClientResponse<Message360<CallMessages>> recordCall(
			@PathParam("AccountSid") String accountSid,
			@QueryParam("CallSid") String callSid,
			@QueryParam("Direction") Direction direction,
			@QueryParam("Record") boolean record,
			@QueryParam("TimeLimit") Long timeLimit,
			@QueryParam("CallBackUrl") String callBackUrl,
			@QueryParam("Fileformat") AudioFormat fileFormat
	);
	
}
