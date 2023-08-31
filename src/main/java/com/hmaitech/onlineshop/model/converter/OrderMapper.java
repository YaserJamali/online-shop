package com.hmaitech.onlineshop.model.converter;

import com.hmaitech.onlineshop.model.dto.OrderDto;
import com.hmaitech.onlineshop.model.entity.OrderEntity;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;

@Service
@Mapper(componentModel = "spring")
public interface OrderMapper extends BaseConverter<OrderDto, OrderEntity> {

}
