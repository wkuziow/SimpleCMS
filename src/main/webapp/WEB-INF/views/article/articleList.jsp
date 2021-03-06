<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Articles List</title>
</head>
<body>
<table>
    <tr>
        <th>Title</th>
        <th>Content</th>
        <th>Created</th>
        <th>Updated</th>
        <th>Category</th>
        <th>Author</th>
        <th>Draft</th>
    </tr>
    <c:forEach var="article" items="${articlesList}">
        <tr>
            <td>${article.title}</td>
            <td>${article.content}</td>
            <td>${article.created}</td>
            <td>${article.updated}</td>
            <td><c:forEach var="category" items="${article.categories}">${category.name} </c:forEach></td>
            <td>${article.author.fullName}</td>
            <td>
                <a href="/article/delete/${article.id}">Delete</a>
                <a href="/article/update/${article.id}">Edit</a>
            </td>
            <td>${article.draft}</td>
        </tr>
    </c:forEach>
</table>
<a href="/article/add">Dodaj artykuł</a>
</body>
</html>
