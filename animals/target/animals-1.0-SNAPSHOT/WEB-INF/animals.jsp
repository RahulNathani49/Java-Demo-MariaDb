<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.isimtl.animals.models.Animal"%>
<% 
    ArrayList<Animal> animals = (ArrayList<Animal>) request.getAttribute("animals");
%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="include/header.html"%>
    </head>
    <body>
        <%@include file="include/menu.jsp"%>
        <% for (Animal animal : animals) { %>
            <%@include file="include/animalView.jsp"%>      
        <% } %>        
    </body>
</html>
