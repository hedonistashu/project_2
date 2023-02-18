<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login</title>
</head>
<body>
<h2>Login here....</h2>
<form action="LoginController" method="post">
	
	Email<input type="text" name="email"/>
	Password<input type="password" name="password"/>
	<input type ="submit" value="save"/>
		

</form>

		<%   
			if(request.getAttribute("errorMsg")!=null){
				out.println(request.getAttribute("errorMsg"));
			}
							%>
</body>
</html>