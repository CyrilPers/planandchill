package fr.planandchill.entities;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Table(name = "permissions_level")
public class PermissionsLevel {
    @Id
    @Column(name = "id_permissions_level", nullable = false)
    private Integer id;

    @Column(name = "label", nullable = false, length = 50)
    private String label;
}