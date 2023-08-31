//package com.hmaitech.onlineshop.security.controller;
//
//import com.hmaitech.onlineshop.security.config.JwtTokenManger;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//@CrossOrigin
//@RestController
//public class JWTAuthenticationController {
//    @Autowired
//    private AuthenticationManager authenticate;
//
//    @Autowired
//    private JwtTokenManger jwtTokenManger;
//
//    @Autowired
//    private JwtTokenUtils jwtTokenUtils;
//
//    @Autowired
//    private UserDetailsService userDetailsService;
//
//    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest){
//
//        authenticate(authenticationRequest.getUserName(),authenticationRequest.getPassword())
//
//
//
//    }
//
//
//}
