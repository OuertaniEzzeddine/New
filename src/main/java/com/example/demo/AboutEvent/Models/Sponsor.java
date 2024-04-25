package com.example.demo.AboutEvent.Models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import jakarta.persistence.*;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Getter
@Setter
@ToString
@Entity
@Table(name="SPONSOR")
public class Sponsor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="SPONSOR_NAME")
    private String nom;

    @Column(name="DESCRIPTION")
    private String description;

    @ManyToOne
    @JsonManagedReference
    private Event event;



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sponsor sponsor = (Sponsor) o;
        return Objects.equals(id, sponsor.id) && Objects.equals(nom, sponsor.nom) && Objects.equals(description, sponsor.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nom, description);
    }
}
