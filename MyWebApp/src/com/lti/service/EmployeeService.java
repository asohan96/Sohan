package com.lti.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class EmployeeService {

	public Employee getEmployeeDetails(int empId) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","Newuser123");
			String sql = "select "
								+ "first_name, last_name,"
								+ "email, phone_number, hire_date,"
								+ "salary from employees where employee_id = ?";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, empId);
			rs = stmt.executeQuery();
			if(rs.next()) {
				Employee emp = new Employee();
				emp.setEmployeeId(empId);
				emp.setFirstName(rs.getString(1));
				emp.setLastName(rs.getString(2));
				emp.setEmail(rs.getString(3));
				emp.setPhoneNumber(rs.getString(4));
				emp.setHireDate(rs.getString(5));
				emp.setSalary(rs.getDouble(6));
				return emp;
			}
			else
				return null; //should throw exception
		}
		catch(Exception e) { //bad, should catch individual exception(s)
			e.printStackTrace(); //very bad, should throw user defined exception instead
			return null;
		}
		finally {
			try { rs.close(); } catch(Exception e) { }
			try { stmt.close(); } catch(Exception e) { }
			try { conn.close(); } catch(Exception e) { }
		}

	}
}
