<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
       <title>Création d'une idée</title>
</head>
<body>
       <%@include file="../commons/menu.jsp"%>

<div class="row">
       <div class="col-md-4"></div>
       <div class="col-md-4">
              <div class="text-center">
               <h4> Choisir une catégorie</h4>
              </div>
              <br>
              <form action="create" method="post">
                     <div class="form-group">
                            <label for="emailInput">Votre Email</label>
                            <input type="email" class="form-control" readonly id="emailInput" name="email" value=" <%= request.getSession().getAttribute("EMAIL_USER") %>">
                     </div>
                     <div class="form-group">
                            <label >Choisir une catégorie</label>
                            <select name="categorie-select">
                                   <c:forEach items="${categories}" var="categories">
                                          <option value="<c:out value="${ categories.id }" />"><c:out value="${ categories.nom }" /></option>
                                   </c:forEach>
                            </select>
                     </div>
                     <div class="form-group">
                            <label for="titrelabel">Titre</label>
                            <input class="form-control" id="titrelabel"  name="titre">
                     </div>
                     <div class="form-group">
                            <label for="exampleFormControlTextarea1">Votre proposition</label>
                            <textarea class="form-control" id="exampleFormControlTextarea1" rows="3" name="texte"></textarea>
                     </div>
                     <div class="form-group">
                            <label>Lien image</label>
                            <input class="form-control" name="lien">
                     </div>
                     <div class="text-right">
                            <button type="submit" class="btn btn-primary">Envoyer</button>
                     </div>
              </form>
       </div>
       <div class="col-md-4"></div>
</div>
</body>
</html>

