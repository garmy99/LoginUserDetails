package com.RegistrationApp.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DAOServiceImpl implements DAOService {

	private Connection con;
	private Statement stmnt;

	@Override
	public void connectDb() {
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/regnewdb", "root", "test");
			stmnt = con.createStatement();

			System.out.println(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean verifyLogin(String email, String password) {

		try {

			ResultSet results = stmnt
					.executeQuery("select * from login where email='" + email + "'and password='" + password + "'");
			if (results.next()) {
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public void saveRegistration(String name, String city, String email, String mobile) {
		try {
			stmnt.executeUpdate("insert into registration values ('" + name + "', '" + city + "', '" + email + "', '"
					+ mobile + "')");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteRegistration(String email) {
		try {
			stmnt.executeUpdate("Delete from registration where email='" + email + "'");
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
	public void updateRegistration(String mobile, String email) {
		try {
			stmnt.executeUpdate("UPDATE registration SET mobile = '"+mobile+"' WHERE email= '"+email+"'");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
