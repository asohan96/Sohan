package com.lti.service;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import sun.font.CreatedFontTracker;

public class DBLoginService {
	Connection conn = null;
	
	PreparedStatement stmt=null,stmt2;
	ResultSet rs = null;

	 String driver = "oracle.jdbc.OracleDriver";
	 String url = "jdbc:oracle:thin:@localhost:1521:xe";
	public boolean isValidUser(String username, String password) {
		
		try {
			Class.forName(driver);
			System.out.println("Driver Loaded");
			conn = DriverManager.getConnection(url, "stuser", "sohan123");
			System.out.println("Connection Established");
			stmt=conn.prepareStatement("select count(1) from  "
																	+ "TBL_USER "
																	+ "where username=? and password=? "
																	+ "and active='y'");
			stmt.setString(1, username);
			stmt.setString(2, password);
			
			rs = stmt.executeQuery();
			if(rs.next())
			{
				 int count = rs.getInt(1);
				if(count==1)
					return true;
					return false;
			}else
					return false;
			}
		 catch (Exception e) {	//bad,should catch individual exceptions
			//System.out.println("NO SUCH USER...");	//very bad,should throw user defined exception instead
			 //System.out.println(e);
			 
			 e.printStackTrace();
			 return false;
			
		} finally {
			try { rs.close();}catch(Exception e) {}
			try { stmt.close();}catch(Exception e) {}
			try { conn.close();}catch(Exception e) {}
			}
	}

		public String fullname(String username)
		{
			try {
				Class.forName(driver);
				conn = DriverManager.getConnection(url, "stuser", "sohan123");
				String sql2="select fullname from tbl_user where username =?";
				stmt2=conn.prepareStatement(sql2);
				stmt2.setString(1, username);
				rs=stmt2.executeQuery();
				if(rs.next())
				{
					String fname=rs.getString("fullname");
					return fname;
				}
				else
					return "anonymous";
			} catch (ClassNotFoundException e) {
			
				e.printStackTrace();
				return "anonymous";
			} catch (SQLException e) {
				
				e.printStackTrace();
				return "anonymous";
			}
			
		}
}

		
	
