package com.example.demo.AboutEvent.Models;

import com.example.demo.base.model.AbstractBaseEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.*;

import jakarta.persistence.*;
import java.util.Date;
import java.util.Objects;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Entity
@Table(name="DEPENSE")

public class Depense extends AbstractBaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="DEPENSE_ID")
    private Integer idDepense;

    @Column(name="MONTANT")
    private Double montant;

    @Column(name="DESCRIPTION")
    private String description;

    @Column(name="DATE")
    private Date date;

    @ManyToOne
    @JsonBackReference
    private Event event;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Depense depense = (Depense) o;
        return Objects.equals(idDepense, depense.idDepense) && Objects.equals(montant, depense.montant) && Objects.equals(description, depense.description) && Objects.equals(date, depense.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idDepense, montant, description, date);
    }
}
