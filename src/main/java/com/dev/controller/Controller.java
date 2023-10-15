package com.dev.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dev.model.SmsRequest;
import com.dev.service.WhatsAppService;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.api.v2010.account.MessageReader;
import com.twilio.type.PhoneNumber;

import java.util.ArrayList;

import javax.validation.Valid;

@RestController
@RequestMapping("api/sms")
public class Controller {
    @Autowired
    private final WhatsAppService service;

    public Controller(WhatsAppService service) {
        this.service = service;
    }

    
    @PostMapping(path = "/send")
    public void sendSms(@Valid @RequestBody SmsRequest smsRequest) {
        service.sendSms(smsRequest);
    }
    
//    
//    @GetMapping("/getMessages")
//    public void getMessages(@PathVariable  String mobileNumber,String[] messages) {
//    	
//    }
    
    
//    @Value("${twilio.account_sid}")
//    private String ACCOUNT_SID;
//    
//    @Value("${twilio.auth_token}")
//    private String AUTH_TOKEN;
//    
//    @GetMapping("/getMessages/{mobileNumber}")
//    public ResponseEntity<ArrayList<String>> getMessages(@PathVariable  String mobileNumber,ArrayList<String> messages) {
//    // Initialize Twilio with your account credentials
//    Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
//    // Create a filter to get messages from a specific number
//    MessageReader messageReader = Message.reader().setFrom(new PhoneNumber(mobileNumber));
//    // Iterate over the messages and add them to the array
//    for (Message message : messageReader.read()) {
//    messages.add(message.getBody());
//    System.out.println("This is my messages"+message);
//    }
//    return new ResponseEntity<ArrayList<String>>(messages,HttpStatus.OK);
//    }
 
}
