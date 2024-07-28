package fr.planandchill.entities;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@Table(name = "invoice_line")
public class InvoiceLine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_invoice_line", nullable = false)
    private Integer id;

    @Column(name = "product_price", nullable = false, precision = 8, scale = 2)
    private BigDecimal productPrice;

    @Column(name = "product_name", nullable = false, length = 50)
    private String productName;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_invoice", nullable = false)
    private Invoice idInvoice;
}