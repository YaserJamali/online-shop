package com.hmaitech.onlineshop.model.converter;

import com.hmaitech.onlineshop.model.dto.ReceiptDto;
import com.hmaitech.onlineshop.model.entity.ReceiptEntity;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;

@Service
@Mapper(componentModel = "spring")
public interface ReceiptMapper extends BaseConverter<ReceiptDto, ReceiptEntity> {

}
