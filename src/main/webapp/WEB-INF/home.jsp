<%--
  Created by IntelliJ IDEA.
  User: louis
  Date: 16/02/2021
  Time: 15:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
       <title>Title</title>
</head>
<body>
       <%@include file="commons/menu.jsp"%>
       <br>
       <br>
       <p>Connecté en tant que <%= request.getSession().getAttribute("EMAIL_USER") %></p>
</body>
</html>
