package cmc.ui;

import java.util.Scanner;

import cmc.controller.LoginController;
import cmc.entity.Person;

public class LoginUI 
{
	private LoginController logControl;
	private Person user;
	
	public void login()
	{
		Scanner s = new Scanner(System.in);
		System.out.print("# Enter a username: " );
		String username = s.next();
		System.out.print("# Enter a password: " );
		String password = s.next();
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
	
	public void resetForm()
	{
		System.out.println("*** FORM WILL BE RESETED BY THE GREAT AND OMNIPOTENT BEING THAT IS IMAD RAHAL ***");
	}
	
	public void denyLogin()
	{
		System.out.println("*** USERNAME OR PASSWORD INVALID ***");
		this.resetForm();
	}
}
