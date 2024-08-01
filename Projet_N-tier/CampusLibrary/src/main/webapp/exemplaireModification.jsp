
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.example.campuslibrary.models.Exemplaire" %>
<%@ page import="com.example.campuslibrary.services.ServicesLivre" %>
<%@ page import="com.example.campuslibrary.models.Livre" %>
<%@ page import="java.util.List" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    // Appel du service pour obtenir la liste des livres
    ServicesLivre serviceLivre = new ServicesLivre();
    List<Livre> livres = serviceLivre.obtenirTousLeslivres();
    request.setAttribute("livres", livres);
%>
<%
    Exemplaire exemplaire2=(Exemplaire) request.getAttribute("exemplaire2");
    if (exemplaire2 == null) {
        System.out.println("Exemplaire non trouvé");

    }
%>
<!doctype html>
<html>
<meta name='viewport' content='width=device-width, initial-scale=1'>
<title>Modification-exemplaires</title>
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
                        <h3 class="register-heading">Mise à jour de <%= exemplaire2.getNumero()%> ${livre.titre} </h3>
                        <form action="updateExemplaire" method="post">
                            <div class="row register-form">
                                <div class="col-md-6">
                                    <div class="form-group">
                                        <input type="text" class="form-control" placeholder="Numero *" value="<%= exemplaire2.getNumero()%>" name="numero" readonly />
                                    </div>



                                </div>
                                <div class="col-md-6">
                                    <div class="form-group">

                                        <select id="reference" name="reference_livre" required>
                                            <option value="" disabled selected><%= exemplaire2.getReference_livre()%></option>
                                            <c:forEach var="livre" items="${livres}">
                                                <option value="${livre.identifiant}"> ${livre.identifiant} ${livre.titre} </option>
                                            </c:forEach>
                                        </select>
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
