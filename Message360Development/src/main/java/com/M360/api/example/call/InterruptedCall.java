package com.M360.api.example.call;

import com.M360.api.Message360Connector;
import com.M360.api.configuration.BasicM360Configuration;
import com.M360.api.configuration.M360Constants;
import com.M360.api.domain.Message360;
import com.M360.api.domain.call.Call;
import com.M360.api.domain.enums.CallInterruptStatus;
import com.M360.api.domain.responses.CallMessages;
import com.M360.api.exception.Error;
import com.M360.api.exception.M360Exception;

public class InterruptedCall {
	public static void main(String[] args) {
		BasicM360Configuration conf = new BasicM360Configuration();
		conf.setSid(M360Constants.ACCOUNTSID); 
		conf.setAuthToken(M360Constants.AUTHTOKEN);
		Message360Connector conn = new Message360Connector(conf);
		try {
			if(!M360Constants.JSONFORMAT){
				String jsonCallResponse=conn.interuptedJsonCall("03c4aaf0-0b7a-0fd0-edfe-a7e4010b246c11111", null, CallInterruptStatus.COMPLETED, null);
				System.out.println(jsonCallResponse);
			}else{
				Message360<CallMessages> interuptedCall = conn.interuptedCall("d9c4aef2-ab03-54fb-6153-fd0346a13ce6111", null, CallInterruptStatus.COMPLETED, null);
				if(interuptedCall.getMessage360().getErrors().getError().size()!=0){
					for(int x=0;x<interuptedCall.getMessage360().getErrors().getError().size();x++){
						Error error=interuptedCall.getMessage360().getErrors().getError().get(x);
							System.out.println("code :="+error.getCode()+".\nMessage:="+error.getMessage()+",\nMoreInfo:="+error.getMoreInfo().toString());
					}
				}else{
					System.out.println("Interrupted Calls");
					for(int x=0;x<interuptedCall.getMessage360().getCall().size();x++){
						Call curCall=interuptedCall.getMessage360().getCall().get(x);
						System.out.println("Account Sid:"+curCall.getAccountSid()+",Callsid:"+curCall.getCallSid());
					}
				}
			}
		} catch (M360Exception e) {
			e.printStackTrace();
		}
	}
}
