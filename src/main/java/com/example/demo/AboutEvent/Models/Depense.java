package com.example.demo.AboutEvent.Models;

public class Depense {
    private int idEvent;
    private double montant;
    private String description;
    private String date;
    private String idDepense;

    public Depense() {
    }

    public Depense(int idEvent, double montant, String description, String date, String idDepense) {
        this.idEvent = idEvent;
        this.montant = montant;
        this.description = description;
        this.date = date;
        this.idDepense = idDepense;
    }

    public int getIdEvent() {
        return idEvent;
    }

    public void setIdEvent(int idEvent) {
        this.idEvent = idEvent;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIdDepense() {
        return idDepense;
    }

    public void setIdDepense(String idDepense) {
        this.idDepense = idDepense;
    }

    @Override
    public String toString() {
        return "Depense {" +
                "idDepense=" + idDepense +
                ", idEvent='" + idEvent + '\'' +
                ", montant=" + montant +
                ", date='" + date + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
