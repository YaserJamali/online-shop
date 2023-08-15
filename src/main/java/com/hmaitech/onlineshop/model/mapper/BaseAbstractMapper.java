package com.hmaitech.onlineshop.model.mapper;


import com.hmaitech.onlineshop.model.dto.BaseDto;
import com.hmaitech.onlineshop.model.entity.BaseEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public abstract class BaseAbstractMapper<D extends BaseDto, E extends BaseEntity> {

    @Autowired
    private D dto;

    @Autowired
    private E entity;

    public E dtoToEntity(D dto) {
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }


    public D entityToDto(E entity) {
        BeanUtils.copyProperties(entity, dto);
        return dto;

    }

    public List<E> entityToDto(List<D> dtoList) {

        if (dtoList != null) {
            return dtoList.stream()
                    .map(item -> dtoToEntity(item))
                    .collect(Collectors.toList());
        }
        return null;
    }


    public List<D> dtoToEntity(List<E> entityList) {

        if (entityList != null) {
            return entityList.stream()
                    .map(item -> entityToDto(item))
                    .collect(Collectors.toList());
        }
        return null;
    }

}
