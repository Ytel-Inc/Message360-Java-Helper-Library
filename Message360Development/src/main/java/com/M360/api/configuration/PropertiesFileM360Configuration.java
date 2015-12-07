package com.M360.api.configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

import org.apache.log4j.Logger;

/**
 * A TelapiConfiguration implementation which loads the configuration from a file.
 * @see M360Configuration
 *
 */
public class PropertiesFileM360Configuration extends Properties implements M360Configuration {
	private static final long serialVersionUID = -7348144965758395514L;
	Logger logger = Logger.getLogger(PropertiesFileM360Configuration.class);
	
	/**
	 * Creates a TelapiConfiguration from a file called "message360.properties" which must be on the classpath.
	 */
	public PropertiesFileM360Configuration() {
		this("message360.properties");
	}
	
	/**
	 * Creates a TelapiConfiguration from a file which must be on the classpath.
	 * @param propFileName The fileName of the properties file.
	 */
	public PropertiesFileM360Configuration(String propFileName) {
		URL url = ClassLoader.getSystemResource(propFileName);
		try {
			load(url.openStream());
		} catch (IOException e) {
			logger.error("Cannot load or find Telapi properties file on classpath: "
					+ propFileName, e);
		}
	}
	
	/**
	 * Creates a TelapiConfiguration by loading properties from the provided FileInputStream.
	 * @param is The FileInputStream from which to load the configuration.
	 */
	public PropertiesFileM360Configuration(FileInputStream is) {
		try {
			load(is);
		} catch (IOException e) {
			logger.error("Cannot load the specified Telapi properties file.");
		}
	}

	public String getSid() {
		return getProperty("sid");
	}

	public String getAuthToken() {
		return getProperty("authToken");
	}

	public String getBaseUrl() {
		return getProperty("baseUrl", M360Constants.BASE_URL);
	}

	public String getProxyHost() {
		return getProperty("proxyHost", null);
	}

	public String getProxyPort() {
		return getProperty("proxyPort", null);
	}

	public String getProxyProtocol() {
		return getProperty("proxyProtocol", null);
	}
	
	

}
