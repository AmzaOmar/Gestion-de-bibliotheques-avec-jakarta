<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.example.campuslibrary.services.*" %>
<%@ page import="com.example.campuslibrary.models.*" %>
<%@ page import="java.util.List" %>
<%
    // Appel du service pour obtenir la liste des abonnés
    ServicesAbonne servicesAbonne = new ServicesAbonne();
    List<Abonne> abonnes = servicesAbonne.obtenirTousLesAbonnes();
    request.setAttribute("abonnes", abonnes);
    // Appel du service pour obtenir la liste des exemplaires
    ServicesExemplaire serviceExemplaire = new ServicesExemplaire();
    List<Exemplaire> exemplaires = serviceExemplaire.obtenirTousLesExemplaires();
    request.setAttribute("exemplaires", exemplaires);
%>

<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title>Tables - Emprunt</title>
    <link href="assets/img/book.ico" rel="icon">
    <!-- pour l'ajout -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <!--fin-->
    <link href="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/style.min.css" rel="stylesheet" />
    <link href="assets/css/dashboard.css" rel="stylesheet" />
    <link href="assets/css/boutton.css" rel="stylesheet">
    <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
</head>
<body class="sb-nav-fixed">
<div class="button-container">
    <button class="cypher-btn-1" type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal">Emprunter</button>

</div>
<div class="modal" id="myModal">
    <div class="modal-dialog">
        <div class="modal-content">

            <!-- Modal Header -->
            <div class="modal-header">
                <h4 class="modal-title">Formulaire d'emprunt</h4>
                <button type="button" class="close" data-dismiss="modal">&times;</button>
            </div>

            <!-- Modal Body -->
            <div class="modal-body">
                <form id="signupForm" method="post" action="emprunt">
                    <div class="form-group">
                        <label for="numero_abonnement">Numéro d'abonnement</label>
                        <select id="numero_abonnement" name="numero_abonnement" required>
                            <option value="" disabled selected>Sélectionnez un numero</option>
                            <c:forEach var="abonne" items="${abonnes}">
                                <option value="${abonne.numero_abonnement}"> ${abonne.numero_abonnement} ${abonne.prenom} ${abonne.nom} </option>
                            </c:forEach>
                        </select>
                        <input type="hidden" id="disponibilite_exemplaire" name="disponibilite_exemplaire">
                    </div>
                    <div class="form-group">
                        <label for="id_exemplaire">Identifiant du exemplaire</label>
                        <select id="id_exemplaire" name="id_exemplaire" required>
                            <option value="" disabled selected>Sélectionnez une exemplaire</option>
                            <jsp:useBean id="servicesExemplaire" class="com.example.campuslibrary.services.ServicesExemplaire" scope="request" />
                            <c:forEach var="exemplaire" items="${exemplaires}">
                                <option value="${exemplaire.numero}" data-disponibilite="${exemplaire.validation}"> ${exemplaire.numero} ${servicesExemplaire.trouverLivre(exemplaire.reference_livre)} </option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="date_emprunt">Date d'emprunt</label>
                        <input type="text" class="form-control" id="date_emprunt" value="<%= new java.text.SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date()) %>" name="date_emprunt" readonly>
                    </div>
                    <div class="form-group">
                        <label for="date_retour_prevue">Date de retour prévue</label>
                        <input type="text" class="form-control" id="date_retour_prevue" placeholder="Entrez la date de retour prévue" name="date_retour_prevue">
                    </div>
                    <button type="submit" class="btn btn-primary">Ajouter</button>
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
            <h1 class="mt-4">Gestion des emprunts</h1>
            <ol class="breadcrumb mb-4">
                <li class="breadcrumb-item"><a href="/CampusLibrary_war/emprunt?action=dashboard">Dashboard</a></li>
                <li class="breadcrumb-item active">Tables</li>
            </ol>
            <div class="card mb-4">
                <div class="card-body">
                    En tant qu'administrateur de la bibliothèque, vous avez accès à un
                    système complet de gestion des emprunts qui vous permet de surveiller et
                    de gérer efficacement toutes les transactions d'emprunt. Ce système vous
                    offre une vue d'ensemble des emprunts en cours, des retours prévus et des
                    éventuels retards. Vous pouvez consulter l'historique des emprunts, suivre
                    les dates d'emprunt et de retour, et gérer les pénalités en cas de retard.
                    En outre, vous pouvez créer et modifier des emprunts, et assurer que chaque
                    transaction est correctement enregistrée et traitée. Grâce à ces fonctionnalités,
                    vous pouvez maintenir un contrôle rigoureux sur les emprunts et garantir une gestion
                    efficace des ressources de la bibliothèque.
                </div>
            </div>

            <div class="card mb-4">
                <div class="card-header">
                    <i class="fas fa-table me-1"></i>
                    Tableau des emprunts
                </div>
                <div class="card-body">
                    <table id="datatablesSimple">
                        <thead>
                        <tr>
                            <th>Id_emprunt</th>
                            <th>Numero_abonnement</th>
                            <th>Id_exemplaire</th>
                            <th>Date_emprunt</th>
                            <th>Date_retour_prevue</th>
                            <th>Date_retour</th>
                            <th>Action</th>
                        </tr>
                        </thead>
                        <tfoot>
                        <tr>
                            <th>Id_emprunt</th>
                            <th>Numero_abonnement</th>
                            <th>Id_exemplaire</th>
                            <th>Date_emprunt</th>
                            <th>Date_retour_prevue</th>
                            <th>Date_retour</th>
                            <th>Action</th>
                        </tr>
                        </tfoot>
                        <tbody>
                        <c:forEach var="emprunt" items="${emprunts}">
                            <tr>
                                <td><c:out value="${emprunt.id_emprunt}"/> </td>
                                <td><c:out value="${emprunt.numero_abonnement}"/></td>
                                <td><c:out value="${emprunt.id_exemplaire}"/> </td>
                                <td><c:out value="${emprunt.date_emprunt}"/> </td>
                                <td><c:out value="${emprunt.date_retour_prevue}"/> </td>
                                <td><c:out value="${emprunt.date_retour}"/> </td>
                                <td>
                                    <a href="/CampusLibrary_war/emprunt?id_emprunt=${emprunt.id_emprunt}&action=supp">Supprimer</a>
                                    <a href="/CampusLibrary_war/emprunt?id_emprunt=${emprunt.id_emprunt}&action=modif">Modifier</a>
                                    <a href="/CampusLibrary_war/emprunt?id_emprunt=${emprunt.id_emprunt}&action=retour">Retourner</a>
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
<script>
    document.addEventListener("DOMContentLoaded", function() {
        document.getElementById("signupForm").addEventListener("submit", function(event) {
            var exemplaireSelect = document.getElementById("id_exemplaire");
            var disponibilite = exemplaireSelect.options[exemplaireSelect.selectedIndex].getAttribute("data-disponibilite");
            if (disponibilite === "non") {
                alert("Impossible d'ajouter cet emprunt : l'exemplaire n'est pas disponible.");
                event.preventDefault(); // Empêche l'envoi du formulaire
            }
        });

        document.getElementById("id_exemplaire").addEventListener("change", function() {
            var disponibilite = this.options[this.selectedIndex].getAttribute("data-disponibilite");
            document.getElementById("disponibilite_exemplaire").value = disponibilite;
        });
    });
</script>
</body>
</html>
