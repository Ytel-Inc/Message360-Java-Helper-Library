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
import com.M360.api.domain.enums.HttpMethod;
import com.M360.api.domain.enums.PhoneNumberType;
import com.M360.api.domain.responses.NumberMessage;

public interface PhoneProxy {
	
	@POST
	@Path("incomingphone/availablenumber.json")
	@Produces("application/json")
	ClientResponse<Message360<NumberMessage>> availableNumber(
			@PathParam("AccountSid") String accountSid,
			@QueryParam(value="areacode") Integer areacode,
			@QueryParam(value="numbertype") PhoneNumberType numbertype,
			@QueryParam(value="pagesize") Integer pagesize
			);
	
	
	@POST
	@Path("incomingphone/viewnumber.json")
	@Produces("application/json")
	ClientResponse<Message360<NumberMessage>> viewNumber(
			@PathParam("AccountSid") String accountSid,
			@QueryParam("phonenumber") String phoneNumber
			);
	
	
	@POST
	@Path("incomingphone/listnumber.json")
	@Produces("application/json")
	ClientResponse<Message360<NumberMessage>> listNumber(
			@PathParam("AccountSid") String accountSid,
			@QueryParam("Page") Integer page,
			@QueryParam("PageSize") Integer pageSize,
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
	
	@DELETE
	@Path("incomingphone/releasenumber.json")
	@Produces("application/json")
	ClientResponse<Message360<NumberMessage>> releaseNumber(
			@PathParam("AccountSid") String accountSid,
			@QueryParam("phonenumber") String releaseNumber
			);
	
}
