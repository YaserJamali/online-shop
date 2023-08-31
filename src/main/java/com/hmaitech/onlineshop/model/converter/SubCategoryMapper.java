package com.hmaitech.onlineshop.model.converter;

import com.hmaitech.onlineshop.model.dto.SubCategoryDto;
import com.hmaitech.onlineshop.model.entity.SubCategoryEntity;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;

@Service
@Mapper(componentModel = "spring")
public interface SubCategoryMapper extends BaseConverter<SubCategoryDto, SubCategoryEntity> {

}
