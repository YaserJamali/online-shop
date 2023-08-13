package com.hmaitech.onlineshop.model.dto;

import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Component
@Getter
@Setter
public class OrderDto extends BaseDto {


    private List<ProductDto> products = new ArrayList<>();

    private Boolean status;

}
