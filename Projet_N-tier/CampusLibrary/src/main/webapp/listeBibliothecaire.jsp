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
    <title>Tables - Bibliothécaires</title>
    <link href="assets/img/book.ico" rel="icon">
    <!-- pour l'ajout -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <!--fin-->
    <link href="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/style.min.css" rel="stylesheet" />
    <link href="assets/css/dashboard.css" rel="stylesheet" />
    <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
</head>
<body class="sb-nav-fixed">

<button style="border: 1px solid transparent;background-color:blue;float: right;color: white;font-weight: bold;font-size: 20px;border-radius: 45px"  type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal">
    Ajouter</button>
<div class="modal" id="myModal">
    <div class="modal-dialog">
        <div class="modal-content">

            <!-- Modal Header -->
            <div class="modal-header">
                <h4 class="modal-title">Formulaire d'Inscription</h4>
                <button type="button" class="close" data-dismiss="modal">&times</button>
            </div>

            <!-- Modal Body -->
            <div class="modal-body">
                <form id="signupForm" method="post" action="bibliothecaire">
                    <div class="form-group">
                        <label for="prenom">Prenom</label>
                        <input type="text" class="form-control" id="prenom" placeholder="Entrez le prenom" name="prenom">
                    </div>
                    <div class="form-group">
                        <label for="nom">Nom</label>
                        <input type="text" class="form-control" id="nom" placeholder="Entrez le nom" name="nom">
                    </div>
                    <div class="form-group">
                        <label for="date_recrutement">Date de recrutrement</label>
                        <input type="text" class="form-control" id="date_recrutement" placeholder="Entrez la date de recrutement" name="date_recrutement">
                    </div>
                    <div class="form-group">
                        <label for="adresse">Adresse</label>
                        <input type="text" class="form-control" id="adresse" placeholder="Entrez l'adresse" name="adresse">
                    </div>
                    <div class="form-group">
                        <label for="email">Adresse email</label>
                        <input type="email" class="form-control" id="email" placeholder="Entrez l'adresse email" name="email">
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
            <h1 class="mt-4">Gestion des bibliothécaires</h1>
            <ol class="breadcrumb mb-4">
                <li class="breadcrumb-item"><a href="dashboard_administrateur.jsp">Dashboard</a></li>
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
                    tableau des bibliothecaires
                </div>
                <div class="card-body">
                    <table id="datatablesSimple">
                        <thead>
                        <tr>
                            <th>Numero bibliothecairement</th>
                            <th>Prenom</th>
                            <th>Nom</th>
                            <th>Statut</th>
                            <th>Institution</th>
                            <th>Adresse email</th>
                            <th>Action</th>
                        </tr>
                        </thead>
                        <tfoot>

                        <tr>
                            <th>Numero bibliothecairement</th>
                            <th>Prenom</th>
                            <th>Nom</th>
                            <th>Statut</th>
                            <th>Institution</th>
                            <th>Adresse email</th>
                            <th>Action</th>
                        </tr>
                        </tfoot>
                        <tbody>
                        <c:forEach var="bibliothecaire" items="${bibliothecaires}">
                            <tr>
                                <td><c:out value="${bibliothecaire.id}"/></td>
                                <td><c:out value="${bibliothecaire.prenom}"/> </td>
                                <td><c:out value="${bibliothecaire.nom}"/> </td>
                                <td><c:out value="${bibliothecaire.date_recrutement}"/> </td>
                                <td><c:out value="${bibliothecaire.adresse}"/> </td>
                                <td><c:out value="${bibliothecaire.email}"/> </td>
                                <td>
                                    <a href="/CampusLibrary_war/bibliothecaire?id=${bibliothecaire.id}&action=supp">Supprimer</a>
                                    <a href="/CampusLibrary_war/bibliothecaire?id=${bibliothecaire.id}&action=modif" >Modifier</a>
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
