package com.M360.api.example.call;

import com.M360.api.Message360Connector;
import com.M360.api.configuration.BasicM360Configuration;
import com.M360.api.configuration.M360Constants;
import com.M360.api.domain.Message360;
import com.M360.api.domain.call.Call;
import com.M360.api.domain.enums.Direction;
import com.M360.api.domain.responses.CallMessages;
import com.M360.api.exception.Error;
import com.M360.api.exception.M360Exception;

public class SendDigits {
	public static void main(String[] args) {
		BasicM360Configuration conf = new BasicM360Configuration();
		conf.setSid(M360Constants.ACCOUNTSID); 
		conf.setAuthToken(M360Constants.AUTHTOKEN);
		Message360Connector conn = new Message360Connector(conf);
		try {
			if(M360Constants.JSONFORMAT){
				String jsonCallResponse=conn.sendJsonDigits("03c4aaf0-0b7a-0fd0-edfe-a7e4010b246c", "123454srrizwad", Direction.IN);
				System.out.println(jsonCallResponse);
			}else{
				System.out.println("sendDigit Calls");
				Message360<CallMessages> sendDigit = conn.sendDigits("2eaff4d2-b983-da87-fe9c-26765d7d296d", "123454srrizwad", Direction.IN);
				if(sendDigit.getMessage360().getErrors().getError().size()!=0){
					for(int x=0;x<sendDigit.getMessage360().getErrors().getError().size();x++){
						Error error=sendDigit.getMessage360().getErrors().getError().get(x);
							System.out.println("code :="+error.getCode()+".\nMessage:="+error.getMessage());
					}
				}else{
					for(int x=0;x<sendDigit.getMessage360().getCall().size();x++){
						Call curCall=sendDigit.getMessage360().getCall().get(x);
						System.out.println("Account Sid:"+curCall.getAccountSid()+",Callsid:"+curCall.getCallSid());
					}
				}
			}
		} catch (M360Exception e) {
			e.printStackTrace();
		}
	}
}
