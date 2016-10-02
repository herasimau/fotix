package com.fotix.api.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * Created by herasimau on 02/10/16.
 */

@Service
public class EmailSenderService  {

    private String defaultFrom = "herasimau.leanid@gmail.com";
    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    public EmailSenderService(JavaMailSender javaMailSender){
        this.javaMailSender = javaMailSender;
    }
    @Async
    public void sendMail(String to, SimpleMailMessage simpleMailMessage){
        if(to == null) {
            return;
        }

        simpleMailMessage.setFrom(defaultFrom);
        simpleMailMessage.setTo(to);
        System.out.println(simpleMailMessage.getText());

        try {

            javaMailSender.send(simpleMailMessage);
            return ;
        } catch (MailException e) {
            e.printStackTrace();
            return ;
        }
    }


}