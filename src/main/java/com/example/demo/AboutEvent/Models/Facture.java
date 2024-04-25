package com.example.demo.AboutEvent.Models;

import com.example.demo.base.model.AbstractBaseEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.*;

import jakarta.persistence.*;

import java.util.Objects;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="FACTURE")
public class Facture extends AbstractBaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="FACTURE_ID")
    private Integer idFacture;

    @Column(name="CONTENU")
    private String contenu;



    @ManyToOne
    @JsonBackReference
    private Event event;
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Facture facture = (Facture) o;
        return Objects.equals(idFacture, facture.idFacture) && Objects.equals(contenu, facture.contenu);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idFacture, contenu);
    }

}
