package fr.planandchill.entities;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;


import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Getter
@Setter
public class SubscribeId implements Serializable {
    private static final long serialVersionUID = 6578597227124397665L;
    @Column(name = "id_company", nullable = false, length = 50)
    private String idCompany;

    @Column(name = "id_membership", nullable = false)
    private Integer idMembership;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        SubscribeId entity = (SubscribeId) o;
        return Objects.equals(this.idMembership, entity.idMembership) &&
                Objects.equals(this.idCompany, entity.idCompany);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idMembership, idCompany);
    }

}