<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Add article</title>
</head>
<body>
<form:form method="post" modelAttribute="article">
    <label for="titleId">Title:</label>
    <form:input type="text" path="title" id="titleId"/>
    <form:errors path="title"/>
    <br/><br/>

    <label for="contentId">Description:</label>
    <form:textarea path="content" rows="5" cols="100" id="contentId"/>
    <form:errors path="content"/>
    <br/><br/>

    <label for="categoryId">Category:</label>
    <form:select path="categories" items="${categoryList}" itemLabel="name" itemValue="id" id="categoryId"/>
    <form:errors path="categories"/>
    <br/><br/>

    <label for="authorsId">Autor:</label>
    <form:radiobuttons path="author.id" items="${authorsList}" itemLabel="fullName" itemValue="id" id="authorsId"/>
    <form:errors path="author.id"/>
    <br/><br/>

    <input type="submit" value="Save">
</form:form>
</body>
</html>

