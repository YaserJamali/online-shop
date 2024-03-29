package com.hmaitech.onlineshop.model.mapper;

import com.hmaitech.onlineshop.model.dto.UsersDto;
import com.hmaitech.onlineshop.model.entity.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserMapper {


    @Autowired
    private User entity;


    @Autowired
    private UsersDto dto;

    public User dtoToEntity(UsersDto dto) {
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }

    public UsersDto dtoToEntity(User entity) {
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }


}
