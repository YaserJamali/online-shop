package com.hmaitech.onlineshop.model.converter;

import com.hmaitech.onlineshop.model.dto.LibraryDto;
import com.hmaitech.onlineshop.model.entity.Library;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;

@Service
@Mapper(componentModel = "spring")
public interface LibraryMapper extends BaseConverter<LibraryDto, Library> {

}
