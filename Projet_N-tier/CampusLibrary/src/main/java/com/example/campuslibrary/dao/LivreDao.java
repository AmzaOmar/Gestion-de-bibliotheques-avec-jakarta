package com.example.campuslibrary.dao;

import java.util.Date;
import com.example.campuslibrary.connexion.Connexion;
import com.example.campuslibrary.models.Abonne;
import com.example.campuslibrary.models.Livre;
import com.example.campuslibrary.models.Livre;
import com.example.campuslibrary.models.Livre;
import com.example.campuslibrary.models.Livre;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LivreDao implements IDao<Livre>{
    public boolean create(Livre livre) {
        String rqt = "insert into livre (titre, auteurs, annee_publication, domaine, niveau) values (?, ?, ?, ?, ?)";
        try (PreparedStatement stm = Connexion.getConnection().prepareStatement(rqt)) {

            stm.setString(1, livre.getTitre());
            stm.setString(2, livre.getAuteurs());
            stm.setString(3, livre.getAnnee_publication());
            stm.setString(4, livre.getDomaine());
            stm.setString(5, livre.getNiveau());

            stm.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println("Erreur lors de l'enregistrement du livre : " + e.getMessage());
            return false;
        }
    }

    public boolean update(Livre livre) {
        String rqt = "update livre set titre=?, auteurs=?, annee_publication=?, domaine=?, niveau=? where identifiant=?";
        try (PreparedStatement stm = Connexion.getConnection().prepareStatement(rqt)) {
            stm.setString(1, livre.getTitre());
            stm.setString(2, livre.getAuteurs());
            stm.setString(3, livre.getAnnee_publication());
            stm.setString(4, livre.getDomaine());
            stm.setString(5, livre.getNiveau());
            stm.setInt(6, livre.getIdentifiant());


            int rowsUpdated = stm.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            System.err.println("Erreur lors de la mise à jour du livre : " + e.getMessage());
            return false;
        }
    }

    public boolean delete(Livre livre) {
        // Début de la transaction
        try {
            // Suppression des exemplaires associés au livre
            String deleteExemplairesQuery = "delete from exemplaire where reference_livre=?";
            try (PreparedStatement stm = Connexion.getConnection().prepareStatement(deleteExemplairesQuery)) {
                stm.setInt(1, livre.getIdentifiant()); // Remplacez ceci par la colonne appropriée pour faire correspondre les exemplaires au livre
                stm.executeUpdate();
            }

            // Suppression du livre
            String deleteLivreQuery = "delete from livre where identifiant=?";
            try (PreparedStatement stm = Connexion.getConnection().prepareStatement(deleteLivreQuery)) {
                stm.setInt(1, livre.getIdentifiant());
                int rowsDeleted = stm.executeUpdate();
                return rowsDeleted > 0;
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la suppression du livre : " + e.getMessage());
            return false;
        }
    }


    public Livre getById(int id) {
        String req = "select * from livre where identifiant=?";
        Livre livre = null;
        try (PreparedStatement stm = Connexion.getConnection().prepareStatement(req)) {
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();

            if (rs.next()) {
                int identifiant = rs.getInt("identifiant");
                String titre = rs.getString("titre");
                String auteurs = rs.getString("auteurs");
                String annee_publication = rs.getString("annee_publication");
                String domaine = rs.getString("domaine");
                String niveau = rs.getString("niveau");
                livre = new Livre(identifiant, titre, auteurs, annee_publication, domaine, niveau);
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la récupération du livre par ID : " + e.getMessage());
        }

        return livre;
    }

    public List<Livre> findAll() {
        String req = "select * from livre";
        List<Livre> list_livre = new ArrayList<>();
        try (PreparedStatement stm = Connexion.getConnection().prepareStatement(req)) {
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                int identifiant = rs.getInt("identifiant");
                String titre = rs.getString("titre");
                String auteurs = rs.getString("auteurs");
                String annee_publication = rs.getString("annee_publication");
                String domaine = rs.getString("domaine");
                String niveau = rs.getString("niveau");
                list_livre.add(new Livre(identifiant, titre, auteurs, annee_publication, domaine, niveau));
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la récupération de tous les livres : " + e.getMessage());
        }

        return list_livre;
    }}
