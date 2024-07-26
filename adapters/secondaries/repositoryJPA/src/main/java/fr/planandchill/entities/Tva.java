package fr.planandchill.entities;
import javax.persistence.*;
import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = "tva")
public class Tva {
    @Id
    @Column(name = "taux", nullable = false, precision = 4, scale = 2)
    private BigDecimal id;

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }
}