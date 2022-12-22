package com.dao;

import java.util.List;

import com.exception.EmployeeException;
import com.exception.GpmException;
import com.exception.ProjectException;
import com.model.Employee;
import com.model.EmployeeDto;
import com.model.GPM;
import com.model.GpmDto;
import com.model.Project;

public interface GpmDao {

	 public GPM loginGPM(GPM gpm) throws GpmException;
	 
	 public int createEmploye(Employee employee) throws EmployeeException;
	 
	 public int assignProjectToEmployee(Project project_id,Employee emp) throws EmployeeException, ProjectException;
	 
	 public List<EmployeeDto> displayEmployeeDetails() throws EmployeeException;
	 
	 public List<GpmDto> displayProjectAssignedToGpm() throws ProjectException ;
	 
	 
	 
	 
	 
}

