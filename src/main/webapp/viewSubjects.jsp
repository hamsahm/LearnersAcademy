<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Subject Details</title>
</head>
<body>
	<h3>Subject Details</h3>
	<table border=5>
		<thead>
			<tr>
				<th>Subject Id</th>
				<th>Subject Name</th>
				<th>Subject Code</th>
				<th>Class Details</th>
			</tr>
		</thead>
		<c:forEach var="subject" items='${sessionScope.subjects}'>
			<tr>
				<td><c:out value="${subject.subjectId}" /></td>
				<td><c:out value="${subject.subjectName}" /></td>
				<td><c:out value="${subject.subjectCode}" /></td>
				<td>
					<table border=3>
						<thead>
							<tr>
								<th>Class Name</th>
								<th>Section</th>
							</tr>
						</thead>
						<c:forEach var="classDetails" items='${subject.classes}'>
							<tr>
								<td><c:out value="${classDetails.className}" /></td>
								<td><c:out value="${classDetails.section}" /></td>
							</tr>
						</c:forEach>
					</table>
				</td>
			</tr>
		</c:forEach>
	</table><br /><br />
	<a href="homepage.jsp">Back To Home Page</a>
</body>
</html>