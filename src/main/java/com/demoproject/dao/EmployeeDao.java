package com.demoproject.dao;

import com.demoproject.data.Employee;

import java.util.List;

public interface EmployeeDao {

	void add(Employee employee);

	Employee getById(int id);

	List<Employee> getAll();

	void update(Employee employee);

	void deleteById(int id);
}