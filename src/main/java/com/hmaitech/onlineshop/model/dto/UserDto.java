//package com.hmaitech.onlineshop.model.dto;
//
//
//import com.fasterxml.jackson.annotation.JsonInclude;
//import com.hmaitech.onlineshop.model.enums.Role;
//import jakarta.validation.constraints.Email;
//import jakarta.validation.constraints.NotNull;
//import jakarta.validation.constraints.Past;
//import jakarta.validation.constraints.Pattern;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//import org.springframework.stereotype.Component;
//
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.List;
//
//
//@NoArgsConstructor
//@AllArgsConstructor
//@Component
//@Getter
//@Setter
//
//@JsonInclude(JsonInclude.Include.NON_EMPTY)
//public class UserDto extends BaseDto {
//
//
//    @Pattern(regexp = "^([a-zA-Z]|\\s){3,20}$",message = "enter valid String between 3 to 20 for First Name")
//    private String name;
//    @Pattern(regexp = "^([a-zA-Z]|\\s){3,20}$",message = "enter valid String between 3 to 20 for Last Name")
//    private String family;
//
//    @NotNull
//    @Pattern(regexp ="^\\d{10}$" ,message = "enter digit numbers ")
//    private String nationalCode;
//
//
//    @Past
//    private LocalDate birthDay;
//
//    private Role role;
//
//    private String fullName;
//
//    private List<AddressDto> addresses = new ArrayList<>();
//
//    private List<OrderDto> orders = new ArrayList<>();
//
//    @Email
//    private String email;
//    @Pattern(regexp ="^\\d{13}$" )
//    private String mobileNumber;
//
//
//}
