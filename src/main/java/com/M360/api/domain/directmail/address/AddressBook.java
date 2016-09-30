package com.M360.api.domain.directmail.address;


import org.codehaus.jackson.annotate.JsonProperty;

import com.M360.api.domain.directmail.DirectMail;

public class AddressBook extends DirectMail{

	@JsonProperty(value="Phone")
	private String phone = null;
	public AddressBook(){
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}
