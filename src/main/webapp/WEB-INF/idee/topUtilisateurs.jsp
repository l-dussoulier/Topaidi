<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>

    <title>Liste des idées classées par Tops des utilisateurs</title>

</head>
<body>
<%@include file="../commons/menu.jsp"%>
<div class="row">
    <div class="col-md-2"></div>
    <div class="col-md-8">
        <div class="row">
            <div class="col-md-2"></div>
            <div class="col-md-8">
                <h1 style="text-align: center;">Tops des utilisateurs</h1>
            </div>
            <div class="col-md-2">
                <a class="btn btn-primary text-right" href="create">Ajouter une idée</a>
            </div>
        </div>
        <div>
            <a class="btn btn-light text-left" href="/Topaidi-1.0-SNAPSHOT/idee/topIdees">Top idées</a>
            <a class="btn btn-light text-left" href="/Topaidi-1.0-SNAPSHOT/idee/topUser">Top brains</a>
            <a class="btn btn-light text-left" href="/Topaidi-1.0-SNAPSHOT/idee/topVotes">Top buzz</a>
        </div>
        <br>
        <br>
        <table class="table table-hover">
            <thead>
            <tr>
                <th>Email</th>
                <th>Username</th>
                <th>Nombre idéees</th>
                <th>Classsement</th>

            </tr>
            </thead>
            <tbody>
            <%
                int y = 0;
            %>
            <c:forEach items="${topUser}" var="topUser">

                    <tr>
                        <td>
                            <c:out value="${topUser.email}" />
                        </td>
                        <td>
                            <c:out value="${topUser.username}" />
                        </td>

                        <td>
                            <c:out value="${topUser.nbIdees}" />
                        </td>
                        <td>
                <%

                    y = y+1;
                    if (y == 1){

                        out.println("<span style='font-size: 1.5em; color: yellow;'>");
                    }
                    if (y == 2){

                        out.println("<span style='font-size: 1.5em; color: gray;'>");
                    }
                    if (y == 3){

                        out.println("<span style='font-size: 1.5em; color: brow;'>");
                    }

                %>
                            <i class='yellow fas fa-medal'></i>
                            </span>
                        </td>

                    </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>