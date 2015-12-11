/**
 * This endpoint allows you to delete entries in the Invalid Emails list.
 * @version v1b
 * @since 2015-11-12 12:12:13
 * @author Ytel Inc
 * 
 */
package com.M360.api.example.emails.spam;

import com.M360.api.Message360Connector;
import com.M360.api.configuration.BasicM360Configuration;
import com.M360.api.configuration.M360Constants;
import com.M360.api.domain.Message360;
import com.M360.api.domain.responses.Message360Email;
import com.M360.api.domain.email.EmailAddress;
import com.M360.api.domain.email.Spam;
import com.M360.api.exception.Error;
import com.M360.api.exception.M360Exception;

public class DeleteSpamEmail {
	public static void main(String[] args) {
		BasicM360Configuration conf = new BasicM360Configuration();
		conf.setSid(M360Constants.ACCOUNTSID);
		conf.setAuthToken(M360Constants.AUTHTOKEN);
		Message360Connector conn = new Message360Connector(conf);
		try {
			if(M360Constants.JSONFORMAT){
				String jsonEmailResponse=conn.deleteJsonSpamEmail("rizwan@xoyal.com");
				System.out.println(jsonEmailResponse);
			}else{
				Message360<Message360Email<Spam>> deleteSpam = conn.deleteSpamEmail("rizwan@xoyal.com");
				if(deleteSpam.getMessage360().getErrors().getError().size()!=0){
					for(int x=0;x<deleteSpam.getMessage360().getErrors().getError().size();x++){
						Error error=deleteSpam.getMessage360().getErrors().getError().get(x);
							System.out.println("code :="+error.getCode()+",\nMessage:="+error.getMessage()+",\nMoreInfo"+error.getMoreInfo().toString());
					}
				}else{
					System.out.println("Delete of Spam Emails");
					int size=deleteSpam.getMessage360().getEmail().getSpam().size();
					for(int x=0;x<size;x++){
						EmailAddress emailAddr=deleteSpam.getMessage360().getEmail().getSpam().get(x);
						if(!emailAddr.getDeleteStatus().toLowerCase().equals("fail"))
							System.out.println(emailAddr.getEmail()+",Delete Status:="+emailAddr.getDeleteStatus());
						else
							System.out.println(emailAddr.getEmail()+",Delete Status:="+emailAddr.getDeleteStatus()+",Reason:="+emailAddr.getReason());
					}
				}
			}
		} catch (M360Exception e) {
			e.printStackTrace();
		}
	}
}
