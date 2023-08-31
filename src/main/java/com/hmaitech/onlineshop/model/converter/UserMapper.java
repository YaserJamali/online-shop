package com.hmaitech.onlineshop.model.converter;

import com.hmaitech.onlineshop.model.dto.UsersDto;
import com.hmaitech.onlineshop.model.entity.User;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;

@Service
@Mapper(componentModel = "spring")
public interface UserMapper extends BaseConverter<UsersDto, User> {

}
