# Message360-Java-Helper-Library

![](http://message360.com/wordpress/wp-content/uploads/2014/08/message360.png)

### Welcome to the Message360 Java Helper Library
This is home to the Official Java Message360 REST API. 

```java
public class MakeCall {
	public static void main(String[] args) {
		BasicM360Configuration conf = new BasicM360Configuration();
		conf.setSid(M360Constants.ACCOUNTSID); 
		conf.setAuthToken(M360Constants.AUTHTOKEN);
		Message360Connector conn = new Message360Connector(conf);
		try {
			CallRequest cr=new CallRequest();
			cr.setFromCountryCode(1);
			cr.setFrom("{fromNumber}");
			cr.setTo("{toNumber}");
			cr.setToCountryCode(1);
			cr.setPlayDtmf("{StringPlayDTMF}");
			cr.setUrl("{URL}");
			if(M360Constants.JSONFORMAT){
				String jsonCallResponse=conn.makeJsonCall(cr);
				System.out.println(jsonCallResponse);
			}else{
				Message360<CallMessages> viewCall = conn.makeCall(cr);
				if(viewCall.getMessage360().getErrors().getError().size()!=0){
					for(int x=0;x<viewCall.getMessage360().getErrors().getError().size();x++){
						Error error=viewCall.getMessage360().getErrors().getError().get(x);
							System.out.println("code :="+error.getCode()+".\nMessage:="+error.getMessage());
					}
				}else{
					System.out.println("Make Call");
					int size=viewCall.getMessage360().getCall().size();
					for(Call curCall:viewCall.getMessage360().getCall()){
						System.out.println(curCall.getCallSid()+","+curCall.getDirection());
					}
				}
				
			}
		} catch (M360Exception e) {
			e.printStackTrace();
		}
	}

```

An account for Message360 is free to sign up for at [https://api.message360.com](https://api.message360.com)

### About Message360
Empowering technology to meet modern day communication needs. Through a simple to use API, developers can build, connect, and manage all communications platforms in one system. 

Communicating with prospects, leads and customers is the single most important thing when protecting and growing your business. Now, take it to the next level by imagining the possibilities and how your business can communicate with these people.

More information can be obtained about message360 at [http://www.message360.com](http://message360.com/)

### Support or Contact
Having trouble with Pages or the library?  Visit [https://api.message360.com](https://api.message360.com) and click the Help button in the bottom right corner or [contact support](mailto:support@ytel.com) and we’ll help you sort it out.

### Company Information
© 2015 Ytel, Inc. | Ytel™ All Rights Reserved. | 800.382.4913 | www.ytel.com
