package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dbutil.DBUtil;
import com.exception.EmployeeException;
import com.exception.GpmException;
import com.exception.ProjectException;
import com.model.Employee;
import com.model.EmployeeDto;
import com.model.GPM;
import com.model.GpmDto;
import com.model.Project;

public class GpmDaoImpl implements GpmDao {

	GPM gpm=new GPM();
	
	
	@Override
	public GPM loginGPM(GPM gpm1) throws GpmException {

		String message= "Login failed";
		
	
		
	try(Connection conn = DBUtil.provideConection()) {
		
		PreparedStatement  ps=  conn.prepareStatement("select * from gpm where email=? and password=?");
		ps.setString(1, gpm1.getEmail());
		ps.setString(2, gpm1.getPassword());
		
	    ResultSet rs= ps.executeQuery();
	      
	      		if(rs.next()) {
			   		int id = rs.getInt("gpm_id");
				   String gpm_name = rs.getString("gpm_name");
				   String email = rs.getString("email");
				   String password = rs.getString("password");
				   String address = rs.getString("address");
				   int pincode = rs.getInt("pincode");
				   
				   gpm=new GPM(id, gpm_name, email, password, address, pincode);
				   message="Wellcome GPM: "+gpm_name;
				   
	      		}
	      		else {
	      			
	      			throw new GpmException("GPM not found..!");
	      		}
		
	} catch (SQLException e) {
		throw new GpmException(e.getMessage());
	}
	
    return gpm;
	}
	
	

	@Override
	public int createEmploye(Employee emp) throws EmployeeException {

		int n=0;
				
	try(Connection conn = DBUtil.provideConection()) {
		
		PreparedStatement  ps=  conn.prepareStatement("insert into employee(emp_name,email,password) values(?,?,?)");
		ps.setString(1, emp.getName());
		ps.setString(2, emp.getEmail());
		ps.setString(3, emp.getPassword());
	
		
		 n = ps.executeUpdate();
		
		if(n<0) {
		
			throw new EmployeeException("Employee not created..!");
		}
	} 
	catch (SQLException e) {
		throw new EmployeeException(e.getMessage());
	}
	
		return n;
	}

	@Override
	public int assignProjectToEmployee(Project project_id, Employee emp) throws EmployeeException, ProjectException {

		String message= "Project not assigned to employee.";
		int n=0;
	
		
	try(Connection conn = DBUtil.provideConection()) {
		PreparedStatement  ps=  conn.prepareStatement("select allotement_id from project_allocate_gpm where project_id=? and gpm_id=?");
		ps.setInt(1, project_id.getProject_id());
		ps.setInt(2,gpm.getGpm_id());
		
		ResultSet rs = ps.executeQuery();
		
		int gpm_allotement_id=0;
		
		if(rs.next())
		{
			gpm_allotement_id = rs.getInt("allotement_id");
		}
		else {
			throw new ProjectException("This project not assigned to GPM "+gpm.getGpm_name());
		}
		
		
		PreparedStatement  ps1=  conn.prepareStatement("insert into project_allocate_employee(gpm_allotement_id,project_id,emp_id,salary,total_working_days) values (?,?,?,?,?)");
		ps1.setInt(1,gpm_allotement_id);
		ps1.setInt(2, project_id.getProject_id());
		ps1.setInt(3, emp.getEmp_id());
		ps1.setInt(4, emp.getSalary());
		ps1.setInt(5, emp.getTotal_working_days());
	
		
		 n = ps1.executeUpdate();
		
		
		
		if(n>0) {
			message="Project is assigned to employee";
			PreparedStatement  ps2=  conn.prepareStatement("update employee set total_working_days=? , salary=? where emp_id=?");	
			ps2.setInt(1, emp.getTotal_working_days());
			ps2.setInt(2, emp.getSalary());
			ps2.setInt(3, emp.getEmp_id());
			
			ps2.executeUpdate();
		}
		else {
			throw new EmployeeException("Project not assigned to employee..!");
		}
		
		
		
		
	} catch (SQLException e) {
		throw new EmployeeException(e.getMessage());
	}
	

		
		return n;
	}

	@Override
	public List<EmployeeDto> displayEmployeeDetails() throws EmployeeException {

		List<EmployeeDto> li=new ArrayList();
		
	
		
	try(Connection conn = DBUtil.provideConection()) {
		
		PreparedStatement  ps =  conn.prepareStatement(" select e.emp_id,e.emp_name,e.email,p.p_name Project,e.total_working_days,e.salary from project_allocate_employee pae inner join employee e on pae.emp_id=e.emp_id inner join project p on pae.project_id=p.project_id inner join project_allocate_gpm pag on pag.allotement_id=pae.gpm_allotement_id where pag.gpm_id=?");
		ps.setInt(1, gpm.getGpm_id());
		
		ResultSet rs = ps.executeQuery();
	if(rs.next()) {
		while(rs.next()) {
			int id = rs.getInt("emp_id");
			String name = rs.getString("emp_name");
			String email = rs.getString("email");
			String project = rs.getString("Project");
			int twd= rs.getInt("total_working_days");
			int salary = rs.getInt("salary");
			int total=twd*salary;
			
			EmployeeDto empdto=new EmployeeDto(id,name,email,project,twd,salary,total);
			li.add(empdto);
		}
	}
		else {
			
			throw new EmployeeException("Employee details not found..");
		}
		
	} catch (SQLException e) {
		throw new EmployeeException(e.getMessage());
	}
	
		return li;
	}



	@Override
	public List<GpmDto> displayProjectAssignedToGpm() throws ProjectException {
		
		
		List<GpmDto> li=new ArrayList();
		
		
		
		try(Connection conn = DBUtil.provideConection()) {
			
			PreparedStatement  ps =  conn.prepareStatement("select g.gpm_id,g.gpm_name,g.email,g.address,g.pincode,p.p_name,p.project_id,p.proj_amount,p.total_work_days from project_allocate_gpm pg inner join gpm g on g.gpm_id=pg.gpm_id  inner join project  p on pg.project_id=p.project_id where  g.gpm_id=?");
			ps.setInt(1, gpm.getGpm_id());
			
			ResultSet rs = ps.executeQuery();
		
			if(rs.next()) {
			while(rs.next()) {
				int gid = rs.getInt("gpm_id");
				String name = rs.getString("gpm_name");
				String email = rs.getString("email");
				String address = rs.getString("address");
				int pincode = rs.getInt("pincode");
				String project = rs.getString("p_name");
				int pid= rs.getInt("project_id");
				int amount = rs.getInt("proj_amount");
				int twd= rs.getInt("total_work_days");
				
				GpmDto gpmdto = new GpmDto(gid, name, email, address, pincode, pid, project, amount, twd);
				
				li.add(gpmdto);
			}
		}
			else {
				
				throw new ProjectException("Project details not found..");
			}
			
		} catch (SQLException e) {
			throw new ProjectException(e.getMessage());
		}
		
		
		return li;
	}

}
