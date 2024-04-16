package com.example.demo.AboutEvent.Models;

import com.example.demo.base.model.AbstractBaseEntity;
import lombok.*;

import jakarta.persistence.*;
import java.util.List;
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

    @OneToMany(cascade = CascadeType.ALL)
    private List<Budget> budgets;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Depense> depenses;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Revenu> revenus;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Facture> factures;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Sponsor> sponsors;




}
