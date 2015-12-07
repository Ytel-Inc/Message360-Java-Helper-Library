package com.M360.api.example.call;

import com.M360.api.Message360Connector;
import com.M360.api.configuration.BasicM360Configuration;
import com.M360.api.configuration.M360Constants;
import com.M360.api.domain.Message360;
import com.M360.api.domain.call.Call;
import com.M360.api.domain.responses.CallMessages;
import com.M360.api.exception.Error;
import com.M360.api.exception.M360Exception;

public class listCall {
	public static void main(String[] args) {
		BasicM360Configuration conf = new BasicM360Configuration();
		conf.setSid(M360Constants.ACCOUNTSID); 
		conf.setAuthToken(M360Constants.AUTHTOKEN);
		Message360Connector conn = new Message360Connector(conf);
		try {
			if(!M360Constants.JSONFORMAT){
				String jsonCallResponse=conn.listJsonCalls();
				System.out.println(jsonCallResponse);
			}else{
				Message360<CallMessages> listCall = conn.listCalls();
				if(listCall.getMessage360().getErrors().getError().size()!=0){
					for(int x=0;x<listCall.getMessage360().getErrors().getError().size();x++){
						Error error=listCall.getMessage360().getErrors().getError().get(x);
							System.out.println("code :="+error.getCode()+".\nMessage:="+error.getMessage());
					}
				}else{
					System.out.println("List Calls");
					for(int x=0;x<listCall.getMessage360().getCallCount();x++){
						Call curCall=listCall.getMessage360().getCalls().getCall().get(x);
						System.out.println(x+")Account "+curCall.getAccountSid()+",call sid "+curCall.getCallSid());
					}
				}
			}
		} catch (M360Exception e) {
			e.printStackTrace();
		}
	}
}
