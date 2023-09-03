package com.hmaitech.onlineshop.service;

import com.hmaitech.onlineshop.exceptions.UserNameOrPasswordWrongException;
import com.hmaitech.onlineshop.model.dto.UsersDto;
import com.hmaitech.onlineshop.model.entity.User;
import com.hmaitech.onlineshop.repository.UserRepository;
import com.hmaitech.onlineshop.utils.Login;
import org.apache.kafka.common.protocol.types.Field;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService extends BaseAbstractService<User, UserRepository> {


    @Autowired
    PasswordEncoder encoder;

    private final String accessTokenSecret;
    private final String refreshTokenSecret;

    public UserService(@Value("${application.security.access-token-secret}") String accessTokenSecret
            ,@Value("${application.security.refresh-token-secret}")  String refreshTokenSecret) {
        this.accessTokenSecret = accessTokenSecret;
        this.refreshTokenSecret = refreshTokenSecret;
    }

    public User login(UsersDto dto)  {
        User user = repository.findByEmail(dto.getEmail()).orElse(null);
        if (user != null) {
            if (encoder.matches(dto.getPassword1(), user.getPassword1())) {
                return user;
            }
        }return null;
    }

    public Login login(String email, String password){

        User user = repository.findByEmail(email).orElse(null);
        if (user != null) {
            if (encoder.matches(password, user.getPassword1())) {
                return Login.getInstance(user.getId(), accessTokenSecret,refreshTokenSecret);
            }
        }return null;
    }


}
