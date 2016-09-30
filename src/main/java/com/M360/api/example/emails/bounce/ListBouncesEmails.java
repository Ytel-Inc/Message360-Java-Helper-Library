/**
 * This endpoint allows you to retrieve entries in the Bounces list.
 * @version v1b
 * @since 2015-11-12 12:12:13
 * @author Ytel Inc
 * 
 */
package com.M360.api.example.emails.bounce;

import com.M360.api.Message360Connector;
import com.M360.api.configuration.BasicM360Configuration;
import com.M360.api.configuration.M360Constants;
import com.M360.api.domain.Message360;
import com.M360.api.domain.email.Bounce;
import com.M360.api.domain.email.EmailAddress;
import com.M360.api.domain.responses.Message360Email;
import com.M360.api.exception.Error;
import com.M360.api.exception.M360Exception;

public class ListBouncesEmails {
	public static void main(String[] args) {
		BasicM360Configuration conf = new BasicM360Configuration();
		conf.setSid(M360Constants.ACCOUNTSID);
		conf.setAuthToken(M360Constants.AUTHTOKEN);
		Message360Connector conn = new Message360Connector(conf);
		try {
			Integer offSet=null,limit=null;
			if(!M360Constants.JSONFORMAT){
				String jsonEmailResponse=conn.listJsonBounceEmail(offSet, limit);
				System.out.println(jsonEmailResponse);
			}else{
				Message360<Message360Email<Bounce>> bounceList = conn.listBounceEmail(offSet, limit);
				if(bounceList.getMessage360().getErrors().getError().size()!=0){
					for(int x=0;x<bounceList.getMessage360().getErrors().getError().size();x++){
						Error error=bounceList.getMessage360().getErrors().getError().get(x);
							System.out.println("code :="+error.getCode()+",\nMessage:="+error.getMessage()+",\nMoreInfo"+error.getMoreInfo().toString());
					}
				}else{
					System.out.println("List of Bounces Emails.");
					for(EmailAddress curBounceEmailAddres:bounceList.getMessage360().getEmail().getBouncedEmailAddresses()){
						System.out.println(curBounceEmailAddres.getEmail()+",\tStatus:="+curBounceEmailAddres.getStatus()+",\tReason:="+curBounceEmailAddres.getReason());
					}
				}
			}	
		} catch (M360Exception e) {
			e.printStackTrace();
		}
	}
}
/*
 *shoaib@ytel.co.in,	Status:=5.1.1,	Reason:=550 5.1.1 The email account that you tried to reach does not exist. Please try double-checking the recipient's email address for typos or unnecessary spaces. Learn more at  https://support.google.com/mail/answer/6596 f13si1534988pff.157 - gsmtp 
see@df.com,	Status:=5.1.1,	Reason:=550 5.1.1 RESOLVER.ADR.RecipNotFound; not found
sese@df.com,	Status:=5.1.1,	Reason:=550 5.1.1 RESOLVER.ADR.RecipNotFound; not found
seema+test1@gmail.com,	Status:=5.1.1,	Reason:=550 5.1.1 The email account that you tried to reach does not exist. Please try double-checking the recipient's email address for typos or unnecessary spaces. Learn more at  https://support.google.com/mail/answer/6596 201si56121663pfu.156 - gsmtp 
eema+test6@ytel.co.in,	Status:=5.1.1,	Reason:=550 5.1.1 The email account that you tried to reach does not exist. Please try double-checking the recipient's email address for typos or unnecessary spaces. Learn more at  https://support.google.com/mail/answer/6596 f88si39378028pfj.219 - gsmtp 
seemass@ytel.co.in,	Status:=5.1.1,	Reason:=550 5.1.1 The email account that you tried to reach does not exist. Please try double-checking the recipient's email address for typos or unnecessary spaces. Learn more at  https://support.google.com/mail/answer/6596 fp17si895236pac.142 - gsmtp 
abc@xyz.com,	Status:=5.1.1,	Reason:=550 5.1.1 The email account that you tried to reach does not exist. Please try double-checking the recipient's email address for typos or unnecessary spaces. Learn more at  https://support.google.com/mail/answer/6596 k74si56107118pfb.191 - gsmtp 
 
 */
