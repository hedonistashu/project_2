<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ page import="java.sql.ResultSet" %>
    <%@ include file="menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Result</title>
</head>
<body>
<h2>Show Registrations...</h2>
					
					<table border= "1">
	
					<tr>
							<th>name</th>
							<th>city</th>
							<th>email</th>
							<th>mobile</th>
							<th>Delete</th>
							<th>Update</th>
					</tr>
	
	<%
			ResultSet result = (ResultSet)request.getAttribute("result");
			while(result.next()){
				
	%>
						<tr>
							<td><%=result.getString(1)%></td>
							<td><%=result.getString(2)%></td>
							<td><%=result.getString(3)%></td>
							<td><%=result.getString(4)%></td>
							<td><a href="DelRegController?email=<%=result.getString(3)%>">Delete</a> </td>
							<td><a href="UpdateRegController?email=<%=result.getString(3)%>&mobile=<%=result.getString(4)%>">Update</a> </td>
					</tr>
				
				<% }
				
				%>
	
					</table>
					
</body>
</html>