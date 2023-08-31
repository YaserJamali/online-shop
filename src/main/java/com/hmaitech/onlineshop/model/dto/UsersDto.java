package com.hmaitech.onlineshop.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.Date;


@Component
@Getter
@Setter
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


    public UsersDto() {

    }


    public static UsersDto of(String firstName, String lastName, String email, String password1, String password2) {
        return new UsersDto(null, null, null, false, null, firstName, lastName, email, password1, password2);
    }

    private UsersDto(Long id, Date createDate, Date updateDate, Boolean deleted, Integer version, String firstName, String lastName, String email, String password1, String password2) {
        super(id, createDate, updateDate, deleted, version);
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password1 = password1;
        this.password2 = password2;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        if (password2.equals(this.password1)) {
            this.password2 = password2;
        } else throw new RuntimeException();
    }


}
