package com.hmaitech.onlineshop.controller;


import com.hmaitech.onlineshop.exceptions.PasswordNotMatchException;
import com.hmaitech.onlineshop.model.dto.UsersDto;
import com.hmaitech.onlineshop.model.mapper.UserMapper;
import com.hmaitech.onlineshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Objects;

@RestController
@RequestMapping("/user")
public class UserController {


    @Autowired
    private UserMapper mapper;


    @Autowired
    private UserService service;

    @PostMapping("/reg")
    @Transactional
    public UsersDto save(@RequestBody UsersDto d)  throws PasswordNotMatchException {

        if (Objects.equals(d.getPassword1(), d.getPassword2())) {


            service.save(mapper.dtoToEntity(d));
            return d;
        }
        throw new PasswordNotMatchException("pass-not-match-class");
    }
}
