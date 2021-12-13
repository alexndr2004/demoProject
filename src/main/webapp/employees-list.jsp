<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee management</title>
</head>
<body>
	<header>
		<nav>
			<ul>
				<li><a href="/officeTM">Main page</a></li>
			</ul>
			<ul>
				<li><a href="<%=request.getContextPath()%>/jsonListEmployees">jsonEmployees</a></li>
			</ul>
		</nav>
	</header>
	<br>
	<div>
		<div>
			<h3>List of Employees</h3>
			<hr>
			<div>
				<a href="<%=request.getContextPath()%>/employee-dispatcher.jsp">Add New
					Employee</a>
			</div>
			<br>
			<table>
				<thead>
					<tr>
						<th>Id</th>
						<th>Name</th>
						<th>Surname</th>
						<th>Hours</th>
						<th>Begin</th>
						<th>EndWork</th>
						<th>Role</th>
						<th>Preference</th>
						<th>Synch</th>
						<th>Performance</th>
						<th>Percent</th>
						<th>Salary</th>
					</tr>
				</thead>

				<tbody>
					<c:forEach var="employee" items="${employees}">
						<tr>
							<td><c:out value="${employee.id}" /></td>
							<td><c:out value="${employee.name}" /></td>
							<td><c:out value="${employee.surname}" /></td>
							<td><c:out value="${employee.hours}" /></td>
							<td><c:out value="${employee.begin}" /></td>
							<td><c:out value="${employee.endWork}" /></td>
							<td><c:out value="${employee.role}" /></td>
							<td><c:out value="${employee.preference}" /></td>
							<td><c:out value="${employee.synch}" /></td>
							<td><c:out value="${employee.performance}" /></td>
							<td><c:out value="${employee.percent}" /></td>
							<td><c:out value="${employee.salary}" /></td>
							<td><a
								href="editEmployee?id=<c:out value='${employee.id}'/>">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="deleteEmployee?id=<c:out value='${employee.id}'/>">Delete</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>