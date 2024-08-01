package com.example.campuslibrary.models;

public class Livre {
    private int identifiant;
    private String titre;
    private String auteurs;
    private String annee_publication;
    private String domaine;
    private String niveau;

    public Livre() {}

    public Livre(int identifiant, String titre, String auteurs, String annee_publication, String domaine, String niveau) {
        this.identifiant = identifiant;
        this.auteurs = auteurs;
        this.titre = titre;
        this.annee_publication = annee_publication;
        this.domaine = domaine;
        this.niveau = niveau;
    }
    public Livre( String titre, String auteurs, String annee_publication, String domaine, String niveau) {
        this.auteurs = auteurs;
        this.titre = titre;
        this.annee_publication = annee_publication;
        this.domaine = domaine;
        this.niveau = niveau;
    }


    public int getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(int identifiant) {
        this.identifiant = identifiant;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getAuteurs() {
        return auteurs;
    }

    public void setAuteurs(String auteurs) {
        this.auteurs = auteurs;
    }

    public String getAnnee_publication() {
        return annee_publication;
    }

    public void setAnnee_publication(String annee_publication) {
        this.annee_publication = annee_publication;
    }

    public String getDomaine() {
        return domaine;
    }

    public void setDomaine(String domaine) {
        this.domaine = domaine;
    }

    public String getNiveau() {
        return niveau;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }
}


