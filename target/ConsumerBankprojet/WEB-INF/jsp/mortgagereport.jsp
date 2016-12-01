<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<style>
table,td {
    border: 1px solid black;
    border-collapse: collapse;
    text-align: center;
}
th {
    border: 1px solid black;
    padding: 5px;
    text-align: left;
    color:lightwhite;
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
	margin-right: 120px;
	margin-bottom: 20px;
	margin-left: 8px;
}
#box1 {  
border-top-left-radius: 2px;
border-top-left-radius: 10px;
border-bottom-left-radius: 5px;
border-bottom-left-radius: 25px; 
  
    }

</style>
</head>
<body>
	<div id= "box1" align="center" >
		<h1>Mortgage Report </h1>
		<table bgcolor="lightblue">
			<tr>
				<th>MonthlyPrincipalAndInterest</th>
				<th>FName</th>
				<th>LName</th>
				<th>City</th>
				<th>State</th>
				<th>zipCode</th>
				<th>Phone</th>
			</tr>
				<tr>
					<td>${customer.customerId}</td>
					<td>${customer.fName}</td>
					<td>${customer.lName}</td>
					<td>${customer.city}</td>
					<td>${customer.state}</td>
					<td>${customer.zipCode}</td>
					<td>${customer.phone}</td>
				</tr>
			
		</table>
		   <br/><br/><br/><br/>
		  		
		<table align = "center">
				<tr><td><input type="submit" value="Validate" /></td>	</tr>
		</table>
	
	</div>
	</body>
</html>
