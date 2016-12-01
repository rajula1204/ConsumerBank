<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
<style>
table{
    border: 0px solid blue;
    table-layout: fixed;
    width: 800px;
}

th, td {
    border: 0px solid black;
    width: 200px;
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
	<div id= "box1" align="center" class="class2">
			<form action="hello" method="GET">
			<table align="center" border="3" height="10%" width="40%" bgcolor="lightblue">
				<tr>
					<td>
						<h1 align="center"> ${welcomeMessage}</h1>
					</td>
				</tr>
				</table>
			  <br/><br/><br/><br/><br/>	
			<table width="400" cellpadding="0" align="center">
				<tr align="center" >
					<td><input type="submit" value="Enroll" /></h2></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>
