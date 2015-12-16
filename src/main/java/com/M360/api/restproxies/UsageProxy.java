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
import com.M360.api.domain.enums.ProductType;
import com.M360.api.domain.responses.UsageMessage;

public interface UsageProxy {
	
	@POST
	@Path("usage/listusage.json")
	@Produces("application/json")
	ClientResponse<Message360<UsageMessage>> listUsage(
			@PathParam("AccountSid") String accountSid,
			@QueryParam("ProductCode") ProductType product, 
			@QueryParam("startDate>=") String from,
			@QueryParam("endDate<=") String to
			);
}
