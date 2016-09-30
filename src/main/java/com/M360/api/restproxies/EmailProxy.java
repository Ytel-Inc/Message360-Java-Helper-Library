/**
 * This endpoint allows you to execute the WEB-Services and return to appropriate class
 * @version v1b
 * @since 2015-11-12 12:12:13
 * @author Ytel Inc
 * 
 */

package com.M360.api.restproxies;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.jboss.resteasy.client.ClientResponse;

import com.M360.api.domain.responses.Message360Email;
import com.M360.api.domain.Message360;
import com.M360.api.domain.email.Blocked;
import com.M360.api.domain.email.Bounce;
import com.M360.api.domain.email.Invalid;
import com.M360.api.domain.email.SendEmail;
import com.M360.api.domain.email.Spam;
import com.M360.api.domain.email.Unsubscribed;
import com.M360.api.domain.enums.EmailSendAs;

public interface EmailProxy {

	@POST
	@Path("email/sendemails.json")
	@Produces("application/json")
	ClientResponse<Message360<Message360Email<SendEmail>>> sendEmail(
			@PathParam("AccountSid") String accountSid,
			@QueryParam(value="to") String to,
			@QueryParam(value="cc") String cc,
			@QueryParam(value="bcc") String bcc,
			@QueryParam(value="subject") String subject,
			@QueryParam(value="type") EmailSendAs type,
			@QueryParam(value="message") String message,
			@QueryParam(value="attachment") List<String> attachment
			
			);
	
	
	@POST
	@Path("email/listblockemail.json")
	@Produces("application/json")
	ClientResponse<Message360<Message360Email<Blocked>>> listBlockedEmailList(
			@PathParam("AccountSid") String accountSid,
			@QueryParam(value="Offset") Integer offSet,
			@QueryParam(value="Limit") Integer limit
			);

	@DELETE
	@Path("email/deleteblocksemail.json")
	@Produces("application/json")
	ClientResponse<Message360<Message360Email<Blocked>>> deleteBlocksEmailAdrees(
			@PathParam("AccountSid") String accountSid,
			@QueryParam(value="email") String email
			);
	
	
	@POST
	@Path("email/listbounceemail.json")
	@Produces("application/json")
	ClientResponse<Message360<Message360Email<Bounce>>> listBouncesEmail(
			@PathParam("AccountSid") String accountSid,
			@QueryParam(value="Offset") Integer offSet,
			@QueryParam(value="Limit") Integer limit
			);
	
	
	@DELETE
	@Path("email/deletebouncesemail.json")
	@Produces("application/json")
	ClientResponse<Message360<Message360Email<Bounce>>> deleteBouncesEmail(
			@PathParam("AccountSid") String accountSid,
			@QueryParam("email") String email
			);
	
	
	@POST
	@Path("email/listspamemail.json")
	@Produces("application/json")
	ClientResponse<Message360<Message360Email<Spam>>> listSpamEmail(
			@PathParam("AccountSid") String accountSid,
			@QueryParam(value="Offset") Integer offSet,
			@QueryParam(value="Limit") Integer limit
			);
	
	@DELETE
	@Path("email/deletespamemail.json")
	@Produces("application/json")
	ClientResponse<Message360<Message360Email<Spam>>> deleteSpamEmail(
			@PathParam("AccountSid") String accountSid,
			@QueryParam(value="email") String email
			);
	
	@POST
	@Path("email/listinvalidemail.json")
	@Produces("application/json")
	ClientResponse<Message360<Message360Email<Invalid>>> listInvalidEmail(
			@PathParam("AccountSid") String accountSid,
			@QueryParam(value="Offset") Integer offSet,
			@QueryParam(value="Limit") Integer limit
			);
	
	@DELETE
	@Path("email/deleteinvalidemail.json")
	@Produces("application/json")
	ClientResponse<Message360<Message360Email<Invalid>>> deleteInvalidEmail(
			@PathParam("AccountSid") String accountSid,
			@QueryParam(value="email") String email
			);
	
	
	@POST
	@Path("email/addunsubscribesemail.json")
	@Produces("application/json")
	ClientResponse<Message360<Message360Email<Unsubscribed>>> addUnsubscribeEmailAdreess(
			@PathParam("AccountSid") String accountSid,
			@QueryParam(value="email") String email
			);
	
	
	
	@POST
	@Path("email/listunsubscribedemail.json")
	@Produces("application/json")
	ClientResponse<Message360<Message360Email<Unsubscribed>>> listUnsubscribeEmailAddress(
			@PathParam("AccountSid") String accountSid,
			@QueryParam(value="Offset") Integer offSet,
			@QueryParam(value="Limit") Integer limit
			);
	
	
	@DELETE
	@Path("email/deleteunsubscribedemail.json")
	@Produces("application/json")
	ClientResponse<Message360<Message360Email<Unsubscribed>>> deleteUnsubscribeEmailAddress(
			@PathParam("AccountSid") String accountSid,
			@QueryParam(value="email") String email
			);
	
}
