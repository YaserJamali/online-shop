package com.hmaitech.onlineshop.model.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.Audited;
import org.springframework.stereotype.Component;

@Entity(name = "pathEntity")
@Table(name = "Path")
@NoArgsConstructor
@AllArgsConstructor
@Component
@Audited
@Getter
@Setter
public class PathEntity extends BaseEntity {

    private String path;


    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "product_id")
    private ProductEntity product;

}
