package com.hmaitech.onlineshop.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;


@Component
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsersDto extends BaseDto {


    @NotEmpty
    @NotNull
    @JsonProperty("first_name")
    @Pattern(regexp = "^([a-zA-Z]|\\s){3,20}$", message = "enter valid String between 3 to 20 for First Name")
    private String firstName;
    @NotEmpty
    @NotNull
    @JsonProperty("last_name")
    @Pattern(regexp = "^([a-zA-Z]|\\s){3,20}$", message = "enter valid String between 3 to 20 for Last Name")
    private String lastName;
    @NotEmpty
    @NotNull
    @Email
    private String email;
    @NotEmpty
    @NotNull
//    @Pattern(regexp = "^([a-zA-Z]|\\s){6,20}$",message = "enter valid String between 6 to 20 for Password1")
    private String password1;

    @NotEmpty
    @NotNull
    @JsonProperty("confirm_password")
//    @Pattern(regexp = "^([a-zA-Z]|\\s){6,20}$",message = "enter valid String between 6 to 20 for Password2")
    private String password2;


}



