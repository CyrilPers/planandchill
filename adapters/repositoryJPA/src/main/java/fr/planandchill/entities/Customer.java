package fr.planandchill.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
public class Customer extends User {

    @Column(name = "advertising", nullable = false)
    private Boolean advertising = false;
}