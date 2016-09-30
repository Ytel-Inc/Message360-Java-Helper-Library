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
import com.M360.api.domain.enums.HttpMethod;
import com.M360.api.domain.responses.SMSMessages;

public interface SmsProxy {
	
	@POST
	@Path("sms/viewsms.json")
	@Produces("application/json")
	ClientResponse<Message360<SMSMessages>> getSmsMessage(
			@PathParam("AccountSid") String accountSid, 
			@QueryParam("messagesid") String smsMessageSid
			);
	
	@POST
	@Path("sms/listsms.json")
	@Produces("application/json")
	ClientResponse<Message360<SMSMessages>> getSmsMessageList(
			@PathParam("AccountSid") String accountSid,
			@QueryParam(value="To") String to,
			@QueryParam(value="From") String from,
			@QueryParam(value="DateSent>") String dateSentGte,
			@QueryParam(value="Page") Integer page,
			@QueryParam(value="PageSize") Integer pageSize
			);
	
	@POST
	@Path("sms/sendsms.json")
	@Produces("application/json")
	ClientResponse<Message360<SMSMessages>> sendSmsMessage(
			@PathParam("AccountSid") String accountSid,
			@QueryParam(value="To") String to,
			@QueryParam(value="From") String from,
			@QueryParam(value="Body") String body,
			@QueryParam(value="method") HttpMethod method,
			@QueryParam(value="FromCountryCode") Integer fromcountrycode,
			@QueryParam(value="ToCountryCode") Integer tocountrycode,
			@QueryParam(value="StatusCallback") String statusCallback
			);
	
	
	@POST
	@Path("Sms/getinboundsms.json")
	@Produces("application/json")
	ClientResponse<Message360<SMSMessages>> getInboundSms(
			@PathParam("AccountSid") String accountSid,
			@QueryParam(value="to") String to,
			@QueryParam(value="from") String from,
			@QueryParam(value="datereceived") String dateReceived,
			@QueryParam(value="page") Integer page,
			@QueryParam(value="pagesize") Integer pageSize
			);
	    
}

