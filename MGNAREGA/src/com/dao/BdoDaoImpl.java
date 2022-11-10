package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.bean.BDO;
import com.bean.Employee;
import com.bean.GPM;
import com.bean.Project;
import com.dbutil.DBUtil;
import com.exception.BdoException;
import com.exception.GpmException;
import com.exception.ProjectException;

public class BdoDaoImpl implements BdoDao {

	BDO bdo =new BDO();
	
//	public static void main(String[] args) {
//		BdoDao bd=new BdoDaoImpl();
//		try {
//			String s=bd.loginBDO(new BDO(0,null,"ram@123","1234",null,0));
//			System.out.println(s);
//		} catch (BdoException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	
	
	
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
		
		PreparedStatement ps =	conn.prepareStatement("insert into project(p_name,proj_amount,total_work_days) values('road repair',2000000,62);");
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
	public List<GPM> displayGPM() {
		
		List<GPM> li = null;
		
		
		
	try(Connection conn = DBUtil.provideConection()){
		PreparedStatement ps =	conn.prepareStatement("");
		
		
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
		
		return li;
	}

	@Override
	public String allocateProjectTOGPM(Project projectid, GPM gpmid) {
		
		String message="Project not allocated..";
		
		
		
	try(Connection conn=DBUtil.provideConection()){
		PreparedStatement ps=	conn.prepareStatement("");
		
		
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
		
		return message;
	}

	@Override
	public List<Employee> displayProjectEmployeDetails() {


		List<Employee> li=null;
		
		
		
	try(Connection conn=DBUtil.provideConection()){
		PreparedStatement ps=	conn.prepareStatement("");
		
		
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
		
		return li;
	}

}
