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
				<li><a href="<%=request.getContextPath()%>/listCompanies">Company</a></li>
			</ul>
			<ul>
				<li><a href="<%=request.getContextPath()%>/jsonListCompanies">jsonCompanies</a></li>
			</ul>
		</nav>
	</header>
	<br>
	<div>
		<c:if test="${company != null}">
			<form action="updateCompany" method="post">
		</c:if>
		<c:if test="${company == null}">
			<form action="addCompany" method="post">
		</c:if>
		<h2>
			<caption>
				<c:if test="${company != null}">
					Edit Company
				</c:if>
				<c:if test="${company == null}">
					Add New Company
				</c:if>
			</caption>
		</h2>

		<c:if test="${company != null}">
			<input type="hidden" name="id" value="<c:out value='${company.id}'/>" />
		</c:if>
		<fieldset>
			<label>Company Name</label> <input type="text"
				value="<c:out value='${company.name}'/>" name="name"
				required="required">
		</fieldset>

		<fieldset>
			<label>Company CountPerson</label> <input type="number"
				value="<c:out value='${company.countPerson}'/>" name="countperson"
				required="required">
		</fieldset>
		<fieldset>
			<label>Company idDepartment</label> <input type="number"
				value="<c:out value='${company.department.id}'/>" name="iddepartment"
				required="required">
		</fieldset>
		<button type="submit">Save</button>
		</form>
	</div>
</body>
</html>