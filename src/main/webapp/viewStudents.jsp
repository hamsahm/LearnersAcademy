<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Details</title>
</head>
<body>
	<h3>Student Details</h3>
	<table border=5>
		<tr>
			<th>Student Id</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Age</th>
			<th>Class Details</th>
		</tr>
		<c:forEach var="students" items='${sessionScope.students}'>
			<tr>
				<td><c:out value="${students.studentId}" /></td>
				<td><c:out value="${students.firstName}" /></td>
				<td><c:out value="${students.lastName}" /></td>
				<td><c:out value="${students.age}" /></td>
				<td>
					<table border=3>
						<thead>
							<tr>
								<th>Class Name</th>
								<th>Section</th>
							</tr>
						</thead>
							<tr>
								<td><c:out value="${students.classId.className}" /></td>
								<td><c:out value="${students.classId.section}" /></td>
							</tr>
					</table>
				</td>
			</tr>
		</c:forEach>
	</table><br/><br/>
<a href="homepage.jsp">Back To Home Page</a>
</body>
</html>