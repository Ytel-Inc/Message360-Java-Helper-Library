package com.M360.api.example.directmail.postcard;

import com.M360.api.Message360Connector;
import com.M360.api.configuration.BasicM360Configuration;
import com.M360.api.configuration.M360Constants;
import com.M360.api.domain.Message360;
import com.M360.api.domain.directmail.responses.DMPostCard;
import com.M360.api.exception.Error;
import com.M360.api.exception.M360Exception;

public class ViewPostCard {
	public static void main(String[] args) {
		BasicM360Configuration conf = new BasicM360Configuration();
		conf.setSid(M360Constants.ACCOUNTSID);
		conf.setAuthToken(M360Constants.AUTHTOKEN);
		Message360Connector conn = new Message360Connector(conf,M360Constants.DIRECT_MAIL);
		try {
			String htmlData="{HtmlPageCode}";
			if(!M360Constants.JSONFORMAT){
				String jsonSMSResponse=conn.viewJsonPostCard("{viewPostCardID}");
				System.out.println(jsonSMSResponse);
			}else{
				Message360<DMPostCard> viewPostCard = conn.viewPostCard("{viewPostCardId}");
				if(viewPostCard.getMessage360().getErrors().getError().size()!=0){
					for(int x=0;x<viewPostCard.getMessage360().getErrors().getError().size();x++){
						Error error=viewPostCard.getMessage360().getErrors().getError().get(x);
							System.out.println("code :="+error.getCode()+".\nMessage:="+error.getMessage()+",\nMoreInfo"+error.getMoreInfo().toString());
					}
				}else{
					System.out.println("View Post Card Details");
					System.out.println("Post Card ID:= "+viewPostCard.getMessage360().getPostcard().getPostCardDetails().getId()+",Recipent ID:="+viewPostCard.getMessage360().getPostcard().getRecipientDetails().getId()+",Sender ID:="+viewPostCard.getMessage360().getPostcard().getSenderDetails().getId()+",Tracking :"+viewPostCard.getMessage360().getPostcard().getTracking().getId());
				}
			}	
		} catch (M360Exception e) {
			e.printStackTrace();
		}
	}
}
