package com.hmaitech.onlineshop.model.converter;

import com.hmaitech.onlineshop.model.dto.ProductDto;
import com.hmaitech.onlineshop.model.entity.ProductEntity;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;

@Service
@Mapper(componentModel = "spring")
public interface ProductMapper extends BaseConverter<ProductDto, ProductEntity> {

}
