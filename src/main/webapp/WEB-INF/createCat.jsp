<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>
<%@include file="commons/menu.jsp"%>

<div class="row" style="margin-top: 10px;">
       <div class="col-md-5"></div>
       <div class="col-md-2" style="margin-top: 40px;">
              <h5> Créer une catégorie</h5>
              <form action="create" method="post">
                     <div class="form-group">
                            <input type="text" class="form-control" id="input" name="categorie" placeholder="Technologie">
                     </div>
                     <div class="text-right">
                            <button type="submit" class="btn btn-primary">Envoyer</button>
                     </div>
              </form>
       </div>
       <div class="col-md-5"></div>
</div>
</body>
</html>
