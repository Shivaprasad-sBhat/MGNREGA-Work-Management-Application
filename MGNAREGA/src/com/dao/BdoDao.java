package com.dao;

import java.util.List;

import com.bean.BDO;
import com.bean.Employee;
import com.bean.GPM;
import com.bean.Project;
import com.exception.BdoException;
import com.exception.GpmException;
import com.exception.ProjectException;

public interface BdoDao {

	public String loginBDO(BDO bdo)  throws BdoException;
	
	public int createProject(Project project)  throws ProjectException;
	
	public List<Project> displayProject() throws ProjectException;
	
	public int createGPM(GPM gpm) throws GpmException;
	
	public List<GPM> displayGPM();
	
	public String allocateProjectTOGPM(Project projectid,GPM gpmid);
	
	public List<Employee> displayProjectEmployeDetails();
	
	
	
	
}




//1. Login into their account.
//2. Create a project.
//3. View List Of Project.
//4. Create new Gram Panchayat Member(GPM).
//5. View all the GPM.
//6. Allocate  Project to GPM
//7. See List of Employee working on that Project and their wages.