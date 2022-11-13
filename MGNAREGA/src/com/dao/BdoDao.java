package com.dao;

import java.util.List;

import com.bean.BDO;
import com.bean.Employee;
import com.bean.EmployeeDto;
import com.bean.GPM;
import com.bean.Project;
import com.exception.BdoException;
import com.exception.EmployeeException;
import com.exception.GpmException;
import com.exception.ProjectException;

public interface BdoDao {

	public BDO loginBDO(BDO bdo)  throws BdoException;
	
	public int createProject(Project project)  throws ProjectException;
	
	public List<Project> displayProject() throws ProjectException;
	
	public int createGPM(GPM gpm) throws GpmException;
	
	public List<GPM> displayGPM() throws GpmException;
	
	public String allocateProjectTOGPM(Project projectid, GPM gpmid) throws ProjectException;
	
	public List<EmployeeDto> displayProjectEmployeDetails() throws EmployeeException;
	
	
	
	
}



