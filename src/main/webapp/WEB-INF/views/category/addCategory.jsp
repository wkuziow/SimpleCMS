<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Add Category</title>
</head>
<body>
<form:form method="post" modelAttribute="category">
    <label for="nameId">Name:</label>
    <form:input type="text" path="name" id="nameId"/>
    <form:errors path="name"/>
    <br/><br/>
    <label for="descriptionId">Description:</label>
    <form:textarea path="description" rows="3" cols="20" id="descriptionId"/>
    <form:errors path="description"/>
    <br/><br/>
    <input type="submit" value="Save">
</form:form>
</body>
</html>

