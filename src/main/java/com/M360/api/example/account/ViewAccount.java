/**
 * 
 * An account resource provides information about a single message360 account. 
 * The resource properties representing an account are listed below. 
 * Account resources can be accessed at a resource URI beginning with the message360 base URL and ending with a unique account SID.
 * 
 * @version v1b
 * @author Ytel-Inc
 * @date November 2015
 * 
 */
package com.M360.api.example.account;

import com.M360.api.Message360Connector;
import com.M360.api.configuration.BasicM360Configuration;
import com.M360.api.configuration.M360Constants;
import com.M360.api.domain.responses.AccountMessage;
import com.M360.api.domain.Message360;
import com.M360.api.exception.Error;
import com.M360.api.exception.M360Exception;

public class ViewAccount {

	public static void main(String[] args) {
		BasicM360Configuration conf = new BasicM360Configuration();
		conf.setSid(M360Constants.ACCOUNTSID1); ///if account sid is wrong
		conf.setAuthToken(M360Constants.AUTHTOKEN);
		Message360Connector conn = new Message360Connector(conf);
		try {
			if(!M360Constants.JSONFORMAT){//this section will return the JSON formate as we disccussed earles
				String accountResponse=conn.viewJsonAccount();
				System.out.println(accountResponse);
			}else{//and this section will generrate the code with Java-Mapping Sounds good.
				//can i run? yes.
				Message360<AccountMessage> accountExample = conn.viewAccount();
				if(accountExample.getMessage360().getErrors().getError().size()!=0){
					for(int x=0;x<accountExample.getMessage360().getErrors().getError().size();x++){
						Error error=accountExample.getMessage360().getErrors().getError().get(x);
							System.out.println("code :="+error.getCode()+".\nMessage:="+error.getMessage());
					}
				}else{
					System.out.println("Account Sid:="+accountExample.getMessage360().getAccountMessage().getAccountSid());
				}
			}
		} catch (M360Exception e) {
			e.printStackTrace();
		}
	}
}
/*Json format looks good
 * {
    "Message360": {
        "ResponseStatus": 1,
        "Message": {
            "Status": "Active",
            "AccountBalance": "$924.0058",
            "InboundCalls": 1686,
            "OutboundCalls": 10115,
            "InboundSMS": 3,
            "OutboundSMS": 982,
            "Email": 106,
            "PhoneNumbers": 119,
            "Address": 22,
            "Areamail": 0,
            "Checks": 0,
            "Jobs": 0,
            "Letters": 1,
            "Objects": 0,
            "Postcard": 5,
            "Transcriptions": 1178,
            "DateCreated": "2015-03-02 02:11:40",
            "DateUpdated": "2015-11-11 10:47:15",
            "TimeZone": "(GMT-08:00) Pacific Time (US & Canada)",
            "AccountSid": "YT94c49d220e5a45dc516f9733460460f5"
        }
    }
}
JAva-Mappinf error 
code :=ER-M360-GL-1500.
Message:=Your Account Sid or Auth Token is incorrect.
I follwed this way ..is it right? Seems good to me.
wait
 */
