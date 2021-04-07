<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
       <title>Créer un rôle</title>
</head>
       <body>
              <%@include file="../commons/menu.jsp"%>
                     <div class="col-md-12">
                     <div class="alert alert-warning alert-dismissible fade show" role="alert">
                            <strong>Attention !</strong> Seul le role administrateur peut voir la liste des utilisateurs.
                            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                   <span aria-hidden="true">&times;</span>
                            </button>
                     </div>

                     <div class="row" style="margin-top: 10px;">
                            <div class="col-md-5"></div>
                            <div class="col-md-2" style="margin-top: 40px;">
                                   <h5> Créer un rôle</h5>
                                   <form action="create" method="post">
                                          <div class="form-group">
                                                 <input type="text" class="form-control" id="input" name="role" placeholder="User" required>
                                          </div>
                                          <div class="text-right">
                                                 <button type="submit" class="btn btn-primary">Envoyer</button>
                                          </div>
                                   </form>
                            </div>
                            <div class="col-md-5"></div>
                     </div>
              </div>
       </body>
</html>
