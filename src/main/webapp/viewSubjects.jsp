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
	<h3>Subject Details</h3>
	<table border=5>
		<!-- 	 <tr>
      <th COLSPAN="3">SUBJECT DETAILS</th>
   </tr> -->
		<tr>
			<th>Subject Id</th>
			<th>Subject Name</th>
			<th>Subject Code</th>
		</tr>
		<c:forEach var="subject" items='${sessionScope.subjects}'>

			<tr>
				<td><c:out value="${subject.subjectId}" /></td>
				<td><c:out value="${subject.subjectName}" /></td>
				<td><c:out value="${subject.subjectCode}" /></td>
			</tr>
		</c:forEach>


	</table>
</body>
</html>