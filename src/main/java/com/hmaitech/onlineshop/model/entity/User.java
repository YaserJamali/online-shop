package com.hmaitech.onlineshop.model.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.envers.Audited;
import org.springframework.stereotype.Component;

import java.util.Date;

@Entity(name = "users")
@Table(name = "Users")
@ToString
@Component
@Audited
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseEntity{




    private String firstName;
    private String lastName;

    @Column(unique = true,nullable = false)
    private String email;

    @Column(nullable = false, name = "password")
    private String password1;
    @Transient()
    private String password2;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinTable(name = "users_address_entity",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "address_entity_id"))
    private AddressEntity address;


}
