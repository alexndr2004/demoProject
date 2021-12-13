<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.demoproject.dao.JdbcEmployeeDao"%>
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
				<li><a href="<%=request.getContextPath()%>/listDepartments">Departments</a></li>
			</ul>
			<ul>
				<li><a href="<%=request.getContextPath()%>/jsonListDepartments">jsonDepartments</a></li>
			</ul>
		</nav>
	</header>
	<br>
	<div>
		<c:if test="${department != null}">
			<form action="updateDepartment" method="post">
		</c:if>
		<c:if test="${department == null}">
			<form action="addDepartment" method="post">
		</c:if>
		<h2>
			<caption>
				<c:if test="${department != null}">
					Edit Department
				</c:if>
				<c:if test="${department == null}">
					Add New Department
				</c:if>
			</caption>
		</h2>

		<c:if test="${department != null}">
			<input type="hidden" name="id"
				value="<c:out value='${department.id}'/>" />
		</c:if>
		<fieldset>
			<label>Department Name</label> <input type="text"
				value="<c:out value='${department.name}'/>" name="name"
				required="required">
		</fieldset>
		<fieldset>
			<label>Department Change</label>
			<p>
				<input type="radio" value="true" name="change" required="required">true<br>
				<input type="radio" value="false" name="change" required="required">false<br>
			</p>
		</fieldset>
		<fieldset>
			<label>Department Synch</label>
			<p>
				<input type="radio" value="true" name="synch" required="required">true<br>
				<input type="radio" value="false" name="synch" required="required">false<br>
			</p>
		</fieldset>
		<fieldset>
			<label>Department idEmployee</label> <input type="number"
				value="<c:out value='${department.employee.id}'/>" name="idemployee"
				required="required">
		</fieldset>
		<button type="submit">Save</button>
		</form>
	</div>
</body>
</html>