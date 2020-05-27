
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

</body>
</html>
