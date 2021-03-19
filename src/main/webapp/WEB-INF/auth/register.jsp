<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
       <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
       <title>Register</title>
</head>
<body>

<div class="row">
       <div class="col-md-5"></div>
       <div class="col-md-2">
              <h1 class="text-center" style="margin-top: 8em;">Topaidi</h1>
              <form class="form-signin" action="register" method="post" style="margin-top: 20px;">
                     <h1 class="h3 mb-3 font-weight-normal">S'inscrire</h1>
                     <br>
                     <label for="inputEmail" class="sr-only">Email</label>
                     <input type="email" id="inputEmail" class="form-control" placeholder="Email " required="" autofocus="" name="email">
                     <br>
                     <label for="inputPassword" class="sr-only">Mot de passe</label>
                     <input type="password" id="inputPassword" class="form-control" placeholder="Password" required="" name="password">
                     <br>
                     <button class="btn btn-lg btn-primary btn-block" type="submit">S'inscrire</button>
                     <br>

              </form>
       </div>
       <div class="col-md-2"></div>
</div>
</body>
</html>
