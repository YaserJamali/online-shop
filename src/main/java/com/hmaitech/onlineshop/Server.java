package com.hmaitech.onlineshop;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.transaction.annotation.EnableTransactionManagement;



@SpringBootApplication
@EnableJpaRepositories
@EnableTransactionManagement
@EnableJpaAuditing
//@EnableWebSecurity
//@SupportedValidationTarget(ValidationTarget.ANNOTATED_ELEMENT)
public class Server {

     public static void main(String[] args) {


        SpringApplication.run(Server.class, args);
    }

}
