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
	<h3>Class Details</h3>
	<table border=5>
		<thead>
			<tr>
				<th>Class Id</th>
				<th>Class Name</th>
				<th>Class Code</th>
				<th>Subject Details</th>
			</tr>
		</thead>
		<c:forEach var="classDetails" items='${sessionScope.classes}'>

			<tr>
				<td><c:out value="${classDetails.classId}" /></td>
				<td><c:out value="${classDetails.className}" /></td>
				<td><c:out value="${classDetails.section}" /></td>
				<td>
					<table border=3>

						<thead>
							<tr>
								<th>Subject Id</th>
								<th>Subject Name</th>
								<th>Subject Code</th>
							</tr>
						</thead>
						<c:forEach var="subject" items="${classDetails.subjects}">
							<tr>
								<td><c:out value="${subject.subjectId}" /></td>
								<td><c:out value="${subject.subjectName}" /></td>
								<td><c:out value="${subject.subjectCode}" /></td>
							</tr>

						</c:forEach>
					</table>
				</td>
			</tr>
		</c:forEach>


	</table>

	<br />
	<br />
	<a href="homepage.jsp">Back To Home Page</a>
</body>
</html>