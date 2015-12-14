/**
 * The request response returned here contains a list of usages resources associated with your message360 accoun
 * @version v1b
 * @since 2015-11-12 12:12:13
 * @author Yel Inc
 * 
 */
package com.M360.api.example.emails.blocks;
import com.M360.api.Message360Connector;
import com.M360.api.configuration.BasicM360Configuration;
import com.M360.api.configuration.M360Constants;
import com.M360.api.domain.Message360;
import com.M360.api.domain.email.Blocked;
import com.M360.api.domain.email.EmailAddress;
import com.M360.api.domain.responses.Message360Email;
import com.M360.api.exception.Error;
import com.M360.api.exception.M360Exception;

public class ListBlocksEmails {
	public static void main(String[] args) {
		BasicM360Configuration conf = new BasicM360Configuration();
		conf.setSid(M360Constants.ACCOUNTSID);
		conf.setAuthToken(M360Constants.AUTHTOKEN);
		Message360Connector conn = new Message360Connector(conf);
		try {
			Integer offSet=null,limit=null;
			if(M360Constants.JSONFORMAT){
				String listJsonBlockEmailAddr=conn.listJsonBlockedEmailList(offSet, limit);
				System.out.println(listJsonBlockEmailAddr);
			}else{
				Message360<Message360Email<Blocked>> listBlocksEmailAddr = conn.listBlockedEmailList(offSet,limit);
				if(listBlocksEmailAddr.getMessage360().getErrors().getError().size()!=0){
					for(int x=0;x<listBlocksEmailAddr.getMessage360().getErrors().getError().size();x++){
						Error error=listBlocksEmailAddr.getMessage360().getErrors().getError().get(x);
							System.out.println("code :="+error.getCode()+",\nMessage:="+error.getMessage()+",\nMoreInfo"+error.getMoreInfo().toString());
					}
				}else{
					System.out.println("List Block Emails ");
					for(EmailAddress curBlockEmailAddres:listBlocksEmailAddr.getMessage360().getEmail().getBlocked()){
						System.out.println(curBlockEmailAddres.getEmail()+",\tReason:="+curBlockEmailAddres.getReason());
					}
				}
			}
		} catch (M360Exception e) {
			e.printStackTrace();
		}
	}
}
