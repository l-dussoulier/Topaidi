<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
       <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
       <title>Connexion</title>
</head>
<body>


<div class="col-md-6">
       <form class="form-signin" action="login" method="post">
              <h1 class="h3 mb-3 font-weight-normal">Connexion</h1>
              <br>
              <label for="inputEmail" class="sr-only">Email</label>
              <input type="email" id="inputEmail" class="form-control" placeholder="Email " required="" autofocus="" name="email">
              <br>
              <label for="inputPassword" class="sr-only">Mot de passe</label>
              <input type="password" id="inputPassword" class="form-control" placeholder="Password" required="" name="password">
              <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
       </form>
</div>
</body>
</html>
