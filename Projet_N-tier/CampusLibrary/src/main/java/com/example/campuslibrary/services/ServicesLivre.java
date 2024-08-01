package com.example.campuslibrary.services;

import com.example.campuslibrary.dao.LivreDao;
import com.example.campuslibrary.dao.*;
import com.example.campuslibrary.models.Livre;

import java.util.List;

public class ServicesLivre {
    LivreDao livreDao;
    EmpruntDao empruntDao;
    ExemplaireDao exemplaireDao;
    public ServicesLivre() {
        this.livreDao = new LivreDao(); // Initialisation de livreDao
        this.empruntDao= new EmpruntDao();
        this.exemplaireDao = new ExemplaireDao();
    }

    public boolean enregistrerLivre(Livre livre) {
        return livreDao.create(livre);
    }

    public boolean modifierLivre(Livre livre) {
        return livreDao.update(livre);
    }

    public boolean supprimerLivre(Livre livre) {
        return livreDao.delete(livre);
    }

    public Livre obtenirLivreParId(int identifiant) {
        return livreDao.getById(identifiant);
    }

    public List<Livre> obtenirTousLeslivres() {
        return livreDao.findAll();
    }

}
