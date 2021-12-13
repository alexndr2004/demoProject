<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Company time management</title>
</head>
<body>
	<header>
		<nav>
			<ul>
				<li><a href="/officeTM">Main page</a></li>
			</ul>
			<ul>
				<li><a href="<%=request.getContextPath()%>/jsonListCompanies">jsonCompanies</a></li>
			</ul>
		</nav>
	</header>
	<br>
	<div>
		<div>
			<h3>Company</h3>
			<hr>
			<div>
				<a href="<%=request.getContextPath()%>/newCompany">Add New
					Company</a>
			</div>
			<br>
			<table>
				<thead>
					<tr>
						<th>Id</th>
						<th>Name</th>
						<th>CountPerson</th>
						<th>idDepartment</th>
					</tr>
				</thead>

				<tbody>
					<c:forEach var="company" items="${company}">
						<tr>
							<td><c:out value="${company.id}" /></td>
							<td><c:out value="${company.name}" /></td>
							<td><c:out value="${company.countPerson}" /></td>
							<td><c:out value="${company.department.id}" /></td>
							<td><a href="editCompany?id=<c:out value='${company.id}'/>">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="deleteCompany?id=<c:out value='${company.id}'/>">Delete</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>