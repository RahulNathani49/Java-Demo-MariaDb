<%@page import="java.util.ArrayList"%>
<%@page import="com.isimtl.animals.models.Category"%>
<%
    ArrayList<Category> categories = (ArrayList<Category>) request.getAttribute("categories");
%>
<nav>
    <ul>
        <li><a href="animals">View all animals</a></li>
        <% for (Category category : categories) { %>
            <li><a href="animals?categoryId=<%=category.getId()%>" ><%=category.getPluralName()%></a></li>
        <% } %>
    </ul>
</nav>