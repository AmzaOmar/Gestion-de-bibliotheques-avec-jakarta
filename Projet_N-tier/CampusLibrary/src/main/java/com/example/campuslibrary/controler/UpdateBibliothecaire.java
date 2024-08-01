package com.example.campuslibrary.controler;

import com.example.campuslibrary.models.Bibliothecaire;
import com.example.campuslibrary.services.ServicesBibliothecaire;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
@WebServlet(name="UpdateBibliothecaire", value="/updateBibliothecaire")
public class UpdateBibliothecaire extends HttpServlet {
    List<Bibliothecaire> bibliothecaires = new ArrayList<>();
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        int id = Integer.parseInt(req.getParameter("id"));
        String nom = req.getParameter("nom");
        String prenom = req.getParameter("prenom");
        String dateRecrutement = req.getParameter("date_recrutement");
        String adresse = req.getParameter("adresse");
        String email = req.getParameter("email");
        String action = req.getParameter("action");
        ServicesBibliothecaire service = new ServicesBibliothecaire();
        bibliothecaires = service.obtenirTousLesbibliothecaires();

        Bibliothecaire bibliothecaire = new Bibliothecaire();


        bibliothecaire.setId(id);
        bibliothecaire.setNom(nom);
        bibliothecaire.setPrenom(prenom);
        bibliothecaire.setDate_recrutement(dateRecrutement);
        bibliothecaire.setAdresse(adresse);
        bibliothecaire.setEmail(email);
        boolean estCreer = service.modifierBibliothecaire(bibliothecaire);
        System.out.println(estCreer);
        req.setAttribute("bibliothecaires", bibliothecaires);
        for (int i = 0; i < bibliothecaires.size(); i++) {
            System.out.println(bibliothecaires.get(i).getId());
        }
        req.getRequestDispatcher("listeBibliothecaire.jsp").forward(req, resp);
    }
}
