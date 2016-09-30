package com.M360.api.domain.enums;

import java.util.HashMap;
import java.util.Map;

import org.codehaus.jackson.annotate.JsonCreator;

import com.M360.api.domain.enums.util.EnumUtil;

public enum IfMachineStatus {
	CONTINUE, HANGUP;
	
	private static Map<IfMachineStatus, String> map;
	
	static {
		map = new HashMap<IfMachineStatus, String>();
		map.put(CONTINUE, "CONTINUE");
		map.put(HANGUP, "HANGUP");
	}
	
	@JsonCreator
	public static IfMachineStatus forValue(String s) {
		return EnumUtil.getValue(s, map, null);
	}
	
	@Override
	public String toString() {
		return map.get(this);
	}
}
