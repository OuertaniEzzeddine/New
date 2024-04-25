package com.example.demo.AboutEvent.DTO;

import java.util.List;

import com.example.demo.AboutEvent.Models.Budget;
import com.example.demo.AboutEvent.Models.Depense;
import com.example.demo.AboutEvent.Models.Facture;
import com.example.demo.AboutEvent.Models.Rapport;
import com.example.demo.AboutEvent.Models.Revenu;
import com.example.demo.AboutEvent.Models.Sponsor;

import lombok.Data;
@Data
public class EventDTO {

    private Long idEvent;
    private String nom;
    private String date;
    private String lieu;
    private String theme;
    private Integer nombrePersonne;
    private Rapport rapp;
    private List<Budget> budgets;
    private List<Depense> depenses;
    private List<Revenu> revenus;
    private List<Facture> factures;
    private List<Sponsor> sponsors;


}
