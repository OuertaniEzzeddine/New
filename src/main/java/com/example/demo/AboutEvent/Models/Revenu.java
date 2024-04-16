package com.example.demo.AboutEvent.Models;

import com.example.demo.base.model.AbstractBaseEntity;
import lombok.*;

import jakarta.persistence.*;
import java.util.Date;

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





}

