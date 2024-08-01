package com.example.campuslibrary.controler;

import com.example.campuslibrary.models.Abonne;
import com.example.campuslibrary.models.Exemplaire;
import com.example.campuslibrary.models.Livre;
import com.example.campuslibrary.services.ServicesLivre;
import com.example.campuslibrary.services.ServicesAbonne;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name="LivreServlet", value="/livre")
public class LivreServlet extends HttpServlet {

    List<Livre> livres = new ArrayList<>();

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        String titre = req.getParameter("titre");
        String auteurs = req.getParameter("auteurs");
        String anneePublication = req.getParameter("annee_publication");
        String domaine = req.getParameter("domaine");
        String niveau = req.getParameter("niveau");
        String action = req.getParameter("action");
        ServicesLivre service = new ServicesLivre();


        livres = service.obtenirTousLeslivres();

        Livre livre = new Livre();





        livre.setTitre(titre);
        livre.setAuteurs(auteurs);
        livre.setAnnee_publication(anneePublication);
        livre.setDomaine(domaine);
        livre.setNiveau(niveau);
        boolean estCreer = service.enregistrerLivre(livre);
        System.out.println(estCreer);
        req.setAttribute("livres", livres);
        req.getRequestDispatcher("listeLivre.jsp").forward(req, resp);

    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        ServicesLivre service = new ServicesLivre();
        ServicesAbonne servicesAbonne=new ServicesAbonne();
        livres = service.obtenirTousLeslivres();
        if (action != null && action.equals("supp")) {
            int id = Integer.parseInt(req.getParameter("identifiant"));
            Livre livre1 = service.obtenirLivreParId(id);
            System.out.println(id);
            service.supprimerLivre(livre1);
            List<Livre> livres = service.obtenirTousLeslivres();
            req.setAttribute("livres", livres);
            req.getRequestDispatcher("listeLivre.jsp").forward(req, resp);

        }else if (action != null && action.equals("modif")) {
            int id = Integer.parseInt(req.getParameter("identifiant"));
            Livre livre2 = service.obtenirLivreParId(id);
            req.setAttribute("livre2", livre2);
            req.getRequestDispatcher("livreModification.jsp").forward(req, resp);
        }
        if (action != null && action.equals("livre")) {
            List<Livre> livres = service.obtenirTousLeslivres();
            req.setAttribute("livres", livres);
            req.getRequestDispatcher("listeLivre.jsp").forward(req, resp);

        }
        if (action!=null && action.equals("exemplaire")){
            List<Livre> livres = service.obtenirTousLeslivres();
            req.setAttribute("livres", livres);
            req.getRequestDispatcher("listeExemplaire.jsp").forward(req, resp);
        }
        if(action!=null && action.equals("dashboard")){
            List<Abonne> abonnes = servicesAbonne.obtenirTousLesAbonnes();
            req.setAttribute("abonnes", abonnes);
            req.getRequestDispatcher("dashboard_bibliothecaire.jsp").forward(req, resp);
        }

    }

}
