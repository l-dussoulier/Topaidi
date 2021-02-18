<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
       <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">

</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
       <a class="navbar-brand" href="#">Topaidi</a>
       <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
              <span class="navbar-toggler-icon"></span>
       </button>
       <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
              <div class="navbar-nav">
                     <a class="nav-item nav-link" href="idee/create">Proposer idée</a>
                     <a class="nav-item nav-link" href="idee/listIdees">Liste idées</a>
                     <a class="nav-item nav-link disabled" href="#">ajouter catégorie</a>
                            <!-- Finir affichage par rapport au niveau du role-->
                            <a class="nav-item nav-link" href="user/listUsers">Liste compte en attente</a>
                     <a class="nav-item nav-link" href="user/create">Créer compte</a>
                     <a class="nav-item nav-link" href="logout">Déconnexion</a>

              </div>
       </div>
</nav>
</body>
</html>
