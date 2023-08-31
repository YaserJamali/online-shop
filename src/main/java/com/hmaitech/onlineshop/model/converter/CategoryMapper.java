package com.hmaitech.onlineshop.model.converter;

import com.hmaitech.onlineshop.model.dto.CategoryDto;
import com.hmaitech.onlineshop.model.entity.CategoryEntity;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;

@Service
@Mapper(componentModel = "spring")
public interface CategoryMapper extends BaseConverter<CategoryDto, CategoryEntity> {

}
