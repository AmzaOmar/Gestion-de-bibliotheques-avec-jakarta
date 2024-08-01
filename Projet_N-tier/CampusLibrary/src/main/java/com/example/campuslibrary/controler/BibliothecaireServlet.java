package com.example.campuslibrary.controler;

import com.example.campuslibrary.models.Abonne;
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

@WebServlet(name="BibliothecaireServlet", value="/bibliothecaire")
public class BibliothecaireServlet extends HttpServlet {

    List<Bibliothecaire> bibliothecaires = new ArrayList<>();

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        String nom = req.getParameter("nom");
        String prenom = req.getParameter("prenom");
        String dateRecrutement = req.getParameter("date_recrutement");
        String adresse = req.getParameter("adresse");
        String email = req.getParameter("email");
        String action = req.getParameter("action");
        ServicesBibliothecaire service = new ServicesBibliothecaire();
        bibliothecaires = service.obtenirTousLesbibliothecaires();

        Bibliothecaire bibliothecaire = new Bibliothecaire();




        bibliothecaire.setNom(nom);
        bibliothecaire.setPrenom(prenom);
        bibliothecaire.setDate_recrutement(dateRecrutement);
        bibliothecaire.setAdresse(adresse);
        bibliothecaire.setEmail(email);
        boolean estCreer = service.enregistrerBibliothecaire(bibliothecaire);
        System.out.println(estCreer);
        req.setAttribute("bibliothecaires", bibliothecaires);
        for (int i = 0; i < bibliothecaires.size(); i++) {
            System.out.println(bibliothecaires.get(i).getId());
        }
        req.getRequestDispatcher("listeBibliothecaire.jsp").forward(req, resp);
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        ServicesBibliothecaire service = new ServicesBibliothecaire();
        bibliothecaires = service.obtenirTousLesbibliothecaires();
        if (action != null && action.equals("supp")) {
            int id1 = Integer.parseInt(req.getParameter("id"));
            Bibliothecaire bibliothecaire1 = service.obtenirBibliothecaireParId(id1);
            System.out.println(id1);
            service.desinscrireBibliothecaire(bibliothecaire1);
            List<Bibliothecaire> bibliothecaires = service.obtenirTousLesbibliothecaires();
            req.setAttribute("bibliothecaires", bibliothecaires);
            req.getRequestDispatcher("listeBibliothecaire.jsp").forward(req, resp);
        }
        if (action != null && action.equals("modif")) {
            int id1 = Integer.parseInt(req.getParameter("id"));
            Bibliothecaire bibliothecaire2 = service.obtenirBibliothecaireParId(id1);
            req.setAttribute("bibliothecaire2", bibliothecaire2);
            req.getRequestDispatcher("bibliothecaireModification.jsp").forward(req, resp);
        }
        if (action != null && action.equals("viewList")) {
            List<Bibliothecaire> bibliothecaires = service.obtenirTousLesbibliothecaires();
            req.setAttribute("bibliothecaires", bibliothecaires);
            req.getRequestDispatcher("listeAbonne.jsp").forward(req, resp);
        }
        if(action!=null && action.equals("bibliothecaire")){
            List<Bibliothecaire> bibliothecaires = service.obtenirTousLesbibliothecaires();
            req.setAttribute("bibliothecaires", bibliothecaires);
            req.getRequestDispatcher("listeBibliothecaire.jsp").forward(req, resp);
        }
    }
}
