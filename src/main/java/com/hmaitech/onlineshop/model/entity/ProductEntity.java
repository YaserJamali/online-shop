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

@Entity(name = "productEntity")
@Table(name = "Product")
@NoArgsConstructor
@AllArgsConstructor
@Component
@Audited
@Getter
@Setter
public class ProductEntity extends BaseEntity {

    private String title;

    private String Description;

    @OneToMany(cascade = {CascadeType.MERGE,CascadeType.DETACH,CascadeType.PERSIST,CascadeType.REFRESH},mappedBy = "product")
    private List<PathEntity> imageUrls = new ArrayList<>();

    private Double Price;

    private Integer Quantity;

    private Boolean isBookmarked;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinTable(name = "product_category_entity",
            joinColumns = @JoinColumn(name = "product_entity_id"),
            inverseJoinColumns = @JoinColumn(name = "category_entity_id"))
    private CategoryEntity category;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_entity_id")
    private OrderEntity order;

}
