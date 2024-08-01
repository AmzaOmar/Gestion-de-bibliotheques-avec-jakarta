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
        <title>Tables - Abonnés</title>
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
                    <h4 class="modal-title">Formulaire d'Inscription</h4>
                    <button type="button" class="close" data-dismiss="modal">&times</button>
                </div>

                <!-- Modal Body -->
                <div class="modal-body">
                    <form id="signupForm" method="post" action="abonne">
                        <div class="form-group">
                            <label for="prenom">Prenom</label>
                            <input type="text" class="form-control" id="prenom" placeholder="Entrez le prenom" name="prenom">
                        </div>
                        <div class="form-group">
                            <label for="nom">Nom</label>
                            <input type="text" class="form-control" id="nom" placeholder="Entrez le nom" name="nom">
                        </div>
                        <div class="form-group">
                            <label for="statut">Statut</label>
                            <input type="text" class="form-control" id="statut" placeholder="Entrez statut" name="statut">
                        </div>
                        <div class="form-group">
                            <label for="institution">Institution</label>
                            <input type="text" class="form-control" id="institution" placeholder="Entrez l'institution" name="institution">
                        </div>
                        <div class="form-group">
                            <label for="email">Adresse email</label>
                            <input type="email" class="form-control" id="email" placeholder="Entrez l'adresse email" name="adresse_email">
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
                <h1 class="mt-4">Gestion d'abonné</h1>
                <ol class="breadcrumb mb-4">
                    <li class="breadcrumb-item"><a href="/CampusLibrary_war/abonne?action=dashboard">Dashboard</a></li>
                    <li class="breadcrumb-item active">Tables</li>
                </ol>
                <div class="card mb-4">
                    <div class="card-body">
                        La bibliothèque dispose d'un système complet de gestion des abonnés,
                        permettant aux administrateurs de suivre et d'administrer les informations des
                        abonnés avec précision. Ce système offre une vue détaillée de chaque abonné,
                        incluant leurs coordonnées, leurs historiques d'emprunt, et leurs informations
                        d'inscription. En tant qu'administrateur, vous pouvez facilement mettre à jour
                        les informations des abonnés, surveiller leurs emprunts en cours, et assurer une
                        gestion efficace de la bibliothèque.
                    </div>
                </div>

                <div class="card mb-4">
                    <div class="card-header">
                        <i class="fas fa-table me-1"></i>
                        tableau des abonnés
                    </div>
                    <div class="card-body">
                        <table id="datatablesSimple">
                            <thead>
                            <tr>
                                <th>Numero Abonnement</th>
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
                                <th>Numero Abonnement</th>
                                <th>Prenom</th>
                                <th>Nom</th>
                                <th>Statut</th>
                                <th>Institution</th>
                                <th>Adresse email</th>
                                <th>Action</th>
                            </tr>
                            </tfoot>
                            <tbody>
                            <c:forEach var="abonne" items="${abonnes}">
                                <tr>
                                    <td><c:out value="${abonne.numero_abonnement}"/></td>
                                    <td><c:out value="${abonne.prenom}"/> </td>
                                    <td><c:out value="${abonne.nom}"/> </td>
                                    <td><c:out value="${abonne.statut}"/> </td>
                                    <td><c:out value="${abonne.institution}"/> </td>
                                    <td><c:out value="${abonne.adresse_email}"/> </td>
                                    <td>
                                        <a href="/CampusLibrary_war/abonne?numero_abonnement=${abonne.numero_abonnement}&action=supp">Supprimer</a>
                                        <a href="/CampusLibrary_war/abonne?identifiant=${abonne.numero_abonnement}&action=modif" >Modifier</a>
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
