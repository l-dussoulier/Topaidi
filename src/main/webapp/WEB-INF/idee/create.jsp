<%--
  Created by IntelliJ IDEA.
  User: louis
  Date: 16/02/2021
  Time: 17:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
       <title>Création d'une idée</title>
</head>
<body>
<%@include file="../commons/menu.jsp"%>
test idée

<c:forEach items="${factures}" var="factures">
       <tr>
              <td>
                     <fmt:formatDate pattern="dd/MM/yyyy" type="date" value="${factures.date}" />
              </td>
              <td>
                     <c:out value="${factures.numero}" />
              </td>
              <td>
                     <c:out value="${factures.prix}" />
              </td>
              <td>
                     <a href="Factures/Detail?id=<c:out value="${factures.id}"/>"/>
                     Détail
                     </a>
              </td>
       </tr>
</c:forEach>
</body>
</html>
