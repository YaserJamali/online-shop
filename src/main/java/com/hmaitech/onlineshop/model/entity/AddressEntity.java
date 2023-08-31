package com.hmaitech.onlineshop.model.entity;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.envers.Audited;
import org.springframework.stereotype.Component;

@Entity(name = "addressEntity")
@Table(name = "address")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Component
@Audited
@Getter
@Setter
public class AddressEntity extends BaseEntity {

    @OneToOne(mappedBy = "address")
    private User userId;


    private String addressLine1;
    private String addressLine2;
    private String Country;
    private String city;

    private String zipcode;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

}
