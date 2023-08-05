package com.hmaitech.onlineshop.model.entity;


import jakarta.persistence.Entity;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.Objects;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Library extends BaseEntity {

    private String name;

}
