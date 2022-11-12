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

	 public GPM loginGPM(GPM gpm) throws GpmException;
	 
	 public int createEmploye(Employee employee) throws EmployeeException;
	 
	 public String assignProjectToEmployee(Project project_id,Employee emp) throws EmployeeException, ProjectException;
	 
	 public List<EmployeeDto> displayEmployeeDetails() throws EmployeeException;
	 
	 
	 
	 
	 
	 
}

