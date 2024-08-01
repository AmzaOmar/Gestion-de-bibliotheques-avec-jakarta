package com.example.campuslibrary.dao;

import com.example.campuslibrary.connexion.Connexion;
import com.example.campuslibrary.models.Emprunt;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmpruntDao implements IDao<Emprunt> {

    @Override
    public boolean create(Emprunt emprunt) {
        String query = "INSERT INTO Emprunt (numero_abonnement, id_exemplaire, date_emprunt, date_retour_prevue) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = Connexion.getConnection().prepareStatement(query)) {
            stmt.setInt(1, emprunt.getNumero_abonnement());
            stmt.setInt(2, emprunt.getid_exemplaire());
            stmt.setString(3, emprunt.getDate_emprunt());
            stmt.setString(4, emprunt.getDate_retour_prevue());


            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println("Erreur lors de l'enregistrement de l'emprunt : " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean update(Emprunt emprunt) {
        String query = "UPDATE Emprunt SET numero_abonnement=?, id_exemplaire=?, date_emprunt=?, date_retour_prevue=?, date_retour=? WHERE id_emprunt=?";
        try (PreparedStatement stmt = Connexion.getConnection().prepareStatement(query)) {
            stmt.setInt(1, emprunt.getNumero_abonnement());
            stmt.setInt(2, emprunt.getid_exemplaire());
            stmt.setString(3, emprunt.getDate_emprunt());
            stmt.setString(4, emprunt.getDate_retour_prevue());
            stmt.setString(5, emprunt.getDate_retour());
            stmt.setInt(6, emprunt.getId_emprunt());

            int rowsUpdated = stmt.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            System.err.println("Erreur lors de la mise à jour de l'emprunt : " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean delete(Emprunt emprunt) {
        String query = "DELETE FROM Emprunt WHERE id_emprunt=?";
        try (PreparedStatement stmt = Connexion.getConnection().prepareStatement(query)) {
            stmt.setInt(1, emprunt.getId_emprunt());

            int rowsDeleted = stmt.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            System.err.println("Erreur lors de la suppression de l'emprunt : " + e.getMessage());
            return false;
        }
    }

    @Override
    public Emprunt getById(int id) {
        String query = "SELECT * FROM Emprunt WHERE id_emprunt=?";
        Emprunt emprunt = null;
        try (PreparedStatement stmt = Connexion.getConnection().prepareStatement(query)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                int id_emprunt = rs.getInt("id_emprunt");
                int numero_abonnement = rs.getInt("numero_abonnement");
                int id_exemplaire = rs.getInt("id_exemplaire");
                String date_emprunt = rs.getString("date_emprunt");
                String date_retour_prevue = rs.getString("date_retour_prevue");
                String date_retour = rs.getString("date_retour");
                emprunt = new Emprunt(id_emprunt, numero_abonnement, id_exemplaire, date_emprunt, date_retour_prevue, date_retour);
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la récupération de l'emprunt par ID : " + e.getMessage());
        }

        return emprunt;
    }

    @Override
    public List<Emprunt> findAll() {
        String query = "SELECT * FROM Emprunt";
        List<Emprunt> emprunts = new ArrayList<>();
        try (PreparedStatement stmt = Connexion.getConnection().prepareStatement(query)) {
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int id_emprunt = rs.getInt("id_emprunt");
                int numero_abonnement = rs.getInt("numero_abonnement");
                int id_exemplaire = rs.getInt("id_exemplaire");
                String date_emprunt = rs.getString("date_emprunt");
                String date_retour_prevue = rs.getString("date_retour_prevue");
                String date_retour = rs.getString("date_retour");
                Emprunt emprunt = new Emprunt(id_emprunt, numero_abonnement, id_exemplaire, date_emprunt, date_retour_prevue, date_retour);
                emprunts.add(emprunt);
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la récupération de tous les emprunts : " + e.getMessage());
        }

        return emprunts;
    }
}
