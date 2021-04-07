<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
       <title>Liste des utilisateurs</title>
</head>
<body>
<%@include file="../commons/menu.jsp"%>
<div class="col-12">

       <div class="alert alert-warning alert-dismissible fade show" role="alert">
              <strong>Attention !</strong> Un utilisateur peut être supprimé uniquement s'il n'a effectué aucune action.
              <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                     <span aria-hidden="true">&times;</span>
              </button>
       </div>

       <h2>Liste des utilisateurs</h2>
       <table class="table table-hover">
              <thead>
              <tr>
                     <th>id</th>
                     <th>Email</th>
                     <th>Role</th>
                     <th>Activé</th>
                     <th></th>
                     <th></th>

              </tr>
              </thead>
              <tbody>
              <c:forEach items="${users}" var="users">
              <form action="listUsers" method="post">
                     <tr>
                            <td>
                                   <input type="text" name="idUser" value="<c:out value="${users.id}" />" hidden ><c:out value="${users.id}" />
                            </td>
                            <td>
                                   <c:out value="${users.email}" />
                            </td>

                            <td>
                                   <select name="role-select" />">
                                          <c:forEach items="${roles}" var="roles">
                                                 <option name="inputT" value="<c:out value="${ roles.id }" />"
                                                         <c:if test="${ users.role.nom == roles.nom }">selected="selected"</c:if>
                                                 >
                                                        <c:out value="${ roles.nom }"/>
                                                 </option>
                                          </c:forEach>
                                   </select>

                            </td>
                            <td>
                                   <input type="checkbox" name="isActivate" <c:if test="${ users.activate == true }">
                                          checked
                                   </c:if>/>

                            </td>

                            <td>
                                   <button class="btn btn-success" type="submit" >Enregistrer</button>
                            </td>
                            <td>
                                   <button class="btn btn-warning" type="submit" value="delete" name="delete">Supprimer</button>
                            </td>

                     </tr>
              </form>
              </c:forEach>
              </tbody>
       </table>
</div>
</body>
</html>
