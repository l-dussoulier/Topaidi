<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
       <meta charset="UTF-8">
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
              <form action="create" method="post" enctype="multipart/form-data">
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
                            <input class="form-control" id="titrelabel"  name="titre" required>
                     </div>
                     <div class="form-group">
                            <label for="exampleFormControlTextarea1">Votre proposition</label>
                            <textarea class="form-control" id="exampleFormControlTextarea1" rows="3" name="texte" required></textarea>
                     </div>
                     <div class="form-group">
                            <!--<label>Lien image</label>
                            <input class="form-control" name="lien">-->
                            <div class="d-flex justify-content-center">
                                   <div style="position: relative;overflow: hidden;display: inline-block;">
                                          <button style=" border: 2px solid gray;color: gray;background-color: white;padding: 8px 20px;border-radius: 8px;font-size: 20px;font-weight: bold;">Ajouter une image</button>
                                          <input type="file" name="imgtest" style="font-size: 100px;position: absolute;left: 0;top: 0;opacity: 0;">
                                   </div>
                            </div>
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

