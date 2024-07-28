package fr.planandchill.entities;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "region")
public class Region {
    @Id
    @Column(name = "insee_region", nullable = false, length = 50)
    private String inseeRegion;
}