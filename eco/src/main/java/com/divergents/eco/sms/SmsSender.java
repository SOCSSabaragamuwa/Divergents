package com.divergents.eco.sms;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.stereotype.Service;

@Service
public class SmsSender {
    // Find your Account Sid and Auth Token at twilio.com/console
    public static final String ACCOUNT_SID =
            "AC5f672b232182db9cf3bc08db78866fe5";
    public static final String AUTH_TOKEN =
            "0c5c9a4b29bd1ccc63e875199a9da3e6";

    public void sendSms(String sendNo,String meg) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        Message message = Message
                .creator(new PhoneNumber(sendNo), // to
                        new PhoneNumber("+12029028058"), // from
                        meg)
                .create();

        System.out.println(message.getSid());
    }
}
