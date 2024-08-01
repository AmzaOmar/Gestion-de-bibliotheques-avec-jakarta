package com.example.campuslibrary.controler;

import com.example.campuslibrary.models.Emprunt;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.example.campuslibrary.services.ServicesEmprunt;

import java.io.IOException;
import java.util.List;
@WebServlet(name = "UpdateEmprunt", value="/updateEmprunt")
public class UpdateEmprunt extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        ServicesEmprunt serviceEmprunt= new ServicesEmprunt();
        int id_emprunt= Integer.parseInt(req.getParameter("id_emprunt"));
        int numeroAbonnement = Integer.parseInt(req.getParameter("numero_abonnement"));
        int id_exemplaire = Integer.parseInt(req.getParameter("id_exemplaire"));
        String dateEmprunt = req.getParameter("date_emprunt");
        String dateRetourPrevue = req.getParameter("date_retour_prevue");
        String date_retour= req.getParameter("date_retour");

        String action = req.getParameter("action");

        Emprunt emprunt = new Emprunt(id_emprunt,numeroAbonnement, id_exemplaire, dateEmprunt, dateRetourPrevue,date_retour);


        boolean estModifier = serviceEmprunt.modifierEmprunt(emprunt);
        System.out.println(estModifier);




        // Redirection vers la liste des emprunts
        List<Emprunt> emprunts = serviceEmprunt.obtenirTousLesEmprunts();
        req.setAttribute("emprunts", emprunts);
        req.getRequestDispatcher("listeEmprunt.jsp").forward(req, resp);
    }
}
