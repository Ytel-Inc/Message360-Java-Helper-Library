package com.M360.api.domain.enums;

import java.util.HashMap;
import java.util.Map;

import org.codehaus.jackson.annotate.JsonCreator;

import com.M360.api.domain.enums.util.EnumUtil;

public enum EmailSendAs {
	TEXT,HTML;
	
	private static Map<EmailSendAs, String> map;
	
	static {
		map = new HashMap<EmailSendAs, String>();
		map.put(TEXT, "text");
		map.put(HTML, "html");
	}
	
	@JsonCreator
	public static EmailSendAs forValue(String s) {
		return EnumUtil.getValue(s, map, null);
	}
	
	@Override
	public String toString() {
		return map.get(this);
	}
}
