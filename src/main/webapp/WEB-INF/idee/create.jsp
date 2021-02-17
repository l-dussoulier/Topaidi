<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
       <title>Création d'une idée</title>
</head>
<body>
<%@include file="../commons/menu.jsp"%>

<h5> Choisir une catégorie</h5>

<div class="col-md-2"></div>
<div class="col-md-8">
       <form action="create" method="post">
              <div class="form-group">
                     <label for="emailInput">Votre Email</label>
                     <input type="email" class="form-control" id="emailInput" name="email" placeholder="name@example.com">
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
                     <label for="exampleFormControlTextarea1">Votre proposition</label>
                     <textarea class="form-control" id="exampleFormControlTextarea1" rows="3" name="texte"></textarea>
              </div>
              <div class="form-group">
                     <label>Lien annexe</label>
                     <textarea class="form-control"  rows="1" name="lien"></textarea>
              </div>
              <button type="submit" class="btn btn-primary">Envoyer</button>
       </form>
</div>
</body>
</html>

