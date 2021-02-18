<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
       <title>Liste user en attente</title>
</head>
<body>
<%@include file="../commons/menu.jsp"%>
<div class="col-12">
       <h2>Liste des utilisateurs en attente</h2>
       <table class="table table-hover">
              <thead>
              <tr>
                     <th>id</th>
                     <th>Email</th>
                     <th>Role</th>
                     <th></th>

              </tr>
              </thead>
              <tbody>
              <form action="listUsers" method="post">
              <c:forEach items="${users}" var="users">
                     <tr>

                            <td>
                                   <input type="text" name="idUser" value="<c:out value="${users.id}" />" hidden ><c:out value="${users.id}" />
                            </td>
                            <td>
                                   <c:out value="${users.email}" />
                            </td>

                            <td>
                                   <select name="role-select">
                                          <c:forEach items="${roles}" var="roles">
                                                 <option value="<c:out value="${ roles.id }" />"><c:out value="${ roles.nom }" /></option>
                                          </c:forEach>
                                   </select>

                            </td>
                            <td>
                                   <button class="btn btn-success" type="submit" >Valider</button>
                            </td>

                     </tr>
              </c:forEach>
              </form>
              </tbody>
       </table>
</div>
</body>
</html>
