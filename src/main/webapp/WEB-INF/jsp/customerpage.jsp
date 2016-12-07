<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<style>
table, th, td {
    border: 0px solid black;
    border-collapse: collapse;
}
th, td {
    padding: 5px;
    text-align: left;
}
table#t01 {
    width: 100%;    
    background-color: #f1f1c1;
    align:center;
    border-style:ridge;
}
h1 {
	border-style:solid 30 solid solid;
	color:blue;
}
.class2{
	font-weight: bold;
	color: green;
}

body {
	margin-top: 10px;
	margin-right: 220px;
	margin-bottom: 20px;
	margin-left: 8px;
}
#box1 {  
border-top-left-radius: 2px;
border-top-left-radius: 10px;
border-bottom-left-radius: 5px;
border-bottom-left-radius: 25px; 
  
    }

.error {
	color: #ff0000;
	font-style: italic;
	font-weight: bold;
}
</style>
</head>

<body>
<div align="right"><table><tr><td><a href="logout">Logout</a></td></tr></table></div>
	<div id= "box1" align="center" class="class2">
		<h1>Please Enter the Customer details</h1>
		<table border="0" width="60%" cellpadding="0">
			<form:form method="POST" action="save" >
				<tr>
					<td align="left">First Name :</td>
					<td><form:input path="fName" /></td>
					<td><form:errors path="fName" cssClass="error" /></td>
				</tr>
				<tr>
					<td align="left">Last Name :</td>
					<td><form:input path="lName" /></td>
					<td><form:errors path="lName" cssClass="error" /></td>
				</tr>
				<tr>
					<td align="left">Address Lane1 :</td>
					<td><form:input path="aLaneOne" /></td>
					<td></td>
					</tr>
				<tr>
					<td align="left">Address Lane2 :</td>
					<td><form:input path="aLaneTwo" /></td>
					<td></td>
				</tr>
				<tr>
					<td align="left">City :</td>
					<td><form:input path="city" /></td>
					<td><form:errors path="city" cssClass="error" /></td>
					</tr>
				<tr>
					<td align="left">State :</td>
					<td><form:select path="state">
					 <form:option value="NONE" label="--- Select ---"/>
   						 <form:options items="${stateList}" />
						 </form:select>
					</td>
					<td><form:errors path="state" cssClass="error" /></td>
				</tr>
				<tr>
					<td align="left">Zipcode :</td>
					<td><form:input path="zipCode" /></td>
					<td><form:errors path="zipCode" cssClass="error" /></td>
					</tr>
				<tr>
					<td align="left">Phone :</td>
					<td><form:input path="phone" /></td>
					<td><form:errors path="phone" cssClass="error" /></td>
				</tr>
				<tr>
					<td align="left">Email :</td>
					<td><form:input path="email" /></td>
					<td><form:errors path="email" cssClass="error" /></td>
					
				</tr>
				<tr>
						<td></td>
						<td><input type="submit" value="Save" /></td>
						<td></td>
					
				</tr>
			</form:form>
		</table>
	</div>
	
</body>
</html>