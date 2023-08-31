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

@Entity(name = "orderEntity")
@Table(name = "Orders")
@NoArgsConstructor
@AllArgsConstructor
@Component
@Audited
@Getter
@Setter
public class OrderEntity extends BaseEntity {


    @OneToMany(cascade = CascadeType.ALL,mappedBy = "order")
    private List<ProductEntity> products = new ArrayList<>();

    @Column(columnDefinition = "Integer", length = 1)
    private Boolean status;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

}
