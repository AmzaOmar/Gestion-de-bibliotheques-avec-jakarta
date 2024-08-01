package com.example.campuslibrary.models;

import java.util.*;
public class Bibliothecaire {

    private int id;
    private String prenom;
    private String nom;
    private String Date_recrutement;
    private String adresse;
    private String email;

    public Bibliothecaire (){}
    public Bibliothecaire(int id, String prenom, String nom, String Date_recrutement, String adresse, String email) {
        this.id = id;
        this.prenom = prenom;
        this.nom = nom;
        this.Date_recrutement = Date_recrutement;
        this.adresse = adresse;
        this.email = email;
    }
    public Bibliothecaire(String prenom, String nom, String Date_recrutement, String adresse, String email) {
        this.prenom = prenom;
        this.nom = nom;
        this.Date_recrutement = Date_recrutement;
        this.adresse = adresse;
        this.email = email;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getDate_recrutement() {
        return Date_recrutement;
    }

    public void setDate_recrutement(String String_recrutement) {
        this.Date_recrutement = String_recrutement;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
