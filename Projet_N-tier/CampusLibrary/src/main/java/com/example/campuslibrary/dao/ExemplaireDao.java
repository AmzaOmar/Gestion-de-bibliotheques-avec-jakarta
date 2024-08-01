package com.example.campuslibrary.dao;

import com.example.campuslibrary.connexion.Connexion;
import com.example.campuslibrary.models.Exemplaire;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ExemplaireDao implements IDao<Exemplaire> {

    @Override
    public boolean create(Exemplaire exemplaire) {
        String rqt = "INSERT INTO Exemplaire (reference_livre,validation) VALUES (?,?)";
        try (PreparedStatement stm = Connexion.getConnection().prepareStatement(rqt)) {
            stm.setInt(1, exemplaire.getReference_livre());
            stm.setString(2, exemplaire.getValidation());
            stm.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println("Erreur lors de l'enregistrement de l'exemplaire : " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean update(Exemplaire exemplaire) {
        String rqt = "UPDATE Exemplaire SET reference_livre=?,validation=? WHERE numero=?";
        try (PreparedStatement stm = Connexion.getConnection().prepareStatement(rqt)) {
            stm.setInt(1, exemplaire.getReference_livre());
            stm.setString(2, exemplaire.getValidation());
            stm.setInt(3, exemplaire.getNumero());
            int rowsUpdated = stm.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            System.err.println("Erreur lors de la mise à jour de l'exemplaire : " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean delete(Exemplaire exemplaire) {
        String rqt = "DELETE FROM exemplaire WHERE numero=?";
        try (PreparedStatement stm = Connexion.getConnection().prepareStatement(rqt)) {
            stm.setInt(1, exemplaire.getNumero());
            int rowsDeleted = stm.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            System.err.println("Erreur lors de la suppression de l'exemplaire : " + e.getMessage());
            return false;
        }
    }

    @Override
    public Exemplaire getById(int id) {
        String req = "SELECT * FROM exemplaire WHERE numero=?";
        Exemplaire exemplaire = null;
        try (PreparedStatement stm = Connexion.getConnection().prepareStatement(req)) {
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                int numero = rs.getInt("numero");
                int reference_livre = rs.getInt("reference_livre");
                String validation = rs.getString("validation");
                exemplaire = new Exemplaire(numero,reference_livre,validation);
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la récupération de l'exemplaire par ID : " + e.getMessage());
        }
        return exemplaire;
    }

    @Override
    public List<Exemplaire> findAll() {
        String req = "SELECT * FROM exemplaire";
        List<Exemplaire> list_exemplaire = new ArrayList<>();
        try (PreparedStatement stm = Connexion.getConnection().prepareStatement(req)) {
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                int numero = rs.getInt("numero");
                int reference_livre = rs.getInt("reference_livre");
                String validation = rs.getString("validation");
                list_exemplaire.add(new Exemplaire(numero, reference_livre,validation));
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la récupération de tous les exemplaires : " + e.getMessage());
        }
        return list_exemplaire;
    }

    public List<Exemplaire> findLivreById(int id) {
        String req = "SELECT * FROM exemplaire WHERE reference_livre=?";
        List<Exemplaire> list_exemplaire = new ArrayList<>();
        try (PreparedStatement stm = Connexion.getConnection().prepareStatement(req)) {
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                int numero = rs.getInt("numero");
                int reference_livre = rs.getInt("reference_livre");
                String validation = rs.getString("validation");
                list_exemplaire.add(new Exemplaire(numero, reference_livre,validation));
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la récupération de l'exemplaire par ID : " + e.getMessage());
        }
        System.out.println("Nombre d'exemplaires trouvés : " + list_exemplaire.size());
        return list_exemplaire;
    }

    public int trouverLeNombreDeReferenceLivre(int reference_livre) {
        String req = "SELECT COUNT(*) AS nombre_exemplaires FROM Exemplaire WHERE reference_livre = ?";
        int nombreExemplaires = 0;
        try (PreparedStatement stm = Connexion.getConnection().prepareStatement(req)) {
            stm.setInt(1, reference_livre);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                nombreExemplaires = rs.getInt("nombre_exemplaires");
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la récupération du nombre d'exemplaires : " + e.getMessage());
        }
        return nombreExemplaires;
    }
}
