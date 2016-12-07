<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
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
<div align="right"><table><tr><td><a href="logout">Logout</a></td></tr></table></div>
<div id= "box1" align="center" class="class2"> 
	<h1 align="center">Enter Customer Loan Details</h1>
	  <form:form method="POST" action="loandetail">
		<table width="400" cellpadding="0">
			<tr>
				<td>Years :</td>
				<td><form:input path="years" /></td>
			</tr>
			<tr>
				<td>Interest :</td>
				<td><form:input path="salary" /></td>
				<td><form:errors path="salary" /></td>
			</tr>
			<tr>
				<td>LoanAmount :</td>
				<td><form:input path="loanAmount" /></td>
			</tr>
			<tr>
				<td>AnnualTax :</td>
				<td><form:input path="annualTax" /></td>
			</tr>
			<tr>
				<td>AnnualInsurance :</td>
				<td><form:input path="annualInsurance" /></td>
			</tr>
			<tr>
				<td></td>
				<td colspan="2"><h2><input type="submit" value="Save"/></h2></td>
			</tr>
		</table>
	</form:form>
	</div>
	<div id= "box1" align="center" >
	
		<h1>Mortgage Report </h1>
		<table bgcolor="lightblue">
			<tr>
				<th>MonthlyPrincipalAndInterest</th>
				<th>MonthlyTax</th>
				<th>MonthlyInsurance</th>
				<th>TotalPayment</th>
			</tr>
				<tr>
					<td>${mortgage.monthlyPrincipalAndInterest}</td>
					<td>${mortgage.monthlyTax}</td>
					<td>${mortgage.monthlyInsurance}</td>
					<td>${mortgage.totalPayment}</td>
				</tr>
			
		</table>
		</div>
</body>
</html>
