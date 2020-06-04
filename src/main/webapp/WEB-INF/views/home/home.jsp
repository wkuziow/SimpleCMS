<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>SpringCMS</title>
</head>
<body>

<table>
    <tr>
        <th>Title</th>
        <th>Created</th>
        <th>Content</th>
    </tr>
    <c:forEach var="article" items="${articles}">
        <tr>
            <td>${article.title}</td>
            <td>${article.created}</td>
            <td>${article.content}</td>


        </tr>
    </c:forEach>
</table>

<p><a href="/category/all" target="_blank">Lista kategorii </a>
    <a href="/category/add" target="_blank">Dodaj kategorię </a></p>
<p>
    <a href="/author/all" target="_blank">Lista autorów</a>
    <a href="/author/add" target="_blank">Dodaj autora</a>
</p>

<p>
    <a href="/article/all" target="_blank">Lista artykułów</a>
    <a href="/article/add" target="_blank">Dodaj artykuł</a>
</p>

<p>
    <a href="/article/draft/all" target="_blank">Lista artykułów</a>
    <a href="/article/draft/add" target="_blank">Dodaj draft</a>
</p>

<table>
    <tr>
        <th>Category</th>
    </tr>
    <c:forEach var="category" items="${categoriesHome}">
        <tr>
            <td><a href="article/category/${category.id}" target="_blank"> ${category.name}</a></td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
