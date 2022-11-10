package com.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	


	public static Connection provideConection() {
		
		Connection conn=null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		try {
			String url="jdbc:mysql://localhost:3306/mgnarega";
			
		conn = DriverManager.getConnection(url,"root","1234");
		
		
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return conn;
	}
}
