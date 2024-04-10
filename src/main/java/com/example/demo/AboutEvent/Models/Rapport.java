package com.example.demo.AboutEvent.Models;

import java.util.List;

public class Rapport {
    private int idRapport;
    private String generationDate;
    private String contenu;
    private List<Revenu> revenus;
    private List<Depense> depenses;

    public Rapport() {
    }

    public Rapport(int idRapport, String generationDate, String contenu, List<Revenu> revenus, List<Depense> depenses) {
        this.idRapport = idRapport;
        this.generationDate = generationDate;
        this.contenu = contenu;
        this.revenus = revenus;
        this.depenses = depenses;
    }

    public int getIdRapport() {
        return idRapport;
    }

    public void setIdRapport(int idRapport) {
        this.idRapport = idRapport;
    }

    public String getGenerationDate() {
        return generationDate;
    }

    public void setGenerationDate(String generationDate) {
        this.generationDate = generationDate;
    }

    public List<Revenu> getRevenus() {
        return revenus;
    }

    public void setRevenus(List<Revenu> revenus) {
        this.revenus = revenus;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public List<Depense> getDepenses() {
        return depenses;
    }

    public void setDepenses(List<Depense> depenses) {
        this.depenses = depenses;
    }

    @Override
    public String toString() {
        return "Rapport{" +
                "idRapport=" + idRapport +
                ", generationDate='" + generationDate + '\'' +
                ", contenu='" + contenu + '\'' +
                ", revenus=" + revenus +
                ", depenses=" + depenses +
                '}';
    }
}
