<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>OfficeTM Management</title>
</head>
<body>
	<header>
		<nav>
			<ul>
				<li><a href="<%=request.getContextPath()%>/listCompanies">Company
					Management</a></li>
			</ul>
			<ul>
				<li><a href="<%=request.getContextPath()%>/listDepartments">Departments
						Management</a></li>
			</ul>
			<ul>
				<li><a href="<%=request.getContextPath()%>/employee-dispatcher.jsp">Employees
						Management</a></li>
			</ul>
		</nav>
	</header>
</body>
</html>