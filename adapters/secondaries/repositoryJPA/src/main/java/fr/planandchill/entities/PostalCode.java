package fr.planandchill.entities;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;

@Getter
@Setter
@Table(name = "postal_code")
public class PostalCode {
    @Id
    @Column(name = "code", nullable = false, length = 50)
    private String code;
}