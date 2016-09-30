package com.M360.api.configuration;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class M360Constants {
	//Production
	public static final String BASE_URL = "https://api.message360.com";
	//development
	public static final String DIRECT_MAIL = "directmail";
	public static final String API_VERSION = "api/v2";

	//USE YOUR ACCOUNT CREDENTAIL
	
	public static final String ACCOUNTSID="c8abd1ad-980c-42fe-7c29-0000dd752fc";
	public static final String AUTHTOKEN="fcdc0azer0603f07d17115c1f879e493";
		
	public static final boolean JSONFORMAT=true;//false
	
	public static final SimpleDateFormat queryDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:sss");
	public static final SimpleDateFormat jsonDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:sss", Locale.ENGLISH);
	
}
