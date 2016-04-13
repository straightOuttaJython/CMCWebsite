package cmc.ui;

import java.util.Scanner;

import cmc.controller.LoginController;
import cmc.controller.LoginController.InactiveAccountException;
import cmc.entity.Person;


/**
 * The LogUI is a boundary that Logs in the person bound to the given username through the login method.
 * 
 * @author Matthew Kounniyom, Erin Queme
 * @version April 1, 2016
 */
public class LoginUI 
{
	/*
	 * Creates a LoginController to process the information between this UI and the dataBase
	 */
	private LoginController logControl = new LoginController();
	
	/*
	 * A Person named user is created to access its information
	 */
	private Person user;
	
	/**
	 * Used to handle logging in.
	 * 
	 * @param	username, the username that is entered.
	 * @param	password, the password that is entered.
	 * @return the user or admin that has logged in
	 */
	public Person login(String username, String password)
	{
		try {
			user = logControl.login(username, password);
		} catch(InactiveAccountException inactive) {
			System.out.println("Inactive");
		} catch(IllegalArgumentException illegal) {
			System.out.println("Illegal");
		}
		return user;
	}
	
	/**
	 * Gets the logged in person.
	 * 
	 * @return user, the person successfully logged in.
	 */
	public Person getLoggedPerson() {
		return this.user;
	}
}
