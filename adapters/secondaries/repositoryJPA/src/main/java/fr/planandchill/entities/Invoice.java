package fr.planandchill.entities;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
import java.time.Instant;

@Getter
@Setter
@Table(name = "invoice")
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_invoice", nullable = false)
    private Integer id;

    @Column(name = "invoice_date", nullable = false)
    private Instant invoiceDate;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_payment", nullable = false)
    private Payment idPayment;
}