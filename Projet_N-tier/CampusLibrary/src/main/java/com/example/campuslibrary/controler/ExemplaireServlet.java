package com.example.campuslibrary.controler;

import com.example.campuslibrary.models.Abonne;
import com.example.campuslibrary.models.Exemplaire;
import com.example.campuslibrary.models.Livre;
import com.example.campuslibrary.services.ServicesAbonne;
import com.example.campuslibrary.services.ServicesLivre;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.example.campuslibrary.services.ServicesExemplaire;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name="ExemplaireServlet", value="/exemplaire")
public class ExemplaireServlet extends HttpServlet {

    List<Exemplaire> exemplaires = new ArrayList<>();
    List<Livre> livres = new ArrayList<>();


    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        int reference_livre = Integer.parseInt(req.getParameter("reference_livre"));
        String validation=req.getParameter("validation");
        String action = req.getParameter("action");
        ServicesExemplaire service = new ServicesExemplaire();
        exemplaires = service.obtenirTousLesExemplaires();



        Exemplaire exemplaire = new Exemplaire();




        exemplaire.setReference_livre(reference_livre);
        exemplaire.setValidation(validation);
        boolean estCreer = service.enregistrerExemplaire(exemplaire);
        System.out.println(estCreer);
        req.setAttribute("exemplaires", exemplaires);
        for (Livre livre : livres) {
            System.out.println(livre.getIdentifiant());
        }
        req.getRequestDispatcher("listeExemplaire.jsp").forward(req, resp);

    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        ServicesExemplaire service = new ServicesExemplaire();
        ServicesAbonne servicesAbonne=new ServicesAbonne();
        exemplaires = service.obtenirTousLesExemplaires();
        if (action != null && action.equals("supp")) {
            int id1 = Integer.parseInt(req.getParameter("numero"));
            Exemplaire exemplaire1 = service.obtenirExemplaireParId(id1);
            System.out.println(id1);
            service.supprimerExemplaire(exemplaire1);
            List<Exemplaire> exemplaires = service.obtenirTousLesExemplaires();
            req.setAttribute("exemplaires", exemplaires);
            req.getRequestDispatcher("listeExemplaire.jsp").forward(req, resp);
        }
        if (action != null && action.equals("viewList")) {
            List<Exemplaire> exemplaires = service.obtenirTousLesExemplaires();
            req.setAttribute("exemplaires", exemplaires);
            req.getRequestDispatcher("listeExemplaire.jsp").forward(req, resp);
        }
        if (action != null && action.equals("modif")) {
            int id1 = Integer.parseInt(req.getParameter("numero"));
            Exemplaire exemplaire2 = service.obtenirExemplaireParId(id1);
            req.setAttribute("exemplaire2", exemplaire2);
            req.getRequestDispatcher("exemplaireModification.jsp").forward(req, resp);
        }
        if (action!=null && action.equals("exemplaire")){
            List<Exemplaire> exemplaires = service.obtenirTousLesExemplaires();
            req.setAttribute("exemplaires", exemplaires);
            req.getRequestDispatcher("listeExemplaire.jsp").forward(req, resp);
        }

        if(action!=null && action.equals("dashboard")){
            List<Abonne> abonnes = servicesAbonne.obtenirTousLesAbonnes();
            req.setAttribute("abonnes", abonnes);
            req.getRequestDispatcher("dashboard_bibliothecaire.jsp").forward(req, resp);
        }

    }
}
