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
import java.util.List;

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
import com.M360.api.domain.directmail.responses.DMAddressBook;
import com.M360.api.domain.directmail.responses.DMAreaMail;
import com.M360.api.domain.directmail.responses.DMLetter;
import com.M360.api.domain.directmail.responses.DMPostCard;
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
import com.M360.api.domain.enums.EmailSendAs;
import com.M360.api.domain.enums.ExtraService;
import com.M360.api.domain.enums.HttpMethod;
import com.M360.api.domain.enums.IfMachineStatus;
import com.M360.api.domain.enums.PhoneNumberType;
import com.M360.api.domain.enums.ProductType;
import com.M360.api.domain.enums.TargetType;
import com.M360.api.domain.enums.TranscriptionStatus;
import com.M360.api.exception.M360Exception;
import com.M360.api.http.RestExecutor;
import com.M360.api.requests.CallRequest;
import com.M360.api.requests.IncomingPhoneNumberRequest;
import com.M360.api.restproxies.AccountsProxy;
import com.M360.api.restproxies.CallProxy;
import com.M360.api.restproxies.CarrierProxy;
import com.M360.api.restproxies.ConferenceProxy;
import com.M360.api.restproxies.DM_AddressBookProxy;
import com.M360.api.restproxies.DM_AreaMailProxy;
import com.M360.api.restproxies.DM_LetterProxy;
import com.M360.api.restproxies.DM_PostCardProxy;
import com.M360.api.restproxies.EmailProxy;
import com.M360.api.restproxies.PhoneProxy;
import com.M360.api.restproxies.RecordingProxy;
import com.M360.api.restproxies.SmsProxy;
import com.M360.api.restproxies.TranscriptionProxy;
import com.M360.api.restproxies.UsageProxy;




/**
 * @author xoyal
 *
 */
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
	private DM_AddressBookProxy addressBookProxy;
	private DM_PostCardProxy postCardProxy;
	private DM_LetterProxy letterProxy;
	private DM_AreaMailProxy areaMailProxy;
		

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
		System.out.println("URL:"+baseUrl);
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
		addressBookProxy = createProxy(DM_AddressBookProxy.class);
		postCardProxy = createProxy(DM_PostCardProxy.class);
		letterProxy = createProxy(DM_LetterProxy.class);
	}
	
	public Message360Connector(M360Configuration conf,String directMail) {
		this.conf = conf;
		executor = RestExecutor.createExecutor(conf);
		URI baseUrl = UriBuilder.fromUri(conf.getBaseUrl()).path(directMail+"/"+M360Constants.API_VERSION).build();
		System.out.println("URL:"+baseUrl);
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
		addressBookProxy = createProxy(DM_AddressBookProxy.class);
		postCardProxy = createProxy(DM_PostCardProxy.class);
		letterProxy = createProxy(DM_LetterProxy.class);
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
	public Message360<AccountMessage> viewAccount(String accountSid,String date) throws M360Exception {
		ClientResponse<Message360<AccountMessage>> acc = accountsProxy.getAccount(accountSid,date);
		return returnThrows(acc);
	}
	
	public Message360<AccountMessage> viewAccount(String date) throws M360Exception {
		return viewAccount(conf.getSid(),date);
	}
	
	public String viewJsonAccount(String date) throws M360Exception {
		return accountsProxy.getAccount(conf.getSid(),date).getEntity(String.class);
	}

	/////////////
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
		
	public Message360<UsageMessage> listUsage(String accountSid,ProductType product,String to,String from) throws M360Exception {
		ClientResponse<Message360<UsageMessage>> acc = usageProxy.listUsage(accountSid,product,to,from);
		return returnThrows(acc);
	}

	public Message360<UsageMessage> listUsage(ProductType product,String to,String from) throws M360Exception {
		return listUsage(conf.getSid(),product,to,from);
	}
	public Message360<UsageMessage> listUsage() throws M360Exception {
		return listUsage(conf.getSid(),ProductType.ALL,null,null);
	}
		
	public String listJsonUsage(ProductType product,String to,String from) throws M360Exception {
		return usageProxy.listUsage(conf.getSid(),product,to,from).getEntity(String.class);
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
		String from,  String dateSentGte,  Integer page,
		Integer pageSize) throws M360Exception {
	
	ClientResponse<Message360<SMSMessages>> smsList = smsProxy.getSmsMessageList(
			accountSid, to, from, dateSentGte, page, pageSize);
		return returnThrows(smsList);
	}
	
	public Message360<SMSMessages> listSmsMessages(String to, String from,
			String dateSentGte,  Integer page, Integer pageSize) throws M360Exception {
		return listSmsMessages(conf.getSid(), to, from, dateSentGte,
			 page, pageSize);
	}
	
	public Message360<SMSMessages> listSmsMessages() throws M360Exception {
		return listSmsMessages(conf.getSid(), null, null, null,  null,null);
	}
	
	public String listJsonSmsMessages() throws M360Exception {
		return smsProxy.getSmsMessageList(conf.getSid(), null, null, null,  null,null).getEntity(String.class);
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
	
	public Message360<SMSMessages> getInboundSMS(String accountSid,String to, String from,String dateReceived,Integer page,Integer pageSize) throws M360Exception {
	 ClientResponse<Message360<SMSMessages>> smsMessage = smsProxy.getInboundSms(accountSid, to, from,dateReceived, page,pageSize);
	 return returnThrows(smsMessage);
	}
	
	public Message360<SMSMessages> getInboundSMS(String to, String from,String dateReceived, Integer page,Integer pageSize) throws M360Exception {
		return getInboundSMS(conf.getSid(), to, from,dateReceived,page,pageSize);
	}
	public Message360<SMSMessages> getInboundSMS() throws M360Exception {
		return getInboundSMS(null,null,null,null,null);
	}
	
	public String getJsonInboundSMS(String to, String from,String dateReceived, Integer page, Integer pageSize) throws M360Exception {
	return smsProxy.getInboundSms(conf.getSid(), to, from,dateReceived,page,pageSize).getEntity(String.class);
	}
	public String getJsonInboundSMS() throws M360Exception {
		return smsProxy.getInboundSms(conf.getSid(), null,null,null,null,null).getEntity(String.class);
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
	public Message360<CallMessages> listCalls(String accountSid, String to, String from,String startTimeGte, Integer page,Integer pageSize) throws M360Exception {
		return returnThrows(callProxy.listCalls(accountSid, to, from,startTimeGte, page,pageSize));
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
	public Message360<CallMessages> listCalls(String to, String from,String startTimeGte, Integer page, Integer pageSize)throws M360Exception {
		return listCalls(conf.getSid(), to, from, startTimeGte,page, pageSize);
	}
	
	public Message360<CallMessages> listCalls()throws M360Exception {
		return listCalls(conf.getSid(), null, null, null,null, null);
	}
	
	public String  listJsonCalls(String to, String from,String dateCreated, Integer page, Integer pageSize)throws M360Exception {
		return callProxy.listCalls(conf.getSid(), to, from, dateCreated,page, pageSize).getEntity(String.class);
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
			String statusCallBackUrl,HttpMethod statusCallbackMethod,String fallBackUrl,HttpMethod fallBackUrlMethod,
			String heartBeatUrl,HttpMethod heartBeatMethod,Long timeout,String playDtmf,Boolean hideCallerId,
			Boolean record,Integer recordcallBackUrl,HttpMethod recordCallBackMethod,Boolean transcribe,String transcribeCallbackUrl,
			IfMachineStatus ifmachine)throws M360Exception {
		
		return returnThrows(callProxy.makeCall(accountsid,fromCountryCode,from,toCountryCode,to,url,method,
				statusCallBackUrl,statusCallbackMethod,fallBackUrl,fallBackUrlMethod,heartBeatUrl,heartBeatMethod,
				timeout,playDtmf,hideCallerId,record,recordcallBackUrl,recordCallBackMethod,transcribe,transcribeCallbackUrl,
				ifmachine));
	}
	
	
	
	public Message360<CallMessages> makeCall(Integer fromCountryCode,String from,
			Integer toCountryCode,String to,String url,HttpMethod method,
			String statusCallBackUrl,HttpMethod statusCallbackMethod,String fallBackUrl,HttpMethod fallBackUrlMethod,
			String heartBeatUrl,HttpMethod heartBeatMethod,Long timeout,String playDtmf,Boolean hideCallerId,
			Boolean record,Integer recordcallBackUrl,HttpMethod recordCallBackMethod,Boolean transcribe,String transcribeCallbackUrl,
			IfMachineStatus ifmachine) throws M360Exception {
		
		return makeCall(conf.getSid(), fromCountryCode,from,toCountryCode,to,url,method,
				statusCallBackUrl,statusCallbackMethod,fallBackUrl,fallBackUrlMethod,heartBeatUrl,heartBeatMethod,
				timeout,playDtmf,hideCallerId,record,recordcallBackUrl,recordCallBackMethod,transcribe,transcribeCallbackUrl,
				ifmachine);
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
		return makeCall(accountSid, cr.getFromCountryCode(),cr.getFrom(),cr.getToCountryCode(),cr.getTo(),cr.getUrl(),cr.getMethod(),cr.getStatusCallbackUrl(),
				cr.getStatusCallbackMethod(),cr.getFallbackUrl(),cr.getFallbackUrlMethod(),cr.getHeartbeatUrl(),cr.getHeartbeatMethod(),
				cr.getTimeout(),cr.getPlayDtmf(),cr.getHideCallerId(),cr.getRecord(),cr.getRecordCallbackUrl(),cr.getRecordCallbackMethod(),cr.getTranscribe(),
				cr.getTranscribeCallbackUrl(),cr.getIfMachine());
	}
	
	public String makeJsonCall(CallRequest cr) throws M360Exception {
		String accountSid = conf.getSid();
		if (cr.getAccountSid() != null)
			accountSid = cr.getAccountSid();
		return callProxy.makeCall(accountSid, cr.getFromCountryCode(),cr.getFrom(),cr.getToCountryCode(),cr.getTo(),cr.getUrl(),cr.getMethod(),cr.getStatusCallbackUrl(),
				cr.getStatusCallbackMethod(),cr.getFallbackUrl(),cr.getFallbackUrlMethod(),cr.getHeartbeatUrl(),cr.getHeartbeatMethod(),
				cr.getTimeout(),cr.getPlayDtmf(),cr.getHideCallerId(),cr.getRecord(),cr.getRecordCallbackUrl(),cr.getRecordCallbackMethod(),cr.getTranscribe(),
				cr.getTranscribeCallbackUrl(),cr.getIfMachine()).getEntity(String.class);
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
	
	public Message360<CallMessages> playAudios(String sid,String callsid,Boolean mix,Long length,Boolean loop,String audioUrl,Direction direction) throws M360Exception{
		ClientResponse<Message360<CallMessages>> playAudio =callProxy.playAudio(sid, callsid, mix, length, loop, audioUrl,direction);
	return returnThrows(playAudio);
	}
	
	public Message360<CallMessages> playAudios(String callsid,Boolean mix,Long length,Boolean loop,String autioUrl,Direction direction) throws M360Exception{
		return playAudios(conf.getSid(), callsid,mix,length,loop,autioUrl,direction);
	}
	
	public String playJsonAudios(String callsid,Boolean mix,Long length,Boolean loop,String autioUrl,Direction direction) throws M360Exception{
		return callProxy.playAudio(conf.getSid(), callsid,mix,length,loop,autioUrl,direction).getEntity(String.class);
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
		return voiceEffects(conf.getSid(),callSid, null, null, null, null, null, null);
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
	public Message360<NumberMessage> availableNumber(String sid,Integer areaCode,PhoneNumberType phoneNumberType,Integer pageSize) throws M360Exception{
		ClientResponse<Message360<NumberMessage>> availablePhoneNumber =phoneProxy.availableNumber(sid, areaCode, phoneNumberType,pageSize);
	return returnThrows(availablePhoneNumber);
	}
	
	public Message360<NumberMessage> availableNumber(Integer areaCode,PhoneNumberType phoneNumberType,Integer pageSize) throws M360Exception{
		return availableNumber(conf.getSid(), areaCode, phoneNumberType,pageSize);
	}
	
	public String availableJsonNumber(Integer areaCode,PhoneNumberType phoneNumberType,Integer pageSize) throws M360Exception{
		return phoneProxy.availableNumber(conf.getSid(), areaCode,phoneNumberType,pageSize).getEntity(String.class);
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
	
	
	public Message360<NumberMessage> listNumber(String sid,Integer page,Integer pageSize,String friendlyName, PhoneNumberType numberType) throws M360Exception{
		ClientResponse<Message360<NumberMessage>> listNumber =phoneProxy.listNumber(sid, page, pageSize, friendlyName,numberType);
	return returnThrows(listNumber);
	}
	
	public Message360<NumberMessage> listNumber(Integer page,Integer pageSize,String friendlyName, PhoneNumberType numberType) throws M360Exception{
		return listNumber(conf.getSid(), page, pageSize, friendlyName,numberType);
	}
	public Message360<NumberMessage> listNumber() throws M360Exception{
		return listNumber(conf.getSid(), null,null, null,PhoneNumberType.ALL);
	}
	
	public String listJsonNumber(Integer page,Integer pageSize,String friendlyName, PhoneNumberType numberType) throws M360Exception{
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
		ClientResponse<Message360<NumberMessage>> buyNumber =phoneProxy.releaseNumber(sid, releaseNumber);
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
	private Message360<RecordMessage> listRecording(String sid,Integer page,Integer pageSize,String callSid,String dateCreated) throws M360Exception{
		ClientResponse<Message360<RecordMessage>> listRecording = recordingProxy.listRecording(sid,page,pageSize,callSid,dateCreated);
		return  returnThrows(listRecording);
	}
	
	public Message360<RecordMessage> listRecording(Integer page,Integer pageSize,String callSid,String dateCreated) throws M360Exception{
		return listRecording(conf.getSid(),page,pageSize,callSid,dateCreated);
	}
	public Message360<RecordMessage> listRecording() throws M360Exception{
		return listRecording(conf.getSid(),null,null,null,null);
	}
	
	
	public String listJsonRecording(Integer page,Integer pageSize,String callSid,String dateCreated) throws M360Exception{
		return recordingProxy.listRecording(conf.getSid(),page,pageSize,callSid,dateCreated).getEntity(String.class);
	}
	public String listJsonRecording() throws M360Exception{
		return recordingProxy.listRecording(conf.getSid(),null,null,null,null).getEntity(String.class);
	}
	/*public String listJsonRecording(String callsid) throws M360Exception{
		return recordingProxy.listRecording(conf.getSid(),callsid).getEntity(String.class);
	}*/
	
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
	public Message360<TranscriptionMessage> listTranscription(String sid,Integer page,Integer pageSize,TranscriptionStatus status,String date) throws M360Exception{
		ClientResponse<Message360<TranscriptionMessage>> listTranscription =transcriptionProxy.listTranscription(sid,page,pageSize,status,date);
		return returnThrows(listTranscription);
	}
	
	public Message360<TranscriptionMessage> listTranscription(Integer page,Integer pageSize,TranscriptionStatus status,String date) throws M360Exception{
		return listTranscription(conf.getSid(),page,pageSize,status,date);
	}
	public Message360<TranscriptionMessage> listTranscription() throws M360Exception{
		return listTranscription(conf.getSid(),null,null,null,null);
	}
	
	public String listJsonTranscription(Integer page,Integer pageSize,TranscriptionStatus status,String date){
		return transcriptionProxy.listTranscription(conf.getSid(),page,pageSize,status,date).getEntity(String.class);
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
		return transcriptionProxy.recordingTranscription(conf.getSid(), recordingSid).getEntity(String.class);
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
	private Message360<Message360Email<SendEmail>> sendEmail(String sid,String to,String cc,String bcc,String subject,EmailSendAs type,String message,List<String> attachment) throws M360Exception{
		ClientResponse<Message360<Message360Email<SendEmail>>> email = emailProxy.sendEmail(sid, to,cc,bcc, subject,type, message,attachment);
		return returnThrows(email);
	}
	
	public Message360<Message360Email<SendEmail>> sendEmail(String to,String cc,String bcc,String subject,EmailSendAs type,String message,List<String> attachment) throws M360Exception{
		return sendEmail(conf.getSid(), to,cc,bcc, subject,type, message,attachment);
	}
	
	public String sendJsonEmail(String to,String cc,String bcc,String subject,EmailSendAs type,String message,List<String> attachment) throws M360Exception{
		return  emailProxy.sendEmail(conf.getSid(), to,cc,bcc, subject,type, message,attachment).getEntity(String.class);
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
	
	public Message360<Message360Email<Bounce>> listBounceEmail(String sid,Integer offset,Integer limit) throws M360Exception{
		ClientResponse<Message360<Message360Email<Bounce>>> listBouncEmail=emailProxy.listBouncesEmail(sid,offset,limit);
		return returnThrows(listBouncEmail);
	}
	public  Message360<Message360Email<Bounce>> listBounceEmail(Integer offset,Integer limit)throws M360Exception{
		return listBounceEmail(conf.getSid(),offset,limit);
	}
	
	public  String listJsonBounceEmail(Integer offset,Integer limit)throws M360Exception{
		return emailProxy.listBouncesEmail(conf.getSid(),offset,limit).getEntity(String.class);
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
	
	public Message360<Message360Email<Spam>> listSpamEmail(String sid,Integer offset,Integer limit) throws M360Exception{
		ClientResponse<Message360<Message360Email<Spam>>> listSpamEmail=emailProxy.listSpamEmail(sid,offset,limit);
		return returnThrows(listSpamEmail);
	}
	public Message360<Message360Email<Spam>> listSpamEmail(Integer offset,Integer limit)throws M360Exception{
		return listSpamEmail(conf.getSid(),offset,limit);
	}
	
	public String listJsonSpamEmail(Integer offset,Integer limit) throws M360Exception{
		return emailProxy.listSpamEmail(conf.getSid(),offset,limit).getEntity(String.class);
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
	public Message360<Message360Email<Invalid>> listInvalidEmail(String sid,Integer offset,Integer limit) throws M360Exception{
		ClientResponse< Message360<Message360Email<Invalid>>> listInValidEmail=emailProxy.listInvalidEmail(sid,offset,limit);
		return returnThrows(listInValidEmail);
	}
	public  Message360<Message360Email<Invalid>> listInvalidEmail(Integer offset,Integer limit)throws M360Exception{
		return listInvalidEmail(conf.getSid(),offset,limit);
	}
	
	public  String listJsonInvalidEmail(Integer offset,Integer limit)throws M360Exception{
		return emailProxy.listInvalidEmail(conf.getSid(),offset,limit).getEntity(String.class);
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
	
	public Message360<Message360Email<Unsubscribed>> listUnsubsribe(String sid,Integer offset,Integer limit)throws M360Exception{
		ClientResponse<Message360<Message360Email<Unsubscribed>>> listUnsubscribe=emailProxy.listUnsubscribeEmailAddress(sid,offset,limit);
		return returnThrows(listUnsubscribe);
	}
	
	public Message360<Message360Email<Unsubscribed>> listUnsubsribeEmaillAddress(Integer offset,Integer limit)throws M360Exception{
		return listUnsubsribe(conf.getSid(),offset,limit);
	}
	
	public String listJsonUnsubsribeEmaillAddress(Integer offset,Integer limit)throws M360Exception{
		return emailProxy.listUnsubscribeEmailAddress(conf.getSid(),offset,limit).getEntity(String.class);
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
	public Message360<ConferenceMessages> listConference(String sid, Integer page, Integer pageSize,String friendlyName,ConferenceStatus Status, Date dateCreated, Date dateUpdated)throws M360Exception{
		ClientResponse<Message360<ConferenceMessages>> viewConference=conferenceProxy.listConference(sid, page, pageSize, friendlyName, Status, dateCreated, dateUpdated);
		return returnThrows(viewConference);
	}
	
	public Message360<ConferenceMessages> listConference(Integer page, Integer pageSize,String friendlyName,ConferenceStatus Status, Date dateCreated, Date dateUpdated)throws M360Exception{
		return listConference(conf.getSid(), page, pageSize, friendlyName, Status, dateCreated, dateUpdated);
	}
	public Message360<ConferenceMessages> listConference()throws M360Exception{
		return listConference(conf.getSid(), null, null, null, null, null, null);
	}
	
	public String listJsonConference(Integer page, Integer pageSize,String friendlyName,ConferenceStatus Status, Date dateCreated, Date dateUpdated)throws M360Exception{
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
			@QueryParam("Page") Integer page,
			@QueryParam("PageSize") Integer pageSize,
			@QueryParam("Muted") Boolean muted,
			@QueryParam("deaf") Boolean deaf,
			@QueryParam("conferenceid") String conferenceid
			);
	 */
	
	public Message360<ConferenceMessages> listParticipant(String sid,Integer page,Integer pageSize,Boolean muted,Boolean deaf,String conferenceSid)throws M360Exception{
		ClientResponse<Message360<ConferenceMessages>> listParticipant=conferenceProxy.listParticipant(conf.getSid(), page,pageSize,muted,deaf,conferenceSid);
		return returnThrows(listParticipant);
	}
	
	public Message360<ConferenceMessages> listParticipant(Integer page,Integer pageSize,Boolean muted,Boolean deaf,String conferenceSid)throws M360Exception{
		return listParticipant(conf.getSid(), page,pageSize,muted,deaf,conferenceSid);
	}
	public Message360<ConferenceMessages> listParticipant(String conferenceSid)throws M360Exception{
		return listParticipant(conf.getSid(), null,null,null,null,conferenceSid);
	}
	
	public String listJsonParticipant(Integer page,Integer pageSize,Boolean muted,Boolean deaf,String conferenceSid)throws M360Exception{
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
	
	/**
	 * 
	 * @param sid
	 * @param page
	 * @param pageSize
	 * @return
	 * @throws M360Exception
	 */
	public Message360<CarrierMessage> carrierLookupList(String sid,Integer page,Integer pageSize)throws M360Exception{
		ClientResponse<Message360<CarrierMessage>> carrierLookup=carrierProxy.carrierLookupList(conf.getSid(), page,pageSize);
		return returnThrows(carrierLookup);
	}
	
	public Message360<CarrierMessage> carrierLookupList(Integer page,Integer pageSize)throws M360Exception{
		return carrierLookupList(conf.getSid(),page,pageSize);
	}
	public Message360<CarrierMessage> carrierLookupList()throws M360Exception{
		return carrierLookupList(conf.getSid(),null,null);
	}
	
	
	public String carrierJsonLookupList(Integer page,Integer pageSize)throws M360Exception{
		return carrierProxy.carrierLookupList(conf.getSid(), page,pageSize).getEntity(String.class);
	}
	
	public String carrierJsonLookupList()throws M360Exception{
		return carrierProxy.carrierLookupList(conf.getSid(), null,null).getEntity(String.class);
	}
	
	////////////////////////////////////
	/////////DIRECT MAIL SERVICE////////
	////////////////////////////////////
	
	/**
	 * 
	 * @param sid
	 * @param name
	 * @param email
	 * @param phone
	 * @param address
	 * @param state
	 * @param zip
	 * @param city
	 * @param country
	 * @return
	 * @throws M360Exception
	 */
	public  Message360<DMAddressBook> createAddressBook(String sid,String name,String email,String phone,String address,String state,String zip,String city,String country)throws M360Exception{
		ClientResponse<Message360<DMAddressBook>> createAddressBook = addressBookProxy.createAddressBook(sid, name, email, phone, address, state, zip, city, country);
		return returnThrows(createAddressBook);
	}
	
	public Message360<DMAddressBook> createAddressBook(String name,String email,String phone,String address,String state,String zip,String city,String country)throws M360Exception{
		return createAddressBook(conf.getSid(), name, email, phone, address, state, zip, city, country);
	}
	
	public String createJsonAddressBook(String name,String email,String phone,String address,String state,String zip,String city,String country)throws M360Exception{
		return addressBookProxy.createAddressBook(conf.getSid(), name, email, phone, address, state, zip, city, country).getEntity(String.class);
	}
	
	//view Address Book
	/**
	 * 
	 * @param sid
	 * @param addressid
	 * @return
	 * @throws M360Exception
	 */
	public  Message360<DMAddressBook> viewAddressBook(String sid,String addressid)throws M360Exception{
		ClientResponse<Message360<DMAddressBook>> viewAddressBook = addressBookProxy.viewAddressBook(sid, addressid);
		return returnThrows(viewAddressBook);
	}
	
	public Message360<DMAddressBook> viewAddressBook(String addressid)throws M360Exception{
		return viewAddressBook(conf.getSid(), addressid);
	}
	
	public String viewJsonAddressBook(String addressid)throws M360Exception{
		return addressBookProxy.viewAddressBook(conf.getSid(), addressid).getEntity(String.class);
	}
	
	///list  Address book
	/**
	 * 
	 * @param sid
	 * @param page
	 * @param pageSize
	 * @param addresseSid
	 * @param dateCreated
	 * @return
	 * @throws M360Exception
	 */
	public  Message360<DMAddressBook> listAddressBook(String sid,Integer page,Integer pageSize,String addresseSid,String dateCreated)throws M360Exception{
		ClientResponse<Message360<DMAddressBook>> listAddressBook = addressBookProxy.listAddressBook(sid, page,pageSize,addresseSid,dateCreated);
		return returnThrows(listAddressBook);
	}
	
	public Message360<DMAddressBook> listAddressBook(Integer page,Integer pageSize,String addresseSid,String dateCreated)throws M360Exception{
		return listAddressBook(conf.getSid(), page,pageSize,addresseSid,dateCreated);
	}
	public Message360<DMAddressBook> listAddressBook()throws M360Exception{
		return listAddressBook(conf.getSid(), null,null,null,null);
	}
	
	public String listJsonAddressBook(Integer page,Integer pageSize,String addresseSid,String dateCreated)throws M360Exception{
		return addressBookProxy.listAddressBook(conf.getSid(), page,pageSize,addresseSid,dateCreated).getEntity(String.class);
	}
	public String listJsonAddressBook()throws M360Exception{
		return addressBookProxy.listAddressBook(conf.getSid(), null,null,null,null).getEntity(String.class);
	}
	
	//verify address book
	/**
	 * 
	 * @param sid
	 * @param addresseSid
	 * @return
	 * @throws M360Exception
	 */
	public  Message360<DMAddressBook> verifyAddressBook(String sid,String addresseSid)throws M360Exception{
		ClientResponse<Message360<DMAddressBook>> verifyAddressBook = addressBookProxy.verifyAddressBook(sid,addresseSid);
		return returnThrows(verifyAddressBook);
	}
	
	public Message360<DMAddressBook> verifyAddressBook(String addresseSid)throws M360Exception{
		return verifyAddressBook(conf.getSid(), addresseSid);
	}
	
	public String verifyJsonAddressBook(String addresseSid)throws M360Exception{
		return addressBookProxy.verifyAddressBook(conf.getSid(),addresseSid).getEntity(String.class);
	}
	
	//delete address book
	
	/**
	 * 
	 * @param sid
	 * @param addresseSid
	 * @return
	 * @throws M360Exception
	 */
	public  Message360<DMAddressBook> deleteAddressBook(String sid,String addresseSid)throws M360Exception{
		ClientResponse<Message360<DMAddressBook>> deleteAddressBook = addressBookProxy.deleteAddressBook(sid,addresseSid);
		return returnThrows(deleteAddressBook);
	}
	
	public Message360<DMAddressBook> deleteAddressBook(String addresseSid)throws M360Exception{
		return deleteAddressBook(conf.getSid(), addresseSid);
	}
	
	public String deleteJsonAddressBook(String addresseSid)throws M360Exception{
		return addressBookProxy.deleteAddressBook(conf.getSid(),addresseSid).getEntity(String.class);
	}
	
	///Post Card
	//create Post Card
	/**
	 * 
	 * @param sid
	 * @param to
	 * @param from
	 * @param attachbyid
	 * @param front
	 * @param back
	 * @param message
	 * @param setting
	 * @param description
	 * @param htmldata
	 * @return
	 * @throws M360Exception
	 */
	public Message360<DMPostCard> createPostCard(String sid,String to,String from,String attachbyid,String front,String back,String message,String setting,String description,String htmldata)throws M360Exception{
		//System.out.println(postCardProxy.createPostCard(sid,to, from, attachbyid, front, back, message, setting, description, htmldata).getEntity(String.class));
		ClientResponse<Message360<DMPostCard>> createPostCard =  postCardProxy.createPostCard(sid,to, from, attachbyid, front, back, message, setting, description, htmldata);
		//createPostCard.created("");
		//System.out.println("Attributes: "+createPostCard.getAttributes()+","+createPostCard.get);;
		return returnThrows(createPostCard);
	}
	public Message360<DMPostCard> createPostCard(String to,String from,String attachbyid,String front,String back,String message,String setting,String description,String htmldata)throws M360Exception{
		return createPostCard(conf.getSid(),to, from, attachbyid, front, back, message, setting, description, htmldata);
	}
	
	public String createJsonPostCard(String to,String from,String attachbyid,String front,String back,String message,String setting,String description,String htmldata)throws M360Exception{
		return postCardProxy.createPostCard(conf.getSid(), to, from, attachbyid, front, back, message, setting, description, htmldata).getEntity(String.class);
	}
	
	//view Post Card
	/**
	 * 
	 * @param sid
	 * @param postcardid
	 * @return
	 * @throws M360Exception
	 */
	public Message360<DMPostCard> viewPostCard(String sid,String postcardid)throws M360Exception{
		ClientResponse<Message360<DMPostCard>> viewPostCard =  postCardProxy.viewPostCard(sid,postcardid);
		return returnThrows(viewPostCard);
	}
	public Message360<DMPostCard> viewPostCard(String postcardid)throws M360Exception{
		return viewPostCard(conf.getSid(),postcardid);
	}
	
	public String viewJsonPostCard(String postcardid)throws M360Exception{
		return postCardProxy.viewPostCard(conf.getSid(),postcardid).getEntity(String.class);
	}
	
	///list Post Card
	/**
	 * 
	 * @param sid
	 * @param page
	 * @param pageSize
	 * @param postcardid
	 * @param dateCreated
	 * @return
	 * @throws M360Exception
	 */
	public Message360<DMPostCard> listPostCard(String sid,Integer page,Integer pageSize,String postcardid,String dateCreated)throws M360Exception{
		ClientResponse<Message360<DMPostCard>> listPostCard =  postCardProxy.listPostCard(sid,page,pageSize,postcardid,dateCreated);
		return returnThrows(listPostCard);
	}
	public Message360<DMPostCard> listPostCard(Integer page,Integer pageSize,String postcardid,String dateCreated)throws M360Exception{
		return listPostCard(conf.getSid(),page,pageSize,postcardid,dateCreated);
	}
	public Message360<DMPostCard> listPostCard()throws M360Exception{
		return listPostCard(conf.getSid(),null,null,null,null);
	}
	
	
	public String listJsonPostCard(Integer page,Integer pageSize,String postcardid,String dateCreated)throws M360Exception{
		return postCardProxy.listPostCard(conf.getSid(),page,pageSize,postcardid,dateCreated).getEntity(String.class);
	}
	public String listJsonPostCard()throws M360Exception{
		return postCardProxy.listPostCard(conf.getSid(),null,null,null,null).getEntity(String.class);
	}
	
	//delete Post Card
	/**
	 * 
	 * @param sid
	 * @param postcardid
	 * @return
	 * @throws M360Exception
	 */
	public Message360<DMPostCard> deletePostCard(String sid,String postcardid)throws M360Exception{
		ClientResponse<Message360<DMPostCard>> deletePostCard =  postCardProxy.deletePostCard(sid,postcardid);
		return returnThrows(deletePostCard);
	}
	
	public Message360<DMPostCard> deletePostCard(String postcardid)throws M360Exception{
		return deletePostCard(conf.getSid(),postcardid);
	}
	
	/**
	 * @param postcardid
	 * @return
	 * @throws M360Exception
	 */
	public String deleteJsonPostCard(String postcardid)throws M360Exception{
		return postCardProxy.deletePostCard(conf.getSid(),postcardid).getEntity(String.class);
	}
	
	
	///////////////
	////Letters
	//////////////
	
	/////Create Letter
	/**${
	 * 
	 * @param accountSid
	 * @param to
	 * @param from
	 * @param attachbyid
	 * @param file
	 * @param color
	 * @param extraservice
	 * @param doublesided
	 * @param description
	 * @param template
	 * @param htmldata
	 * @return
	 * @throws M360Exception
	 */
	public Message360<DMLetter> createLetters(String accountSid, String to, String from, String attachbyid, String  file, Boolean color, ExtraService extraservice, Boolean doublesided, String description, Boolean template, String htmldata)throws M360Exception{
		ClientResponse<Message360<DMLetter>> createPostCard =  letterProxy.createLetter(accountSid, to, from, attachbyid, file, color, extraservice, doublesided, description, template, htmldata);
		return returnThrows(createPostCard);
	}
	
	public Message360<DMLetter> createLetters( String to, String from, String attachbyid, String  file, Boolean color, ExtraService extraservice, Boolean doublesided, String description, Boolean template, String htmldata)throws M360Exception{
		return createLetters(conf.getSid(), to, from, attachbyid, file, color, extraservice, doublesided, description, template, htmldata);
	}
	
	public String createJsonLetters( String to, String from, String attachbyid, String  file, Boolean color, ExtraService extraservice, Boolean doublesided, String description, Boolean template, String htmldata)throws M360Exception{
		return letterProxy.createLetter(conf.getSid(), to, from, attachbyid, file, color, extraservice, doublesided, description, template, htmldata).getEntity(String.class);
	}

	//view Letter
	/**
	 * 
	 * @param accountSid
	 * @param letterid
	 * @return
	 * @throws M360Exception
	 */
	public Message360<DMLetter> viewLetters(String accountSid, String letterid)throws M360Exception{
		ClientResponse<Message360<DMLetter>> viewPostCard =  letterProxy.viewLetter(accountSid, letterid);
		return returnThrows(viewPostCard);
	}
	
	public Message360<DMLetter> viewLetters( String letterid)throws M360Exception{
		return viewLetters(conf.getSid(), letterid);
	}
	
	public String viewJsonLetters(String letterid)throws M360Exception{
		return letterProxy.viewLetter(conf.getSid(), letterid).getEntity(String.class);
	}
	
	////List Letter
	
	/**
	 * 
	 * @param accountSid
	 * @param page
	 * @param pageSize
	 * @param letterid
	 * @param dateCreated
	 * @return
	 * @throws M360Exception
	 */
	public Message360<DMLetter> listLetters(String accountSid, Integer page,Integer pageSize,String letterid,String dateCreated)throws M360Exception{
		ClientResponse<Message360<DMLetter>> listPostCard =  letterProxy.listLetter(accountSid, page,pageSize,letterid,dateCreated);
		return returnThrows(listPostCard);
	}
	
	public Message360<DMLetter> listLetters()throws M360Exception{
		return  listLetters(conf.getSid(), null,null,null,null);
	}
	
	public Message360<DMLetter> listLetters(Integer page,Integer pageSize,String letterid,String dateCreated)throws M360Exception{
		return  listLetters(conf.getSid(), page,pageSize,letterid,dateCreated);
	}
	
	public String  listJsonLetters(Integer page,Integer pageSize,String letterid,String dateCreated)throws M360Exception{
		return   letterProxy.listLetter(conf.getSid(), page,pageSize,letterid,dateCreated).getEntity(String.class);
	}
	public String  listJsonLetters()throws M360Exception{
		return   letterProxy.listLetter(conf.getSid(), null,null,null,null).getEntity(String.class);
	}
	
	//Delete letter
	
	/**
	 * 
	 * @param accountSid
	 * @param letterid
	 * @return
	 * @throws M360Exception
	 */
	public Message360<DMLetter> deleteLetters(String accountSid, String letterid)throws M360Exception{
		ClientResponse<Message360<DMLetter>> deletePostCard =  letterProxy.deleteLetter(accountSid, letterid);
		return returnThrows(deletePostCard);
	}
	
	public Message360<DMLetter> deleteLetters( String letterid)throws M360Exception{
		return deleteLetters(conf.getSid(), letterid);
	}
	
	public String deleteJsonLetters(String letterid)throws M360Exception{
		return letterProxy.deleteLetter(conf.getSid(), letterid).getEntity(String.class);
	}
	
	///////////////////
	////////AREA MAIL
	/////////////////
	
	//CREATE AREAMAIL
	/**
	 * 
	 * @param accountSid
	 * @param attachbyid
	 * @param front
	 * @param back
	 * @param description
	 * @param routes
	 * @param targettype
	 * @param htmldata
	 * @return
	 * @throws M360Exception
	 */
	
	
	public Message360<DMAreaMail> createAreaMail(String accountSid,String attachbyid, String front, String back, String description, String routes, TargetType targettype, String htmldata)throws M360Exception{
		ClientResponse<Message360<DMAreaMail>> createAreaMail =  areaMailProxy.createAreaMail(accountSid, attachbyid, front, back, description, routes, targettype, htmldata);
		return returnThrows(createAreaMail);
	}
	
	public Message360<DMAreaMail> createAreaMail( String attachbyid, String front, String back, String description, String routes, TargetType targettype, String htmldata)throws M360Exception{
		return createAreaMail(conf.getSid(), attachbyid, front, back, description, routes, targettype, htmldata );
	}
	
	public String createJsonAreaMail(String attachbyid, String front, String back, String description, String routes, TargetType targettype, String htmldata)throws M360Exception{
		return areaMailProxy.createAreaMail(conf.getSid(), attachbyid, front, back, description, routes, targettype, htmldata).getEntity(String.class);
	}
	
	//View Area Mail
	/**{@author xoyal}
	 * 
	 * @param accountSid
	 * @param areamailid
	 * @return
	 * @throws M360Exception
	 */
	public Message360<DMAreaMail> viewAreaMail(String accountSid,String areamailid)throws M360Exception{
		ClientResponse<Message360<DMAreaMail>> viewAreaMail =  areaMailProxy.viewAreaMail(accountSid, areamailid);
		return returnThrows(viewAreaMail);
	}
	
	public Message360<DMAreaMail> viewAreaMail(String areamailid)throws M360Exception{
		return viewAreaMail(conf.getSid(),areamailid);
	}
	
	public String viewJsonAreaMail(String areamailid)throws M360Exception{
		return areaMailProxy.viewAreaMail(conf.getSid(), areamailid).getEntity(String.class);
	}
	
	//list Area Mail
	/**
	 * 
	 * @param accountSid []
	 * @param page
	 * @param pageSize
	 * @param areamailid
	 * @param dateCreated
	 * @return
	 * @throws M360Exception
	 */
	public Message360<DMAreaMail> listAreaMail(String accountSid,Integer page,Integer pageSize,String areamailid,String dateCreated)throws M360Exception{
		ClientResponse<Message360<DMAreaMail>> listAreaMail =  areaMailProxy.listAreaMail(accountSid, page,pageSize,areamailid,dateCreated);
		return returnThrows(listAreaMail);
	}
	
	public Message360<DMAreaMail> listAreaMail(Integer page,Integer pageSize,String areamailid,String dateCreated)throws M360Exception{
		return listAreaMail(conf.getSid(), page,pageSize,areamailid,dateCreated);
	}
	
	public String listJsonAreaMail(Integer page,Integer pageSize,String areamailid,String dateCreated)throws M360Exception{
		return areaMailProxy.listAreaMail(conf.getSid(),  page,pageSize,areamailid,dateCreated).getEntity(String.class);
	}
	
	public Message360<DMAreaMail> listAreaMail()throws M360Exception{
		return listAreaMail(conf.getSid(),  null,null,null,null);
	}
	
	public String listJsonAreaMail()throws M360Exception{
		return areaMailProxy.listAreaMail(conf.getSid(),  null,null,null,null).getEntity(String.class);
	}
	
	//Delete Area Mail
	/**
	 * 
	 * @param accountSid [account sid for testing]
	 * @param areamailid [Area email id]
	 * @return
	 * @throws M360Exception
	 */
	public Message360<DMAreaMail> deleteAreaMail(String accountSid,String areamailid)throws M360Exception{
		ClientResponse<Message360<DMAreaMail>> deleteAreaMail =  areaMailProxy.deleteAreaMail(accountSid, areamailid);
		return returnThrows(deleteAreaMail);
	}
	
	public Message360<DMAreaMail> deleteAreaMail(String areamailid)throws M360Exception{
		return deleteAreaMail(conf.getSid(),areamailid);
	}
	
	public String deleteJsonAreaMail(String areamailid)throws M360Exception{
		return areaMailProxy.deleteAreaMail(conf.getSid(), areamailid).getEntity(String.class);
	}
	
	
}
