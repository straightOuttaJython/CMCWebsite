package cmc.driver;

import cmc.controller.LoginController;
import cmc.entity.Person;
import dblibrary.project.csci230.UniversityDBLibrary;

public class Driver {

	/**
	 * Used to name the database and is the login username.
	 */
	private static String nameDB = "straightou";
	
	/**
	 * Database password.
	 */
	private static String passDB = "adem4";
	
	/**
	 * Generic main method to drive the classes.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UniversityDBLibrary db = new UniversityDBLibrary(nameDB, nameDB, passDB);
		//LoginController login = new LoginController();
		//String username = "bob";
		//String password = "obo";
		//Person person = login.login(username, password, db);
	}

}
