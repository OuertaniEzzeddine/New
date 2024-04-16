package com.example.demo.AboutEvent.Models;

import com.example.demo.base.model.AbstractBaseEntity;
import lombok.*;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity

@Table(name="RAPPORT")
public class Rapport extends AbstractBaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="RAPPORT_ID")
    private Integer idRapport;

    @Column(name="GENERATION_DATE")
    private Date generationDate;

    @Column(name="CONTENU")
    private String contenu;

    @OneToOne (mappedBy = "rapp")
    private Event e;


    @OneToMany(cascade = CascadeType.ALL)
    private List<Revenu> revenus;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Depense> depenses;



}
