<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.isimtl.animals.models.Animal"%>
<%
    Animal animal = (Animal) request.getAttribute("animal");
%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="include/header.html"%>
    </head>
    <body>        
        <%@include file="include/menu.jsp"%>
        <%@include file="include/animalView.jsp"%>
    </body>
</html>
