<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Department management</title>
</head>
<body>
	<header>
		<nav>
			<ul>
				<li><a href="/officeTM">Main page</a></li>
			</ul>
			<ul>
				<li><a href="<%=request.getContextPath()%>/jsonListDepartments">jsonDepartments</a></li>
			</ul>
		</nav>
	</header>
	<br>
	<div>
		<div>
			<h3>List of Department</h3>
			<hr>
			<div>
				<a href="<%=request.getContextPath()%>/newDepartment">Add New
					Department</a>
			</div>
			<br>
			<table>
				<thead>
					<tr>
						<th>Id</th>
						<th>Name</th>
						<th>Change</th>
						<th>Synch</th>
						<th>idEmployee</th>
						<th>Performance</th>
					</tr>
				</thead>

				<tbody>
					<c:forEach var="department" items="${departments}">
						<tr>
							<td><c:out value="${department.id}" /></td>
							<td><c:out value="${department.name}" /></td>
							<td><c:out value="${department.change}" /></td>
							<td><c:out value="${department.synch}" /></td>
							<td><c:out value="${department.employee.id}" /></td>
							<td><c:out value="${department.performance}" /></td>
							<td><a
								href="editDepartment?id=<c:out value='${department.id}'/>">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="deleteDepartment?id=<c:out value='${department.id}'/>">Delete</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>