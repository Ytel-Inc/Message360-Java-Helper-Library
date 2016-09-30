package com.M360.api.example.directmail.letters;

import com.M360.api.Message360Connector;
import com.M360.api.configuration.BasicM360Configuration;
import com.M360.api.configuration.M360Constants;
import com.M360.api.domain.Message360;
import com.M360.api.domain.directmail.letters.Letter;
import com.M360.api.domain.directmail.responses.DMLetter;
import com.M360.api.exception.Error;
import com.M360.api.exception.M360Exception;

public class ListLetter {
	public static void main(String[] args) {
		BasicM360Configuration conf = new BasicM360Configuration();
		conf.setSid(M360Constants.ACCOUNTSID);
		conf.setAuthToken(M360Constants.AUTHTOKEN);
		Message360Connector conn = new Message360Connector(conf);
		try {
			if(M360Constants.JSONFORMAT){
				String jsonSMSResponse=conn.listJsonLetters();
				//listJsonLetters(page,pageSize,"{letter_id}",date);
				System.out.println(jsonSMSResponse);
			}else{
				Message360<DMLetter> listLetter = conn.listLetters();
				//listJsonLetters(page,pageSize,"{letter_id}",date);
				if(listLetter.getMessage360().getErrors().getError().size()!=0){
					for(int x=0;x<listLetter.getMessage360().getErrors().getError().size();x++){
						Error error=listLetter.getMessage360().getErrors().getError().get(x);
							System.out.println("code :="+error.getCode()+".\nMessage:="+error.getMessage()+",\nMoreInfo"+error.getMoreInfo().toString());
					}
				}else{
					System.out.println("List Letter Card");
					for(Letter letter:listLetter.getMessage360().getLetters()){
						System.out.println("Letter Card ID:= "+letter.getLettersDetails().getId()+",Recipent ID:="+letter.getRecipientDetails().getId()+",Sender ID:="+letter.getSenderDetails().getId()+",Tracking :"+letter.getTracking().getId());
					}
				}
			}	
		} catch (M360Exception e) {
			e.printStackTrace();
		}
	}
}
