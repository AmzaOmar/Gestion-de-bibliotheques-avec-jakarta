package com.example.campuslibrary.models;

public class Emprunt {
    private int id_emprunt;
    private int numero_abonnement;
    private int id_exemplaire;
    private String date_emprunt;
    private String date_retour_prevue;
    private String date_retour;

    public Emprunt(){}

    public Emprunt(int id_emprunt, int numero_abonnement, int id_exemplaire, String date_emprunt, String date_retour_prevue, String date_retour) {
        this.id_emprunt = id_emprunt;
        this.numero_abonnement = numero_abonnement;
        this.id_exemplaire = id_exemplaire;
        this.date_emprunt = date_emprunt;
        this.date_retour_prevue = date_retour_prevue;
        this.date_retour = date_retour;
    }
    public Emprunt(int numero_abonnement, int id_exemplaire, String date_emprunt, String date_retour_prevue) {

        this.numero_abonnement = numero_abonnement;
        this.id_exemplaire = id_exemplaire;
        this.date_emprunt = date_emprunt;
        this.date_retour_prevue = date_retour_prevue;

    }

    public Emprunt(int numero_abonnement, int id_exemplaire, String date_emprunt, String date_retour_prevue, String date_retour) {

        this.numero_abonnement = numero_abonnement;
        this.id_exemplaire = id_exemplaire;
        this.date_emprunt = date_emprunt;
        this.date_retour_prevue = date_retour_prevue;
        this.date_retour = date_retour;
    }

    public int getId_emprunt() {
        return id_emprunt;
    }

    public void setId_emprunt(int id_emprunt) {
        this.id_emprunt = id_emprunt;
    }

    public int getNumero_abonnement() {
        return numero_abonnement;
    }

    public void setNumero_abonnement(int numero_abonnement) {
        this.numero_abonnement = numero_abonnement;
    }

    public int getid_exemplaire() {
        return id_exemplaire;
    }

    public void setid_exemplaire(int id_exemplaire) {
        this.id_exemplaire = id_exemplaire;
    }

    public String getDate_emprunt() {
        return date_emprunt;
    }

    public void setDate_emprunt(String date_emprunt) {
        this.date_emprunt = date_emprunt;
    }

    public String getDate_retour_prevue() {
        return date_retour_prevue;
    }

    public void setDate_retour_prevue(String date_retour_prevue) {
        this.date_retour_prevue = date_retour_prevue;
    }

    public String getDate_retour() {
        return date_retour;
    }

    public void setDate_retour(String date_retour) {
        this.date_retour = date_retour;
    }
}
