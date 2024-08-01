<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page import="com.example.campuslibrary.services.ServicesExemplaire" %>
<%@ page import="com.example.campuslibrary.services.ServicesLivre" %>
<%@ page import="com.example.campuslibrary.models.Livre" %>
<%@ page import="java.util.List" %>
<%
    // Appel du service pour obtenir la liste des livres
    ServicesLivre serviceLivre = new ServicesLivre();
    List<Livre> livres = serviceLivre.obtenirTousLeslivres();
    request.setAttribute("livres", livres);
%>

<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title>Tables - Exemplaires</title>
    <link href="assets/img/book.ico" rel="icon">
    <!-- pour l'ajout -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <!--fin-->
    <link href="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/style.min.css" rel="stylesheet" />
    <link href="assets/css/dashboard.css" rel="stylesheet" />
    <link href="assets/css/boutton.css" rel="stylesheet" />
    <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
</head>
<body class="sb-nav-fixed">
<div class="button-container">
    <button class="cypher-btn-1" type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal">Ajouter</button>

</div>
<div class="modal" id="myModal">
    <div class="modal-dialog">
        <div class="modal-content">

            <!-- Modal Header -->
            <div class="modal-header">
                <h4 class="modal-title">Formulaire d'Ajout d'un exemplaire</h4>
                <button type="button" class="close" data-dismiss="modal">&times;</button>
            </div>

            <!-- Modal Body -->
            <div class="modal-body">
                <form id="signupForm" method="post" action="exemplaire">

                    <div class="form-group">
                        <div class="form-group">
                            <label for="validation">Disponibilite</label>
                            <select id="validation" name="validation">
                                <option value="" disabled selected>Donner la disponibilite(Oui/Non)</option>
                                <option>oui</option>
                                <option>non</option>

                            </select>

                        </div>
                        <label for="reference">livre</label>
                        <select id="reference" name="reference_livre" required>
                            <option value="" disabled selected>Sélectionnez un livre</option>
                            <c:forEach var="livre" items="${livres}">
                                <option value="${livre.identifiant}"> ${livre.identifiant} ${livre.titre} </option>
                            </c:forEach>
                        </select>
                    </div>


                    <button type="submit" class="btn btn-primary" onsubmit="actualisePage()">ajouter</button>
                </form>
            </div>

            <!-- Modal Footer -->
            <div class="modal-footer">
                <button type="button" class="btn btn-danger" data-dismiss="modal">Fermer</button>
            </div>

        </div>
    </div>
</div>
<div id="layoutSidenav_content">
    <main>
        <div class="container-fluid px-4">
            <h1 class="mt-4">Gestion d'exemplaire</h1>
            <ol class="breadcrumb mb-4">
                <li class="breadcrumb-item"><a href="/CampusLibrary_war/exemplaire?action=dashboard">Dashboard</a></li>
                <li class="breadcrumb-item active">Tables</li>
            </ol>
            <div class="card mb-4">
                <div class="card-body">
                    La bibliothèque offre un système de gestion des exemplaires qui permet aux administrateurs
                    de superviser et de gérer efficacement chaque exemplaire de livre. Ce système fournit une
                    vue complète des exemplaires disponibles, leur statut de disponibilité, et leur historique
                    d'emprunt. En tant qu'administrateur, vous pouvez facilement suivre l'état de chaque
                    exemplaire, mettre à jour leur statut, et assurer que la collection de la bibliothèque
                    reste bien organisée et accessible aux abonnés. Vous avez également la possibilité de
                    gérer les réservations et les retours d'exemplaires, garantissant ainsi une gestion
                    fluide et sans accrocs des ressources de la bibliothèque.
                </div>
            </div>

            <div class="card mb-4">
                <div class="card-header">
                    <i class="fas fa-table me-1"></i>
                    tableau des exemplaires
                </div>
                <div class="card-body">
                    <table id="datatablesSimple">
                        <thead>
                        <tr>
                            <th>Numero</th>
                            <th>Réference du livre</th>
                            <th>Disponibilite</th>
                            <th>Action</th>
                        </tr>
                        </thead>
                        <tfoot>
                        <tr>
                            <th>Numero</th>
                            <th>Réference du livre</th>
                            <th>Disponibilite</th>
                            <th>Action</th>
                        </tr>
                        </tfoot>
                        <tbody>
                        <jsp:useBean id="exemplaires" scope="request" type="java.util.List"/>
                        <c:forEach var="exemplaire" items="${exemplaires}">
                            <tr>
                                <td><c:out value="${exemplaire.numero}"/></td>
                                <td>
                                    <c:out value="${exemplaire.reference_livre}"/>
                                    <jsp:useBean id="servicesExemplaire" class="com.example.campuslibrary.services.ServicesExemplaire" scope="request" />
                                    <c:out value="${servicesExemplaire.trouverLivre(exemplaire.reference_livre)}"/>
                                </td>
                                <td><c:out value="${exemplaire.validation}"/></td>
                                <td>
                                    <a href="/CampusLibrary_war/exemplaire?numero=${exemplaire.numero}&action=supp">Supprimer</a>
                                    <a href="/CampusLibrary_war/exemplaire?numero=${exemplaire.numero}&action=modif">Modifier</a>
                                </td>
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
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
<script src="assets/js/scripts.js"></script>
<script src="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/umd/simple-datatables.min.js" crossorigin="anonymous"></script>
<script src="assets/js/datatables-simple-demo.js"></script>

</body>
</html>
