
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.example.campuslibrary.models.Emprunt" %>
<%
    Emprunt emprunt1=(Emprunt) request.getAttribute("emprunt");
    if (emprunt1 == null) {
        System.out.println("Emprunt non trouvé");

    }
%>
<!doctype html>
<html>
<meta name='viewport' content='width=device-width, initial-scale=1'>
<title>Modification-emprunt</title>
<link href="assets/img/book.ico" rel="icon">
<link href='https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css' rel='stylesheet'>
<link href='assets/css/update.css' rel='stylesheet'>

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
            <a href="/CampusLibrary_war/emprunt?action=emprunt">Retour</a><br />
        </div>
        <div class="col-md-9 register-right">


            <div class="tab-content" id="myTabContent">
                <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">

                    <div class="tab-pane fade show" id="profile" role="tabpanel" aria-labelledby="profile-tab">
                        <h3 class="register-heading">Mise à jour de l'emprunt <%= emprunt1.getId_emprunt()%> </h3>
                        <form action="updateEmprunt" method="post">
                            <div class="row register-form">
                                <div class="col-md-6">
                                    <div class="form-group">
                                        <input type="text" class="form-control" placeholder="Identifiant Emprunt *" value="<%= emprunt1.getId_emprunt()%>" name="id_emprunt" readonly />
                                    </div>
                                    <div class="form-group">
                                        <input type="text" class="form-control" placeholder="Numéro Abonnement *" value="<%= emprunt1.getNumero_abonnement()%>" name="numero_abonnement" readonly />
                                    </div>
                                    <div class="form-group">
                                        <input type="text" class="form-control" placeholder="Identifiant Exemplaire *" value="<%= emprunt1.getid_exemplaire()%>" name="id_exemplaire" readonly />
                                    </div>
                                    <div class="form-group">
                                        <input type="text"  class="form-control" placeholder="Date Emprunt *" value="<%= emprunt1.getDate_emprunt()%>" name="date_emprunt" />
                                    </div>


                                </div>
                                <div class="col-md-6">
                                    <div class="form-group">
                                        <input type="text" class="form-control" placeholder="Date Retour prévue *" value="<%= emprunt1.getDate_retour_prevue()%>" name="date_retour_prevue" />
                                    </div>
                                    <div class="form-group">
                                        <input type="text"  class="form-control" placeholder="Date Retour *" value="<%= emprunt1.getDate_retour()%>" name="date_retour" />
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
