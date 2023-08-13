package com.hmaitech.onlineshop.model.dto;


import jakarta.persistence.Entity;
import lombok.*;
import org.hibernate.envers.Audited;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@AllArgsConstructor
@Component
@Getter
@Setter
public class LibraryDto extends BaseDto {

    private String name;


}
