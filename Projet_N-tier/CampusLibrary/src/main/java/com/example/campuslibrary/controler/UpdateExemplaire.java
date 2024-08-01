package com.example.campuslibrary.controler;

import com.example.campuslibrary.models.Exemplaire;
import com.example.campuslibrary.models.Livre;
import com.example.campuslibrary.services.ServicesExemplaire;
import com.example.campuslibrary.services.ServicesLivre;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
@WebServlet(name="UpdateExemplaire", value="/updateExemplaire")
public class UpdateExemplaire extends HttpServlet {
    List<Exemplaire> exemplaires = new ArrayList<>();
    List<Livre> livres = new ArrayList<>();
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        int numero = Integer.parseInt(req.getParameter("numero"));
        int reference_livre = Integer.parseInt( req.getParameter("reference_livre"));
        String action = req.getParameter("action");
        ServicesExemplaire service = new ServicesExemplaire();
        ServicesLivre serviceLivre = new ServicesLivre();
        exemplaires = service.obtenirTousLesExemplaires();



        Exemplaire exemplaire = new Exemplaire();




        exemplaire.setReference_livre(reference_livre);
        boolean estCreer = service.modifierExemplaire(exemplaire);
        System.out.println(estCreer);
        req.setAttribute("exemplaires", exemplaires);

        req.getRequestDispatcher("listeExemplaire.jsp").forward(req, resp);

    }
}
