package com.M360.api.example.phonenumber;

import com.M360.api.Message360Connector;
import com.M360.api.configuration.BasicM360Configuration;
import com.M360.api.configuration.M360Constants;
import com.M360.api.domain.Message360;
import com.M360.api.domain.phonenumber.Phone;
import com.M360.api.domain.responses.NumberMessage;
import com.M360.api.exception.Error;
import com.M360.api.exception.M360Exception;
import com.M360.api.requests.IncomingPhoneNumberRequest;

public class UpdateNumber {
	public static void main(String[] args) {
		BasicM360Configuration conf = new BasicM360Configuration();
		conf.setSid(M360Constants.ACCOUNTSID); 
		conf.setAuthToken(M360Constants.AUTHTOKEN);
		Message360Connector conn = new Message360Connector(conf);
		try {
			IncomingPhoneNumberRequest incomingPhoneRequest=new IncomingPhoneNumberRequest();
			incomingPhoneRequest.setPhoneNumber("{phoneNumber}");//
			incomingPhoneRequest.setFriendlyName("{FriendlyName}");//to be update
			if(!M360Constants.JSONFORMAT){
				String jsonSMSResponse=conn.updateJsonNumber(incomingPhoneRequest);
				System.out.println(jsonSMSResponse);
			}else{
				Message360<NumberMessage> updateNumber = conn.updateNumber(incomingPhoneRequest);
				if(updateNumber.getMessage360().getErrors().getError().size()!=0){
					for(int x=0;x<updateNumber.getMessage360().getErrors().getError().size();x++){
						Error error=updateNumber.getMessage360().getErrors().getError().get(x);
							System.out.println("code :="+error.getCode()+".\nMessage:="+error.getMessage()+",\nMoreInfo"+error.getMoreInfo().toString());
					}
				}else{
					System.out.println("Update number:");
					for(Phone curPhone:updateNumber.getMessage360().getPhone()){
						System.out.println("sid="+curPhone.getPhoneNumber()+",Sid:="+curPhone.getFriendlyName());
					}
				}
			}
		} catch (M360Exception e) {
			e.printStackTrace();
		}
	}
}
