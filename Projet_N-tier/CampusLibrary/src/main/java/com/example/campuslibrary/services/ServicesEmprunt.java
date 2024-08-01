package com.example.campuslibrary.services;

import com.example.campuslibrary.dao.EmpruntDao;
import com.example.campuslibrary.models.Emprunt;
import com.example.campuslibrary.dao.ExemplaireDao;
import com.example.campuslibrary.models.Exemplaire;


import java.util.ArrayList;
import java.util.List;

public class ServicesEmprunt {
    private EmpruntDao empruntDao;
    private ExemplaireDao exemplaireDao=new ExemplaireDao();

    public ServicesEmprunt() {

        this.empruntDao = new EmpruntDao(); // Initialisation de empruntDao
    }

    public boolean enregistrerEmprunt(Emprunt emprunt) {
        Exemplaire exemplaire = exemplaireDao.getById(emprunt.getid_exemplaire());


        if (exemplaire == null) {
            System.err.println("Exemplaire non trouvé.");
            return false;
        } else if (exemplaire.getValidation().equals("non")) {
            return false;
        }

        Exemplaire exemplaire1=new Exemplaire(exemplaire.getNumero(), exemplaire.getReference_livre(),"non");
        boolean estModifie=exemplaireDao.update(exemplaire1);

        return empruntDao.create(emprunt);
    }
    public boolean retournerEmprunt(Emprunt emprunt) {
        Exemplaire exemplaire = exemplaireDao.getById(emprunt.getid_exemplaire());
        if (exemplaire == null) {
            System.err.println("Exemplaire non trouvé.");
            return false;
        } else if (exemplaire.getValidation().equals("oui")) {
            return false;
        }
        Emprunt emprunt1=new Emprunt(emprunt.getId_emprunt(),emprunt.getNumero_abonnement(),emprunt.getid_exemplaire(),emprunt.getDate_emprunt(),emprunt.getDate_retour_prevue(), new java.text.SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date()));
        Exemplaire exemplaire1=new Exemplaire(exemplaire.getNumero(), exemplaire.getReference_livre(),"oui");
        boolean modifie=exemplaireDao.update(exemplaire1);
        System.out.println("modif"+modifie);
        return empruntDao.update(emprunt1);
    }


    public boolean modifierEmprunt(Emprunt emprunt) {
        return empruntDao.update(emprunt);
    }

    public boolean supprimerEmprunt(Emprunt emprunt) {
        Exemplaire exemplaire = exemplaireDao.getById(emprunt.getid_exemplaire());
        Exemplaire exemplaire1=new Exemplaire(exemplaire.getNumero(), exemplaire.getReference_livre(),"oui");
        boolean estModifie=exemplaireDao.update(exemplaire1);
        return empruntDao.delete(emprunt);
    }

    public Emprunt obtenirEmpruntParId(int id) {
        return empruntDao.getById(id);
    }

    public List<Emprunt> obtenirTousLesEmprunts() {
        return empruntDao.findAll();
    }
    public boolean estExemplaireDisponible(int idExemplaire) {
        Exemplaire exemplaire = exemplaireDao.getById(idExemplaire);
        return exemplaire != null && exemplaire.getValidation().equals("oui");
    }
}
