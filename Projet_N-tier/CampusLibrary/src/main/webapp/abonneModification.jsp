
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.example.campuslibrary.models.Abonne" %>
<%
    Abonne abonne1=(Abonne) request.getAttribute("abonne2");
    if (abonne1 == null) {
        System.out.println("Abonné non trouvé");

    }
%>
<!doctype html>
<html>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
    <title>Modification-abonné</title>
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
            <a href="/CampusLibrary_war/abonne?action=abonne">Retour</a><br />
        </div>
        <div class="col-md-9 register-right">


            <div class="tab-content" id="myTabContent">
                <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">

                    <div class="tab-pane fade show" id="profile" role="tabpanel" aria-labelledby="profile-tab">
                        <h3 class="register-heading">Mise à jour de <%= abonne1.getPrenom()%> <%= abonne1.getNom()%></h3>
                        <form action="updateAbonne" method="post">
                            <div class="row register-form">
                                <div class="col-md-6">
                                    <div class="form-group">
                                        <input type="text" class="form-control" placeholder="Numero Abonné *" value="<%= abonne1.getNumero_abonnement()%>" name="id" readonly />
                                    </div>
                                    <div class="form-group">
                                        <input type="text" class="form-control" placeholder="Nom *" value="<%= abonne1.getNom()%>" name="nom" />
                                    </div>
                                    <div class="form-group">
                                        <input type="text" class="form-control" placeholder="Prenom" value="<%= abonne1.getPrenom()%>" name="prenom" />
                                    </div>
                                    <div class="form-group">
                                        <input type="text"  class="form-control" placeholder="Statut *" value="<%= abonne1.getStatut()%>" name="statut" />
                                    </div>


                                </div>
                                <div class="col-md-6">
                                    <div class="form-group">
                                        <input type="text" class="form-control" placeholder="Institution *" value="<%= abonne1.getInstitution()%>" name="institution" />
                                    </div>
                                    <div class="form-group">
                                        <input type="text" class="form-control" placeholder="Adresse email *" value="<%= abonne1.getAdresse_email()%>" name="email" />
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
