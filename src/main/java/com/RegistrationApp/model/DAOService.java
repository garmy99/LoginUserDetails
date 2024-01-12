package com.RegistrationApp.model;

import java.sql.ResultSet;

public interface DAOService {

	       public void connectDb();
	       public boolean verifyLogin(String email, String password);
	       public void saveRegistration(String name, String city, String email, String mobile);
	       public void deleteRegistration(String email);
	       public ResultSet getAllRegistrations();
		   public void updateRegistration(String mobile, String email);
		 
	      
	       
	
}
