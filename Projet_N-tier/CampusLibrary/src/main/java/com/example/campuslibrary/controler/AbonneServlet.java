package com.example.campuslibrary.controler;

import com.example.campuslibrary.models.Abonne;
import com.example.campuslibrary.services.ServicesAbonne;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name="AbonneServlet", value="/abonne")
public class AbonneServlet extends HttpServlet {

    List<Abonne> abonnes = new ArrayList<>();


    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        String nom = req.getParameter("nom");
        String prenom = req.getParameter("prenom");
        String statut = req.getParameter("statut");
        String institution = req.getParameter("institution");
        String adresse_email = req.getParameter("adresse_email");
        String action = req.getParameter("action");
        ServicesAbonne service = new ServicesAbonne();
        abonnes = service.obtenirTousLesAbonnes();

        Abonne abonne = new Abonne();




        abonne.setNom(nom);
        abonne.setPrenom(prenom);
        abonne.setStatut(statut);
        abonne.setInstitution(institution);
        abonne.setAdresse_email(adresse_email);
        boolean estCreer = service.inscrireAbonne(abonne);
        System.out.println(estCreer);
        req.setAttribute("abonnes", abonnes);
        req.getRequestDispatcher("listeAbonne.jsp").forward(req, resp);
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        ServicesAbonne service = new ServicesAbonne();
        abonnes = service.obtenirTousLesAbonnes();
        if (action != null && action.equals("supp")) {
            int id1 = Integer.parseInt(req.getParameter("numero_abonnement"));
            Abonne abonne1 = service.obtenirAbonneParId(id1);
            System.out.println(id1);
            service.desinscrireAbonne(abonne1);
            List<Abonne> abonnes = service.obtenirTousLesAbonnes();
            req.setAttribute("abonnes", abonnes);
            req.getRequestDispatcher("listeAbonne.jsp").forward(req, resp);
        }else if(action!=null && action.equals("modif")){
            int id1=Integer.parseInt(req.getParameter("identifiant"));
            Abonne abonne2=service.obtenirAbonneParId(id1);
            req.setAttribute("abonne2",abonne2);
            req.getRequestDispatcher("abonneModification.jsp").forward(req,resp);
        }

        if(action!=null && action.equals("abonne")){
            List<Abonne> abonnes = service.obtenirTousLesAbonnes();
            req.setAttribute("abonnes", abonnes);
            req.getRequestDispatcher("listeAbonne.jsp").forward(req, resp);
        }
        if(action!=null && action.equals("dashboard")){
            List<Abonne> abonnes = service.obtenirTousLesAbonnes();
            req.setAttribute("abonnes", abonnes);
            req.getRequestDispatcher("dashboard_bibliothecaire.jsp").forward(req, resp);
        }

    }
}

