package com.dao;

import java.util.List;

import com.bean.Employee;
import com.bean.GPM;
import com.bean.Project;

public interface GpmDao {

	 public String login(GPM gpm);
	 
	 public String createEmploye(Employee employee);
	 
	 public String assignProjectToEmployee(Project project_id,Employee emp_id,int wrok_days,int wage);
	 
	 public List<Employee> displayEmployeeDetails();
	 
	 
	 
	 
	 
	 
}


//Login into their Account.
//2. Create Employee.
//3. View the Details of Employee.
//4. Assign Employee to a Project.
//5. View total number of days Employee worked in a project and also their wages.