package com.M360.api.domain.phonenumber;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;


public class Phones {
	@JsonProperty(value="Phone")
	private List<Phone> phone = null;
	
	public Phones(){
		super();
		phone=new ArrayList<Phone>();
	}

	public List<Phone> getPhone() {
		return phone;
	}

	public void setPhone(List<Phone> phone) {
		this.phone = phone;
	}
	
	
}
