package com.hmaitech.onlineshop.model.entity;


import com.hmaitech.onlineshop.model.enums.Role;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.envers.Audited;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Entity(name = "userEntity")
@Table(name = "Users")
@NoArgsConstructor
@AllArgsConstructor
@Component
@Audited
@Getter
@Setter
public class UserEntity extends BaseEntity {


    @Column(name = "FIRST_NAME", length = 50)
    private String name;
    @Column(name = "LAST_NAME", length = 50)
    private String family;

    @Column(name = "NATIONAL_CODE")
    private String nationalCode;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Transient
    private String fullName;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "user")
    private List<AddressEntity> addresses = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "user")
    private List<OrderEntity> orders = new ArrayList<>();

    private String email;

    private String mobileNumber;

    @Column(name = "BIRTH_DAY")
    private LocalDate birthDay;


    @OneToOne(orphanRemoval = true)
    @JoinTable(name = "users_address_entity",
            joinColumns = @JoinColumn(name = "user_entity_id"),
            inverseJoinColumns = @JoinColumn(name = "address_entity_id"))
    private AddressEntity address;

}
