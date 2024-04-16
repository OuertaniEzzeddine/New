package com.example.demo.AboutEvent.Models;

import com.example.demo.base.model.AbstractBaseEntity;
import lombok.*;

import jakarta.persistence.*;
import java.util.Date;

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







}
