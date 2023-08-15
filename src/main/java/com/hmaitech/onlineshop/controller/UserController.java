package com.hmaitech.onlineshop.controller;


import com.hmaitech.onlineshop.model.dto.UserDto;
import com.hmaitech.onlineshop.model.entity.UserEntity;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@Validated
public class UserController extends BaseAbstractController<UserEntity, UserDto> {

}
