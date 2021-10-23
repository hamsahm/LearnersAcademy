<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		Integer errorCode = Integer.parseInt(request.getParameter("error"));
		if (errorCode == 1) {
	%>
	<script>
		alert("Error occurred, Please enter username");
	</script>
	<%
		} else if (errorCode == 2) {
			out.println("<h1> Error occurred, Please enter password</h1>");
		} else if (errorCode == 3){
			out.println("<h1> Error occurred, Invalid credentials</h1>");
		}
	%>

	<a href="login.jsp">
		Login</a>
</body>
</html>