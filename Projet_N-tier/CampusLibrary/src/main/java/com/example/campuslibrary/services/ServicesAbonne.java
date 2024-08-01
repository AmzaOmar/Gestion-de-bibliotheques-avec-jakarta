package com.example.campuslibrary.services;

import com.example.campuslibrary.connexion.Connexion;
import com.example.campuslibrary.dao.AbonneDao;
import com.example.campuslibrary.models.Abonne;

import java.util.List;

public class ServicesAbonne {
    private AbonneDao abonneDao;
    private Connexion conn;

    public ServicesAbonne() {
        this.abonneDao = new AbonneDao(); // Initialisation de abonneDao
    }

    public boolean inscrireAbonne(Abonne abonne) {
        return abonneDao.create(abonne);
    }

    public boolean modifierAbonne(Abonne abonne) {
        return abonneDao.update(abonne);
    }

    public boolean desinscrireAbonne(Abonne abonne) {
        return abonneDao.delete(abonne);
    }

    public Abonne obtenirAbonneParId(int numeroAbonnement) {
        return abonneDao.getById(numeroAbonnement);
    }

    public List<Abonne> obtenirTousLesAbonnes() {
        return abonneDao.findAll();
    }
}
