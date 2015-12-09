package com.M360.api.domain.enums;

import java.util.HashMap;
import java.util.Map;

import org.codehaus.jackson.annotate.JsonCreator;

import com.M360.api.domain.enums.util.EnumUtil;

public enum Legs {
	ALEG, BLEG, BOTH;
	
	private static Map<Legs, String> map;
	
	static {
		map = new HashMap<Legs, String>();
		map.put(ALEG, "aleg");
		map.put(BLEG, "bleg");
		map.put(BOTH, "both");
	}
	
	@JsonCreator
	public static Legs forValue(String s) {
		return EnumUtil.getValue(s, map, null);
	}
	
	@Override
	public String toString() {
		return map.get(this);
	}
}