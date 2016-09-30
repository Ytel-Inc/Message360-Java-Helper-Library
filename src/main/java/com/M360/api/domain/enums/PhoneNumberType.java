package com.M360.api.domain.enums;

import java.util.HashMap;
import java.util.Map;

import org.codehaus.jackson.annotate.JsonCreator;

import com.M360.api.domain.enums.util.EnumUtil;

public enum PhoneNumberType {
	VOICE, SMS,ALL;
	
	private static Map<PhoneNumberType, String> map;
	
	static {
		map = new HashMap<PhoneNumberType, String>();
		map.put(VOICE, "voice");
		map.put(SMS, "sms");
		map.put(ALL, "all");
	}
	
	@JsonCreator
	public static PhoneNumberType forValue(String s) {
		return EnumUtil.getValue(s, map, null);
	}
	
	@Override
	public String toString() {
		return map.get(this);
	}
}