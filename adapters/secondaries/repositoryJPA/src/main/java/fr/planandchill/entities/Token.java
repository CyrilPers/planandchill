package fr.planandchill.entities;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "token")
public class Token {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_token", nullable = false)
    private Integer id;

    @Column(name = "token", nullable = false, length = 50)
    private String token;

    @Column(name = "createAt", nullable = false)
    private Instant createAt;

    @Column(name = "expiresAt", nullable = false)
    private Instant expiresAt;

    @Column(name = "validatedAt")
    private Instant validatedAt;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_user", nullable = false)
    private User idUser;

}