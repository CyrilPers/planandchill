package fr.planandchill.entities;


import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "appointment")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_appointment", nullable = false)
    private Integer id;

    @Column(name = "date_start", nullable = false)
    private Instant dateStart;

    @Column(name = "date_end", nullable = false)
    private Instant dateEnd;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_user", nullable = false)
    private Worker idUser;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_user1", nullable = false)
    private Customer idUser1;

    
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_apppointment_state", nullable = false)
    private AppointmentState idApppointmentState;
}