package fr.planandchill.entities;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;

@Getter
@Setter
@Table(name = "permissions_level")
public class PermissionsLevel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_permissions_level", nullable = false)
    private Integer id;

    @Column(name = "label", nullable = false, length = 50)
    private String label;
}