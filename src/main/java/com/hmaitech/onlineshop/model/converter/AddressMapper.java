package com.hmaitech.onlineshop.model.converter;

import com.hmaitech.onlineshop.model.dto.AddressDto;
import com.hmaitech.onlineshop.model.entity.AddressEntity;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;

@Service
@Mapper(componentModel = "spring")
public interface AddressMapper extends BaseConverter<AddressDto, AddressEntity> {

}
