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

    public User() {

    }


    public static User of(String firstName, String lastName, String email, String password1, String password2){
        return new User(null,null,null,false,null,firstName,lastName,email,password1,password2);
    }

    private User(Long id, Date createDate, Date updateDate, Boolean deleted, Integer version, String firstName, String lastName, String email, String password1, String password2) {
        super(id, createDate, updateDate, deleted, version);
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password1 = password1;
        this.password2 = password2;
    }
}
