package com.demoproject.dao;

import com.demoproject.data.Department;

import java.util.List;

public interface DepartmentDao {

	void add(Department department);

	Department getById(int id);

	List<Department> getAll();

	void update(Department department);

	void deleteById(int id);
}