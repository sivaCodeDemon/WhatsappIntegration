package com.dev;

import com.twilio.Twilio;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
//@Slf4j
public class TwiloInitializer {
    private final TwilioConfiguration twilioConfiguration;

    private final static Logger LOGGER = LoggerFactory.getLogger(TwiloInitializer.class);

    @Autowired
    public TwiloInitializer(TwilioConfiguration twilioConfiguration) {
    	LOGGER.info("START WhatsAppMessage{}  :TwiloInitializer.class");

        this.twilioConfiguration = twilioConfiguration;
        Twilio.init(
                twilioConfiguration.getAccountSid(),
                twilioConfiguration.getAuthToken()
        );
    	LOGGER.info("END WhatsAppMessage{}  :TwiloInitializer.class");

        LOGGER.info("Twilio initialised with accoutn sid {}", twilioConfiguration.getAccountSid());
    }
}
