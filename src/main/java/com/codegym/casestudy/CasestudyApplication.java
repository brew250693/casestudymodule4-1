package com.codegym.casestudy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication


public class CasestudyApplication {



    public static void main(String[] args) {
        SpringApplication.run(CasestudyApplication.class, args);
    }

}
