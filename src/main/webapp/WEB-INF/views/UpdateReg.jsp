<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Registration</title>
</head>
<body>
<h2>Update Registration here...</h2>
	<form action="UpdateRegController" method="post">
			email<input type="text" name="email" value=<%out.print(request.getAttribute("email")); %> readonly > <br><br>
			mobile<input type="text" name="mobile" value= <%out.print(request.getAttribute("mobile")); %>>
			
					<input type="submit" value="update">
	</form>

</body>
</html>