<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Bienvenue !</title>
    <%@include file="commons/header.jsp"%>

</head>
<body>
<%@include file="commons/menu.jsp"%>
<div class="nav-wrapper">
    <ul id="nav-mobile" class="hide-on-med-and-down">
        <li><a href="user/create">Proposer une id�e</a></li>
        <li><a href="id�es">Id�es propos�es</a></li>
    </ul>
</div>
<%@include file="commons/footer.jsp"%>

</body>
</html>
