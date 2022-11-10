package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.bean.Employee;
import com.bean.GPM;
import com.bean.Project;
import com.dbutil.DBUtil;

public class GpmDaoImpl implements GpmDao {

	@Override
	public String login(GPM gpm) {

		String message= "Login failed";
		
	
		
	try(Connection conn = DBUtil.provideConection()) {
		
		PreparedStatement  ps=  conn.prepareStatement("select * from gpm where email=? and password=?");
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	

		
		return message;
	}
	
	

	@Override
	public String createEmploye(Employee employee) {

		String message= "Login failed";
		
	
		
	try(Connection conn = DBUtil.provideConection()) {
		
		PreparedStatement  ps=  conn.prepareStatement("select * from gpm where email=? and password=?");
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	

		
		return message;
	}

	@Override
	public String assignProjectToEmployee(Project project_id, Employee emp_id, int wrok_days, int wage) {

		String message= "Login failed";
		
	
		
	try(Connection conn = DBUtil.provideConection()) {
		
		PreparedStatement  ps=  conn.prepareStatement("select * from gpm where email=? and password=?");
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	

		
		return message;
	}

	@Override
	public List<Employee> displayEmployeeDetails() {

		List<Employee> li=null;
		
	
		
	try(Connection conn = DBUtil.provideConection()) {
		
		PreparedStatement  ps=  conn.prepareStatement("select * from gpm where email=? and password=?");
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	

		
		return li;
	}

}
