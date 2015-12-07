package com.M360.api.example.phonenumber;

import com.M360.api.Message360Connector;
import com.M360.api.configuration.BasicM360Configuration;
import com.M360.api.configuration.M360Constants;
import com.M360.api.domain.Message360;
import com.M360.api.domain.phonenumber.Phone;
import com.M360.api.domain.responses.NumberMessage;
import com.M360.api.exception.Error;
import com.M360.api.exception.M360Exception;

public class ViewNumbers {
	public static void main(String[] args) {
		BasicM360Configuration conf = new BasicM360Configuration();
		conf.setSid(M360Constants.ACCOUNTSID); 
		conf.setAuthToken(M360Constants.AUTHTOKEN);
		Message360Connector conn = new Message360Connector(conf);
		try {
			if(M360Constants.JSONFORMAT){
				String jsonSMSResponse=conn.viewJsonNumber("9082242414");
				System.out.println(jsonSMSResponse);
			}else{
				Message360<NumberMessage> viewNumber = conn.viewNumber("908224241");
				if(viewNumber.getMessage360().getErrors().getError().size()!=0){
					for(int x=0;x<viewNumber.getMessage360().getErrors().getError().size();x++){
						Error error=viewNumber.getMessage360().getErrors().getError().get(x);
							System.out.println("code :="+error.getCode()+".\nMessage:="+error.getMessage()+",\nMoreInfo"+error.getMoreInfo().toString());
					}
				}else{
					System.out.println("List of View Number");
					for(int x=0;x<viewNumber.getMessage360().getPhone().size();x++){
						Phone curPhone=viewNumber.getMessage360().getPhone().get(x);
						System.out.println(x+") sid="+curPhone.getPhoneNumber()+",sid :="+curPhone.getSid());
					}
				}
			}
		} catch (M360Exception e) {
			e.printStackTrace();
		}
	}
}
