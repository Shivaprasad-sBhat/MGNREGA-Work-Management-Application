package com.dao;

import com.bean.Employee;

public interface EmployeeDao {

	public String LoginEmployee(Employee employee);
	
	public String displayEmployeeDetails();
	
	public int withdrwSalary(int amount);
	
	
}
