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
				<li><a href="<%=request.getContextPath()%>/listEmployees">Employees</a></li>
			</ul>
			<ul>
				<li><a href="<%=request.getContextPath()%>/jsonListEmployees">jsonEmployees</a></li>
			</ul>
		</nav>
	</header>
	<br>
	<div>
		<c:if test="${employee != null}">
			<form action="updateEmployee" method="post">
		</c:if>
		<c:if test="${employee == null}">
			<form action="addEmployee" method="post">
		</c:if>
		<h2>
			<caption>
				<c:if test="${employee != null}">
					Edit Employee
				</c:if>
				<c:if test="${employee == null}">
					Add New Employee
				</c:if>
			</caption>
		</h2>

		<c:if test="${employee != null}">
			<input type="hidden" name="id"
				value="<c:out value='${employee.id}'/>" />
		</c:if>
		<fieldset>
			<label>Employee Name</label> <input type="text"
				value="<c:out value='${employee.name}'/>" name="name"
				required="required">
		</fieldset>
		<fieldset>
			<label>Employee Surname</label> <input type="text"
				value="<c:out value='${employee.surname}'/>" name="surname"
				required="required">
		</fieldset>

		<input type="hidden" value="160" name="hours" required="required">

		<fieldset>
			<label>Employee Begin</label> <input type="number" min="0" max="23"
				placeholder="23" value="<c:out value='${employee.begin}'/>"
				name="begin" required="required">
		</fieldset>

		<p>
			<input type="hidden" value="EMPLOYEE_BY_PERCENT" name="role"
				required="required">
		</p>

		<fieldset>
			<label>Employee Type</label>
			<p>
				<input type="radio" value="OFFICE" name="preference" required="required">OFFICE<br>
				<input type="radio" value="AFTER" name="preference" required="required">AFTER<br>
				<input type="radio" value="HOMEWORK" name="preference" required="required">HOMEWORK<br>
				<input type="radio" value="BEFORE" name="preference" required="required">BEFORE<br>
			</p>
		</fieldset>
		<fieldset>
			<label>Employee Synch</label>
			<p>
				<input type="radio" value="true" name="synch" required="required">true<br>
				<input type="radio" value="false" name="synch" required="required">false<br>
			</p>
		</fieldset>
		<fieldset>
			<label>Employee Percent</label> <input type="number" min="0" max="1"
				step="0.01" value="<c:out value='${employee.percent}'/>"
				name="percent" required="required">
		</fieldset>
		<button type="submit">Save</button>
		</form>
	</div>
</body>
</html>