<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Add author</title>
</head>
<body>
<form:form method="post" modelAttribute="author">
    <label for="firstNameId">First name:</label>
    <form:input type="text" path="firstName" id="firstNameId"/>
    <br/><br/>
    <label for="lastNameId">Last name:</label>
    <form:input type="text" path="lastName" id="lastNameId"/>

    <br/><br/>
    <input type="submit" value="Save">
</form:form>
</body>
</html>
