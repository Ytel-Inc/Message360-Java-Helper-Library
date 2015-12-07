/**
 * This endpoint allows you to execute the WEB-Services and return to appropriate class
 * @version v1b
 * @since 2015-11-12 12:12:13
 * @author Ytel Inc
 * 
 */

package com.M360.api.restproxies;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.jboss.resteasy.client.ClientResponse;

import com.M360.api.domain.responses.AccountMessage;
import com.M360.api.domain.Message360;

public interface AccountsProxy {
	
	@GET
	@Path("accounts/viewaccount.json")
	@Produces("application/json")
	ClientResponse<Message360<AccountMessage>> getAccount(
			@PathParam("AccountSid") String accountSid
			);
}
