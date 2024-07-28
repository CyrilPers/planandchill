package fr.planandchill.entities;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "country")
public class Country {
    @Id
    @Column(name = "insee_country", nullable = false)
    private Integer id;

    @Column(name = "label", length = 50)
    private String label;
}