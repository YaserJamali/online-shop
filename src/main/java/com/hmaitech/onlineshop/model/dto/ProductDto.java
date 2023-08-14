package com.hmaitech.onlineshop.model.dto;


import com.hmaitech.onlineshop.model.entity.OrderEntity;
import com.hmaitech.onlineshop.model.entity.PathEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Component
public class ProductDto extends BaseDto {


    private String title;
    private String Description;
    private List<PathEntity> imageUrls = new ArrayList<>();

    private Double Price;
    private Integer Quantity;
    private Boolean isBookmarked;

    @Autowired
    private CategoryDto category;


    @Autowired
    private OrderDto order;


}
