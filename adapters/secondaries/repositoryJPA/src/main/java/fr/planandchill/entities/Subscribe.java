package fr.planandchill.entities;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
import java.time.Instant;

@Getter
@Setter
@Table(name = "subscribe")
public class Subscribe {
    @EmbeddedId
    private SubscribeId id;

    @MapsId("idCompany")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_company", nullable = false)
    private Company idCompany;

    @MapsId("idMembership")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_membership", nullable = false)
    private Membership idMembership;

    @Column(name = "date_start", nullable = false)
    private Instant dateStart;

    @Column(name = "date_end")
    private Instant dateEnd;
}