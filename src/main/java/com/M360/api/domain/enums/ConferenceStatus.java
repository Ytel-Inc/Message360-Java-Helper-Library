package com.M360.api.domain.enums;

import java.util.HashMap;
import java.util.Map;

import org.codehaus.jackson.annotate.JsonCreator;

import com.M360.api.domain.enums.util.EnumUtil;

public enum ConferenceStatus {
	 IN_PROGRESS, COMPLETED;
	
	private static Map<ConferenceStatus, String> map;
	
	static {
		map = new HashMap<ConferenceStatus, String>();
		map.put(IN_PROGRESS, "in-progress");
		map.put(COMPLETED, "completed");
	}
	
	@JsonCreator
	public static ConferenceStatus forValue(String s) {
		return EnumUtil.getValue(s, map, null);
	}
	
	@Override
	public String toString() {
		return map.get(this);
	}
}
