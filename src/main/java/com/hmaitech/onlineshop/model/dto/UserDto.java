package com.hmaitech.onlineshop.model.dto;


import com.hmaitech.onlineshop.model.enums.Role;
import lombok.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Component
@Getter
@Setter
public class UserDto extends BaseDto {


    private String name;
    private String family;

    private Role role;

    private String fullName;

    private List<AddressDto> addressEntities = new ArrayList<>();

    private List<OrderDto> orderEntities = new ArrayList<>();

    private String email;

    private String mobileNumber;


}
