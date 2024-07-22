package fr.planandchill.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Table(name = "image")
public class Image {
    @Id
    @Column(name = "id_image", nullable = false)
    private Integer id;

    @Column(name = "link", nullable = false, length = 250)
    private String link;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_company", nullable = false)
    private Company idCompany;
}