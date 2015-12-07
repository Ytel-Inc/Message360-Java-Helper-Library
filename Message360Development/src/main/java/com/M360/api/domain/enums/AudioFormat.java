package com.M360.api.domain.enums;

import java.util.HashMap;
import java.util.Map;

import org.codehaus.jackson.annotate.JsonCreator;

import com.M360.api.domain.enums.util.EnumUtil;

public enum AudioFormat {
	MP3,WAV;
	
	private static Map<AudioFormat, String> map;
	
	static {
		map = new HashMap<AudioFormat, String>();
		map.put(MP3, "mp3");
		map.put(WAV, "wav");
	}
	
	@JsonCreator
	public static AudioFormat forValue(String s) {
		return EnumUtil.getValue(s, map, null);
	}
	
	@Override
	public String toString() {
		return map.get(this);
	}
}
