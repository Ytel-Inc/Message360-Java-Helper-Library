package com.M360.api.domain.enums;

import java.util.HashMap;
import java.util.Map;

import org.codehaus.jackson.annotate.JsonCreator;

import com.M360.api.domain.enums.util.EnumUtil;

public enum Direction {
	IN, OUT,BOTH;
	
	private static Map<Direction, String> map;
	
	static {
		map = new HashMap<Direction, String>();
		map.put(IN, "in");
		map.put(OUT, "out");
		map.put(BOTH, "both");
	}
	
	@JsonCreator
	public static Direction forValue(String s) {
		return EnumUtil.getValue(s, map, null);
	}
	
	@Override
	public String toString() {
		return map.get(this);
	}
}
