package com.fotix.api.service;

import com.fotix.api.email.RegistrationMessage;
import com.fotix.api.entities.user.User;
import com.fotix.api.entities.verification.VerificationToken;
import com.fotix.api.repository.VerificationTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.Future;

/**
 * Created by herasimau on 02/10/16.
 */
@Service
public class VerificationTokenService {

    @Autowired
    private VerificationTokenRepository verificationTokenRepository;

    @Autowired
    private EmailSenderService emailSenderService;

    @Autowired
    private UserRegistrationService userRegistrationService;

    @Async
    public Future<VerificationToken> saveAndNotifyUser(User user){
        VerificationToken token = new VerificationToken(generateVerificationToken(),user);
        emailSenderService.sendMail(user.getEmail(), new RegistrationMessage(token.getToken()));
        verificationTokenRepository.save(token);
        return new AsyncResult<>(token);
    }




    @Async
    public Future<Boolean> confirmUserByToken(String token){
        Optional<VerificationToken> verificationToken = verificationTokenRepository.findByToken(token);
        if(tokenIsValid(verificationToken)){
            userRegistrationService.confirmUser(verificationToken);
            return new AsyncResult<>(Boolean.TRUE);
        }
        return new AsyncResult<>(Boolean.FALSE);
    }


    public boolean tokenIsValid(Optional<VerificationToken> token){

      return token.isPresent()?token.get().getExpiryDate().isAfter(LocalDateTime.now()):false;
    }


    public String generateVerificationToken(){
        return UUID.randomUUID().toString();
    }

}
