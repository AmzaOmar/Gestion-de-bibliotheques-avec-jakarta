package com.example.campuslibrary.services;

import com.example.campuslibrary.dao.BibliothecaireDao;
import com.example.campuslibrary.models.Bibliothecaire;

import java.util.List;

public class ServicesBibliothecaire {
    BibliothecaireDao bibliothecaireDao;
    public ServicesBibliothecaire() {
        this.bibliothecaireDao = new BibliothecaireDao(); // Initialisation de bibliothecaireDao
    }

    public boolean enregistrerBibliothecaire(Bibliothecaire bibliothecaire) {
        return bibliothecaireDao.create(bibliothecaire);
    }

    public boolean modifierBibliothecaire(Bibliothecaire bibliothecaire) {
        return bibliothecaireDao.update(bibliothecaire);
    }

    public boolean desinscrireBibliothecaire(Bibliothecaire bibliothecaire) {
        return bibliothecaireDao.delete(bibliothecaire);
    }

    public Bibliothecaire obtenirBibliothecaireParId(int id) {
        return bibliothecaireDao.getById(id);
    }

    public List<Bibliothecaire> obtenirTousLesbibliothecaires() {
        return bibliothecaireDao.findAll();
    }
}
