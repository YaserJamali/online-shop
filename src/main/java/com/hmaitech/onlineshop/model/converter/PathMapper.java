package com.hmaitech.onlineshop.model.converter;

import com.hmaitech.onlineshop.model.dto.PathDto;
import com.hmaitech.onlineshop.model.entity.PathEntity;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;

@Service
@Mapper(componentModel = "spring")
public interface PathMapper extends BaseConverter<PathDto, PathEntity> {

}
