<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3>Teacher Details</h3>
	<table border=5>
		<!-- 	 <tr>
      <th COLSPAN="3">SUBJECT DETAILS</th>
   </tr> -->
		<tr>
			<th>Teacher Id</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Age</th>
		</tr>
		<c:forEach var="teachers" items='${sessionScope.teachers}'>

			<tr>
				<td><c:out value="${teachers.teacherId}" /></td>
				<td><c:out value="${teachers.firstName}" /></td>
				<td><c:out value="${teachers.lastName}" /></td>
				<td><c:out value="${teachers.age}" /></td>
			</tr>
		</c:forEach>


	</table>
</body>
</html>