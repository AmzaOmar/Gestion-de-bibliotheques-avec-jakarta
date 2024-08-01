<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>



<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title>Tables -Livres</title>
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
                <h4 class="modal-title">Formulaire d'Ajout</h4>
                <button type="button" class="close" data-dismiss="modal">&times;</button>
            </div>

            <!-- Modal Body -->
            <div class="modal-body">
                <form id="signupForm" method="post" action="livre">
                    <div class="form-group">
                        <label for="titre">Titre</label>
                        <input type="text" class="form-control" id="titre" placeholder="Entrez le titre" name="titre">
                    </div>
                    <div class="form-group">
                        <label for="auteurs">Auteurs</label>
                        <input type="text" class="form-control" id="auteurs" placeholder="Entrez les auteurs" name="auteurs">
                    </div>
                    <div class="form-group">
                        <label for="annee_publication">Année de publication</label>
                        <input type="text" class="form-control" id="annee_publication" placeholder="Entrez l'année de publication" name="annee_publication">
                    </div>
                    <div class="form-group">
                        <label for="domaine">Domaine</label>
                        <input type="text" class="form-control" id="domaine" placeholder="Entrez le domaine" name="domaine">
                    </div>
                    <div class="form-group">
                        <label for="niveau">Niveau</label>
                        <input type="text" class="form-control" id="niveau" placeholder="Entrez le niveau" name="niveau">
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
                <h1 class="mt-4">Gestion de livre</h1>
                <ol class="breadcrumb mb-4">
                    <li class="breadcrumb-item"><a href="/CampusLibrary_war/livre?action=dashboard">Dashboard</a></li>
                    <li class="breadcrumb-item active">Tables</li>
                </ol>
                <div class="card mb-4">
                    <div class="card-body">
                        La bibliothèque propose une vaste collection de livres couvrant divers sujets. Vous pouvez explorer notre catalogue pour trouver des livres correspondant à vos intérêts académiques et personnels.
                    </div>
                </div>

                <div class="card mb-4">
                    <div class="card-header">
                        <i class="fas fa-table me-1"></i>
                        tableau des livres
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
                                <th>Action</th>
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
                                <th>Action</th>
                            </tr>
                            </tfoot>
                            <tbody>
                            <c:forEach var="livre" items="${livres}">
                                <tr>
                                    <td><c:out value="${livre.identifiant}"/></td>
                                    <td><c:out value="${livre.titre}"/> </td>
                                    <td><c:out value="${livre.auteurs}"/> </td>
                                    <td><c:out value="${livre.annee_publication}"/> </td>
                                    <td><c:out value="${livre.domaine}"/> </td>
                                    <td><c:out value="${livre.niveau}"/> </td>
                                    <td>
                                        <a href="/CampusLibrary_war/livre?identifiant=${livre.identifiant}&action=supp">Supprimer</a>
                                        <a href="/CampusLibrary_war/livre?identifiant=${livre.identifiant}&action=modif">Modifier</a>
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
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
<script src="assets/js/scripts.js"></script>
<script src="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/umd/simple-datatables.min.js" crossorigin="anonymous"></script>
<script src="assets/js/datatables-simple-demo.js"></script>

</body>
</html>
