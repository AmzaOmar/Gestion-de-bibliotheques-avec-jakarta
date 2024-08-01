package com.example.campuslibrary.controler;

import com.example.campuslibrary.models.Livre;
import com.example.campuslibrary.services.ServicesLivre;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name="UpdateLivre", value="/updateLivre")
public class UpdateLivre extends HttpServlet {
    List<Livre> livres = new ArrayList<>();
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        int identifiant = Integer.parseInt(req.getParameter("identifiant"));
        String titre = req.getParameter("titre");
        String auteurs = req.getParameter("auteurs");
        String anneePublication = req.getParameter("annee_publication");
        String domaine = req.getParameter("domaine");
        String niveau = req.getParameter("niveau");
        String action = req.getParameter("action");
        ServicesLivre service = new ServicesLivre();
        livres = service.obtenirTousLeslivres();

        Livre livre = new Livre();



        livre.setIdentifiant(identifiant);
        livre.setTitre(titre);
        livre.setAuteurs(auteurs);
        livre.setAnnee_publication(anneePublication);
        livre.setDomaine(domaine);
        livre.setNiveau(niveau);
        boolean estCreer = service.modifierLivre(livre);
        System.out.println(estCreer);
        req.setAttribute("livres", livres);
        req.getRequestDispatcher("listeLivre.jsp").forward(req, resp);

    }
}
