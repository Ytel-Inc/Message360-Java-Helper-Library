package com.M360.api.domain.enums;

import java.util.HashMap;
import java.util.Map;

import org.codehaus.jackson.annotate.JsonCreator;

import com.M360.api.domain.enums.util.EnumUtil;

public enum TranscriptionStatus {
	COMPLETED, IN_PROGRESS, FAILED;
	
	private static Map<TranscriptionStatus, String> map;
	
	static {
		map = new HashMap<TranscriptionStatus, String>();
		map.put(COMPLETED, "completed");
		map.put(IN_PROGRESS, "in-progress");
		map.put(FAILED, "failed");
		
	}
	
	@JsonCreator
	public static TranscriptionStatus forValue(String s) {
		return EnumUtil.getValue(s, map, null);
	}
	
	@Override
	public String toString() {
		return map.get(this);
	}
	
}
