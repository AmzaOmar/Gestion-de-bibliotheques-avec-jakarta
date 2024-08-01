package com.example.campuslibrary.dao;

import com.example.campuslibrary.connexion.Connexion;
import com.example.campuslibrary.models.Abonne;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AbonneDao implements IDao<Abonne> {


    public boolean create(Abonne abonne) {
        String rqt = "insert into abonne (prenom, nom, statut, institution, adresse_email) values (?, ?, ?, ?, ?)";
        try (PreparedStatement stm = Connexion.getConnection().prepareStatement(rqt)) {

            stm.setString(1, abonne.getPrenom());
            stm.setString(2, abonne.getNom());
            stm.setString(3, abonne.getStatut());
            stm.setString(4, abonne.getInstitution());
            stm.setString(5, abonne.getAdresse_email());

            stm.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println("Erreur lors de la création de l'abonné : " + e.getMessage());
            return false;
        }
    }

    public boolean update(Abonne abonne) {
        String rqt = "update abonne set prenom=?, nom=?, statut=?, institution=?, adresse_email=? where numero_abonnement=?";
        try (PreparedStatement stm = Connexion.getConnection().prepareStatement(rqt)) {
            stm.setString(1, abonne.getPrenom());
            stm.setString(2, abonne.getNom());
            stm.setString(3, abonne.getStatut());
            stm.setString(4, abonne.getInstitution());
            stm.setString(5, abonne.getAdresse_email());
            stm.setInt(6, abonne.getNumero_abonnement());

            int rowsUpdated = stm.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            System.err.println("Erreur lors de la mise à jour de l'abonné : " + e.getMessage());
            return false;
        }
    }

    public boolean delete(Abonne abonne) {
        String rqt = "delete from abonne where numero_abonnement=?";
        try (PreparedStatement stm = Connexion.getConnection().prepareStatement(rqt)) {
            stm.setInt(1, abonne.getNumero_abonnement());

            int rowsDeleted = stm.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            System.err.println("Erreur lors de la suppression de l'abonné : " + e.getMessage());
            return false;
        }
    }

    public Abonne getById(int id) {
        String req = "select * from abonne where numero_abonnement=?";
        Abonne abonne = null;
        try (PreparedStatement stm = Connexion.getConnection().prepareStatement(req)) {
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();

            if (rs.next()) {
                int numero_abonnement = rs.getInt("numero_abonnement");
                String prenom = rs.getString("prenom");
                String nom = rs.getString("nom");
                String statut = rs.getString("statut");
                String institution = rs.getString("institution");
                String adresse_email = rs.getString("adresse_email");
                abonne = new Abonne(numero_abonnement, prenom, nom, statut, institution, adresse_email);
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la récupération de l'abonné par ID : " + e.getMessage());
        }

        return abonne;
    }

    public List<Abonne> findAll() {
        String req = "select * from abonne";
        List<Abonne> list_abonne = new ArrayList<>();
        try (PreparedStatement stm = Connexion.getConnection().prepareStatement(req)) {
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                int numero_abonnement = rs.getInt("numero_abonnement");
                String prenom = rs.getString("prenom");
                String nom = rs.getString("nom");
                String statut = rs.getString("statut");
                String institution = rs.getString("institution");
                String email = rs.getString("adresse_email");
                list_abonne.add(new Abonne(numero_abonnement, prenom, nom, statut, institution, email));
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la récupération de tous les abonnés : " + e.getMessage());
        }

        return list_abonne;
    }
}
