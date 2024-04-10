package com.example.demo.AboutEvent.Models;

public class Budget {
    private double montant;
    private int idEvent;
    private String desciption;

    public Budget() {
    }

    public Budget(double montant, int idEvent, String desciption) {
        this.montant = montant;
        this.idEvent = idEvent;
        this.desciption = desciption;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public int getIdEvent() {
        return idEvent;
    }

    public void setIdEvent(int idEvent) {
        this.idEvent = idEvent;
    }

    public String getDesciption() {
        return desciption;
    }

    public void setDesciption(String desciption) {
        this.desciption = desciption;
    }
}
