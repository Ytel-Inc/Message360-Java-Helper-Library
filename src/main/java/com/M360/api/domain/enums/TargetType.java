package com.M360.api.domain.enums;

import java.util.HashMap;
import java.util.Map;

import org.codehaus.jackson.annotate.JsonCreator;

import com.M360.api.domain.enums.util.EnumUtil;

public enum TargetType {
	BUSINESS_AND_RESIDENTIAL,RESIDENTIAL_ONLY;
	
	private static Map<TargetType, String> map;
	
	static {
		map = new HashMap<TargetType, String>();
		map.put(BUSINESS_AND_RESIDENTIAL, "all");
		map.put(RESIDENTIAL_ONLY, "Residentail Only");
	}
	
	@JsonCreator
	public static TargetType forValue(String s) {
		return EnumUtil.getValue(s, map, null);
	}
	
	@Override
	public String toString() {
		return map.get(this);
	}
}
