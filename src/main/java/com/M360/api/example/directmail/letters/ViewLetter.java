package com.M360.api.example.directmail.letters;

import com.M360.api.Message360Connector;
import com.M360.api.configuration.BasicM360Configuration;
import com.M360.api.configuration.M360Constants;
import com.M360.api.domain.Message360;
import com.M360.api.domain.directmail.responses.DMLetter;
import com.M360.api.exception.Error;
import com.M360.api.exception.M360Exception;

public class ViewLetter {
	public static void main(String[] args) {
		BasicM360Configuration conf = new BasicM360Configuration();
		conf.setSid(M360Constants.ACCOUNTSID);
		conf.setAuthToken(M360Constants.AUTHTOKEN);
		Message360Connector conn = new Message360Connector(conf,M360Constants.DIRECT_MAIL);
		try {
			if(M360Constants.JSONFORMAT){
				String jsonSMSResponse=conn.viewJsonLetters("{letter_id}");
				System.out.println(jsonSMSResponse);
			}else{
				Message360<DMLetter> createLetter = conn.viewLetters("{letter_id}");
				if(createLetter.getMessage360().getErrors().getError().size()!=0){
					for(int x=0;x<createLetter.getMessage360().getErrors().getError().size();x++){
						Error error=createLetter.getMessage360().getErrors().getError().get(x);
							System.out.println("code :="+error.getCode()+".\nMessage:="+error.getMessage()+",\nMoreInfo"+error.getMoreInfo().toString());
					}
				}else{
					System.out.println("view Letter Card");
					System.out.println("Letter Card ID:= "+createLetter.getMessage360().getLetter().getLettersDetails().getId()+",Recipent ID:="+createLetter.getMessage360().getLetter().getRecipientDetails().getId()+",Sender ID:="+createLetter.getMessage360().getLetter().getSenderDetails().getId()+",Tracking :"+createLetter.getMessage360().getLetter().getTracking().getId());
				}
			}	
		} catch (M360Exception e) {
			e.printStackTrace();
		}
	}
}
