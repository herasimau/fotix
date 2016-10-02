package com.fotix.api.controllers;


import com.fotix.dto.commons.ValueObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;



@RestController
@RequestMapping("/")
public class TestRestController {

    @RequestMapping("/title")
    public ValueObject getTitle(Principal user) {
        return new ValueObject("API SERVER IS ALIVE" + (user == null ? "" : " " + user.getName()));
    }

    @RequestMapping("/user")
    public Principal user(Principal user) {
        return user;
    }

}
