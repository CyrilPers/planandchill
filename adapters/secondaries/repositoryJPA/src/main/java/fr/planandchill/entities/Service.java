package fr.planandchill.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@Table(name = "service")
public class Service {
    @Id
    @Column(name = "id_service", nullable = false)
    private Integer id;

    @Column(name = "duration", nullable = false)
    private Short duration;

    @Column(name = "description", length = 250)
    private String description;

    @Column(name = "title", nullable = false, length = 50)
    private String title;

    @Column(name = "price", nullable = false, precision = 8, scale = 2)
    private BigDecimal price;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "taux", nullable = false)
    private Tva taux;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_category", nullable = false)
    private Category idCategory;
}