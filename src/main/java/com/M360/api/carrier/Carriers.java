package com.M360.api.carrier;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class Carriers {
	@JsonProperty(value="Carrier")
	private List<Carrier> carrier=null;
	
	public Carriers(){
		carrier=new ArrayList<Carrier>();
	}

	public List<Carrier> getCarrier() {
		return carrier;
	}

	public void setCarrier(List<Carrier> carrier) {
		this.carrier = carrier;
	}
	
	
	
}
