package com.hmaitech.onlineshop.controller;

import com.hmaitech.onlineshop.model.dto.UsersDto;
import com.hmaitech.onlineshop.model.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")

public class TestController extends BaseAbstractController<User,UsersDto>{

    @GetMapping
    public String test(){
        return "Hello";
    }

}
