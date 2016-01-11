<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spittle</title>
</head>
<body>
<h1>Your Spittle</h1>
<div align="center">
        <table border="0">
            <tr>
                <td>Your message: </td>
                <td>${spittle.message}</td>
            </tr>
            <tr>
                <td>Time:</td>
                <td>${spittle.time}</td>
            </tr>
            <tr>
                <td>longtitude:</td>
                <td>${spittle.latitude}</td>
            </tr>
            <tr>
                <td>latitude:</td>
                <td>${spittle.longitude }</td>
            </tr>
 
        </table>
    </div>
</body>
</html>