<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Error Page</title>
</head>
<body>

<h2>Application Error, please contact support.</h2>

<h3>Debug Information:</h3>
<table border="1"><tr><td>
Requested URL</td><td> ${url}<br><br>
</td></tr><tr><td>
Exception </td><td> ${exception.message}<br><br>
</td></tr><tr><td>
<strong>Exception Stack Trace</strong><br></td><td>
<c:forEach items="${exception.stackTrace}" var="ste">
	${ste}
</c:forEach>
</td></tr><tr><td>
</table>
</body>
</html>