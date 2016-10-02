package com.fotix.api.email;

import org.springframework.mail.SimpleMailMessage;

/**
 * Created by herasimau on 02/10/16.
 */
public class RegistrationMessage extends SimpleMailMessage {
    public RegistrationMessage(String token){
        super.setSubject("Registration");
        super.setText("Please visit this link to confirm email: http://localhost:8082/"+token);

    }

}
