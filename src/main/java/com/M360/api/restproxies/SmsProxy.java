/**
 * This endpoint allows you to execute the WEB-Services and return to appropriate class
 * @version v1b
 * @since 2015-11-12 12:12:13
 * @author Ytel Inc
 * 
 */

package com.M360.api.restproxies;

import java.util.Date;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.jboss.resteasy.client.ClientResponse;

import com.M360.api.domain.Message360;
import com.M360.api.domain.responses.SMSMessages;

public interface SmsProxy {
	
	@GET
	@Path("sms/viewsms/{SMSMessageSid}.json")
	@Produces("application/json")
	ClientResponse<Message360<SMSMessages>> getSmsMessage(
			@PathParam("AccountSid") String accountSid, 
			@PathParam("SMSMessageSid") String smsMessageSid
			);
	
	@POST
	@Path("sms/listsms.json")
	@Produces("application/json")
	ClientResponse<Message360<SMSMessages>> getSmsMessageList(
			@PathParam("AccountSid") String accountSid,
			@QueryParam(value="To") String to,
			@QueryParam(value="From") String from,
			@QueryParam(value="DateSent>") String dateSentGte,
			@QueryParam(value="DateSent<") String dateSentLt,
			@QueryParam(value="Page") Long page,
			@QueryParam(value="PageSize") Long pageSize
			);
	
	@POST
	@Path("sms/sendsms.json")
	@Produces("application/json")
	ClientResponse<Message360<SMSMessages>> sendSmsMessage(
			@PathParam("AccountSid") String accountSid,
			@QueryParam(value="To") String to,
			@QueryParam(value="From") String from,
			@QueryParam(value="Body") String body,
			@QueryParam(value="method") String method,
			@QueryParam(value="FromCountryCode") Integer fromcountrycode,
			@QueryParam(value="ToCountryCode") Integer tocountrycode,
			@QueryParam(value="StatusCallback") String statusCallback
			);
	
	@POST
	@Path("sms/numberoptin.json")
	@Produces("application/json")
	ClientResponse<Message360<SMSMessages>> getNumberOptins(
			@PathParam("AccountSid") String accountSid,
			@QueryParam(value="To") String to,
			@QueryParam(value="From") String from,
			@QueryParam(value="FromCountryCode") Integer fromcountrycode,
			@QueryParam(value="ToCountryCode") Integer tocountrycode,
			@QueryParam(value="Expires") Integer expires,
			@QueryParam(value="Authorizedby") String authorizedby,
			@QueryParam(value="Authorizedhow") String authorizedhow
			);
	
	
	@POST
	@Path("Sms/getinboundsms.json")
	@Produces("application/json")
	ClientResponse<Message360<SMSMessages>> getInboundSms(
			@PathParam("AccountSid") String accountSid,
			@QueryParam(value="To") String to,
			@QueryParam(value="From") String from,
			@QueryParam(value="DateReceived") Date dateReceived,
			@QueryParam(value="Page") Long page,
			@QueryParam(value="PageSize") Long pageSize
			);
	    
}

