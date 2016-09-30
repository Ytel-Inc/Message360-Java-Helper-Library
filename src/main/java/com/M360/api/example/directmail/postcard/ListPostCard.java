package com.M360.api.example.directmail.postcard;

import com.M360.api.Message360Connector;
import com.M360.api.configuration.BasicM360Configuration;
import com.M360.api.configuration.M360Constants;
import com.M360.api.domain.Message360;
import com.M360.api.domain.directmail.postcard.PostCard;
import com.M360.api.domain.directmail.responses.DMPostCard;
import com.M360.api.exception.Error;
import com.M360.api.exception.M360Exception;

public class ListPostCard {
	public static void main(String[] args) {
		BasicM360Configuration conf = new BasicM360Configuration();
		conf.setSid(M360Constants.ACCOUNTSID);
		conf.setAuthToken(M360Constants.AUTHTOKEN);
		Message360Connector conn = new Message360Connector(conf,M360Constants.DIRECT_MAIL);
		try {
			String htmlData="{HtmlDataPage}";
			if(!M360Constants.JSONFORMAT){
				String jsonSMSResponse=conn.listJsonPostCard();//listJsonPostCard(page,pageSize,postCardID,date);
				System.out.println(jsonSMSResponse);
			}else{
				Message360<DMPostCard> listPostCard = conn.listPostCard();//listJsonPostCard(page,pageSize,postCardID,date);
				if(listPostCard.getMessage360().getErrors().getError().size()!=0){
					for(int x=0;x<listPostCard.getMessage360().getErrors().getError().size();x++){
						Error error=listPostCard.getMessage360().getErrors().getError().get(x);
							System.out.println("code :="+error.getCode()+".\nMessage:="+error.getMessage()+",\nMoreInfo"+error.getMoreInfo().toString());
					}
				}else{
					System.out.println("List Post Card Details");
					for(PostCard postCard:listPostCard.getMessage360().getPostcards())
						System.out.println("Post Card ID:= "+postCard.getPostCardDetails().getId()+",Recipent ID:="+postCard.getRecipientDetails().getId()+",Sender ID:="+postCard.getSenderDetails().getId()+",Tracking :"+postCard.getTracking().getId());
				}
			}	
		} catch (M360Exception e) {
			e.printStackTrace();
		}
	}
}
