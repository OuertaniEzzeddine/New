package com.example.demo.AboutEvent.Models;

public class Facture {
    private int idFacture;
    private String contenu;

    public Facture() {
    }

    public Facture(int idFacture, String contenu) {
        this.idFacture = idFacture;
        this.contenu = contenu;
    }

    public int getIdFacture() {
        return idFacture;
    }

    public void setIdFacture(int idFacture) {
        this.idFacture = idFacture;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    @Override
    public String toString() {
        return "Facture{" +
                "idFacture=" + idFacture +
                ", contenu='" + contenu + '\'' +
                '}';
    }
}
