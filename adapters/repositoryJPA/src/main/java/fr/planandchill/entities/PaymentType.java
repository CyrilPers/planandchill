package fr.planandchill.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Table(name = "payment_type")
public class PaymentType {
    @Id
    @Column(name = "id_payment_type", nullable = false)
    private Integer id;

    @Column(name = "label", nullable = false, length = 50)
    private String label;
}