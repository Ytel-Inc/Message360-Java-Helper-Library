package com.M360.api.domain.directmail.areamail;

import org.codehaus.jackson.annotate.JsonProperty;

import com.M360.api.domain.directmail.Tracking;

public class AreaMail {
	
	@JsonProperty(value="AreamailsDetails")
	private AreaMailsDetails areaMailDetails = null;
	@JsonProperty(value="RoutesDetails")
	private RoutesDetails routesDetails = null;
	@JsonProperty(value="Tracking")
	private Tracking tracking = null;
	
	public  AreaMail() {
		areaMailDetails = new AreaMailsDetails();
		routesDetails = new RoutesDetails();
		tracking =new Tracking();
	}

	public AreaMailsDetails getAreaMailDetails() {
		return areaMailDetails;
	}
	public void setAreaMailDetails(AreaMailsDetails areaMailDetails) {
		this.areaMailDetails = areaMailDetails;
	}

	public RoutesDetails getRoutesDetails() {
		return routesDetails;
	}

	public void setRoutesDetails(RoutesDetails routesDetails) {
		this.routesDetails = routesDetails;
	}

	public Tracking getTracking() {
		return tracking;
	}

	public void setTracking(Tracking tracking) {
		this.tracking = tracking;
	}

}
