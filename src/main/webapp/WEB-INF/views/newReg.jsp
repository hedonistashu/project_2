<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ include file= "menu.jsp" %>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>
</head>
<body>
	<h1>New Registration</h1>
	<form action="newReg" method="post">

		<table>

			<tr>
				<td>Name</td>
				<td><input type="text" name="name" /></td>
			</tr>

			<tr>
				<td>City</td>
				<td><input type="text" name="city" /></td>
			</tr>

			<tr>
				<td>Email</td>
				<td><input type="text" name="email" /></td>
			</tr>

			<tr>
				<td>Mobile</td>
				<td><input type="text" name="mobile" /></td>
			</tr>

			<tr>
				<td><input type="submit" value="save" /></td>
			</tr>

		</table>

	</form>
	
	
	
	
			<%   
			if(request.getAttribute("msg")!=null){
				out.println(request.getAttribute("msg"));
			}
							%>
</body>
</html>