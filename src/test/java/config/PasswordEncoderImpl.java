//package com.hmaitech.onlineshop.security.config;
//
//import org.springframework.security.crypto.bcrypt.BCrypt;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//
//@Service
//public class PasswordEncoderImpl implements PasswordEncoder {
//    @Override
//    public String encode(CharSequence rawPassword) {
//        return BCrypt.hashpw(rawPassword.toString(), BCrypt.gensalt(12));
//    }
//
//    @Override
//    public boolean matches(CharSequence rawPassword, String encodedPassword) {
//        return BCrypt.checkpw(rawPassword.toString(), encodedPassword);
//    }
//}
