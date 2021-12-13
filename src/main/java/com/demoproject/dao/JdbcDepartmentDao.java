package com.demoproject.dao;

import com.demoproject.data.Department;
import com.demoproject.data.Employee;
import com.demoproject.connection.ConnectionManager;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JdbcDepartmentDao implements DepartmentDao {

	private static ConnectionManager connectionManager;
	private final EmployeeDao employeeDao;
	private static final String ADD_DEPARTMENT = "insert into department (name, change, synch, idEmployee, performance) values (?,?,?,?,?)";
	private static final String GET_DEPARTMENT = "select * from department where id=?";
	private static final String GET_ALL_DEPARTMENTS = "select * from department";
	private static final String UPDATE_DEPARTMENT = "update department set name=?, change=?, synch=?, idEmployee=?, performance=? where id=?";
	private static final String DELETE_DEPARTMENT = "delete from department where id=?";

	public JdbcDepartmentDao() {
		connectionManager = ConnectionManager.getInstance();
		employeeDao = new JdbcEmployeeDao();
	}

	@Override
	public void add( Department department) {
		Employee employeeDb = employeeDao.getById(department.getEmployee().getId());
		if (employeeDb.isSynch() == department.isSynch()) {
			try {
				Connection connection = connectionManager.getConnection();
				PreparedStatement st = connection.prepareStatement(ADD_DEPARTMENT);
				st.setString(1, department.getName());
				st.setBoolean(2, department.isChange());
				st.setBoolean(3, department.isSynch());
				st.setInt(4, department.getEmployee().getId());
				st.setDouble(5, department.getPerformance());
				st.executeUpdate();
				ResultSet rs = st.getGeneratedKeys();
				if (rs.next()) {
					int key = rs.getInt(1);
					department.setId(key);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public Department getById(int id) {
		Department department = null;
		try {
			Connection connection = connectionManager.getConnection();
			PreparedStatement st = connection.prepareStatement(GET_DEPARTMENT);
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				String name = rs.getString("name");
				boolean change;
				change = rs.getBoolean("change");
				boolean synch;
				synch = rs.getBoolean("synch");
				int idEmployee;
				idEmployee = rs.getInt("idEmployee");
				double performance;
				performance = rs.getDouble("performance");
				Employee employee;
				employee = employeeDao.getById(idEmployee);
				department = new Department(id, name, employee, change, synch, performance);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return department;
	}

	@Override
	public List<Department> getAll() {
		List<Department> departments = new ArrayList<>();
		try {
			Connection connection = connectionManager.getConnection();
			PreparedStatement st = connection.prepareStatement(GET_ALL_DEPARTMENTS);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				boolean change;
				change = rs.getBoolean("change");
				boolean synch;
				synch = rs.getBoolean("synch");
				int idEmployee = rs.getInt("idEmployee");
				double performance = rs.getDouble("performance");
				Employee employee = employeeDao.getById(idEmployee);
				departments.add(new Department(id, name, employee, change, synch, performance));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return departments;
	}

	@Override
	public void update(Department department) {
		Department departmentDb = getById(department.getId());
		if (departmentDb.isChange()) {
			try {
				Connection connection = connectionManager.getConnection();
				PreparedStatement st = connection.prepareStatement(UPDATE_DEPARTMENT);
				st.setString(1, department.getName());
				st.setBoolean(2, department.isChange());
				st.setBoolean(3, department.isSynch());
				st.setInt(4, department.getEmployee().getId());
				st.setDouble(5, department.getPerformance());
				st.setInt(6, department.getId());
				st.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void deleteById(int id) {
		try {
			Connection connection = connectionManager.getConnection();
			PreparedStatement st = connection.prepareStatement(DELETE_DEPARTMENT);
			st.setInt(1, id);
			st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static ConnectionManager getConnectionManager() {
		return connectionManager;
	}

	public static void setConnectionManager(ConnectionManager connection) {
		JdbcDepartmentDao.connectionManager = connection;
	}
}