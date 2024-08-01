package com.example.campuslibrary.models;



public class Abonne {
    private int numero_abonnement;
    private String prenom;
    private String nom;
    private String statut;
    private String institution;
    private String adresse_email;

    public Abonne() {}

    public Abonne(int numero_abonnement, String prenom, String nom, String statut, String institution, String adresse_email) {
        this.numero_abonnement = numero_abonnement;
        this.prenom = prenom;
        this.nom = nom;
        this.statut = statut;
        this.institution = institution;
        this.adresse_email = adresse_email;
    }
    public Abonne(String prenom, String nom, String statut, String institution, String adresse_email) {

        this.prenom = prenom;
        this.nom = nom;
        this.statut = statut;
        this.institution = institution;
        this.adresse_email = adresse_email;
    }


    public int getNumero_abonnement() {
        return numero_abonnement;
    }

    public void setNumero_abonnement(int numero_abonnement) {
        this.numero_abonnement = numero_abonnement;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public String getAdresse_email() {
        return adresse_email;
    }

    public void setAdresse_email(String adresse_email) {
        this.adresse_email = adresse_email;
    }
}
