package fr.planandchill.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "user")
public class User {
    @Id
    @Column(name = "id_user", nullable = false)
    private Integer id;

    @Column(name = "first_name", nullable = false, length = 50)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 50)
    private String lastName;

    @Column(name = "enabled")
    private Boolean enabled;

    @Column(name = "email", nullable = false, length = 250)
    private String email;

    @Column(name = "password", nullable = false, length = 250)
    private String password;

    @Column(name = "phone_number", length = 50)
    private String phoneNumber;

    @Column(name = "account_locked", nullable = false)
    private Boolean accountLocked = false;

    @Column(name = "creation_date", nullable = false)
    private LocalDateTime creationDate;

    @ManyToMany(mappedBy = "user")
    private List<Address> addresses = new ArrayList<>();

    @OneToOne(mappedBy = "idUser")
    private Customer customer;

    @OneToMany(mappedBy = "idUser")
    private List<Token> tokens = new ArrayList<>();



}