package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.dbutil.DBUtil;
import com.exception.EmployeeException;
import com.model.Employee;

public class EmployeeDaoImpl implements EmployeeDao {
	
	Employee emp = new Employee();
	
	@Override
	public Employee LoginEmployee(Employee employee) throws EmployeeException {
	
		try(Connection conn = DBUtil.provideConection()) {
 
		PreparedStatement ps =	conn.prepareStatement("select * from employee where email=? and password=?");
		
		ResultSet rs = 	ps.executeQuery();
		
	
		if(rs.next()) {
			
			int id = rs.getInt("emp_id");
			String name = rs.getString("emp_name"); 
			String email = rs.getString("email"); 
			String password = rs.getString("password"); 
			int salary = rs.getInt("salary");
			int twd = rs.getInt("total_working_days");
			
			emp = new Employee(id, name, email, password, salary, twd);
			
			
		}
		else {
			throw new EmployeeException("Employee details not found!");
		}
		
		
 	}catch (SQLException e) {
		System.out.println(e.getMessage());
		
	}
		return emp;
		
	}

	@Override
	public Employee displayEmployeeDetails() {
		
		return emp;
	}

	@Override
	public int applyForWork() {
		// TODO Auto-generated method stub
		return 0;
	}



}
