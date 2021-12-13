package com.demoproject.dao;

import com.demoproject.data.Company;

import java.util.List;

public interface CompanyDao {

	void add(Company company);

	Company getById(int id);

	List<Company> getAll();

	void update(Company company);

	void deleteById(int id);
}