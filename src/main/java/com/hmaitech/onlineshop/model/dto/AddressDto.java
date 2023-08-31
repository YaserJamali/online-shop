package com.hmaitech.onlineshop.model.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.OneToOne;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@AllArgsConstructor
@Component
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_EMPTY)

public class AddressDto extends BaseDto {





    private UsersDto userId=new UsersDto();


    private String addressLine1;
    private String addressLine2;
    private String Country;
    private String city;

    private String zipcode;

}
