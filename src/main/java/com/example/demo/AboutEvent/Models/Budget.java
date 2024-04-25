package com.example.demo.AboutEvent.Models;

import com.example.demo.base.model.AbstractBaseEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "BUDGET")
public class Budget extends AbstractBaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="BUDGET_ID")
    private Integer id;

    @Column(name = "MONTANT")
    private Double montant;

    @Column(name = "DESCRIPTION")
    private String desciption;

    @ManyToOne
    @JsonBackReference
    private Event event;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Budget budget = (Budget) o;
        return Objects.equals(id, budget.id) && Objects.equals(montant, budget.montant) && Objects.equals(desciption, budget.desciption);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, montant, desciption);
    }
}
