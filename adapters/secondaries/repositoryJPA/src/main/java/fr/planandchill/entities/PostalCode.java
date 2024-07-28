package fr.planandchill.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
@Entity
@Table(name = "postal_code")
public class PostalCode {
    @Id
    @Column(name = "code", nullable = false, length = 50)
    private String code;

    public PostalCode() {
    }

    public PostalCode(String number) {
        this.code = number;
    }
}