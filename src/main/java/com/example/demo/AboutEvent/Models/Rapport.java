package com.example.demo.AboutEvent.Models;

import com.example.demo.base.model.AbstractBaseEntity;
import lombok.*;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rapport rapport = (Rapport) o;
        return Objects.equals(idRapport, rapport.idRapport) && Objects.equals(generationDate, rapport.generationDate) && Objects.equals(contenu, rapport.contenu) && Objects.equals(e, rapport.e) && Objects.equals(revenus, rapport.revenus) && Objects.equals(depenses, rapport.depenses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idRapport, generationDate, contenu, e, revenus, depenses);
    }
}
