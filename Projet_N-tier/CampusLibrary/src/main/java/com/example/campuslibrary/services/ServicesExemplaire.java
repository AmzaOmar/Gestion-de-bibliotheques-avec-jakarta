package com.example.campuslibrary.services;

import com.example.campuslibrary.dao.ExemplaireDao;
import com.example.campuslibrary.models.Exemplaire;
import com.example.campuslibrary.models.Livre;
import com.example.campuslibrary.dao.LivreDao;

import java.util.List;

public class ServicesExemplaire {
    ExemplaireDao exemplaireDao;
    public ServicesExemplaire() {

        exemplaireDao = new ExemplaireDao();
    }
    public boolean enregistrerExemplaire(Exemplaire exemplaire) {

        return exemplaireDao.create(exemplaire);
    }

    public boolean modifierExemplaire(Exemplaire exemplaire) {

        return exemplaireDao.update(exemplaire);
    }

    public boolean supprimerExemplaire(Exemplaire exemplaire) {

        return exemplaireDao.delete(exemplaire);
    }

    public Exemplaire obtenirExemplaireParId(int id){

        return exemplaireDao.getById(id);
    }

    public List<Exemplaire> obtenirTousLesExemplaires(){
        return exemplaireDao.findAll();
    }
    public int nombreExemplaire(int livre){

        return exemplaireDao.trouverLeNombreDeReferenceLivre(livre);
    }
    public String trouverLivre(int idlivre){
        LivreDao livreDao =new LivreDao();
        Livre livre=new Livre();
        livre=livreDao.getById(idlivre);
        return livre.getTitre();
    }
}
