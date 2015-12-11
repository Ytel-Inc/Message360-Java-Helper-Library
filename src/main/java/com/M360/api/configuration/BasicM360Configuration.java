/**
 * Provides a basic POJO-like implementation of TelapiConfiguration.
 * @see M360Configuration
 * @version v1b
 * @author Ytel-Inc
 * @date November 2015
 */
package com.M360.api.configuration;


public class BasicM360Configuration implements M360Configuration {

	private String sid;
	private String authToken;
	private String baseUrl = M360Constants.BASE_URL;
	private String proxyHost;
	private String proxyPort;
	private String proxyProtocol;
	
	public BasicM360Configuration() {
		
	}
	
	/**
	 * @param sid The account sid.
	 * @param authToken The authorization token.
	 */
	public BasicM360Configuration(String sid, String authToken) {
		setSid(sid);
		setAuthToken(authToken);
	}
	
	public String getSid() {
		return sid;
	}

	public String getAuthToken() {
		return authToken;
	}

	public String getBaseUrl() {
		return baseUrl;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public void setAuthToken(String authToken) {
		this.authToken = authToken;
	}

	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}

	public String getProxyHost() {
		return proxyHost;
	}

	public String getProxyPort() {
		return proxyPort;
	}

	public String getProxyProtocol() {
		return proxyProtocol;
	}

	public void setProxyHost(String proxyHost) {
		this.proxyHost = proxyHost;
	}

	public void setProxyPort(String proxyPort) {
		this.proxyPort = proxyPort;
	}

	public void setProxyProtocol(String proxyProtocol) {
		this.proxyProtocol = proxyProtocol;
	}

}
