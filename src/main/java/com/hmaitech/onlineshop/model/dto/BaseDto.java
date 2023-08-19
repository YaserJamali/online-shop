package com.hmaitech.onlineshop.model.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import java.util.Date;


@AllArgsConstructor
@Getter
@Setter
@RequiredArgsConstructor
@Component
@Validated
public abstract class BaseDto  {

    private Long id;


    private Date createDate;

    private Date updateDate;


    private Boolean deleted = false;


    private Integer version;

}
