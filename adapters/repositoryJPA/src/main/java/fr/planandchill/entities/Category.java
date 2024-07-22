package fr.planandchill.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Table(name = "category")
public class Category {
    @Id
    @Column(name = "id_category", nullable = false)
    private Integer id;

    @Column(name = "label", nullable = false, length = 50)
    private String label;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_company", nullable = false)
    private Company idCompany;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_service_type", nullable = false)
    private TypeService idServiceType;
}