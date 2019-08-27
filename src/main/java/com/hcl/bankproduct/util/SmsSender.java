package com.hcl.bankproduct.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

/**
 * 
 * @author DeepikaSivarajan
 *
 */
@Component
public class SmsSender {
	private static Logger logger = LoggerFactory.getLogger(SmsSender.class);
	// Find your Account Sid and Auth Token at twilio.com/console
	public static final String ACCOUNT_SID = "AC50dbb981f0acb261c192b204b3e3a4fa";
	public static final String AUTH_TOKEN = "c89b4c138e226b10da12d8e957136356";
	String returnString = "SMS success";

	public String sendSms(String mobileNumber) {
		try {
			Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
			Message message = Message.creator(new PhoneNumber("+91" + mobileNumber), // to
					new PhoneNumber("+13343262449"), // from
					"Product Ordered Successfully").create();
			logger.info(message.getAccountSid());
		} catch (Exception e) {
			returnString = "SMS failed";
			logger.error(e.getMessage());
		}
		return returnString;

	}
}
