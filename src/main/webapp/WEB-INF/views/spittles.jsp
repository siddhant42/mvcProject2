<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<p>Showing spittles</p>

<c:forEach items="${spittle1}" var="spittle" >
<c:out value="${spittle.message}" /><br>
<c:out value="${spittle.time}"/>
</c:forEach>

</body>
<%-- <body>
<c:forEach items="${spittle1}" var="spittle" >
<li id="spittle_<c:out value="spittle.id"/>">
<div class="spittleMessage">
<c:out value="${spittle.message}" />
</div>
<div>
<span class="spittleTime"><c:out value="${spittle.time}" /></span>
<span class="spittleLocation">
(<c:out value="${spittle.latitude}" />,
<c:out value="${spittle.longitude}" />)</span>
</div>
</li>
</c:forEach>
</body> --%>
</html>