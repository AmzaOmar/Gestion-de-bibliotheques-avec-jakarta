package com.example.campuslibrary.controler;

import com.example.campuslibrary.models.Abonne;
import com.example.campuslibrary.models.Emprunt;
import com.example.campuslibrary.services.ServicesAbonne;
import com.example.campuslibrary.services.ServicesEmprunt;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name="EmpruntServlet", value="/emprunt")
public class EmpruntServlet extends HttpServlet {

    private ServicesEmprunt serviceEmprunt;

    @Override
    public void init() throws ServletException {
        serviceEmprunt = new ServicesEmprunt(); // Initialisation du service
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        int numeroAbonnement = Integer.parseInt(req.getParameter("numero_abonnement"));
        int id_exemplaire = Integer.parseInt(req.getParameter("id_exemplaire"));
        String dateEmprunt = req.getParameter("date_emprunt");
        String dateRetourPrevue = req.getParameter("date_retour_prevue");

        String action = req.getParameter("action");

        Emprunt emprunt = new Emprunt(numeroAbonnement, id_exemplaire, dateEmprunt, dateRetourPrevue);


            boolean estCreer = serviceEmprunt.enregistrerEmprunt(emprunt);
            System.out.println(estCreer);




        // Redirection vers la liste des emprunts
        List<Emprunt> emprunts = serviceEmprunt.obtenirTousLesEmprunts();
        req.setAttribute("emprunts", emprunts);
        req.getRequestDispatcher("listeEmprunt.jsp").forward(req, resp);
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServicesAbonne servicesAbonne=new ServicesAbonne();
        String action = req.getParameter("action");
        if ("supp".equals(action)) {
            int idEmprunt = Integer.parseInt(req.getParameter("id_emprunt"));
            Emprunt emprunt = serviceEmprunt.obtenirEmpruntParId(idEmprunt);
            if (emprunt != null) {
                serviceEmprunt.supprimerEmprunt(emprunt);
            }

            List<Emprunt> emprunts = serviceEmprunt.obtenirTousLesEmprunts();
            req.setAttribute("emprunts", emprunts);
            req.getRequestDispatcher("listeEmprunt.jsp").forward(req, resp);
        } if ("modif".equals(action)) {
            int idEmprunt = Integer.parseInt(req.getParameter("id_emprunt"));
            Emprunt emprunt = serviceEmprunt.obtenirEmpruntParId(idEmprunt);
            req.setAttribute("emprunt", emprunt);
            req.getRequestDispatcher("empruntModification.jsp").forward(req, resp);
        } if ("viewList".equals(action)) {
            List<Emprunt> emprunts = serviceEmprunt.obtenirTousLesEmprunts();
            req.setAttribute("emprunts", emprunts);
            req.getRequestDispatcher("listeEmprunt.jsp").forward(req, resp);
        } if ("emprunt".equals(action)) {
            List<Emprunt> emprunts = serviceEmprunt.obtenirTousLesEmprunts();
            req.setAttribute("emprunts", emprunts);
            req.getRequestDispatcher("listeEmprunt.jsp").forward(req, resp);
        }
        if(action!=null && action.equals("dashboard")){
            List<Abonne> abonnes = servicesAbonne.obtenirTousLesAbonnes();
            req.setAttribute("abonnes", abonnes);
            req.getRequestDispatcher("dashboard_bibliothecaire.jsp").forward(req, resp);
        }
        if ("retour".equals(action)) {
            int idEmprunt = Integer.parseInt(req.getParameter("id_emprunt"));
            Emprunt emprunt = serviceEmprunt.obtenirEmpruntParId(idEmprunt);
            serviceEmprunt.retournerEmprunt(emprunt);
            List<Emprunt> emprunts = serviceEmprunt.obtenirTousLesEmprunts();
            req.setAttribute("emprunts", emprunts);
            req.getRequestDispatcher("listeEmprunt.jsp").forward(req, resp);

        }
    }
}
