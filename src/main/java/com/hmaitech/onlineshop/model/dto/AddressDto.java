package com.hmaitech.onlineshop.model.dto;


import jakarta.persistence.OneToOne;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@AllArgsConstructor
@Component
@Getter
@Setter

public class AddressDto extends BaseDto {



    private UserDto userId=new UserDto();


    private String addressLine1;
    private String addressLine2;
    private String Country;
    private String city;

    private String zipcode;

}
