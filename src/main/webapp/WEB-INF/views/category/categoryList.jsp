<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>CategoryList</title>
</head>
<body>
<table>
    <tr>
        <th>Name</th>
        <th>Descripion</th>

    </tr>
    <c:forEach var="category" items="${categories}">
        <tr>
            <td>${category.name}</td>
            <td>${category.description}</td>
            <td>
                <a href="/category/delete/${category.id}">Delete</a>
                <a href="/category/update/${category.id}">Edit</a>
            </td>


        </tr>
    </c:forEach>
</table>
<a href="/category/add">Dodaj kategorię</a>
</body>
</html>
