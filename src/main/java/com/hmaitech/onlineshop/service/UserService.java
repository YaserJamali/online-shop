package com.hmaitech.onlineshop.service;

import com.hmaitech.onlineshop.exceptions.UserNameOrPasswordWrongException;
import com.hmaitech.onlineshop.model.dto.UsersDto;
import com.hmaitech.onlineshop.model.entity.User;
import com.hmaitech.onlineshop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService extends BaseAbstractService<User, UserRepository> {


    @Autowired
    PasswordEncoder encoder;

    public User login( UsersDto dto)  {
        User user = repository.findByEmail(dto.getEmail());
        if (user != null) {
            if (encoder.matches(dto.getPassword1(), user.getPassword1())) {
                return user;
            }
        }return null;
    }


}
