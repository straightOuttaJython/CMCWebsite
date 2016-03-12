package cmc.driver;

import cmc.ui.AdminUI;
import cmc.ui.LoginUI;
import cmc.ui.UserUI;

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
	public static void main(String[] args) 
	{
		// tests login
		LoginUI login = new LoginUI();
		login.login();
		
		//admin stuff
		AdminUI admin = new AdminUI();
		admin.viewMenu();
		

		//System.out.println("********** UPDATED **********");
		admin.manageSchools();
		
		//user ui stuff
		UserUI user = new UserUI(login.getLoggedPerson());
		user.viewMenu();
		

		UserUI user1 = new UserUI(login.getLoggedPerson());
		user1.viewMenu();
		user1.manageUserProfile();
		user1.logout(login);
	}
}
