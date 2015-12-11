package com.M360.api.domain.enums;

import java.util.HashMap;
import java.util.Map;

import org.codehaus.jackson.annotate.JsonCreator;

import com.M360.api.domain.enums.util.EnumUtil;

public enum CarrierLookupStatus {
	DELIVRD, UNDELIV, UNKNOWN, REJECTED;
	
	private static Map<CarrierLookupStatus, String> map;
	
	static {
		map = new HashMap<CarrierLookupStatus, String>();
		map.put(DELIVRD, "DELIVRD");
		map.put(UNDELIV, "UNDELIV");
		map.put(UNKNOWN, "UNKNOWN");
		map.put(REJECTED, "REJECTED");
		
	}
	
	@JsonCreator
	public static CarrierLookupStatus forValue(String s) {
		return EnumUtil.getValue(s, map, null);
	}
	
	@Override
	public String toString() {
		return map.get(this);
	}
	
}
