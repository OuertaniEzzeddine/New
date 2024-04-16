package com.example.demo.AboutEvent.Models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import jakarta.persistence.*;

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

/*    private Event ee;*/
}
