package com.M360.api.example.phonenumber;

import com.M360.api.Message360Connector;
import com.M360.api.configuration.BasicM360Configuration;
import com.M360.api.configuration.M360Constants;
import com.M360.api.domain.Message360;
import com.M360.api.domain.responses.NumberMessage;
import com.M360.api.exception.Error;
import com.M360.api.exception.M360Exception;

public class ReleaseNumber {
	public static void main(String[] args) {
		BasicM360Configuration conf = new BasicM360Configuration();
		conf.setSid(M360Constants.ACCOUNTSID); 
		conf.setAuthToken(M360Constants.AUTHTOKEN);
		Message360Connector conn = new Message360Connector(conf);
		try {
			if(M360Constants.JSONFORMAT){
				String jsonSMSResponse=conn.releaseJsonNumber("{phoneNumber}");
				System.out.println(jsonSMSResponse);
			}else{
				Message360<NumberMessage> releaseNumber = conn.releaseNumber("{phoneNumber}");
				if(releaseNumber.getMessage360().getErrors().getError().size()!=0){
					for(int x=0;x<releaseNumber.getMessage360().getErrors().getError().size();x++){
						Error error=releaseNumber.getMessage360().getErrors().getError().get(x);
							System.out.println("code :="+error.getCode()+".\nMessage:="+error.getMessage()+",\nMoreInfo"+error.getMoreInfo().toString());
					}
				}else{
					System.out.println("Release Number:");
					System.out.println(releaseNumber.getMessage360().getRelease().getAccountSid()+" "+releaseNumber.getMessage360().getRelease().getStatus());
				}
			}
		} catch (M360Exception e) {
			e.printStackTrace();
		}
	}
}
