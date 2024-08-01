package com.example.campuslibrary.dao;

import java.util.Date;
import com.example.campuslibrary.connexion.Connexion;
import com.example.campuslibrary.models.Abonne;
import com.example.campuslibrary.models.Bibliothecaire;
import com.example.campuslibrary.models.Bibliothecaire;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BibliothecaireDao implements IDao<Bibliothecaire> {
    public boolean create(Bibliothecaire bibliothecaire) {
        String rqt = "insert into Bibliothecaire (prenom, nom, date_recrutement, adresse, adresse_email) values (?, ?, ?, ?, ?)";
        try (PreparedStatement stm = Connexion.getConnection().prepareStatement(rqt)) {
            stm.setString(1, bibliothecaire.getPrenom());
            stm.setString(2, bibliothecaire.getNom());
            stm.setString(3, bibliothecaire.getDate_recrutement());
            stm.setString(4, bibliothecaire.getAdresse());
            stm.setString(5, bibliothecaire.getEmail());

            stm.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println("Erreur lors de l'enregistrement du bibliothecaire : " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean update(Bibliothecaire bibliothecaire) {
        String rqt = "update bibliothecaire set prenom=?, nom=?, date_recrutement=?, adresse=?, adresse_email=? where identifiant=?";
        try (PreparedStatement stm = Connexion.getConnection().prepareStatement(rqt)) {
            stm.setString(1, bibliothecaire.getPrenom());
            stm.setString(2, bibliothecaire.getNom());
            stm.setString(3, bibliothecaire.getDate_recrutement());
            stm.setString(4, bibliothecaire.getAdresse());
            stm.setString(5, bibliothecaire.getEmail());
            stm.setInt(6, bibliothecaire.getId());

            int rowsUpdated = stm.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            System.err.println("Erreur lors de la mise à jour du bibliothecaire : " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean delete(Bibliothecaire bibliothecaire) {
        String rqt = "delete from bibliothecaire where identifiant=?";
        try (PreparedStatement stm = Connexion.getConnection().prepareStatement(rqt)) {
            stm.setInt(1, bibliothecaire.getId());

            int rowsDeleted = stm.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            System.err.println("Erreur lors de la suppression du bibliothecaire : " + e.getMessage());
            return false;
        }
    }

    @Override
    public Bibliothecaire getById(int id1) {
        String req = "select * from bibliothecaire where identifiant=?";
        Bibliothecaire bibliothecaire = null;
        try (PreparedStatement stm = Connexion.getConnection().prepareStatement(req)) {
            stm.setInt(1, id1);
            ResultSet rs = stm.executeQuery();

            if (rs.next()) {
                int id = rs.getInt("identifiant");
                String prenom = rs.getString("prenom");
                String nom = rs.getString("nom");
                String date_recrutement = rs.getString("date_recrutement");
                String adresse = rs.getString("adresse");
                String adresse_email = rs.getString("adresse_email");
                bibliothecaire = new Bibliothecaire(id, prenom, nom, date_recrutement, adresse, adresse_email);
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la récupération du bibliothecaire par ID : " + e.getMessage());
        }

        return bibliothecaire;
    }

    @Override
    public List<Bibliothecaire> findAll() {
        String req = "select * from bibliothecaire";
        List<Bibliothecaire> list_bibliothecaire = new ArrayList<>();
        try (PreparedStatement stm = Connexion.getConnection().prepareStatement(req)) {
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("identifiant");
                String prenom = rs.getString("prenom");
                String nom = rs.getString("nom");
                String date_recrutement = rs.getString("date_recrutement");
                String adresse = rs.getString("adresse");
                String adresse_email = rs.getString("adresse_email");
                list_bibliothecaire.add(new Bibliothecaire(id, prenom, nom, date_recrutement, adresse, adresse_email));
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la récupération de tous les bibliothecaire : " + e.getMessage());
        }

        return list_bibliothecaire;
    }
}

