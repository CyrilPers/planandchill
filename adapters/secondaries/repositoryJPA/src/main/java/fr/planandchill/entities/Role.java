package fr.planandchill.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "permission_level")
public class Role {
    @Id
    @Column(name = "id_permission_level", nullable = false, length = 50)
    private Integer id;
    @Column(name = "label")
    private String name;
}
