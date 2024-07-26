package fr.planandchill.entities;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@Table(name = "payment")
public class Payment {
    @Id
    @Column(name = "id_payment", nullable = false)
    private Integer id;

    @Column(name = "amount", nullable = false, precision = 8, scale = 2)
    private BigDecimal amount;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_appointment", nullable = false)
    private Appointment idAppointment;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_payment_type", nullable = false)
    private PaymentType idPaymentType;
}