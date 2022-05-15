/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



package API;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

/**
 *
 * @author NMEDIA
 */
public class sendSMS {
public static final String ACCOUNT_SID = System.getenv("ACcf267b8b6bb4db310ee6329f12e00a71");
    public static final String AUTH_TOKEN = System.getenv("46ad341998deef8651c1130e176800c2");
   

    public static void sendSMS() {
        Twilio.init("ACcf267b8b6bb4db310ee6329f12e00a71", "46ad341998deef8651c1130e176800c2");
        Message message = Message.creator(new PhoneNumber("+21651311763"),
                new PhoneNumber("+19706846625"),"votre reclamations a eté prise en considération mercci!!").create();
        System.out.println(message.getSid());
       
    }

}
