/**
 * 
 * Message360 allows you to play an audio file during a call. This is useful for playing hold music, providing IVR prompts, etc.
 * 
 * @version v1b
 * @author Ytel-Inc
 * @date November 2015
 * 
 */
package com.M360.api.example.call;

import com.M360.api.Message360Connector;
import com.M360.api.configuration.BasicM360Configuration;
import com.M360.api.configuration.M360Constants;
import com.M360.api.domain.Message360;
import com.M360.api.domain.call.Call;
import com.M360.api.domain.responses.CallMessages;
import com.M360.api.exception.Error;
import com.M360.api.exception.M360Exception;

public class PlayAudioCall {
	public static void main(String[] args) {
		BasicM360Configuration conf = new BasicM360Configuration();
		conf.setSid(M360Constants.ACCOUNTSID); 
		conf.setAuthToken(M360Constants.AUTHTOKEN);
		Message360Connector conn = new Message360Connector(conf);
		try {
			if(M360Constants.JSONFORMAT){
				String jsonCallResponse=conn.playJsonAudios("{callSid}", null, null, null, "{audioUrl}");
				System.out.println(jsonCallResponse);
			}else{
				Message360<CallMessages> playAudioCall = conn.playAudios("{callSid}", null, null, null, "{audioUrl}");
				if(playAudioCall.getMessage360().getErrors().getError().size()!=0){
					for(int x=0;x<playAudioCall.getMessage360().getErrors().getError().size();x++){
						Error error=playAudioCall.getMessage360().getErrors().getError().get(x);
							System.out.println("code :="+error.getCode()+".\nMessage:="+error.getMessage());
					}
				}else{
					for(Call curCall:playAudioCall.getMessage360().getCall()){
						System.out.println("Account Sid:"+curCall.getAccountSid()+",Callsid:"+curCall.getCallSid());
					}
				}
			}
		} catch (M360Exception e) {
			e.printStackTrace();
		}
	}
}
