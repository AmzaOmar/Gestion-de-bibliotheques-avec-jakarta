package com.example.campuslibrary.controler;

import com.example.campuslibrary.models.Abonne;
import com.example.campuslibrary.services.ServicesAbonne;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.*;

import java.io.IOException;
@WebServlet(name = "UpdateAbonne",value = "/updateAbonne")
public class UpdateAbonne extends HttpServlet {

    private List<Abonne> abonnes = new ArrayList<>();

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        int numero_abonnement = Integer.parseInt(req.getParameter("id"));
        String nom = req.getParameter("nom");
        String prenom = req.getParameter("prenom");
        String statut = req.getParameter("statut");
        String institution = req.getParameter("institution");
        String adresse_email = req.getParameter("adresse_email");
        String action = req.getParameter("action");
        ServicesAbonne service = new ServicesAbonne();
        abonnes = service.obtenirTousLesAbonnes();

        Abonne abonne = new Abonne();
        abonne.setNumero_abonnement(numero_abonnement);
        abonne.setNom(nom);
        abonne.setPrenom(prenom);
        abonne.setStatut(statut);
        abonne.setInstitution(institution);
        abonne.setAdresse_email(adresse_email);
        boolean estCreer = service.modifierAbonne(abonne);
        System.out.println(estCreer);
        req.setAttribute("abonnes", abonnes);
        req.getRequestDispatcher("listeAbonne.jsp").forward(req, resp);
    }
}
