package com.hmaitech.onlineshop.controller;


import com.hmaitech.onlineshop.model.dto.UsersDto;
import com.hmaitech.onlineshop.model.entity.User;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@Validated
public class UserController extends BaseAbstractController<User, UsersDto> {


}
