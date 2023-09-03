package com.hmaitech.onlineshop.controller;


import com.hmaitech.onlineshop.exceptions.PasswordNotMatchException;
import com.hmaitech.onlineshop.exceptions.UserNameOrPasswordWrongException;
import com.hmaitech.onlineshop.model.dto.UsersDto;
import com.hmaitech.onlineshop.model.entity.User;
import com.hmaitech.onlineshop.model.mapper.UserMapper;
import com.hmaitech.onlineshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private PasswordEncoder encoder;


    @Autowired
    private UserMapper mapper;


    @Autowired
    private UserService service;

    @PostMapping("/reg")
    @Transactional
    public UsersDto save(@RequestBody UsersDto dto) throws PasswordNotMatchException {

        if (Objects.equals(dto.getPassword1(), dto.getPassword2())) {

            dto.setPassword1(encoder.encode(dto.getPassword1()));

            service.save(mapper.dtoToEntity(dto));
            return dto;
        }
        throw new PasswordNotMatchException("pass-not-match-class");
    }



    @PostMapping("/login")
    public UsersDto login(@RequestBody UsersDto dto) throws UserNameOrPasswordWrongException {
        User user = service.login(dto);
        if (user != null) {
            return mapper.dtoToEntity(user);
        } else throw new UserNameOrPasswordWrongException("credential-exception");

    }

}


