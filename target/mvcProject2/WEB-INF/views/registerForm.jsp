<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ page session="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spitter</title>
<style type="text/css">
label.error {
color: red;
}
input.error {
background-color: #ffcccc;
}
div.errors {
background-color: #ffcccc;
border: 2px solid red;
}
</style>
</head>
<body>
<h1>Register</h1>
<sf:form method="POST" commandName="spitter" enctype="multipart/form-data">
<sf:errors path="*" element="div" cssClass="errors" />
First Name: <sf:input path="firstName" /><br/>
Last Name: <sf:input path="lastName" /><br/>
Username: <sf:input path="username" /><br/>
Password: <sf:password path="password" /><br/>
Profile Picture:
<sf:input type="file" path="profilePicture" accept="image/jpeg,image/png,image/gif" /><br/>
<input type="submit" value="Register" />
</sf:form>
</body>
</html>