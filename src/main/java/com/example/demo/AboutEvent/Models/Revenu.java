package com.example.demo.AboutEvent.Models;

import com.example.demo.base.model.AbstractBaseEntity;
import lombok.*;

import jakarta.persistence.*;
import java.util.Date;
import java.util.Objects;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity

@Table(name="REVENU")
public class Revenu extends AbstractBaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private Integer id;

    @Column(name="MONTANT")
    private double montant;

    @Column(name="DESCRIPTION")
    private String description;

    @Column(name="DATE")
    private Date date;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Revenu revenu = (Revenu) o;
        return Double.compare(montant, revenu.montant) == 0 && Objects.equals(id, revenu.id) && Objects.equals(description, revenu.description) && Objects.equals(date, revenu.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, montant, description, date);
    }
}

