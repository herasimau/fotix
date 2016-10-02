package com.fotix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;



@SpringBootApplication
@EnableCaching
public class FotixCommonTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(FotixCommonTestApplication.class, args);
    }

}
