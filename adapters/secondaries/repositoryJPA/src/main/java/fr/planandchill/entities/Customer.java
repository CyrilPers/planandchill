package fr.planandchill.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@Table(name = "customer")
@PrimaryKeyJoinColumn(name = "id_user")
public class Customer extends User {

    @Column(name = "advertising", nullable = false)
    private Boolean advertising = false;

    public Customer() {}

    public Boolean getAdvertising() {
        return advertising;
    }

    public void setAdvertising(Boolean advertising) {
        this.advertising = advertising;
    }
}