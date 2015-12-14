package com.M360.api.example.phonenumber;

import com.M360.api.Message360Connector;
import com.M360.api.configuration.BasicM360Configuration;
import com.M360.api.configuration.M360Constants;
import com.M360.api.exception.M360Exception;

public class ReleaseNumber {
	public static void main(String[] args) {
		BasicM360Configuration conf = new BasicM360Configuration();
		conf.setSid(M360Constants.ACCOUNTSID); 
		conf.setAuthToken(M360Constants.AUTHTOKEN);
		Message360Connector conn = new Message360Connector(conf);
		try {
			if(M360Constants.JSONFORMAT){
				String jsonSMSResponse=conn.releaseJsonNumber("{PhoneNumber}");
				System.out.println(jsonSMSResponse);
			}else{
				/*Not Ready */
			}
		} catch (M360Exception e) {
			e.printStackTrace();
		}
	}
}
