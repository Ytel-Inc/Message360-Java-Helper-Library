package com.M360.api.configuration;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class M360Constants {
	//development
	public static final String BASE_URL = "https://api-dev.message360.com";
	public static final String API_VERSION = "api/v1b";
	
	
	public static final String ACCOUNTSID1="YTaa972478db58e151d9c67a3521e6d7191";
	//public static final String ACCOUNTSID="YTaa972478db58e151d9c67a3521e6d719";//rizwan@xoyal.c at development
	//public static final String AUTHTOKEN="f03ad426b8775a7ef81b53593727476e";//
		
	public static final String ACCOUNTSID="YT94c49d220e5a45dc516f9733460460f5";//sangeeth@xoyal.c at development
	public static final String AUTHTOKEN="53ee61684ef2a3805fb4721dfdf9672f";//
		
	public static final boolean JSONFORMAT=true;
	
	
	public static final SimpleDateFormat queryDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:sss");
	public static final SimpleDateFormat jsonDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:sss", Locale.ENGLISH);
	
}
