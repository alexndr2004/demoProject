package com.demoproject;

import com.demoproject.dao.EmployeeDao;
import com.demoproject.data.Employee;
import com.demoproject.data.Role;
import com.demoproject.data.Preference;
import com.demoproject.database.EmployeeService;
import lombok.val;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ServletEmployee {

	private HttpServletRequest request;
	private HttpServletResponse response;
	private EmployeeDao employeeDao;

	public ServletEmployee(HttpServletRequest request, HttpServletResponse response, EmployeeDao employeeDao) {
		this.request = request;
		this.response = response;
		this.employeeDao = employeeDao;
	}

	void showEditFormEmployee() {
		int id = Integer.parseInt(request.getParameter("id"));
		Employee employeeDb = employeeDao.getById(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("employee-form.jsp");
		request.setAttribute("employee", employeeDb);
		try {
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

	void addEmployee() {
		String name = request.getParameter("name");
		String surname = request.getParameter("surname");
		int hours = Integer.parseInt(request.getParameter("hours"));
		int begin = Integer.parseInt(request.getParameter("begin"));
		final boolean synch = Boolean.parseBoolean(request.getParameter("synch"));
		Role role = Role.valueOf(request.getParameter("role"));
		Preference preference = Preference.valueOf(request.getParameter("preference"));
		val percent = Double.parseDouble(request.getParameter("percent"));
		Employee employee = new Employee(name, surname, hours, begin, role, preference, synch, percent);
		employeeDao.add(new EmployeeService(employee).getEmployee());
		try {
			response.sendRedirect("listEmployees");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	void updateEmployee() {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String surname = request.getParameter("surname");
		int hours = Integer.parseInt(request.getParameter("hours"));
		int begin = Integer.parseInt(request.getParameter("begin"));
		val synch = Boolean.parseBoolean(request.getParameter("synch"));
		Role role = Role.valueOf(request.getParameter("role"));
		Preference preference = Preference.valueOf(request.getParameter("preference"));
		double percent = Double.parseDouble(request.getParameter("percent"));
		Employee employee = new Employee(id, name, surname, hours, begin, role, preference, synch, percent);
		employeeDao.update(new EmployeeService(employee).getEmployee());
		try {
			response.sendRedirect("listEmployees");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	void deleteEmployee() {
		int id = Integer.parseInt(request.getParameter("id"));
		employeeDao.deleteById(id);
		try {
			response.sendRedirect("listEmployees");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	void getEmployees() {
		List<Employee> employees = employeeDao.getAll();
		request.setAttribute("employees", employees);
		RequestDispatcher dispatcher = request.getRequestDispatcher("employees-list.jsp");
		try {
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}

	public EmployeeDao getEmployeeDao() {
		return employeeDao;
	}

	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}
}