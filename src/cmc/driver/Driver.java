package cmc.driver;

import cmc.ui.AdminUI;
import cmc.ui.LoginUI;
import cmc.ui.UserUI;

public class Driver {


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
		if(login.getLoggedPerson().getType() == 'a') 
		{
			//admin stuff
			AdminUI admin = new AdminUI();
			admin.viewMenu();
		}
		else 
		{
			//user ui stuff
			UserUI user = new UserUI(login.getLoggedPerson());
			user.viewMenu();
		}
	}
}
