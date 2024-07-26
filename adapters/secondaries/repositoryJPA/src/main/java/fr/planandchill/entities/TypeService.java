package fr.planandchill.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "type_service")
public class TypeService {
    @Id
    @Column(name = "id_service_type", nullable = false, length = 50)
    private String idServiceType;

    @Column(name = "label", nullable = false, length = 50)
    private String label;
}