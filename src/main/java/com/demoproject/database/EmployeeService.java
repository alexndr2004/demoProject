package com.demoproject.database;

import com.demoproject.data.Employee;
import com.demoproject.data.Preference;

public class EmployeeService {

	private Employee employee;

	public EmployeeService(Employee employee) {
		this.employee = checkPreference(employee);

	}

	public Employee checkPreference(Employee employee) {
		int begin = employee.getBegin();
		Preference preference = employee.getPreference();
		boolean synch = employee.isSynch();
		double performance = 1.0;
		int hours = employee.getHours();
		double percent = employee.getPercent();
		int beginDiff = 9 - begin;
		employee.setEndWork(begin + 9);
		if (preference.equals(Preference.OFFICE)) {
			performance -= Math.abs(beginDiff) * 0.2;
		} else if (preference.equals(Preference.BEFORE)) {
			performance += beginDiff * 0.2;
		} else if (preference.equals(Preference.AFTER)) {
			performance += (-1) * beginDiff * 0.2;
		} else if (preference.equals(Preference.HOMEWORK) && synch == true) {
			performance -= Math.abs(beginDiff) * 0.2;
		}
		employee.setPerformance(validPerformance(performance));
		employee.setSalary((performance * hours) + (hours * percent));
		if (employee.getSalary() <= 0) {
			employee.setSalary(0.1);
		}
		return employee;
	}

	double validPerformance(double performance) {
		if (performance <= 0) {
			performance = 0.01;
		}
		return performance;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
}