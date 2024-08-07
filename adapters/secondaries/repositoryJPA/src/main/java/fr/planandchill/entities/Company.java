package fr.planandchill.entities;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "company")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @OneToOne
    @JoinColumn(name = "id_address", referencedColumnName = "id_address")
    private Address address;
}