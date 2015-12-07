package com.M360.api.domain.enums;

import java.util.HashMap;
import java.util.Map;

import org.codehaus.jackson.annotate.JsonCreator;

import com.M360.api.domain.enums.util.EnumUtil;


public enum ProductType {
	ALL, OUTBOUND_CALL,INBOUND_CALL,OUTBOUND_SMS,INBOUND_SMS,TRANSCRIPTION,EMAIL,NUMBER_PURCHASED,
	DIRECT_MAIL_VERIFICATION,DIRECT_MAIL_POSTCARD,DIRECT_MAIL_LETTERS,DIRECT_MAIL_CHECKS,
	DIRECT_MAIL_PRINTS,DIRECT_MAIL_AREAMAILS;
	
	private static Map<ProductType, String> map;
	
	static {
		map = new HashMap<ProductType, String>();
		map.put(ALL, "0");
		map.put(OUTBOUND_CALL, "1");
		map.put(INBOUND_CALL, "2");
		map.put(OUTBOUND_SMS, "3");
		map.put(INBOUND_SMS, "4");
		map.put(TRANSCRIPTION, "5");
		map.put(EMAIL, "6");
		map.put(NUMBER_PURCHASED, "7");
		map.put(DIRECT_MAIL_VERIFICATION, "8");
		map.put(DIRECT_MAIL_POSTCARD, "9");
		map.put(DIRECT_MAIL_LETTERS, "10");
		map.put(DIRECT_MAIL_CHECKS, "11");
		map.put(DIRECT_MAIL_PRINTS, "12");
		map.put(DIRECT_MAIL_AREAMAILS, "13");
	}
	
	@JsonCreator
	public static ProductType forValue(String s) {
		return EnumUtil.getValue(s, map, null);
	}
	
	@Override
	public String toString() {
		return map.get(this);
	}
}
