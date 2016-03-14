package cmc.ui;

import java.util.Scanner;

import cmc.controller.LoginController;
import cmc.entity.Person;


/**
 * The LogUI is a boundary that Logs in the person bound to the given username through the login method.
 * 
 * @author Matthew Kounniyom, Erin Queme
 * @version March 11, 2016
 */
public class LoginUI 
{
	private LoginController logControl;
	private Person user;
	private Scanner s;
	
	/**
	 * Used to handle logging in.
	 */
	public void login()
	{
		s = new Scanner(System.in);
		System.out.println(" * ENTER \"reset\" IF RESET IS NEEDED *");
		System.out.print("# Enter a username: " );
		String username = s.next();
		if(username.equals("reset")) {
			this.resetForm();
		} else {
			System.out.print("# Enter a password: " );
			String password = s.next();
			if(password.equals("reset")) {
				this.resetForm();
			} else {
				logControl = new LoginController();
				user = logControl.login(username, password);
				if(user.getFirstName().equals("")) 
				{
					this.denyLogin();
				} 
				else
				{
					System.out.println("*** YOU HAVE SUCCESSFULLY LOGGED-IN ***");
				}
			}
		}
	}
	
	/**
	 * Is called if the the form is needed to be reset.
	 */
	public void resetForm()
	{
		System.out.println("*** FORM WILL BE RESETED BY THE GREAT AND OMNIPOTENT BEING THAT IS IMAD RAHAL ***");
		this.login();
	}
	
	/**
	 * Used to alert the user if their username or password are not in the database.
	 */
	private void denyLogin()
	{
		System.out.println("*** USERNAME OR PASSWORD INVALID ***");
		this.resetForm();
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
