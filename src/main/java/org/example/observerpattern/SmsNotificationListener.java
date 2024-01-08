package org.example.observerpattern;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class SmsNotificationListener implements  EventListener{
    public static final String ACCOUNT_SID = "AC706ab152c39a2253b8d99cbbd118c0e4";
    public static final String AUTH_TOKEN = "33c8e63d6b32cafbd39d202262b0df21";




    @Override
    public void update(String eventType, String outgoingMessage, String phoneNumber) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(
                        new PhoneNumber(phoneNumber),
                        new PhoneNumber("+12017629498"),
                        outgoingMessage)
                .create();

        System.out.println(message.getSid());
    }
}
