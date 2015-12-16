/**
 * 
 * The class used for all forms of communication with the M360 REST API.
 * @version v1b
 * @author Ytel-Inc
 * @date November 2015
 * 
 */
package com.M360.api;

import java.net.URI;
import java.util.Date;

import javax.ws.rs.core.UriBuilder;

import org.jboss.resteasy.client.ClientResponse;
import org.jboss.resteasy.client.ProxyFactory;
import org.jboss.resteasy.client.core.executors.ApacheHttpClient4Executor;

import com.M360.api.configuration.M360Configuration;
import com.M360.api.configuration.M360Constants;
import com.M360.api.domain.Message360;
import com.M360.api.domain.email.Blocked;
import com.M360.api.domain.email.Bounce;
import com.M360.api.domain.email.Invalid;
import com.M360.api.domain.responses.AccountMessage;
import com.M360.api.domain.responses.CallMessages;
import com.M360.api.domain.responses.CarrierMessage;
import com.M360.api.domain.responses.ConferenceMessages;
import com.M360.api.domain.responses.Message360Email;
import com.M360.api.domain.responses.NumberMessage;
import com.M360.api.domain.responses.RecordMessage;
import com.M360.api.domain.responses.SMSMessages;
import com.M360.api.domain.responses.TranscriptionMessage;
import com.M360.api.domain.responses.UsageMessage;
import com.M360.api.domain.email.SendEmail;
import com.M360.api.domain.email.Spam;
import com.M360.api.domain.email.Unsubscribed;
import com.M360.api.domain.enums.AudioDirection;
import com.M360.api.domain.enums.AudioFormat;
import com.M360.api.domain.enums.CallInterruptStatus;
import com.M360.api.domain.enums.ConferenceStatus;
import com.M360.api.domain.enums.Direction;
import com.M360.api.domain.enums.HttpMethod;
import com.M360.api.domain.enums.PhoneNumberType;
import com.M360.api.domain.enums.ProductType;
import com.M360.api.domain.enums.TranscriptionStatus;
import com.M360.api.exception.M360Exception;
import com.M360.api.http.RestExecutor;
import com.M360.api.requests.CallRequest;
import com.M360.api.requests.IncomingPhoneNumberRequest;
import com.M360.api.restproxies.AccountsProxy;
import com.M360.api.restproxies.CallProxy;
import com.M360.api.restproxies.CarrierProxy;
import com.M360.api.restproxies.ConferenceProxy;
import com.M360.api.restproxies.EmailProxy;
import com.M360.api.restproxies.PhoneProxy;
import com.M360.api.restproxies.RecordingProxy;
import com.M360.api.restproxies.SmsProxy;
import com.M360.api.restproxies.TranscriptionProxy;
import com.M360.api.restproxies.UsageProxy;



public class Message360Connector {

	private ApacheHttpClient4Executor executor;
	private M360Configuration conf;
	private String fullBaseUrl;
	private CallProxy callProxy;
	private SmsProxy smsProxy;
	private TranscriptionProxy transcriptionProxy;
	private PhoneProxy phoneProxy;
	private RecordingProxy recordingProxy;
	private AccountsProxy accountsProxy;
	private UsageProxy usageProxy;
	private ConferenceProxy conferenceProxy;
	private EmailProxy emailProxy;
	private CarrierProxy carrierProxy;
	

	/**
	 * Creates a new M360Connector based on the provided configuration.
	 * 
	 * @param conf
	 *            The configuration based on which the M360Connector will be
	 *            created.
	 * @see BasicM360Configuration, PropertiesFileM360Configuration,
	 *      M360Configuration
	 */
	public Message360Connector(M360Configuration conf) {
		this.conf = conf;
		executor = RestExecutor.createExecutor(conf);
		URI baseUrl = UriBuilder.fromUri(conf.getBaseUrl()).path(M360Constants.API_VERSION).build();
		fullBaseUrl = baseUrl.toString();
		callProxy = createProxy(CallProxy.class);
		smsProxy = createProxy(SmsProxy.class);
		transcriptionProxy = createProxy(TranscriptionProxy.class);
		phoneProxy = createProxy(PhoneProxy.class);
		recordingProxy =createProxy(RecordingProxy.class);
		accountsProxy = createProxy(AccountsProxy.class);
		usageProxy =createProxy(UsageProxy.class);
		conferenceProxy = createProxy(ConferenceProxy.class);
		emailProxy = createProxy(EmailProxy.class);
		carrierProxy = createProxy(CarrierProxy.class);
	}

	private <T> T createProxy(Class<T> clazz) {
		return ProxyFactory.create(clazz, fullBaseUrl, executor);
	}

	private <T> T returnThrows(ClientResponse<T> response)
			throws M360Exception {
		int status = response.getStatus();
		if (status > 399) {
			M360Exception exception = response
					.getEntity(M360Exception.class);
			throw exception;
		}
		return response.getEntity();
	}

	private String getDateString(Date date) {
		if (date == null)
			return null;
		return M360Constants.queryDateFormat.format(date);
	}
	
	////////////
	///ACCOUNT
	///////////

	/**
	 * An account resource provides information about a single M360 account.
	 * This methods gets the info of the account with the provided Sid.
	 * @see viewAccount
	 * @param accountSid
	 * @return
	 * @throws M360Exception
	 */
	
	//define all functions here 
	public Message360<AccountMessage> viewAccount(String accountSid) throws M360Exception {
		ClientResponse<Message360<AccountMessage>> acc = accountsProxy.getAccount(accountSid);
		return returnThrows(acc);
	}
	
	public Message360<AccountMessage> viewAccount() throws M360Exception {
		return viewAccount(conf.getSid());
	}
	
	public String viewJsonAccount() throws M360Exception {
		return accountsProxy.getAccount(conf.getSid()).getEntity(String.class);
	}

	//////////////
	/////Usage
	/////////////
	
	/**
	 * @see  listUsage
	 * @param accountSid
	 * @param product
	 * @param to
	 * @param from
	 * @return
	 * @throws M360Exception
	 */
		
	public Message360<UsageMessage> listUsage(String accountSid,ProductType product,Date to,Date from) throws M360Exception {
		ClientResponse<Message360<UsageMessage>> acc = usageProxy.listUsage(accountSid,product,getDateString(to),getDateString(from));
		return returnThrows(acc);
	}

	public Message360<UsageMessage> listUsage(ProductType product,Date to,Date from) throws M360Exception {
		return listUsage(conf.getSid(),product,to,from);
	}
	public Message360<UsageMessage> listUsage() throws M360Exception {
		return listUsage(conf.getSid(),ProductType.ALL,null,null);
	}
		
	public String listJsonUsage(ProductType product,Date to,Date from) throws M360Exception {
		return usageProxy.listUsage(conf.getSid(),product,getDateString(to),getDateString(from)).getEntity(String.class);
	}
	
	public String listJsonUsage() throws M360Exception {
		return usageProxy.listUsage(conf.getSid(),ProductType.ALL,null,null).getEntity(String.class);
	}
	
	//////////////
	/////SMS 
	/////////////
	
	/**
	* viewSmsMessage: Getting the SMS information by message sid
	* @see viewSMS
	* @param sid
	* @param smsMessageSid
	* @return
	* @throws M360Exception
	*/
	
	public Message360<SMSMessages> viewSmsMessage(String sid, String smsMessageSid)
		throws M360Exception {
	ClientResponse<Message360<SMSMessages>> sms = smsProxy.getSmsMessage(sid,smsMessageSid);
		return returnThrows(sms);
	}
	
	public Message360<SMSMessages> viewSmsMessage(String smsMessageSid)
		throws M360Exception {
		return viewSmsMessage(conf.getSid(), smsMessageSid);
	}
	
	public String viewJsonSmsMessage(String smsMessageSid)throws M360Exception {
		return smsProxy.getSmsMessage(conf.getSid(), smsMessageSid).getEntity(String.class);
	}
	
	/**@see ListSMS
	* Getting all SMS information of account.
	* @param to
	*            Lists all SMS messages sent to this number.
	* @param from
	*            Lists all SMS messages sent from this number.
	* @param dateSentGte
	*            Lists all SMS messages beginning on or from a certain date.
	* @param dateSentLt
	*            Lists all SMS messages before a certain date.
	* @param page
	*            Used to return a particular page within the list.
	* @param pageSize
	*            Used to specify the amount of list items to return per page.
	* @return A list of SmsMessage resources.
	* @throws M360Exception
	*/
	public Message360<SMSMessages> listSmsMessages(String accountSid, String to,
		String from, Date dateSentGte, Date dateSentLt, Long page,
		Long pageSize) throws M360Exception {
	
	ClientResponse<Message360<SMSMessages>> smsList = smsProxy.getSmsMessageList(
			accountSid, to, from, getDateString(dateSentGte),
			getDateString(dateSentLt), page, pageSize);
		return returnThrows(smsList);
	}
	
	public Message360<SMSMessages> listSmsMessages(String to, String from,
		Date dateSentGte, Date dateSentLt, Long page, Long pageSize) throws M360Exception {
		return listSmsMessages(conf.getSid(), to, from, dateSentGte,
			dateSentLt, page, pageSize);
	}
	
	public Message360<SMSMessages> listSmsMessages() throws M360Exception {
		return listSmsMessages(conf.getSid(), null, null, null, null, null,null);
	}
	
	public String listJsonSmsMessages() throws M360Exception {
		return smsProxy.getSmsMessageList(conf.getSid(), null, null, null, null, null,null).getEntity(String.class);
	}
	
	
	/**@see SendSMS
	* Sends Message to "To" number.
	* @param to
	*            The number you want to send the SMS to (required).
	* @param from
	*            The number you want to display as sending the SMS. A subcharge
	*            will apply when sending via a custom From number (required).
	* @param body
	*            Text of the SMS message to be sent. Plain text up to 160
	*            characters in length (required).
	* @param statusCallback
	*            URL that a set of default parameters will be forwarded to once
	*            the SMS is complete.
	* @return The SMS message which was sent.
	* @throws M360Exception
	*/
	public Message360<SMSMessages> sendSmsMessage(String accountSid, String to, String from,
		String body,HttpMethod method, Integer fromCountryCode,Integer toCountryCode,String statusCallback) throws M360Exception {
	ClientResponse<Message360<SMSMessages>> smsMessage = smsProxy.sendSmsMessage(
			accountSid, to, from, body,method,fromCountryCode,toCountryCode, statusCallback);
	return returnThrows(smsMessage);
	}
	
	public Message360<SMSMessages> sendSmsMessage(String to, String from, String body,HttpMethod method,Integer fromCountryCode,Integer toCountryCode,
		String statusCallback) throws M360Exception {
	return sendSmsMessage(conf.getSid(), to, from, body,method,fromCountryCode,toCountryCode, statusCallback);
	}
	
	public String  sendJsonSmsMessage(String to, String from, String body,HttpMethod method,Integer fromCountryCode,Integer toCountryCode,String statusCallback) throws M360Exception {
		return smsProxy.sendSmsMessage(conf.getSid(), to, from, body,method,fromCountryCode,toCountryCode, statusCallback).getEntity(String.class);
	}
	
	
	
	/**@see InBound sms
	* Getting all inBound SMs asscociated with the account
	* @param accountSid
	* @param to
	* @param from
	* @param dateReceived
	* @param page
	* @param pageSize
	* @return
	* @throws M360Exception
	*/
	
	public Message360<SMSMessages> getInboundSMS(String accountSid,String to, String from,Date dateReceived,Long page,Long pageSize) throws M360Exception {
	 ClientResponse<Message360<SMSMessages>> smsMessage = smsProxy.getInboundSms(accountSid, to, from,dateReceived, page,pageSize);
	 return returnThrows(smsMessage);
	}
	
	public Message360<SMSMessages> getInboundSMS(String to, String from,Date dateReceived, Long page,Long pageSize) throws M360Exception {
		return getInboundSMS(conf.getSid(), to, from,dateReceived,page,pageSize);
	}
	public Message360<SMSMessages> getInboundSMS() throws M360Exception {
		return getInboundSMS(conf.getSid(),null,null,null,null);
	}
	
	public String getJsonInboundSMS(String to, String from,Date dateReceived, Long page,Long pageSize) throws M360Exception {
	return smsProxy.getInboundSms(conf.getSid(), to, from,dateReceived,page,pageSize).getEntity(String.class);
	}
	public String getJsonInboundSMS() throws M360Exception {
		return smsProxy.getInboundSms(conf.getSid(), null,null,null,null,null).getEntity(String.class);
	}
	
	/** @see  OptIns
	*  Send SMS to TollFree Number . 
	* @param accountSid
	* @param to
	* @param from
	* @param fromCountryCode
	* @param toCountryCode
	* @param expires
	* @param authorizedby
	* @param authorizedhow
	* @return
	* @throws M360Exception
	*/
	
	
	public Message360<SMSMessages> getNumberOptins(String accountSid,String to, String from,Integer fromCountryCode,Integer toCountryCode,
		Integer expires,String authorizedby,String authorizedhow) throws M360Exception {
	 ClientResponse<Message360<SMSMessages>> smsMessage = smsProxy.getNumberOptins(
			accountSid, to, from, fromCountryCode,toCountryCode,  expires,authorizedby,authorizedhow);
	 return returnThrows(smsMessage);
	}
	
	public Message360<SMSMessages> getNumberOptins(String to, String from, Integer fromCountryCode,Integer toCountryCode,Integer expires,String authorizedby,String authorizedhow) throws M360Exception {
		return getNumberOptins(conf.getSid(), to, from,fromCountryCode,toCountryCode, expires,authorizedby,authorizedhow);
	}
	
	public String getJsonNumberOptins(String to, String from, Integer fromCountryCode,Integer toCountryCode,Integer expires,String authorizedby,String authorizedhow) throws M360Exception {
		return smsProxy.getNumberOptins(conf.getSid(), to, from,fromCountryCode,toCountryCode, expires,authorizedby,authorizedhow).getEntity(String.class);
	}
	

	//////////////////////
	//////CALL SECTION
	//////////////////////
	
	/**
	* @see #viewCall(String)
	* @param accountSid
	*            The account sid (required).
	* @throws M360Exception
	*/
	public Message360<CallMessages> viewCall(String accountSid, String callSid)throws M360Exception {
		return returnThrows(callProxy.viewCall(accountSid, callSid));
	}
	
	/**
	* Gets the specified call resource. A call resource provides information
	* about an individual call that has occurred through M360. Both inbound
	* and outbound voice communication through M360 are categorized as calls.
	* 
	* @param callSid
	*            The sid of the requested Call resource (required).
	* @return The requested Call resource.
	* @throws M360Exception
	*/
	public Message360<CallMessages> viewCall(String callSid) throws M360Exception {
		return viewCall(conf.getSid(), callSid);
	}
	
	public String viewJsonCall(String callSid) throws M360Exception {
		return callProxy.viewCall(conf.getSid(), callSid).getEntity(String.class);
	}
	
	
	/**
	* @see #listCalls(String, String, CallStatus, Date, Date, Long, Long)
	* @param accountSid
	*            The account sid (required).
	* @throws M360Exception
	*/
	public Message360<CallMessages> listCalls(String accountSid, String to, String from,Date startTimeGte, Long page,Long pageSize) throws M360Exception {
		return returnThrows(callProxy.listCalls(accountSid, to, from,getDateString(startTimeGte), page,pageSize));
	}
	
	/**@see listCalls
	* To view a list of all inbound and outbound call resources associated with
	* a given account, use this method. The response returned lists the calls
	* in chronological order and also includes paging information.
	* 
	* @param to
	*            Lists all calls made to this number only.
	* @param from
	*            Lists all calls made from this number.
	* @param status
	*            Lists all calls with the specified status only.
	* @param startTimeGte
	*            Lists all calls beginning on or from a certain date.
	* @param startTimeLt
	*            Lists all calls beginning before a certain date.
	* @param page
	*            Used to return a particular page within the list.
	* @param pageSize
	*            Used to specify the amount of list items to return per page.
	* @return A list of calls.
	* @throws M360Exception
	*/
	public Message360<CallMessages> listCalls(String to, String from,Date startTimeGte, Long page, Long pageSize)throws M360Exception {
		return listCalls(conf.getSid(), to, from, startTimeGte,page, pageSize);
	}
	
	public Message360<CallMessages> listCalls()throws M360Exception {
		return listCalls(conf.getSid(), null, null, null,null, null);
	}
	
	public String  listJsonCalls(String to, String from,Date startTimeGte, Long page, Long pageSize)throws M360Exception {
		return callProxy.listCalls(conf.getSid(), to, from, getDateString(startTimeGte),page, pageSize).getEntity(String.class);
	}
	
	public String  listJsonCalls() throws M360Exception {
		return callProxy.listCalls(conf.getSid(), null, null, null,null,null).getEntity(String.class);
	}
	
	
	/**
	* @see #makeCall(String, String, String, HttpMethod, String, HttpMethod,
	*      String, HttpMethod, String, HttpMethod, String, String, Long,
	*      Boolean, Boolean, String, HttpMethod, Boolean, String, HttpMethod)
	* @throws M360Exception
	*/
	
	public Message360<CallMessages> makeCall(String accountsid,Integer fromCountryCode,String from,
			Integer toCountryCode,String to,String url,HttpMethod method,
			String statusCallBack,HttpMethod statusCallbackMethod,String fallBackUrl,HttpMethod fallBackMethod,
			String heartBeatUrl,HttpMethod heartBeatMethod,String forwardedForm,Long timeout,String playDtmf,Boolean hideCallerId,
			Boolean record,Integer recordcallBack,HttpMethod recordCallBackMethod,Boolean transcribe,String transcribeQuality,
			String straightToVoiceMail,String ifMachine,String ifMachineURl,String ifMachineMethod)throws M360Exception {
		
		return returnThrows(callProxy.makeCall(accountsid,fromCountryCode,from,toCountryCode,to,url,method,
				statusCallBack,statusCallbackMethod,fallBackUrl,fallBackMethod,heartBeatUrl,heartBeatMethod,
				forwardedForm,timeout,playDtmf,hideCallerId,record,recordcallBack,recordCallBackMethod,transcribe,transcribeQuality,
				straightToVoiceMail,ifMachine,ifMachineURl,ifMachineMethod));
	}
	
	
	
	public Message360<CallMessages> makeCall(Integer fromCountryCode,String from,
			Integer toCountryCode,String to,String url,HttpMethod method,
			String statusCallBack,HttpMethod statusCallbackMethod,String fallBackUrl,HttpMethod fallBackMethod,
			String heartBeatUrl,HttpMethod heartBeatMethod,String forwardedForm,Long timeout,String playDtmf,Boolean hideCallerId,
			Boolean record,Integer recordcallBack,HttpMethod recordCallBackMethod,Boolean transcribe,String transcribeQuality,
			String straightToVoiceMail,String ifMachine,String ifMachineURl,String ifMachineMethod) throws M360Exception {
		
		return makeCall(conf.getSid(), fromCountryCode,from,toCountryCode,to,url,method,
				statusCallBack,statusCallbackMethod,fallBackUrl,fallBackMethod,heartBeatUrl,heartBeatMethod,
				forwardedForm,timeout,playDtmf,hideCallerId,record,recordcallBack,recordCallBackMethod,transcribe,transcribeQuality,
				straightToVoiceMail,ifMachine,ifMachineURl,ifMachineMethod);
	}
	
	/**
	* Convenience method which accepts a CallRequest object containing
	* parameters.
	* 
	/** @see makeCall
	* 
	* @param to
	*            The number to call (required).
	* @param from
	*            The number to display as calling (required).
	* @param url
	*            The URL requested once the call connects. A set of default
	*            parameters will be sent here.
	* @param method
	*            Specifies the HTTP method used to request the required URL
	*            once call connects. Defaults to POST.
	* @param fallbackUrl
	*            URL used if any errors occur during execution of InboundXML or
	*            at initial request of the required Url provided with the POST.
	* @param fallbackMethod
	*            Specifies the HTTP method used to request FallbackUrl.
	*            Defaults to POST.
	* @param statusCallback
	*            URL that can be requested to receive notification when call
	*            has ended. A set of default parameters will be sent here once
	*            the call is finished.
	* @param statusCallbackMethod
	*            Specifies the HTTP method used to request StatusCallbackUrl.
	*            Defaults to POST.
	* @param heartbeatUrl
	*            URL that can be requested every 60 seconds during the call to
	*            notify of elapsed time and pass other general information.
	* @param heartbeatMethod
	*            Specifies the HTTP method used to request the Heartbeat URL.
	* @param forwardedFrom
	*            Specifies the forwarding number to pass to the receiving
	*            carrier.
	* @param sendDigits
	*            Dials digits once call connects. Can be used to forward
	*            callers to different extensions or numbers. Allowed values are
	*            numbers, # and *.
	* @param timeout
	*            Number of seconds call stays on the line while waiting for an
	*            answer. The max time limit is 999 and the default limit is 60
	*            seconds but lower times can be set. Defaults to 60.
	* @param hideCallerId
	*            Specifies if the caller id will be hidden.
	* @param record
	*            Specifies whether this call should be recorded. Defaults to
	*            false.
	* @param recordCallback
	*            A URL some parameters regarding the recording will be past to
	*            once it is completed.
	* @param recordCallbackMethod
	*            Method used to request the RecordCallback URL.
	* @param transcribe
	*            Specifies whether this call should be transcribed. Defaults to
	*            false.
	* @param transcribeCallback
	*            A URL some parameters regarding the transcription will be past
	*            to once it is completed.
	* @param transcribeCallbackMethod
	*            Method used to request the TranscribeCallback URL.
	* @return The newly made call.
	* @throws M360Exception
	*/
	
	public Message360<CallMessages> makeCall(CallRequest cr) throws M360Exception {
		String accountSid = conf.getSid();
		if (cr.getAccountSid() != null)
			accountSid = cr.getAccountSid();
		return makeCall(accountSid, cr.getFromCountryCode(),cr.getFrom(),cr.getToCountryCode(),cr.getTo(),cr.getUrl(),cr.getMethod(),cr.getStatusCallback(),
				cr.getStatusCallbackMethod(),cr.getFallbackUrl(),cr.getFallbackMethod(),cr.getHeartbeatUrl(),cr.getHeartbeatMethod(),cr.getForwardedFrom(),
				cr.getTimeout(),cr.getPlayDtmf(),cr.getHideCallerId(),cr.getRecord(),cr.getRecordCallback(),cr.getRecordCallbackMethod(),cr.getTranscribe(),
				cr.getTranscribeQuality(),cr.getStraightToVoicemail(),cr.getIfMachine(),cr.getIfMachineUrl(),cr.getIfMachineMethod());
	}
	
	public String makeJsonCall(CallRequest cr) throws M360Exception {
		String accountSid = conf.getSid();
		if (cr.getAccountSid() != null)
			accountSid = cr.getAccountSid();
		return callProxy.makeCall(accountSid, cr.getFromCountryCode(),cr.getFrom(),cr.getToCountryCode(),cr.getTo(),cr.getUrl(),cr.getMethod(),cr.getStatusCallback(),
				cr.getStatusCallbackMethod(),cr.getFallbackUrl(),cr.getFallbackMethod(),cr.getHeartbeatUrl(),cr.getHeartbeatMethod(),cr.getForwardedFrom(),
				cr.getTimeout(),cr.getPlayDtmf(),cr.getHideCallerId(),cr.getRecord(),cr.getRecordCallback(),cr.getRecordCallbackMethod(),cr.getTranscribe(),
				cr.getTranscribeQuality(),cr.getStraightToVoicemail(),cr.getIfMachine(),cr.getIfMachineUrl(),cr.getIfMachineMethod()).getEntity(String.class);
	}
	
	
	/**
	 * @see #interuptedCall
	 * @param sid
	 * @param callsid
	 * @param method
	 * @param status
	 * @param url
	 * @return
	 * @throws M360Exception
	 */
	public Message360<CallMessages> interuptedCall(String sid,String callsid,HttpMethod method,CallInterruptStatus status ,String url)  throws M360Exception{
		ClientResponse<Message360<CallMessages>> interuptedCall = callProxy.interruptCall(sid, callsid,method,status,url);
		return returnThrows(interuptedCall);
	}
	
	public Message360<CallMessages> interuptedCall(String callsid,HttpMethod method,CallInterruptStatus status,String url) throws M360Exception{
		System.out.println("510:"+callsid+","+method+","+status);
		return interuptedCall(conf.getSid(), callsid, method, status, url);
	}
	
	public String interuptedJsonCall(String callsid,HttpMethod method,CallInterruptStatus status,String url) throws M360Exception{
		return callProxy.interruptCall(conf.getSid(), callsid, method, status, url).getEntity(String.class);
	}
	
	
	/**@see #sendDigit
	 * 
	 * @param sid
	 * @param callsid
	 * @param playDtmf
	 * @param playDtmfDirection
	 * @return
	 * @throws M360Exception
	 */
	
	public Message360<CallMessages> sendDigits(String sid,String callsid,String playDtmf,Direction playDtmfDirection) throws M360Exception{
		ClientResponse<Message360<CallMessages>> interuptedCall = callProxy.sendDigits(sid, callsid,playDtmf,playDtmfDirection);
	return returnThrows(interuptedCall);
	}
	
	public Message360<CallMessages> sendDigits(String callsid,String playDtmf,Direction playDtmfDirection) throws M360Exception{
		return sendDigits(conf.getAuthToken(),callsid,playDtmf,playDtmfDirection);
	}
	
	public String sendJsonDigits(String callsid,String playDtmf,Direction playDtmfDirection) throws M360Exception{
		return callProxy.sendDigits(conf.getAuthToken(),callsid,playDtmf,playDtmfDirection).getEntity(String.class);
	}
	
	/**PlayAudio
	* @see #playAudio
	* @param sid
	* @param callsid
	* @param mix
	* @param length
	* @param loop
	* @param audioUrl
	* @return
	* @throws M360Exception
	*/
	
	public Message360<CallMessages> playAudios(String sid,String callsid,Boolean mix,Long length,Boolean loop,String audioUrl) throws M360Exception{
		ClientResponse<Message360<CallMessages>> playAudio =callProxy.playAudio(sid, callsid, mix, length, loop, audioUrl);
	return returnThrows(playAudio);
	}
	
	public Message360<CallMessages> playAudios(String callsid,Boolean mix,Long length,Boolean loop,String autioUrl) throws M360Exception{
		return playAudios(conf.getSid(), callsid,mix,length,loop,autioUrl);
	}
	
	public String playJsonAudios(String callsid,Boolean mix,Long length,Boolean loop,String autioUrl) throws M360Exception{
		return callProxy.playAudio(conf.getSid(), callsid,mix,length,loop,autioUrl).getEntity(String.class);
	}
	
	
	/**@see #voiceEffects()
	* @param sid
	* @param callSid
	* @param audioDirection
	* @param pitchSemiTones
	* @param pitchOctaves
	* @param pitch
	* @param rate
	* @param tempo
	* @return
	* @throws M360Exception
	*/
	
	public Message360<CallMessages> voiceEffects(String sid,String callSid,AudioDirection audioDirection,Long pitchSemiTones,Long pitchOctaves,Long pitch,Long rate,Long tempo) throws M360Exception{
		ClientResponse<Message360<CallMessages>> voiceEffect =callProxy.voiceEffects(sid, callSid, audioDirection, pitchSemiTones, pitchOctaves, pitch, rate, tempo);
	return returnThrows(voiceEffect);
	}
	
	public Message360<CallMessages> voiceEffects(String callSid,AudioDirection audioDirection,Long pitchSemiTones,Long pitchOctaves,Long pitch,Long rate,Long tempo) throws M360Exception{
		return voiceEffects(conf.getSid(),callSid, audioDirection, pitchSemiTones, pitchOctaves, pitch, rate, tempo);
	}
	public Message360<CallMessages> voiceEffects(String callSid) throws M360Exception{
		return voiceEffects(conf.getSid(),null, null, null, null, null, null, null);
	}
	
	public String voiceJsonEffects(String callSid,AudioDirection audioDirection,Long pitchSemiTones,Long pitchOctaves,Long pitch,Long rate,Long tempo) throws M360Exception{
		return callProxy.voiceEffects(conf.getSid(),callSid, audioDirection, pitchSemiTones, pitchOctaves, pitch, rate, tempo).getEntity(String.class);
	}
	public String voiceJsonEffects(String callSid) throws M360Exception{
		return callProxy.voiceEffects(conf.getSid(),callSid, null, null, null, null, null, null).getEntity(String.class);
	}
	
	/**
	 * @see #recordCall
	 * @param sid
	 * @param callSid
	 * @param direction
	 * @param record
	 * @param timeLimit
	 * @param callBackUrl
	 * @param fileFormat
	 * @return
	 * @throws M360Exception
	 */
	public Message360<CallMessages> recordCall(String sid,String callSid,Direction direction,boolean record,Long timeLimit,String callBackUrl ,AudioFormat fileFormat) throws M360Exception{
		ClientResponse<Message360<CallMessages>> recordCall =callProxy.recordCall(sid, callSid, direction, record, timeLimit, callBackUrl, fileFormat);
	return returnThrows(recordCall);
	}
	
	public Message360<CallMessages> recordCall(String callSid,Direction direction,boolean record,Long timeLimit,String callBackUrl ,AudioFormat fileFormat) throws M360Exception{
		return recordCall(conf.getSid(), callSid, direction, record, timeLimit, callBackUrl, fileFormat);
	}
	
	public String recordJsonCall(String callSid,Direction direction,boolean record,Long timeLimit,String callBackUrl ,AudioFormat fileFormat) throws M360Exception{
		return callProxy.recordCall(conf.getSid(), callSid, direction, record, timeLimit, callBackUrl, fileFormat).getEntity(String.class);
	}
	
	//////////////////////
	////Phone Numbers
	//////////////////////
	
	/**
	 * @see avaialbeNumber
	 * @param sid
	 * @param areaCode
	 * @param region
	 * @param phoneNumberType
	 * @return
	 * @throws M360Exception
	 */
	public Message360<NumberMessage> availableNumber(String sid,String areaCode,String region,PhoneNumberType phoneNumberType) throws M360Exception{
		ClientResponse<Message360<NumberMessage>> availablePhoneNumber =phoneProxy.availableNumber(sid, areaCode, region, phoneNumberType);
	return returnThrows(availablePhoneNumber);
	}
	
	public Message360<NumberMessage> availableNumber(String areaCode,String region,PhoneNumberType phoneNumberType) throws M360Exception{
		return availableNumber(conf.getSid(), areaCode, region, phoneNumberType);
	}
	
	public String availableJsonNumber(String areaCode,String region,PhoneNumberType phoneNumberType) throws M360Exception{
		return phoneProxy.availableNumber(conf.getSid(), areaCode, region, phoneNumberType).getEntity(String.class);
	}
	
	/**
	 * @see #viewNumber
	 * @param sid
	 * @param phoneNumber
	 * @return
	 * @throws M360Exception
	 */
	
	public Message360<NumberMessage> viewNumber(String sid,String phoneNumber) throws M360Exception{
		ClientResponse<Message360<NumberMessage>> viewNumber =phoneProxy.viewNumber(sid, phoneNumber);
	return returnThrows(viewNumber);
	}
	
	public Message360<NumberMessage> viewNumber(String phoneNumber) throws M360Exception{
		return viewNumber(conf.getSid(), phoneNumber);
	}
	
	public String viewJsonNumber(String phoneNumber) throws M360Exception{
		return phoneProxy.viewNumber(conf.getSid(),phoneNumber).getEntity(String.class);
	}
	
	/**List Number
	 * @param sid
	 * @param page
	 * @param pageSize
	 * @param friendlyName
	 * @param numberType
	 * @return
	 * @throws M360Exception
	 */
	
	
	public Message360<NumberMessage> listNumber(String sid,Long page,Long pageSize,String friendlyName, PhoneNumberType numberType) throws M360Exception{
		ClientResponse<Message360<NumberMessage>> listNumber =phoneProxy.listNumber(sid, page, pageSize, friendlyName,numberType);
	return returnThrows(listNumber);
	}
	
	public Message360<NumberMessage> listNumber(Long page,Long pageSize,String friendlyName, PhoneNumberType numberType) throws M360Exception{
		return listNumber(conf.getSid(), page, pageSize, friendlyName,numberType);
	}
	public Message360<NumberMessage> listNumber() throws M360Exception{
		return listNumber(conf.getSid(), null,null, null,PhoneNumberType.ALL);
	}
	
	public String listJsonNumber(Long page,Long pageSize,String friendlyName, PhoneNumberType numberType) throws M360Exception{
		return phoneProxy.listNumber(conf.getSid(), page, pageSize, friendlyName,numberType).getEntity(String.class);
	}
	public String listJsonNumber() throws M360Exception{
		return phoneProxy.listNumber(conf.getSid(), null,null, null,PhoneNumberType.ALL).getEntity(String.class);
	}
	
	
	/**Buy Number
	 * @param sid
	 * @param phoneNumber
	 * @return
	 * @throws M360Exception
	 */
	
	
	public Message360<NumberMessage> buyNumber(String sid,String phoneNumber) throws M360Exception{
		ClientResponse<Message360<NumberMessage>> buyNumber =phoneProxy.buyNumber(sid, phoneNumber);;
	return returnThrows(buyNumber);
	}
	
	public Message360<NumberMessage> buyNumber(String phoneNumber) throws M360Exception{
		return buyNumber(conf.getSid(), phoneNumber);
	}
	
	public String buyJsonNumber(String phoneNumber) throws M360Exception{
		return phoneProxy.buyNumber(conf.getSid(), phoneNumber).getEntity(String.class);
	}
	
	/**
	 * 
	 * @param sid
	 * @param phoneNumber
	 * @param friendlyName
	 * @param voiceUrl
	 * @param voiceMethod
	 * @param voiceFallbackUrl
	 * @param voiceFallbackMethod
	 * @param hangupCallback
	 * @param hangupCallbackMethod
	 * @param heartbeatUrl
	 * @param heartbeatMethod
	 * @param smsUrl
	 * @param smsMethod
	 * @param smsFallbackUrl
	 * @param smsFallbackMethod
	 * @return
	 * @throws M360Exception
	 */
	
	public Message360<NumberMessage> updateNumber(String sid,String phoneNumber, String friendlyName,String voiceUrl, HttpMethod voiceMethod,String voiceFallbackUrl,HttpMethod voiceFallbackMethod,
			String hangupCallback, HttpMethod hangupCallbackMethod, String heartbeatUrl,HttpMethod heartbeatMethod,String smsUrl, HttpMethod smsMethod,String smsFallbackUrl,HttpMethod smsFallbackMethod) throws M360Exception{
		ClientResponse<Message360<NumberMessage>> updateNumber =phoneProxy.updateNumber(sid, phoneNumber, friendlyName, voiceUrl, voiceMethod, voiceFallbackUrl, voiceFallbackMethod, hangupCallback, hangupCallbackMethod, heartbeatUrl, heartbeatMethod, smsUrl, smsMethod, smsFallbackUrl, smsFallbackMethod);
	return returnThrows(updateNumber);
	}
	
	public Message360<NumberMessage> updateNumber(String phoneNumber, String friendlyName,String voiceUrl, HttpMethod voiceMethod,String voiceFallbackUrl,HttpMethod voiceFallbackMethod,
			String hangupCallback, HttpMethod hangupCallbackMethod, String heartbeatUrl,HttpMethod heartbeatMethod,String smsUrl, HttpMethod smsMethod,String smsFallbackUrl,HttpMethod smsFallbackMethod) throws M360Exception{
		return updateNumber(conf.getSid(), phoneNumber, friendlyName, voiceUrl, voiceMethod, voiceFallbackUrl, voiceFallbackMethod, hangupCallback, hangupCallbackMethod, heartbeatUrl, heartbeatMethod, smsUrl, smsMethod, smsFallbackUrl, smsFallbackMethod);
	}
	
	public Message360<NumberMessage> updateNumber(IncomingPhoneNumberRequest phoneRequest) throws M360Exception{
		String accountSid = conf.getSid();
		if (phoneRequest.getAccountSid() != null)
			accountSid = phoneRequest.getAccountSid();
		return updateNumber(accountSid, phoneRequest.getPhoneNumber(), phoneRequest.getFriendlyName(), phoneRequest.getVoiceUrl(), phoneRequest.getVoiceMethod(),
				phoneRequest.getVoiceFallbackUrl(), phoneRequest.getVoiceFallbackMethod(), phoneRequest.getHangupCallback(),
				phoneRequest.getHangupCallbackMethod(), phoneRequest.getHeartbeatUrl(), phoneRequest.getHeartbeatMethod(), phoneRequest.getSmsUrl(),
				phoneRequest.getSmsMethod(), phoneRequest.getSmsFallbackUrl(), phoneRequest.getSmsFallbackMethod());
		
	}
	
	
	public String updateJsonNumber(String phoneNumber, String friendlyName,String voiceUrl, HttpMethod voiceMethod,String voiceFallbackUrl,HttpMethod voiceFallbackMethod,
			String hangupCallback, HttpMethod hangupCallbackMethod, String heartbeatUrl,HttpMethod heartbeatMethod,String smsUrl, HttpMethod smsMethod,String smsFallbackUrl,HttpMethod smsFallbackMethod) throws M360Exception{
		return phoneProxy.updateNumber(conf.getSid(),  phoneNumber, friendlyName, voiceUrl, voiceMethod, voiceFallbackUrl, voiceFallbackMethod, hangupCallback, hangupCallbackMethod, heartbeatUrl, heartbeatMethod, smsUrl, smsMethod, smsFallbackUrl, smsFallbackMethod).getEntity(String.class);
	}
	
	public String updateJsonNumber(IncomingPhoneNumberRequest phoneRequest) throws M360Exception{
		String accountSid = conf.getSid();
		if (phoneRequest.getAccountSid() != null)
			accountSid = phoneRequest.getAccountSid();
		return phoneProxy.updateNumber(accountSid, phoneRequest.getPhoneNumber(), phoneRequest.getFriendlyName(), phoneRequest.getVoiceUrl(), phoneRequest.getVoiceMethod(),
				phoneRequest.getVoiceFallbackUrl(), phoneRequest.getVoiceFallbackMethod(), phoneRequest.getHangupCallback(),
				phoneRequest.getHangupCallbackMethod(), phoneRequest.getHeartbeatUrl(), phoneRequest.getHeartbeatMethod(), phoneRequest.getSmsUrl(),
				phoneRequest.getSmsMethod(), phoneRequest.getSmsFallbackUrl(), phoneRequest.getSmsFallbackMethod()).getEntity(String.class);
	}
	
	/**
	 * @see releaseNumber
	 * @param sid
	 * @param releaseNumber
	 * @return
	 * @throws M360Exception
	 */
	public Message360<NumberMessage> releaseNumber(String sid,String releaseNumber) throws M360Exception{
		ClientResponse<Message360<NumberMessage>> buyNumber =phoneProxy.buyNumber(sid, releaseNumber);
	return returnThrows(buyNumber);
	}
	
	public Message360<NumberMessage> releaseNumber(String releaseNumber) throws M360Exception{
		return releaseNumber(conf.getSid(), releaseNumber);
	}
	
	public String releaseJsonNumber(String releaseNumber) throws M360Exception{
		return phoneProxy.releaseNumber(conf.getSid(), releaseNumber).getEntity(String.class);
	}
	
	///////////////////////
	//////Recording
	//////////////////////
	
	/**viewRecording
	 * 
	 * @param sid
	 * @param recordingId
	 * @return
	 * @throws M360Exception
	 */
	public Message360<RecordMessage> viewRecording(String sid,String recordingId) throws M360Exception{
		ClientResponse<Message360<RecordMessage>> viewRecording = recordingProxy.viewRecording(sid,recordingId);
		return  returnThrows(viewRecording);
	}
	
	public Message360<RecordMessage> viewRecording(String recordingId) throws M360Exception{
		return viewRecording(conf.getSid(),recordingId);
	}
	
	public String viewJsonRecording(String recordingId) throws M360Exception{
		return recordingProxy.viewRecording(conf.getSid(),recordingId).getEntity(String.class);
		
	}
	
	/**ListRecording
	 * 
	 * @param sid
	 * @param recordingId
	 * @return
	 * @throws M360Exception
	 */
	private Message360<RecordMessage> listRecording(String sid) throws M360Exception{
		ClientResponse<Message360<RecordMessage>> listRecording = recordingProxy.listRecording(sid);
		return  returnThrows(listRecording);
	}
	
	public Message360<RecordMessage> listRecording() throws M360Exception{
		return listRecording(conf.getSid());
	}
	
	public String listJsonRecording() throws M360Exception{
		return recordingProxy.listRecording(conf.getSid()).getEntity(String.class);
	}
	
	/**@see deleteRecording
	 * 
	 * @param accountSid
	 * @param recordingSid
	 * @return
	 * @throws M360Exception
	 */
	public Message360<RecordMessage> deleteRecording(String accountSid,String recordingSid) throws M360Exception{
		ClientResponse<Message360<RecordMessage>> viewRecording = recordingProxy.deleteRecording(accountSid, recordingSid);
		return returnThrows(viewRecording);
	}
	
	public Message360<RecordMessage> deleteRecording(String recordingSid) throws M360Exception{
		return deleteRecording(conf.getSid(),recordingSid);
	}
	public String deleteRecordingJson(String recordingSid) throws M360Exception{
		return recordingProxy.deleteRecording(conf.getSid(),recordingSid).getEntity(String.class);
	}
	
	/////////////////////
	////TRANSCRIPTION
	/////////////////////
	
	/**viewTransription
	 * @param sid
	 * @param transcriptionsid
	 * @return
	 * @throws M360Exception
	 */
	
	public Message360<TranscriptionMessage> viewTranscription(String sid,String transcriptionsid) throws M360Exception{
		ClientResponse<Message360<TranscriptionMessage>> viewTranscription =transcriptionProxy.viewTranscription(sid,transcriptionsid);
		return returnThrows(viewTranscription);
	}
	
	public Message360<TranscriptionMessage> viewTranscription(String transcriptionsid) throws M360Exception{
		return viewTranscription(conf.getSid(),transcriptionsid);
	}
	
	public String viewJsonTranscription(String transcriptionsid){
		return transcriptionProxy.viewTranscription(conf.getSid(),transcriptionsid).getEntity(String.class);
	}
	
	/**@see #listTranscription
	 * @param sid
	 * @param page
	 * @param pageSize
	 * @param status
	 * @param date
	 * @return
	 * @throws M360Exception
	 */
	public Message360<TranscriptionMessage> listTranscription(String sid,Long page,Long pageSize,TranscriptionStatus status,Date date) throws M360Exception{
		ClientResponse<Message360<TranscriptionMessage>> listTranscription =transcriptionProxy.listTranscription(sid,page,pageSize,status,getDateString(date));
		return returnThrows(listTranscription);
	}
	
	public Message360<TranscriptionMessage> listTranscription(Long page,Long pageSize,TranscriptionStatus status,Date date) throws M360Exception{
		return listTranscription(conf.getSid(),page,pageSize,status,date);
	}
	public Message360<TranscriptionMessage> listTranscription() throws M360Exception{
		return listTranscription(conf.getSid(),null,null,null,null);
	}
	
	public String listJsonTranscription(Long page,Long pageSize,TranscriptionStatus status,Date date){
		return transcriptionProxy.listTranscription(conf.getSid(),page,pageSize,status,getDateString(date)).getEntity(String.class);
	}
	public String listJsonTranscription(){
		return transcriptionProxy.listTranscription(conf.getSid(),null,null,null,null).getEntity(String.class);
	}
	
	/**@see #audioUrlTranscription
	 * 
	 * @param sid
	 * @param audioUrl
	 * @return
	 * @throws M360Exception
	 */
	
	public Message360<TranscriptionMessage> audioUrlTranscription(String sid,String audioUrl) throws M360Exception{
		ClientResponse<Message360<TranscriptionMessage>> viewTranscription =transcriptionProxy.audioTranscriptionUrl(sid, audioUrl);
		return returnThrows(viewTranscription);
	}
	
	public Message360<TranscriptionMessage> audioUrlTranscription(String audioUrl) throws M360Exception{
		return audioUrlTranscription(conf.getSid(), audioUrl);
	}
	
	public String audioUrlJsonTranscription(String audioUrl) throws M360Exception{
		return transcriptionProxy.audioTranscriptionUrl(conf.getSid(), audioUrl).getEntity(String.class);
	}
	
	/**
	 * @see #recordingTranscription
	 * 
	 * @param sid
	 * @param recordingSid
	 * @return
	 * @throws M360Exception
	 */
	
	public Message360<TranscriptionMessage> recordingTranscription(String sid,String recordingSid) throws M360Exception{
		ClientResponse<Message360<TranscriptionMessage>> recordingTranscription =transcriptionProxy.recordingTranscription(sid, recordingSid);
		return returnThrows(recordingTranscription);
	}
	
	public Message360<TranscriptionMessage> recordingTranscription(String recordingSid) throws M360Exception{
		return recordingTranscription(conf.getSid(), recordingSid);
	}
	
	public String recordingJsonTranscription(String recordingSid) throws M360Exception{
		return transcriptionProxy.audioTranscriptionUrl(conf.getSid(), recordingSid).getEntity(String.class);
	}
	
	/////////////////////
	//////EMAIL SECTION
	////////////////////
	
	/**@see #sendEmail
	 *  
	 * @param sid 
	 * 		The account sid(required)
	 * @param to
	 * 		eMail to
	 * @param subject  
	 * 		email subject
	 * @param message
	 *		email   
	 * @return An Email Message resource.
	 * @throws M360Exception. 
	 * 
	 */
	private Message360<Message360Email<SendEmail>> sendEmail(String sid,String to,String subject,String message) throws M360Exception{
		ClientResponse<Message360<Message360Email<SendEmail>>> email = emailProxy.sendEmail(sid, to, subject, message);
		return returnThrows(email);
	}
	
	public Message360<Message360Email<SendEmail>> sendEmail(String to,String subject,String message) throws M360Exception{
		return sendEmail(conf.getSid(), to, subject, message);
	}
	
	public String sendJsonEmail(String to,String subject,String message) throws M360Exception{
		return  emailProxy.sendEmail(conf.getSid(), to, subject, message).getEntity(String.class);
	}
	

	
	
	/**@see #listBlockedEmailList(Integer, Integer)
	 * 
	 * return all BlockedEmailList
	 * @param sid
	 * @return
	 * @throws M360Exception
	 */
	private Message360<Message360Email<Blocked>> listBlockedEmailList(String sid,Integer offset,Integer limit) throws M360Exception{
		ClientResponse<Message360<Message360Email<Blocked>>> email = emailProxy.listBlockedEmailList(sid,offset,limit);
		return returnThrows(email);
	}
	
	public Message360<Message360Email<Blocked>> listBlockedEmailList(Integer offset,Integer limit) throws M360Exception{
		return listBlockedEmailList(conf.getSid(),offset,limit);
	}
	
	public String listJsonBlockedEmailList(Integer offset,Integer limit) throws M360Exception{
		return emailProxy.listBlockedEmailList(conf.getSid(),offset,limit).getEntity(String.class);
	}
	
	
	
	/**@see #deleteBlocksEmailAdress(String)
	 * Delete the BlockedEmaiAddress
	 * @param sid
	 * @param email
	 * 	email to delete from BlockedEmailAddress
	 * @return
	 * @throws M360Exception
	 */
	
	public Message360<Message360Email<Blocked>> deleteBlocksEmailAdress(String sid,String email) throws M360Exception{
		ClientResponse<Message360<Message360Email<Blocked>>> blockEmailAddress = emailProxy.deleteBlocksEmailAdrees(sid,email);
		return returnThrows(blockEmailAddress);
	}
	public Message360<Message360Email<Blocked>> deleteBlocksEmailAdress(String email) throws M360Exception{
		return deleteBlocksEmailAdress(conf.getSid(),email);
	}
	
	public String deleteJsonBlocksEmailAdress(String email) throws M360Exception{
		return emailProxy.deleteBlocksEmailAdrees(conf.getSid(),email).getEntity(String.class);
	}
	
	/**@see #listBounceEmail(String)
	 * @param email
	 *	 email to delete from BlockedEmailAddress
	 * @return
	 * @throws M360Exception
	 */
	
	public Message360<Message360Email<Bounce>> listBounceEmail(String sid) throws M360Exception{
		ClientResponse<Message360<Message360Email<Bounce>>> listBouncEmail=emailProxy.listBouncesEmail(sid);
		return returnThrows(listBouncEmail);
	}
	public  Message360<Message360Email<Bounce>> listBounceEmail()throws M360Exception{
		return listBounceEmail(conf.getSid());
	}
	
	public  String listJsonBounceEmail()throws M360Exception{
		return emailProxy.listBouncesEmail(conf.getSid()).getEntity(String.class);
	}
	
	/**@see #deleteBounceEmail(String)
	 * @param sid
	 * @param email
	 * @return
	 * @throws M360Exception
	 */
	
	public  Message360<Message360Email<Bounce>> deleteBounceEmail(String sid,String email) throws M360Exception{
		ClientResponse<Message360<Message360Email<Bounce>>> listBouncEmail=emailProxy.deleteBouncesEmail(sid,email);
		return returnThrows(listBouncEmail);
	}
	public  Message360<Message360Email<Bounce>> deleteBounceEmail(String email)throws M360Exception{
		return deleteBounceEmail(conf.getSid(),email);
	}
	
	public String deleteJsonBounceEmail(String email)throws M360Exception{
		return emailProxy.deleteBouncesEmail(conf.getSid(),email).getEntity(String.class);
	}
	
	/**@see #listSpamEmail(String)
	 * @param sid
	 * @return																																																																																																																																																		
	 * @throws M360Exception																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																						
	 */
	
	public Message360<Message360Email<Spam>> listSpamEmail(String sid) throws M360Exception{
		ClientResponse<Message360<Message360Email<Spam>>> listSpamEmail=emailProxy.listSpamEmail(sid);
		return returnThrows(listSpamEmail);
	}
	public Message360<Message360Email<Spam>> listSpamEmail()throws M360Exception{
		return listSpamEmail(conf.getSid());
	}
	
	public String listJsonSpamEmail() throws M360Exception{
		return emailProxy.listSpamEmail(conf.getSid()).getEntity(String.class);
	}
	
	/**@see #deleteSpamEmail(String)
	 * 
	 * @param sid
	 * @param email
	 * @return
	 * @throws M360Exception
	 */
	public Message360<Message360Email<Spam>> deleteSpamEmail(String sid,String email) throws M360Exception{
		ClientResponse<Message360<Message360Email<Spam>>> listSpamEmail=emailProxy.deleteSpamEmail(sid,email);
		return returnThrows(listSpamEmail);
	}
	public Message360<Message360Email<Spam>> deleteSpamEmail(String email)throws M360Exception{
		return deleteSpamEmail(conf.getSid(),email);
	}
	
	
	public String deleteJsonSpamEmail(String email)throws M360Exception{
		return emailProxy.deleteSpamEmail(conf.getSid(),email).getEntity(String.class);
	}
	
	
	/**List Invalid Email
	 * List all invalid email conditions with messages .
	 * @param sid
	 * @return
	 * @throws M360Exception
	 */
	public Message360<Message360Email<Invalid>> listInvalidEmail(String sid) throws M360Exception{
		ClientResponse< Message360<Message360Email<Invalid>>> listInValidEmail=emailProxy.listInvalidEmail(sid);
		return returnThrows(listInValidEmail);
	}
	public  Message360<Message360Email<Invalid>> listInvalidEmail()throws M360Exception{
		return listInvalidEmail(conf.getSid());
	}
	
	public  String listJsonInvalidEmail()throws M360Exception{
		return emailProxy.listInvalidEmail(conf.getSid()).getEntity(String.class);
	}
	
	/**
	 * Delete the Invalid email from accout
	 *  
	 * @param sid
	 * @return
	 * @throws M360Exception
	 */
	public  Message360<Message360Email<Invalid>> deleteInValidEmail(String sid,String email) throws M360Exception{
		ClientResponse< Message360<Message360Email<Invalid>>> deleteInValidEmail=emailProxy.deleteInvalidEmail(sid, email);
		return returnThrows(deleteInValidEmail);
	}
	public  Message360<Message360Email<Invalid>> deleteInValidEmail(String email)throws M360Exception{
		return deleteInValidEmail(conf.getSid(),email);
	}
	
	public  String deleteJsonInvalidEmail(String email)throws M360Exception{
		return emailProxy.deleteInvalidEmail(conf.getSid(),email).getEntity(String.class);
	}
	
	
	
	/**
	 * Add Unsubscribed EmailAddress
	 * 
	 * @param sid
	 * @param email
	 * @return
	 * @throws M360Exception
	 */
	
	public Message360<Message360Email<Unsubscribed>> addUnsubsribe(String sid,String email)throws M360Exception{
		ClientResponse<Message360<Message360Email<Unsubscribed>>> addUnsubscribe=emailProxy.addUnsubscribeEmailAdreess(sid,email);
		return returnThrows(addUnsubscribe);
	}
	
	public Message360<Message360Email<Unsubscribed>> addUnsubsribeEmailAddress(String email)throws M360Exception{
		return addUnsubsribe(conf.getSid(),email);
	}
	
	public String addJsonUnsubsribeEmailAddress(String email)throws M360Exception{
		return emailProxy.addUnsubscribeEmailAdreess(conf.getSid(),email).getEntity(String.class);
	}
	
	/**List the Unsubscribed Email addresses
	 * 
	 * @param sid
	 * @return
	 * @throws M360Exception
	 */
	
	public Message360<Message360Email<Unsubscribed>> listUnsubsribe(String sid)throws M360Exception{
		ClientResponse<Message360<Message360Email<Unsubscribed>>> listUnsubscribe=emailProxy.listUnsubscribeEmailAddress(sid);
		return returnThrows(listUnsubscribe);
	}
	
	public Message360<Message360Email<Unsubscribed>> listUnsubsribeEmaillAddress()throws M360Exception{
		return listUnsubsribe(conf.getSid());
	}
	
	public String listJsonUnsubsribeEmaillAddress()throws M360Exception{
		return emailProxy.listUnsubscribeEmailAddress(conf.getSid()).getEntity(String.class);
	}
	
	/**Delete the unsubscribe Email from email Addresses
	 * 
	 * @param sid
	 * @param email
	 * @return
	 * @throws M360Exception
	 */
	public Message360<Message360Email<Unsubscribed>> deleteUnsubsribeEmailAddress(String sid,String email)throws M360Exception{
		ClientResponse<Message360<Message360Email<Unsubscribed>>> deleteUnsubscribe=emailProxy.deleteUnsubscribeEmailAddress(sid,email);
		return returnThrows(deleteUnsubscribe);
	}
	
	public Message360<Message360Email<Unsubscribed>> deleteUnsubsribeEmailAddress(String email)throws M360Exception{
		return deleteUnsubsribeEmailAddress(conf.getSid(),email);
	}
	
	public String deleteJsonUnsubsribeEmailAddress(String email)throws M360Exception{
		return emailProxy.deleteUnsubscribeEmailAddress(conf.getSid(),email).getEntity(String.class);
	}
	
	
	////////////////
	///Conference
	////////////////
	/**View Conference
	 * 
	 * @param sid
	 * @param conferenceSid
	 * @return
	 * @throws M360Exception
	 */
	public Message360<ConferenceMessages> viewConference(String sid,String conferenceSid)throws M360Exception{
		ClientResponse<Message360<ConferenceMessages>> viewConference=conferenceProxy.viewConference(sid, conferenceSid);
		return returnThrows(viewConference);
	}
	
	public Message360<ConferenceMessages> viewConference(String conferenceSid)throws M360Exception{
		return viewConference(conf.getSid(),conferenceSid);
	}
	
	public String viewJsonConference(String conferenceSid)throws M360Exception{
		return conferenceProxy.viewConference(conf.getSid(), conferenceSid).getEntity(String.class);
	}
	
	/**List conference
	 * 
	 * @param sid
	 * @param conferenceSid
	 * @return
	 * @throws M360Exception
	 */
	public Message360<ConferenceMessages> listConference(String sid, Long page, Long pageSize,String friendlyName,ConferenceStatus Status, Date dateCreated, Date dateUpdated)throws M360Exception{
		ClientResponse<Message360<ConferenceMessages>> viewConference=conferenceProxy.listConference(sid, page, pageSize, friendlyName, Status, dateCreated, dateUpdated);
		return returnThrows(viewConference);
	}
	
	public Message360<ConferenceMessages> listConference(Long page, Long pageSize,String friendlyName,ConferenceStatus Status, Date dateCreated, Date dateUpdated)throws M360Exception{
		return listConference(conf.getSid(), page, pageSize, friendlyName, Status, dateCreated, dateUpdated);
	}
	public Message360<ConferenceMessages> listConference()throws M360Exception{
		return listConference(conf.getSid(), null, null, null, null, null, null);
	}
	
	public String listJsonConference(Long page, Long pageSize,String friendlyName,ConferenceStatus Status, Date dateCreated, Date dateUpdated)throws M360Exception{
		return conferenceProxy.listConference(conf.getSid(), page, pageSize, friendlyName, Status, dateCreated, dateUpdated).getEntity(String.class);
	}
	
	public String listJsonConference()throws M360Exception{
		return conferenceProxy.listConference(conf.getSid(), null, null, null, null, null, null).getEntity(String.class);
	}
	/**Add Participant
	 * 
	 * @param sid
	 * @param conferenceSid
	 * @param participantNumberm
	 * @param muted
	 * @param deaf
	 * @param toCountryCode
	 * @return
	 * @throws M360Exception
	 */
	
	public Message360<ConferenceMessages> addParticipant(String sid,String conferenceSid,String participantNumberm,Boolean muted,Boolean deaf,Integer toCountryCode)throws M360Exception{
		ClientResponse<Message360<ConferenceMessages>> addParticipant=conferenceProxy.addParticipant(conf.getSid(), conferenceSid, participantNumberm, muted, deaf, toCountryCode);
		return returnThrows(addParticipant);
	}
	
	public Message360<ConferenceMessages> addParticipant(String conferenceSid,String participantNumberm,Boolean muted,Boolean deaf,Integer toCountryCode)throws M360Exception{
		return addParticipant(conf.getSid(),conferenceSid, participantNumberm, muted, deaf, toCountryCode);
	}
	
	public String addJsonParticipant(String conferenceSid,String participantNumberm,Boolean muted,Boolean deaf,Integer toCountryCode)throws M360Exception{
		return conferenceProxy.addParticipant(conf.getSid(), conferenceSid, participantNumberm, muted, deaf, toCountryCode).getEntity(String.class);
	}
	
	/**view Participant
	 * 
	 * @param sid
	 * @param conferenceSid
	 * @param participantsid
	 * @return
	 * @throws M360Exception
	 */
	
	public Message360<ConferenceMessages> viewParticipant(String sid,String conferenceSid,String participantsid)throws M360Exception{
		ClientResponse<Message360<ConferenceMessages>> addParticipant=conferenceProxy.viewParticipant(conf.getSid(), conferenceSid, participantsid);
		return returnThrows(addParticipant);
	}
	
	public Message360<ConferenceMessages> viewParticipant(String conferenceSid,String participantsid)throws M360Exception{
		return viewParticipant(conf.getSid(),conferenceSid,participantsid);
	}
	
	public String viewJsonParticipant(String conferenceSid,String participantsid)throws M360Exception{
		return conferenceProxy.viewParticipant(conf.getSid(), conferenceSid,participantsid).getEntity(String.class);
	}
	
	/**
	 * ClientResponse<Message360<ConferenceMessages>> listParticipant(
			@PathParam("AccountSid") String accountSid,
			@QueryParam("Page") Long page,
			@QueryParam("PageSize") Long pageSize,
			@QueryParam("Muted") Boolean muted,
			@QueryParam("deaf") Boolean deaf,
			@QueryParam("conferenceid") String conferenceid
			);
	 */
	
	public Message360<ConferenceMessages> listParticipant(String sid,Long page,Long pageSize,Boolean muted,Boolean deaf,String conferenceSid)throws M360Exception{
		ClientResponse<Message360<ConferenceMessages>> listParticipant=conferenceProxy.listParticipant(conf.getSid(), page,pageSize,muted,deaf,conferenceSid);
		return returnThrows(listParticipant);
	}
	
	public Message360<ConferenceMessages> listParticipant(Long page,Long pageSize,Boolean muted,Boolean deaf,String conferenceSid)throws M360Exception{
		return listParticipant(conf.getSid(), page,pageSize,muted,deaf,conferenceSid);
	}
	public Message360<ConferenceMessages> listParticipant(String conferenceSid)throws M360Exception{
		return listParticipant(conf.getSid(), null,null,null,null,conferenceSid);
	}
	
	public String listJsonParticipant(Long page,Long pageSize,Boolean muted,Boolean deaf,String conferenceSid)throws M360Exception{
		return conferenceProxy.listParticipant(conf.getSid(), page,pageSize,muted,deaf,conferenceSid).getEntity(String.class);
	}
	public String listJsonParticipant(String conferenceSid)throws M360Exception{
		return conferenceProxy.listParticipant(conf.getSid(), null,null,null,null,conferenceSid).getEntity(String.class);
	}
	
	/**
	 * 
	 * @param sid
	 * @param conferenceSid
	 * @param participantsid
	 * @param mute
	 * @param deaf
	 * @return
	 * @throws M360Exception
	 */
	
	public Message360<ConferenceMessages> deafMuteParticipant(String sid,String conferenceSid,String participantsid,Boolean mute,Boolean deaf)throws M360Exception{
		ClientResponse<Message360<ConferenceMessages>> deafMuteParticipant=conferenceProxy.deafMuteParticipant(conf.getSid(), conferenceSid, participantsid,mute,deaf);
		return returnThrows(deafMuteParticipant);
	}
	
	public Message360<ConferenceMessages> deafMuteParticipant(String conferenceSid,String participantsid,Boolean mute,Boolean deaf)throws M360Exception{
		return deafMuteParticipant(conf.getSid(),conferenceSid, participantsid,mute,deaf);
	}
	
	public String deafMuteJsonParticipant(String conferenceSid,String participantsid,Boolean mute,Boolean deaf)throws M360Exception{
		return conferenceProxy.deafMuteParticipant(conf.getSid(), conferenceSid, participantsid,mute,deaf).getEntity(String.class);
	}
	
	/**
	 * 
	 * @param sid
	 * @param conferenceSid
	 * @param callSid
	 * @return
	 * @throws M360Exception
	 */
	 

	public Message360<ConferenceMessages> hangupParticipant(String sid,String conferenceSid,String participantSid)throws M360Exception{
		ClientResponse<Message360<ConferenceMessages>> hangupParticipant=conferenceProxy.hangupParticipant(conf.getSid(), conferenceSid, participantSid);
		return returnThrows(hangupParticipant);
	}
	
	public Message360<ConferenceMessages> hangupParticipant(String conferenceSid,String participantSid)throws M360Exception{
		return hangupParticipant(conf.getSid(),conferenceSid, participantSid);
	}
	
	public String hangupJsonParticipant(String conferenceSid,String participantSid)throws M360Exception{
		return conferenceProxy.hangupParticipant(conf.getSid(), conferenceSid, participantSid).getEntity(String.class);
	}
	
	/**PlayAudio
	 * 
	 * @param sid
	 * @param conferenceSid
	 * @param participantsid
	 * @param audiourl
	 * @return
	 * @throws M360Exception
	 */
	public Message360<ConferenceMessages> playAudio(String sid,String conferenceSid,String participantsid,String audiourl)throws M360Exception{
		ClientResponse<Message360<ConferenceMessages>> playAudio=conferenceProxy.playAudio(conf.getSid(), conferenceSid, participantsid,audiourl);
		return returnThrows(playAudio);
	}
	
	public Message360<ConferenceMessages> playAudio(String conferenceSid,String participantsid,String audiourl)throws M360Exception{
		return playAudio(conf.getSid(),conferenceSid, participantsid,audiourl);
	}
	
	public String playJsonAudio(String conferenceSid,String participantsid,String audiourl)throws M360Exception{
		return conferenceProxy.playAudio(conf.getSid(), conferenceSid, participantsid,audiourl).getEntity(String.class);
	}
	
	////////////////
	////Carrier
	///////////////
	
	/**{@link #carrierLookup(String)}
	 * 
	 * @param sid
	 * @param phoneNumber
	 * @return
	 * @throws M360Exception
	 */
	
	public Message360<CarrierMessage> carrierLookup(String sid,String phoneNumber)throws M360Exception{
		ClientResponse<Message360<CarrierMessage>> carrierLookup=carrierProxy.carrierLookup(conf.getSid(), phoneNumber);
		return returnThrows(carrierLookup);
	}
	
	public Message360<CarrierMessage> carrierLookup(String phoneNumber)throws M360Exception{
		return carrierLookup(conf.getSid(),phoneNumber);
	}
	
	public String carrierJsonLookup(String phoneNumber)throws M360Exception{
		return carrierProxy.carrierLookup(conf.getSid(), phoneNumber).getEntity(String.class);
	}
	
	
	public Message360<CarrierMessage> carrierLookupList(String sid,Long page,Long pageSize)throws M360Exception{
		ClientResponse<Message360<CarrierMessage>> carrierLookup=carrierProxy.carrierLookupList(conf.getSid(), page,pageSize);
		return returnThrows(carrierLookup);
	}
	
	public Message360<CarrierMessage> carrierLookupList(Long page,Long pageSize)throws M360Exception{
		return carrierLookupList(conf.getSid(),page,pageSize);
	}
	public Message360<CarrierMessage> carrierLookupList()throws M360Exception{
		return carrierLookupList(conf.getSid(),null,null);
	}
	
	
	public String carrierJsonLookupList(Long page,Long pageSize)throws M360Exception{
		return carrierProxy.carrierLookupList(conf.getSid(), page,pageSize).getEntity(String.class);
	}
	
	public String carrierJsonLookupList()throws M360Exception{
		return carrierProxy.carrierLookupList(conf.getSid(), null,null).getEntity(String.class);
	}
	
	
	
}
