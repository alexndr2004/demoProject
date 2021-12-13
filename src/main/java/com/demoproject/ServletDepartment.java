package com.demoproject;

import com.demoproject.dao.DepartmentDao;
import com.demoproject.dao.EmployeeDao;
import com.demoproject.data.Department;
import com.demoproject.data.Employee;
import com.demoproject.database.DepartmentService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ServletDepartment {

	private HttpServletRequest request;
	private HttpServletResponse response;
	private EmployeeDao employeeDao;
	private DepartmentDao departmentDao;

	public ServletDepartment(ServletEmployee employeeMapper, DepartmentDao departmentDao) {
		this.request = employeeMapper.getRequest();
		this.response = employeeMapper.getResponse();
		this.employeeDao = employeeMapper.getEmployeeDao();
		this.departmentDao = departmentDao;
	}

	void showEditFormDepartment() {
		int id = Integer.parseInt(request.getParameter("id"));
		Department departmentDb = departmentDao.getById(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("department-form.jsp");
		request.setAttribute("department", departmentDb);
		try {
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

	void addDepartment() {
		String name = request.getParameter("name");
		boolean change = Boolean.valueOf(request.getParameter("change"));
		boolean synch = Boolean.valueOf(request.getParameter("synch"));
		int idEmployee = Integer.parseInt(request.getParameter("idemployee"));
		Employee employee = employeeDao.getById(idEmployee);
		if (employee != null) {
			Department department = new Department(name, employee, change, synch);
			departmentDao.add(new DepartmentService(department).getDepartment());
			try {
				response.sendRedirect("listDepartments");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	void updateDepartment() {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		boolean change = Boolean.valueOf(request.getParameter("change"));
		boolean synch = Boolean.valueOf(request.getParameter("synch"));
		int idEmployee = Integer.parseInt(request.getParameter("idemployee"));
		Employee employee = employeeDao.getById(idEmployee);
		Department department = new Department(id, name, employee, change, synch);
		departmentDao.update(new DepartmentService(department).getDepartment());
		try {
			response.sendRedirect("listDepartments");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	void deleteDepartment() {
		int id = Integer.parseInt(request.getParameter("id"));
		Department department = departmentDao.getById(id);
		int idEmployee = department.getEmployee().getId();
		departmentDao.deleteById(id);
		employeeDao.deleteById(idEmployee);
		try {
			response.sendRedirect("listDepartments");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	void getDepartments() {
		List<Department> departments = departmentDao.getAll();
		request.setAttribute("departments", departments);
		RequestDispatcher dispatcher = request.getRequestDispatcher("departments-list.jsp");
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

	public DepartmentDao getDepartmentDao() {
		return departmentDao;
	}

	public void setDepartmentDao(DepartmentDao departmentDao) {
		this.departmentDao = departmentDao;
	}
}