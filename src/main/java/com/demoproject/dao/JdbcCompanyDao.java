package com.demoproject.dao;

import com.demoproject.data.Company;
import com.demoproject.data.Department;
import com.demoproject.connection.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JdbcCompanyDao implements CompanyDao {

	private static ConnectionManager connectionManager;
	private final DepartmentDao departmentDao;
	private static final String ADD_COMPANY = "insert into company (name, number, countPerson, idDepartment) values (?,?,?,?)";
	private static final String GET_COMPANY = "select * from company where id=?";
	private static final String GET_ALL_COMPANIES = "select * from company";
	private static final String UPDATE_COMPANY = "update company set name=?,  number=?, countPerson=?, idDepartment=? where id=?";
	private static final String DELETE_COMPANY = "delete from company where id=?";

	public JdbcCompanyDao() {
		connectionManager = ConnectionManager.getInstance();
		departmentDao = new JdbcDepartmentDao();
	}

	@Override
	public void add(Company company) {
		try {
			Connection connection = connectionManager.getConnection();
			PreparedStatement st = connection.prepareStatement(ADD_COMPANY);
			st.setString(1, company.getName());
			st.setInt(2, company.getCountPerson());
			st.setInt(3, company.getDepartment().getId());
			st.executeUpdate();
			ResultSet rs = st.getGeneratedKeys();
			if (rs.next()) {
				int key = rs.getInt(1);
				company.setId(key);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Company getById(int id) {
		Company company = null;
		try {
			Connection connection = connectionManager.getConnection();
			PreparedStatement st = connection.prepareStatement(GET_COMPANY);
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				String name = rs.getString("name");
				int countPerson = rs.getInt("countPerson");
				int idDepartment = rs.getInt("idDepartment");
				Department department = departmentDao.getById(idDepartment);
				company = new Company(id, name, countPerson, department);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return company;
	}

	@Override
	public List<Company> getAll() {
		List<Company> companies = new ArrayList<>();
		try {
			Connection connection = connectionManager.getConnection();
			PreparedStatement st = connection.prepareStatement(GET_ALL_COMPANIES);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int countPerson = rs.getInt("countPerson");
				int idDepartment = rs.getInt("idDepartment");
				Department department = departmentDao.getById(idDepartment);
				companies.add(new Company(id, name, countPerson, department));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return companies;
	}

	@Override
	public void update(Company company) {
		try {
			Connection connection = connectionManager.getConnection();
			PreparedStatement st = connection.prepareStatement(UPDATE_COMPANY);
			st.setString(1, company.getName());
			st.setInt(2, company.getCountPerson());
			st.setInt(3, company.getDepartment().getId());
			st.setInt(4, company.getId());
			st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteById(int id) {
		try {
			Connection connection = connectionManager.getConnection();
			PreparedStatement st = connection.prepareStatement(DELETE_COMPANY);
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
		JdbcCompanyDao.connectionManager = connection;
	}
}
