package com.example.demo.AboutEvent.Models;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEvent;
    private String nom;
    private String date;
    private String lieu;
    private String theme;
    private int nombrePersonne;
    private List<Budget> budgets;
    private List<Depense> depenses;
    private List<Revenu> revenus;
    private List<Facture> factures;
    private List<Sponsor> sponsors;

    public Event() {
    }

    public Event(Long idEvent, String nom, String date, String lieu, String theme, int nombrePersonne, List<Budget> budgets, List<Depense> depenses, List<Revenu> revenus, List<Facture> factures, List<Sponsor> sponsors) {
        this.idEvent = idEvent;
        this.nom = nom;
        this.date = date;
        this.lieu = lieu;
        this.theme = theme;
        this.nombrePersonne = nombrePersonne;
        this.budgets = budgets;
        this.depenses = depenses;
        this.revenus = revenus;
        this.factures = factures;
        this.sponsors = sponsors;
    }


    public long getIdEvent() {
        return idEvent;
    }

    public void setIdEvent(Long idEvent) {
        this.idEvent = idEvent;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public int getNombrePersonne() {
        return nombrePersonne;
    }

    public void setNombrePersonne(int nombrePersonne) {
        this.nombrePersonne = nombrePersonne;
    }

    public List<Budget> getBudgets() {
        return budgets;
    }

    public void setBudgets(List<Budget> budgets) {
        this.budgets = budgets;
    }

    public List<Depense> getDepenses() {
        return depenses;
    }

    public void setDepenses(List<Depense> depenses) {
        this.depenses = depenses;
    }

    public List<Revenu> getRevenus() {
        return revenus;
    }

    public void setRevenus(List<Revenu> revenus) {
        this.revenus = revenus;
    }

    public List<Facture> getFactures() {
        return factures;
    }

    public void setFactures(List<Facture> factures) {
        this.factures = factures;
    }

    public List<Sponsor> getSponsors() {
        return sponsors;
    }

    public void setSponsors(List<Sponsor> sponsors) {
        this.sponsors = sponsors;
    }

    @Override
    public String toString() {
        return "Event{" +
                "idEvent=" + idEvent +
                ", nom='" + nom + '\'' +
                ", date='" + date + '\'' +
                ", lieu='" + lieu + '\'' +
                ", theme='" + theme + '\'' +
                ", nombrePersonne=" + nombrePersonne +
                ", budgets=" + budgets +
                ", depenses=" + depenses +
                ", revenus=" + revenus +
                ", factures=" + factures +
                ", sponsors=" + sponsors +
                '}';
    }
}
