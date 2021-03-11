<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
       <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">

</head>
       <body>
              <nav class="navbar navbar-expand-md navbar-dark bg-dark">
                     <div class="navbar-collapse collapse w-100 order-1 order-md-0 dual-collapse2">
                            <ul class="navbar-nav mr-auto">
                                   <li class="nav-item">
                                          <a class="nav-item nav-link" href="/Topaidi-1.0-SNAPSHOT/idee/create">Proposer idée</a>
                                   </li>
                                   <li class="nav-item">
                                          <a class="nav-item nav-link" href="/Topaidi-1.0-SNAPSHOT/idee/listIdees">Liste idées</a>
                                   </li>
                                   <li class="nav-item">
                                          <a class="nav-item nav-link" href="/Topaidi-1.0-SNAPSHOT/idee/topIdees">Top idées</a>
                                   </li>
                                   <li class="nav-item">
                                          <a class="nav-item nav-link" href="/Topaidi-1.0-SNAPSHOT/categorie/create">Ajouter catégorie</a>
                                   </li>
                            </ul>
                     </div>
                     <div class="mx-auto order-0">
                            <a class="navbar-brand mx-auto" href="#">Topaidi</a>
                            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target=".dual-collapse2">
                                   <span class="navbar-toggler-icon"></span>
                            </button>
                     </div>
                     <div class="navbar-collapse collapse w-100 order-3 dual-collapse2">
                            <ul class="navbar-nav ml-auto">
                                   <c:if test="${session.ROLEID_USER == 1 }">
                                          <li class="nav-item">
                                                 <a class="nav-item nav-link" href="/Topaidi-1.0-SNAPSHOT/user/listUsers">Liste des comptes</a>
                                          </li>
                                   </c:if>
                                   <li class="nav-item">
                                          <a class="nav-item nav-link text-right" href="/Topaidi-1.0-SNAPSHOT/logout">Déconnexion</a>
                                   </li>
                            </ul>
                     </div>
              </nav>
       </body>
</br>
</br>
</html>

