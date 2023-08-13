package com.hmaitech.onlineshop.model.dto;


import com.hmaitech.onlineshop.model.entity.ProductEntity;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Component
@Getter
@Setter
public class CategoryDto extends BaseDto {

    private String name;

    private ProductDto product;


    private List<SubCategoryDto> subCategories = new ArrayList<>();


}
