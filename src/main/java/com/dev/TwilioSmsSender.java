package com.dev;

import com.dev.model.SmsRequest;
import com.dev.model.smsSender;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.api.v2010.account.MessageCreator;
import com.twilio.rest.api.v2010.account.MessageReader;
import com.twilio.type.PhoneNumber;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;


@Service
public class TwilioSmsSender implements smsSender {
    private final TwilioConfiguration twilioConfiguration;

    private final static Logger LOGGER = LoggerFactory.getLogger(TwilioSmsSender.class);

    public TwilioSmsSender(TwilioConfiguration twilioConfiguration) {
        this.twilioConfiguration = twilioConfiguration;
    }

    @Override
    public void sendSms(SmsRequest smsRequest) {
    	LOGGER.info("START WhatsAppMessage{}");
        if (isPhoneVaild(smsRequest.getPhoneNumber())) {
            PhoneNumber to = new PhoneNumber("whatsapp:"+smsRequest.getPhoneNumber());
            PhoneNumber from = new PhoneNumber("whatsapp:14155238886");
//            PhoneNumber from = new PhoneNumber(smsRequest.getPhoneNumber());

            String message = smsRequest.getMessage();
            MessageCreator creator = Message.creator(
                    to,
                    from,
                    message
            );

            creator.create();
            LOGGER.info("END WhatsAppMessage{}" + smsRequest);
        } else {
            LOGGER.info("invalid phone number {}");
            throw new IllegalArgumentException("Phone number [" + smsRequest.getPhoneNumber() + "] is not valid");
        }

    }

    private boolean isPhoneVaild(String phoneNumber) {
        //use google phone number validator
        return true;
    }
    
//    private void recivedSMS(String mobileNumber,String messages) {
//		// TODO Auto-generated method stub
//    	
//    	 if (isPhoneVaild(mobileNumber)) {
//             PhoneNumber from = new PhoneNumber("whatsapp:"+mobileNumber);
//             PhoneNumber  to= new PhoneNumber("whatsapp:14155238886");
//
//             MessageReader creator = Message.reader(
//            		 messages);
//            		 
//             creator.read();
//
//	   }
//    }
    
}
