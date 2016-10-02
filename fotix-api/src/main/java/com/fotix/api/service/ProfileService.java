package com.fotix.api.service;

import com.fotix.api.entities.user.User;
import com.fotix.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by herasimau on 02/10/16.
 */
@Service
public class ProfileService {

    @Autowired
    private UserRepository userRepository;


}
