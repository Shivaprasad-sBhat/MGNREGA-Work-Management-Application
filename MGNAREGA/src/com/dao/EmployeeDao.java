
package com.dao;

import com.exception.EmployeeException;
import com.model.Employee;

public interface EmployeeDao {

	public Employee LoginEmployee(Employee employee) throws EmployeeException;
	
	public Employee displayEmployeeDetails();
	
	public int applyForWork();
	
	
}



