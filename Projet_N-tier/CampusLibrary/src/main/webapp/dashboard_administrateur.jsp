<%--
  Created by IntelliJ IDEA.
  User: Amza
  Date: 16/07/2024
  Time: 20:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.example.campuslibrary.services.ServicesBibliothecaire" %>
<%@ page import="com.example.campuslibrary.models.Bibliothecaire" %>
<%@ page import="java.util.List" %>

<%
  // Appel du service pour obtenir la liste des bibliothecaires
  ServicesBibliothecaire serviceBibliothecaire = new ServicesBibliothecaire();
  List<Bibliothecaire> bibliothecaires = serviceBibliothecaire.obtenirTousLesbibliothecaires();
  request.setAttribute("bibliothecaires", bibliothecaires);
%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge" />
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
  <meta name="description" content="" />
  <meta name="author" content="" />
  <title>Dashboard - SB Admin</title>
  <link href="assets/img/book.ico" rel="icon">
  <link href="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/style.min.css" rel="stylesheet" />
  <link href="assets/css/dashboard.css" rel="stylesheet" />
  <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
</head>
<body class="sb-nav-fixed">


<div id="layoutSidenav_content">
  <main>
    <div class="container-fluid px-4">
      <h1 class="mt-4">Tableau de bord</h1>
      <ol class="breadcrumb mb-4">
        <li class="breadcrumb-item"><a href="index.html">Acceuil</a></li>
        <li class="breadcrumb-item active">Bibliothécaire</li>
      </ol>

      <div class="row">
        <div class="col-xl-3 col-md-6">
          <div class="card bg-primary text-white mb-4">
            <div class="card-body">Bibliothécaire</div>
            <div class="card-footer d-flex align-items-center justify-content-between">
              <a class="small text-white stretched-link" href="/CampusLibrary_war/bibliothecaire?action=bibliothecaire">Details</a>
              <div class="small text-white"><i class="fas fa-angle-right"></i></div>
            </div>
          </div>
        </div>
        <div class="col-xl-3 col-md-6">
          <div class="card bg-warning text-white mb-4">
            <div class="card-body">Etats de la bibliothéque</div>
            <div class="card-footer d-flex align-items-center justify-content-between">
              <a class="small text-white stretched-link" href="/CampusLibrary_war/bibliothecaire?action=bibliothecaire">Details</a>
              <div class="small text-white"><i class="fas fa-angle-right"></i></div>
            </div>
          </div>
        </div>

      </div>

      <div class="card mb-4">
        <div class="card-header">
          <i class="fas fa-table me-1"></i>
          table des bibliothecaires
        </div>
        <div class="card-body">
          <table id="datatablesSimple">
            <thead>
            <tr>
              <th>Identifiant</th>
              <th>Titre</th>
              <th>Auteurs</th>
              <th>Année de publication</th>
              <th>Domaine</th>
              <th>Niveau</th>
            </tr>
            </thead>
            <tfoot>

            <tr>
              <th>Identifiant</th>
              <th>Titre</th>
              <th>Auteurs</th>
              <th>Année de publication</th>
              <th>Domaine</th>
              <th>Niveau</th>
            </tr>
            </tfoot>
            <tbody>
            <c:forEach var="bibliothecaire" items="${bibliothecaires}">
              <tr>
                <td>${bibliothecaire.id}</td>
                <td>${bibliothecaire.prenom} </td>
                <td>${bibliothecaire.nom} </td>
                <td>${bibliothecaire.date_recrutement} </td>
                <td>${bibliothecaire.adresse} </td>
                <td>${bibliothecaire.email} </td>
              </tr>
            </c:forEach>
            </tbody>
          </table>
        </div>
      </div>
    </div>
  </main>
  <footer class="py-4 bg-light mt-auto">
    <div class="container-fluid px-4">
      <div class="d-flex align-items-center justify-content-between small">
        <div class="text-muted">Copyright &copy; Cheikhna & Ngone</div>
      </div>
    </div>
  </footer>
</div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
<script src="assets/js/scripts.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>
<script src="assets/demo/chart-area-demo.js"></script>
<script src="assets/demo/chart-bar-demo.js"></script>
<script src="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/umd/simple-datatables.min.js" crossorigin="anonymous"></script>
<script src="assets/js/datatables-simple-demo.js"></script>
</body>
</html>
