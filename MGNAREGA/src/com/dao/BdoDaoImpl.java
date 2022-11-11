package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bean.BDO;
import com.bean.Employee;
import com.bean.EmployeeDto;
import com.bean.GPM;
import com.bean.Project;
import com.dbutil.DBUtil;
import com.exception.BdoException;
import com.exception.EmployeeException;
import com.exception.GpmException;
import com.exception.ProjectException;

public class BdoDaoImpl implements BdoDao {

	BDO bdo =new BDO();
	
//	public static void main(String[] args) throws Exception {
//		BdoDaoImpl bd=new BdoDaoImpl();
//	
//			String s=bd.loginBDO(new BDO(0,null,"ram@123","1234",null,0));
//			System.out.println(s);
//			
////			int x=	bd.createGPM(new GPM(0,"Guru","guru@123","1234","ylp",57000));
////			System.out.println(x);
//			System.out.println(bd.bdo);
//			Project p=new Project();
//			p.setP_name("irrigation");
//			p.setProj_amount(300000);
//			p.setTotal_workers(50);
//			int j=	bd.createProject(p);
//			System.out.println(j);
//			
//			String d=bd.allocateProjectTOGPM(2, 2);
//			
//			System.out.println(d);
//			
//	
//		
//	}
	
	
	
	// BDO Login
	@Override
	public String loginBDO(BDO b) throws BdoException {
		
		String message = "Login failed..";
		
		
		
	try(Connection conn = DBUtil.provideConection()){
		
		PreparedStatement ps=	conn.prepareStatement(" select * from bdo where email=? and password=?;");
		
		ps.setString(1, b.getEmail());
		ps.setString(2, b.getPassword());
		
	ResultSet rs =	ps.executeQuery();
	
	if(rs.next()) {
		int id = rs.getInt("bdo_id");
		String name = rs.getString("bdo_name");
		String email = rs.getString("email");
		String password = rs.getString("password");
		String address = rs.getString("address");
		int pincode = rs.getInt("pincode");
		
		bdo = new BDO(id,name,email,password,address,pincode);
		message = "Wellcome BDO: "+name;
	}
	else
		throw new BdoException("Provide correct information");
	} 
	catch (SQLException e) {
		
		throw new BdoException(e.getMessage());
	}
		
		return message;
	}
	
	
	
    //creating new project
	@Override
	public int createProject(Project project) throws ProjectException {
		
		int n = 0;
		
	try(Connection conn = DBUtil.provideConection()){
		
		PreparedStatement ps =	conn.prepareStatement("insert into project(p_name,proj_amount,total_work_days) values(?,?,?);");
		ps.setString(1, project.getP_name());
		ps.setInt(2, project.getProj_amount());
		ps.setInt(3, project.getTotal_workers());
		
		n = ps.executeUpdate();
		
		if(n<0)
		{
			throw new ProjectException("Project not created..!");
		}
	} 
	catch (SQLException e) {
		
		throw new ProjectException(e.getMessage());
		
	}
		
		
		return n;
	}

	//diplay projects
	@Override
	public List<Project> displayProject() throws ProjectException {
		
		List<Project> li=null;
		
		
	try(Connection conn = DBUtil.provideConection()){
		PreparedStatement ps =	conn.prepareStatement("select * from project");
		
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()) {
			
			while(rs.next()) {
				int id = rs.getInt("project_id");
				String p_name = rs.getString("p_name");
				int proj_amount = rs.getInt("proj_amount");
				int twd = rs.getInt("total_work_days");
				
				Project proj = new Project(id,p_name,proj_amount,twd);
				
				li.add(proj);
				
			}
			
		}
		else {
			throw new ProjectException("Project not found..!");
		}
		
		
	} 
	catch (SQLException e) {
		throw new ProjectException(e.getMessage());
	}
		
		
		return li;
	}

	//create GPM
	@Override
	public int createGPM(GPM gpm) throws GpmException {
		
		int n = 0;
			
	try(Connection conn = DBUtil.provideConection()){
		
		PreparedStatement ps =	conn.prepareStatement("insert into gpm(gpm_name,email,password,address,pincode) values(?,?,?,?,?);");
		ps.setString(1,gpm.getGpm_name());
		ps.setString(2, gpm.getEmail());
		ps.setString(3, gpm.getPassword());
		ps.setString(4,gpm.getAddress());
		ps.setInt(5, gpm.getPincode());
		
		n = ps.executeUpdate();
		
		if(n<=0)
			throw new GpmException("Wrong information..!");
		
	} 
	catch (SQLException e) {
		throw new GpmException(e.getMessage());
	}
		
		return n;
	}

	
	//display GPM
	@Override
	public List<GPM> displayGPM() throws GpmException {
		
		List<GPM> li = null;
		
		
		
	try(Connection conn = DBUtil.provideConection()){
		PreparedStatement ps =	conn.prepareStatement("select * from gpm");
		
		 ResultSet rs = ps.executeQuery();
		
		 if(rs.next())
		 {
		 while(rs.next()) {
			 
			 int id = rs.getInt("gpm_id");
			 String name = rs.getString("gpm_name");
			 String email = rs.getString("email");
			 String password = rs.getString("password");
			 String address = rs.getString("address");
			 int pincode = rs.getInt("pincode");
			 
			 GPM gpm = new GPM(id, name, email, password, address, pincode);
			 
			 li.add(gpm);
			 
		  }
		 }
		 else 
			 throw new GpmException("GPM not found..!");
		
	} catch (SQLException e) {
		 throw new GpmException(e.getMessage());
	}
		
		
		return li;
	}

	//Allocating project to GPM
	@Override
	public String allocateProjectTOGPM(Project projectid, GPM gpmid) throws ProjectException {
		
		String message="Project not allocated..";
		
		
		
	try(Connection conn=DBUtil.provideConection()){
		
		PreparedStatement ps = conn.prepareStatement("insert into project_allocate_gpm(bdo_id,gpm_id,project_id) values(?,?,?)");
		ps.setInt(1, bdo.getB_id());
		ps.setInt(2, gpmid.getGpm_id());
		ps.setInt(3, projectid.getProject_id());
		
		
		
		int n = ps.executeUpdate();
		
		if(n!=0) {
			message="Project  allocated succesfully..";
		}
		else
			throw new ProjectException("Project allocation failed");
		
	} catch (SQLException e) {
		throw new ProjectException(e.getMessage());
	}
		
		
		return message;
	}

	@Override
	public List<EmployeeDto> displayProjectEmployeDetails() throws EmployeeException {


		List<EmployeeDto> li=new ArrayList();
		
		
		
		try(Connection conn = DBUtil.provideConection()) {
			
			PreparedStatement  ps =  conn.prepareStatement("select e.emp_id,e.emp_name,e.email,p.p_name Project,e.total_working_days,e.salary from project_allocate_employee pae inner join employee e on pae.emp_id=e.emp_id inner join project p on pae.project_id=p.project_id;");
			
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
}

//select  p.project_id,pj.p_name,b.bdo_id,b.bdo_name,g.gpm_id,g.gpm_name,g.address,g.pincode from project_allotment p inner join gpm g on g.gpm_id=p.gpm_id inner join bdo b on b.bdo_id=p.bdo_id inner join project pj on p.project_id=pj.project_id;
