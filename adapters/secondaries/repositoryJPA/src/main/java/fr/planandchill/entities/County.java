package fr.planandchill.entities;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "county")
public class County {
    @Id
    @Column(name = "insee_county", nullable = false)
    private Integer id;


    @Column(name = "label", nullable = false, length = 50)
    private String label;

    @Column(name = "number")
    private Integer number;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "insee_region", nullable = false)
    private Region inseeRegion;
}