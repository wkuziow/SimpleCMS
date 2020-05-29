<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>AuthorList</title>
</head>
<body>
<table>
    <tr>
        <th>First name</th>
        <th>Last name</th>
    </tr>
    <c:forEach var="author" items="${authors}">
        <tr>
            <td>${author.firstName}</td>
            <td>${author.lastName}</td>
            <td>
                <a href="/author/delete/${author.id}">Delete</a>
                <a href="/author/update/${author.id}">Edit</a>
            </td>
        </tr>
    </c:forEach>
</table>
<a href="/author/add">Dodaj autora</a>
</body>
</html>

