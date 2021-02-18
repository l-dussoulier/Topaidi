<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
       <title>Création d'un user</title>
</head>
<body>
<%@include file="../commons/menu.jsp"%>

<div class="col-md-2"></div>
<div class="col-md-8">
       <form action="create" method="post">
              <div class="form-group">
                     <label for="emailInput">Votre Email</label>
                     <input type="email" class="form-control" id="emailInput" name="email" placeholder="nom@prenom.fr">
              </div>
              <div class="form-group">
                     <label for="inputPassword">Password</label>
                     <input type="password" class="form-control" id="inputPassword" placeholder="Mot de passe" name="password">

              </div>
              <button type="submit" class="btn btn-primary">Envoyer</button>
       </form>
</div>
</body>
</html>


