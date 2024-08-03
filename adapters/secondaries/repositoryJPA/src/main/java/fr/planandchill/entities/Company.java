package fr.planandchill.entities;
import lombok.*;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "company")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_company", nullable = false, length = 50)
    private Integer id;

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

    @Column(name = "creation")
    private LocalDateTime creation;

}