package com.M360.api.restproxies;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.jboss.resteasy.client.ClientResponse;

import com.M360.api.domain.Message360;
import com.M360.api.domain.directmail.responses.DMAddressBook;

public interface DM_AddressBookProxy {
	
	@POST
	@Path("addresses/create.json")
	@Produces("application/json")
	ClientResponse<Message360<DMAddressBook>> createAddressBook(
			@PathParam("AccountSid") String accountSid,
			@QueryParam("name") String name,
			@QueryParam("email") String email,
			@QueryParam("phone") String phone,
			@QueryParam("address") String address,
			@QueryParam("state") String state,
			@QueryParam("zip") String zip,
			@QueryParam("city") String city,
			@QueryParam("country") String country
			);
	
	@POST
	@Path("addresses/view.json")
	@Produces("application/json")
	ClientResponse<Message360<DMAddressBook>> viewAddressBook(
			@PathParam("AccountSid") String accountSid,
			@QueryParam("addressid") String name
			);
	
	
	@POST
	@Path("addresses/lists.json")
	@Produces("application/json")
	ClientResponse<Message360<DMAddressBook>> listAddressBook(
			@PathParam("AccountSid") String accountSid,
			@QueryParam("page") Integer page,
			@QueryParam("pagesize") Integer pagesize,
			@QueryParam("addressesid") String addressesid,
			@QueryParam("datecreated") String datecreated
			);
	
	@POST
	@Path("addresses/verify.json")
	@Produces("application/json")
	ClientResponse<Message360<DMAddressBook>> verifyAddressBook(
			@PathParam("AccountSid") String accountSid,
			@QueryParam("addressid") String addressesid
			);
	
	@POST
	@Path("addresses/delete.json")
	@Produces("application/json")
	ClientResponse<Message360<DMAddressBook>> deleteAddressBook(
			@PathParam("AccountSid") String accountSid,
			@QueryParam("addressid") String addressesid
			);
}
