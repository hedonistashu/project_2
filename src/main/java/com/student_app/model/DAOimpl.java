package com.student_app.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;





public class DAOimpl implements DAO {
	
	private Connection con;
	private Statement stmnt;
	
	@Override
	public void connectDB() {
		
					try {
						Class.forName("com.mysql.jdbc.Driver");
						con = DriverManager.getConnection("jdbc:mysql://localhost:3306/registration", "root", "test");
						stmnt =  con.createStatement();
						System.out.println("connect to db");
						
					} catch (Exception e) {
					
						e.printStackTrace();
					}
	}
	
	@Override
	public boolean verifyLoginCreditails(String email, String password) {
		try {
			
			ResultSet result = stmnt.executeQuery("select * from login where email ='"+email+"' and password='"+password+"'");
			return result.next();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public void NewRegistration(String name, String city, String email, String mobile) {
		
		try {
			
			stmnt.executeUpdate("insert into registration values('"+name+"','"+city+"','"+email+"','"+mobile+"')");
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public ResultSet getAllRegistrations() {
		
try {
			
			ResultSet result = stmnt.executeQuery("select * from registration");
			return result;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public void DeleteRegistration(String email) {
		
		try {
			stmnt.executeUpdate("delete from registration where email='"+email+"' ");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void UpdateReg(String email, String mobile) {
		
		
		try {
			
			stmnt.executeUpdate("update registration set mobile ='"+mobile+"' where email='"+email+"' ");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	

	

	
			
	
	

	

}
