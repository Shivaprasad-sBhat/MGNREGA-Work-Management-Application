
package com.dao;

import com.bean.Employee;
import com.exception.EmployeeException;

public interface EmployeeDao {

	public Employee LoginEmployee(Employee employee) throws EmployeeException;
	
	public Employee displayEmployeeDetails();
	
	public int applyForWork();
	
	
}



