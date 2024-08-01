
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.example.campuslibrary.models.Bibliothecaire" %>
<%
    Bibliothecaire bibliothecaire2=(Bibliothecaire) request.getAttribute("bibliothecaire2");
    if (bibliothecaire2 == null) {
        System.out.println("Abonné non trouvé");

    }
%>
<!doctype html>
<html>
<meta name='viewport' content='width=device-width, initial-scale=1'>
<title>Modification-bibliothecaire</title>
<link href='https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css' rel='stylesheet'>
<link href='assets/css/update.css' rel='stylesheet'>
<link href="assets/img/book.ico" rel="icon">

<script type='text/javascript' src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>
<script type='text/javascript' src='https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js'></script>
<script type='text/javascript' src='https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js'></script>
</head>
<body oncontextmenu='return false' class='snippet-body'>
<div class="container register">
    <div class="row">
        <div class="col-md-3 register-left">
            <img src="https://image.ibb.co/n7oTvU/logo_white.png" alt="" />
            <h3>Bienvenue !</h3>
            <p>dans le rubrique de mise à jour </p>
            <a href="/CampusLibrary_war/bibliothecaire?action=bibliothecaire">Retour</a><br />
        </div>
        <div class="col-md-9 register-right">


            <div class="tab-content" id="myTabContent">
                <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">

                    <div class="tab-pane fade show" id="profile" role="tabpanel" aria-labelledby="profile-tab">
                        <h3 class="register-heading">Mise à jour de <%= bibliothecaire2.getPrenom()%> <%= bibliothecaire2.getNom()%></h3>
                        <form action="updateBibliothecaire" method="post">
                            <div class="row register-form">
                                <div class="col-md-6">
                                    <div class="form-group">
                                        <input type="text" class="form-control" placeholder="Identifiant *" value="<%=bibliothecaire2.getId()%>" name="id" readonly />
                                    </div>
                                    <div class="form-group">
                                        <input type="text" class="form-control" placeholder="Nom *" value="<%= bibliothecaire2.getNom()%>" name="nom" />
                                    </div>
                                    <div class="form-group">
                                        <input type="text" class="form-control" placeholder="Prenom" value="<%= bibliothecaire2.getPrenom()%>" name="prenom" />
                                    </div>
                                    <div class="form-group">
                                        <input type="text"  class="form-control" placeholder="Date de recrutement *" value="<%= bibliothecaire2.getDate_recrutement()%>" name="date_recrutement" />
                                    </div>


                                </div>
                                <div class="col-md-6">
                                    <div class="form-group">
                                        <input type="text" class="form-control" placeholder="Adresse *" value="<%= bibliothecaire2.getAdresse()%>" name="adresse" />
                                    </div>
                                    <div class="form-group">
                                        <input type="text" class="form-control" placeholder="Adresse email *" value="<%= bibliothecaire2.getEmail()%>" name="email" />
                                    </div>


                                    <input type="submit" class="btnRegister" value="Mettre à jour" />
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>

    </div>
</div>
<script type='text/javascript'></script>
</body>
</html>
