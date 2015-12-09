/**
 * This endpoint allows you to execute the WEB-Services and return to appropriate class
 * @version v1b
 * @since 2015-11-12 12:12:13
 * @author Ytel Inc
 * 
 */

package com.M360.api.restproxies;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.jboss.resteasy.client.ClientResponse;

import com.M360.api.domain.Message360;
import com.M360.api.domain.enums.HttpMethod;
import com.M360.api.domain.enums.PhoneNumberType;
import com.M360.api.domain.responses.NumberMessage;

public interface PhoneProxy {
	
	@POST
	@Path("incomingphone/availablenumber.json")
	@Produces("application/json")
	ClientResponse<Message360<NumberMessage>> availableNumber(
			@PathParam("AccountSid") String accountSid,
			@QueryParam("areacode") String areacode,
			@QueryParam("region") String region,
			@QueryParam("numbertype") PhoneNumberType numbertype
			);
	
	
	@GET
	@Path("incomingphone/viewnumber/{PhoneNumber}.json")
	@Produces("application/json")
	ClientResponse<Message360<NumberMessage>> viewNumber(
			@PathParam("AccountSid") String accountSid,
			@PathParam("PhoneNumber") String phoneNumber
			);
	
	
	@POST
	@Path("incomingphone/listnumber.json")
	@Produces("application/json")
	ClientResponse<Message360<NumberMessage>> listNumber(
			@PathParam("AccountSid") String accountSid,
			@QueryParam("Page") Long page,
			@QueryParam("PageSize") Long pageSize,
			@QueryParam("FriendlyName") String friendlyName,
			@QueryParam("NumberType") PhoneNumberType numberType
			);
	
	@POST
	@Path("incomingphone/buynumber.json")
	@Produces("application/json")
	ClientResponse<Message360<NumberMessage>> buyNumber(
			@PathParam("AccountSid") String accountSid,
			@QueryParam("phonenumber") String PhoneNumber
			);
	
	
	
	//curl -X POST 'https://api-dev.message360.com/api/v1b/incomingphone/updatenumber.json' -u 'YT94c49d220e5a45dc516f9733460460f5:53ee61684ef2a3805fb4721dfdf9672f' -d 
	//'PhoneNumber=9494685018&FriendlyName=(908) 224-2413&VoiceUrl=gf&VoiceMethod=POST&VoiceFallbackUrl=fg&VoiceFallbackMethod=POST&
	//HangupCallback=fgh&HangupCallbackMethod=POST&HeartbeatUrl=fgh&HeartbeatMethod=POST&SmsUrl=fgh&SmsMethod=POST&SmsFallbackUrl=fghfg&SmsFallbackMethod=POST'
	
	@POST
	@Path("incomingphone/updatenumber.json")
	@Produces("application/json")
	ClientResponse<Message360<NumberMessage>> updateNumber(
			@PathParam("AccountSid") String accountSid,
			@QueryParam("PhoneNumber") String phoneNumber,
			@QueryParam("FriendlyName") String friendlyName,
			@QueryParam("VoiceUrl") String voiceUrl,
			@QueryParam("VoiceMethod") HttpMethod voiceMethod,
			@QueryParam("VoiceFallbackUrl") String voiceFallbackUrl,
			@QueryParam("VoiceFallbackMethod") HttpMethod voiceFallbackMethod,
			@QueryParam("HangupCallback") String hangupCallback,
			@QueryParam("HangupCallbackMethod") HttpMethod hangupCallbackMethod,
			@QueryParam("HeartbeatUrl") String heartbeatUrl,
			@QueryParam("HeartbeatMethod") HttpMethod heartbeatMethod,
			@QueryParam("SmsUrl") String smsUrl,
			@QueryParam("SmsMethod") HttpMethod smsMethod,
			@QueryParam("SmsFallbackUrl") String smsFallbackUrl,
			@QueryParam("SmsFallbackMethod") HttpMethod smsFallbackMethod
			);
	
	
	//curl -X DELETE 'https://api-dev.message360.com/api/v1b/incomingphone/releasenumber/9495350361.xml' -u 'YT94c49d220e5a45dc516f9733460460f5:53ee61684ef2a3805fb4721dfdf9672f'
	@DELETE
	@Path("incomingphone/releasenumber/{ReleaseNumber}.json")
	@Produces("application/json")
	ClientResponse<Message360<NumberMessage>> releaseNumber(
			@PathParam("AccountSid") String accountSid,
			@QueryParam("ReleaseNumber") String releaseNumber
			);
	
}
