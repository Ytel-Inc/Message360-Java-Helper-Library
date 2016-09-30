package com.M360.api.domain.enums;

import java.util.HashMap;
import java.util.Map;

import org.codehaus.jackson.annotate.JsonCreator;

import com.M360.api.domain.enums.util.EnumUtil;

public enum ExtraService {
	CERTIFIED,REGISTERED;
	
	private static Map<ExtraService, String> map;
	
	static {
		map = new HashMap<ExtraService, String>();
		map.put(CERTIFIED, "certified");
		map.put(REGISTERED, "registered");
	}
	
	@JsonCreator
	public static ExtraService forValue(String s) {
		return EnumUtil.getValue(s, map, null);
	}
	
	@Override
	public String toString() {
		return map.get(this);
	}
}
