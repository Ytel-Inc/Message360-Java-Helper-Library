/**
 * 
 * The class used for static values for connecting M360 REST API.
 * @version v1b
 * @author Ytel-Inc
 * @date November 2015
 * 
 */
package com.M360.api.configuration;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class M360Constants {
	//development
	public static final String BASE_URL = "https://api-dev.message360.com";
	public static final String API_VERSION = "api/v1b";	
	
	// use credential
	public static final String ACCOUNTSID="{ACCOUNTSID}";
	public static final String AUTHTOKEN="{AUTHTOKEN}";
		
	public static final boolean JSONFORMAT=true;
	
	
	public static final SimpleDateFormat queryDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:sss");
	public static final SimpleDateFormat jsonDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:sss", Locale.ENGLISH);
	
}
