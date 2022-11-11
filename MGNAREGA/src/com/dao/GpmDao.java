package com.dao;

import java.util.List;

import com.bean.Employee;
import com.bean.EmployeeDto;
import com.bean.GPM;
import com.bean.Project;
import com.exception.EmployeeException;
import com.exception.GpmException;
import com.exception.ProjectException;

public interface GpmDao {

	 public String loginGPM(GPM gpm) throws GpmException;
	 
	 public String createEmploye(Employee employee) throws EmployeeException;
	 
	 public String assignProjectToEmployee(Project project_id,Employee emp) throws EmployeeException, ProjectException;
	 
	 public List<EmployeeDto> displayEmployeeDetails() throws EmployeeException;
	 
	 
	 
	 
	 
	 
}


//Login into their Account.
//2. Create Employee.
//3. View the Details of Employee.
//4. Assign Employee to a Project.
//5. View total number of days Employee worked in a project and also their wages.