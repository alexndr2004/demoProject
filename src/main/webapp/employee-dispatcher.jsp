<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee dispatcher</title>
</head>
<body>
	Employee dispatcher
	<form action="dispatcherEmployee" method="post">
		<fieldset>
			<label>Employee Role</label>
			<p>
				<input type="radio" value="EMPLOYEE" name="role" required="required">EMPLOYEE<br>
			</p>
			<p>
				<input type="radio" value="EMPLOYEE_BY_HOURS" name="role"
					required="required">EMPLOYEE_BY_HOURS<br>
			</p>
			<p>
				<input type="radio" value="EMPLOYEE_BY_PERCENT" name="role"
					required="required">EMPLOYEE_BY_PERCENT<br>
			</p>
		</fieldset>
		<button type="submit">Save</button>
	</form>
</body>
</html>