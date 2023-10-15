package com.dev.service;

import org.springframework.stereotype.Service;

import com.dev.TwilioSmsSender;
import com.dev.model.SmsRequest;


@Service
public class WhatsAppService {
    private TwilioSmsSender twilioSmsSender;

    public WhatsAppService( TwilioSmsSender twilioSmsSender) {
        this.twilioSmsSender = twilioSmsSender;
    }

    public void sendSms(SmsRequest smsRequest){
        twilioSmsSender.sendSms(smsRequest);
    }
    
    
//    public void getMessages(String mobileNumber,String[] messages) {
//    	
//    }
}
