package com.hmaitech.onlineshop.model.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.Audited;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "categoryEntity")
@Table(name = "Category")
@NoArgsConstructor
@AllArgsConstructor
@Component
@Audited
@Getter
@Setter
public class CategoryEntity extends BaseEntity {

    private String name;


    @OneToOne(cascade = CascadeType.ALL, mappedBy = "category")
    private ProductEntity product;


    @OneToMany(targetEntity = SubCategoryEntity.class, mappedBy = "category")
    private List<SubCategoryEntity> subCategories = new ArrayList<>();


}
