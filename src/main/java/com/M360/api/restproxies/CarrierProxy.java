package com.M360.api.restproxies;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.jboss.resteasy.client.ClientResponse;

import com.M360.api.domain.Message360;
import com.M360.api.domain.responses.CallMessages;
import com.M360.api.domain.responses.CarrierMessage;

public interface CarrierProxy {
	
	@POST
	@Path("carrier/lookup.json")
	@Produces("application/json")
	ClientResponse<Message360<CarrierMessage>> carrierLookup(
			@PathParam("AccountSid") String accountSid,
			@QueryParam("phonenumber") String phoneNumber
			);
	
	@POST
	@Path("carrier/lookuplist.json")
	@Produces("application/json")
	ClientResponse<Message360<CarrierMessage>> carrierLookupList(
			@PathParam("AccountSid") String accountSid,
			@QueryParam("page") Long page,
			@QueryParam("pageSize") Long pageSize
			);
}
