package com.student_app.model;

import java.sql.ResultSet;

public interface DAO {
	
	public void connectDB();
	
	public boolean verifyLoginCreditails(String email, String password);

	public void NewRegistration(String name, String city, String email, String mobile);

	public ResultSet getAllRegistrations();

	public void DeleteRegistration(String email);

	

	public void UpdateReg(String email, String mobile);
	
	
}
