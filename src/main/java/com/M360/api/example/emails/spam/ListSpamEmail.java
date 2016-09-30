/**
 * This endpoint allows you to retrieve entries in the spam reports list.
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

public class ListSpamEmail {
	public static void main(String[] args) {
		BasicM360Configuration conf = new BasicM360Configuration();
		conf.setSid(M360Constants.ACCOUNTSID);
		conf.setAuthToken(M360Constants.AUTHTOKEN);
		Message360Connector conn = new Message360Connector(conf);
		try {
			Integer offset=null,limit=null;
			if(M360Constants.JSONFORMAT){
				String jsonEmailResponse=conn.listJsonSpamEmail(offset,limit);
				System.out.println(jsonEmailResponse);
			}else{
				Message360<Message360Email<Spam>> listSpam = conn.listSpamEmail(offset,limit);
				if(listSpam.getMessage360().getErrors().getError().size()!=0){
					for(int x=0;x<listSpam.getMessage360().getErrors().getError().size();x++){
						Error error=listSpam.getMessage360().getErrors().getError().get(x);
							System.out.println("code :="+error.getCode()+",\nMessage:="+error.getMessage()+",\nMoreInfo"+error.getMoreInfo().toString());
					}
				}else{
					System.out.println("List of Spam Emails");
					for(EmailAddress curInvalid:listSpam.getMessage360().getEmail().getSpamReports()){
						System.out.println(curInvalid.getEmail());
					}
				}
			}	
		} catch (M360Exception e) {
			e.printStackTrace();
		}
	}
}
