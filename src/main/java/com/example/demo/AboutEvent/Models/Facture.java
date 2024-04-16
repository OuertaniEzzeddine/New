package com.example.demo.AboutEvent.Models;

import com.example.demo.base.model.AbstractBaseEntity;
import lombok.*;

import jakarta.persistence.*;
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


}
