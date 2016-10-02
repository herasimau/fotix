package com.fotix.api.controllers;

import com.fotix.api.dto.UserDTO;
import com.fotix.api.entities.user.User;
import com.fotix.api.service.UserRegistrationService;
import com.fotix.api.service.VerificationTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;


/**
 * Created by herasimau on 25/09/16.
 */

@Transactional
@RestController
public class RegistrationController {


    @Autowired
    private UserRegistrationService userRegistrationService;


    @Autowired
    private VerificationTokenService verificationTokenService;


    @RequestMapping(value = "/register", method = RequestMethod.POST,consumes = "application/json")
    public ResponseEntity<?> registerUser(@RequestBody UserDTO user){

        if(userRegistrationService.canRegister(user)){
            User newUser = userRegistrationService.createAndSaveUser(user);
            verificationTokenService.saveAndNotifyUser(newUser);
            return new ResponseEntity<>(user,HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.CONFLICT);
    }


    @RequestMapping(value = "/confirm/{token}", method = RequestMethod.GET)
    public ResponseEntity confirmRegistration(@PathVariable String token) throws InterruptedException,ExecutionException{

            if(verificationTokenService.confirmUserByToken(token).get()){

                return ResponseEntity.ok("Email confirmed");
            }


        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid token");

    }


}
