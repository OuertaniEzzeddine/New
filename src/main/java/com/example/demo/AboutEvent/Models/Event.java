package com.example.demo.AboutEvent.Models;

import com.example.demo.base.model.AbstractBaseEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.*;

import jakarta.persistence.*;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name="EVENT")

public class Event extends AbstractBaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long idEvent;
    
    private String nom;
    private String date;
    private String lieu;
    private String theme;
    private Integer nombrePersonne;

    @OneToOne
    private Rapport rapp;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "event",orphanRemoval = true)
    @JsonManagedReference
    private List<Budget> budgets;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "event",orphanRemoval = true)
    @JsonManagedReference
    private List<Depense> depenses;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "event",orphanRemoval = true)
    @JsonManagedReference
    private List<Revenu> revenus;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "event",orphanRemoval = true)
    @JsonManagedReference
    private List<Facture> factures;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "event",orphanRemoval = true)
    @JsonManagedReference
    private List<Sponsor> sponsors;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return Objects.equals(idEvent, event.idEvent) && Objects.equals(nom, event.nom) && Objects.equals(date, event.date) && Objects.equals(lieu, event.lieu) && Objects.equals(theme, event.theme) && Objects.equals(nombrePersonne, event.nombrePersonne) && Objects.equals(rapp, event.rapp) && Objects.equals(budgets, event.budgets) && Objects.equals(depenses, event.depenses) && Objects.equals(revenus, event.revenus) && Objects.equals(factures, event.factures) && Objects.equals(sponsors, event.sponsors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEvent, nom, date, lieu, theme, nombrePersonne, rapp, budgets, depenses, revenus, factures, sponsors);
    }
}
