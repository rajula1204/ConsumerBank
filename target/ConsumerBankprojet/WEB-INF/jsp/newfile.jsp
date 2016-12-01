<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Spring 4 MVC list values</title>
</head>
<body>
	<h2>Show Contact</h2>
	<table>
		<tr>
			<th>Value</th>
		</tr>
		<c:forEach  items="${stateList.list}" var="alist"
			varStatus="status">
			<tr>
				<td>${alist.value}</td>
				
			</tr>
		</c:forEach>
	</table>
	<br />
	<input type="button" value="Back" onclick="javascript:history.back()" />
</body>
</html>