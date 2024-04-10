package com.example.demo.AboutEvent.Models;

public class Revenu {
    private int idRevenu;
    private double montant;
    private String description;
    private String date;
    private int idEvent;


    public Revenu() {
    }

    public Revenu(int idRevenu, double montant, String description, String date, int idEvent) {
        this.idRevenu = idRevenu;
        this.montant = montant;
        this.description = description;
        this.date = date;
        this.idEvent = idEvent;
    }

    public int getIdRevenu() {
        return idRevenu;
    }

    public void setIdRevenu(int idRevenu) {
        this.idRevenu = idRevenu;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getIdEvent() {
        return idEvent;
    }

    public void setIdEvent(int idEvent) {
        this.idEvent = idEvent;
    }
}

