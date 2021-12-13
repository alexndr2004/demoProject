package com.demoproject.database;

import com.demoproject.dao.DepartmentDao;
import com.demoproject.dao.JdbcDepartmentDao;
import com.demoproject.data.Department;

import java.util.ArrayList;
import java.util.List;

public class DepartmentService {

	private Department department;
	private final DepartmentDao departmentDao = new JdbcDepartmentDao();

	public DepartmentService(Department department) {
		this.department = checkPerformance(department);
	}

	Department checkPerformance(Department department) {
		List<Department> departments = getSameDepartmens(department);
		double avgPerformance = getAvgPerformance(departments, department);
		updateDbDepartments(departments, avgPerformance);
		return department;
	}

	public void updateDbDepartments(List<Department> departments, double avgPerformance) {
		for (Department obj : departments) {
			obj.setPerformance(avgPerformance);
			departmentDao.update(obj);
		}
	}

	public double getAvgPerformance(List<Department> departments, Department department) {
		double sumPerformance = 0;
		int count = 0;
		for (Department obj : departments) {
			if (obj.getEmployee().isSynch() == department.isSynch()) {
				sumPerformance += obj.getEmployee().getPerformance();
				count++;
			}
		}
		return sumPerformance / count;
	}

	public List<Department> getSameDepartmens(Department department) {
		String name = department.getName();
		boolean change = department.isChange();
		boolean synch = department.isSynch();
		List<Department> departments = new ArrayList<>();
		for (Department departmentDb : departmentDao.getAll()) {
			String nameDb = departmentDb.getName();
			boolean changeDb = departmentDb.isChange();
			boolean synchDb = departmentDb.isSynch();
			if (nameDb.equals(name) && changeDb == change && synchDb == synch) {
				departments.add(departmentDb);
			}
		}
		departments.add(department);
		return departments;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
}