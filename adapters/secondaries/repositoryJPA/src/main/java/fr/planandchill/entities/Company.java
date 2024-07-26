package fr.planandchill.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Table(name = "company")
public class Company {
    @Id
    @Column(name = "id_company", nullable = false, length = 50)
    private String idCompany;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "description", length = 250)
    private String description;

    @Column(name = "siret")
    private Integer siret;

    @Column(name = "text_message_balance")
    private Integer textMessageBalance;

    @Column(name = "adminLink", length = 50)
    private String adminLink;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_address", nullable = false)
    private Address idAddress;
}