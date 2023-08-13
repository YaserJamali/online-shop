package com.hmaitech.onlineshop.model.dto;

import com.hmaitech.onlineshop.model.entity.CategoryEntity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@AllArgsConstructor
@Component
@Getter
@Setter
public class SubCategoryDto extends BaseDto {


    private String name;

    private CategoryDto categoryId;

}
