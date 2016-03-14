package cmc.driver;

import cmc.entity.Person;
import cmc.home.PersonHome;
import cmc.ui.AdminUI;
import cmc.ui.LoginUI;
import cmc.ui.UserUI;

public class Driver {


	/**
	 * Generic main method to drive the classes.
	 * 
	 * @param args
	 */
	/**
	 * @param args
	 */
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		
		//Seeing all the Users Information
		System.out.println("*****ALL THE USER'S INFORMATION BEFORE PLAYING WITH THE WEBSITE*****");
		PersonHome person = new PersonHome();
		Person[] listOfPersons = person.getAllUsers();
		for(Person p : listOfPersons)
		{
			System.out.println(p.getUsername() + "'s Information: ");
			System.out.println("     First Name: " + p.getFirstName());
			System.out.println("     Last Name:  " + p.getLastName());
			System.out.println("     Password:   " + p.getPassword());
			System.out.println("     Status:     " + p.getStatus());
			System.out.println("     Type:       " + p.getType());
			System.out.println("     Username:   " + p.getUsername());
			System.out.println("*************************");
		}
		
		// tests login
		
		System.out.println("***************REMEBER TO SEE ABOVE***************\n");
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
		
		//Seeing all the Users Information
		System.out.println("*****ALL THE USER'S INFORMATION AFTER PLAYING WITH THE WEBSITE*****");
		PersonHome person1 = new PersonHome();
		Person[] listOfPersons1 = person1.getAllUsers();
		for(Person pe : listOfPersons1)
		{
			System.out.println(pe.getUsername() + "'s Information: ");
			System.out.println("     First Name: " + pe.getFirstName());
			System.out.println("     Last Name:  " + pe.getLastName());
			System.out.println("     Password:   " + pe.getPassword());
			System.out.println("     Status:     " + pe.getStatus());
			System.out.println("     Type:       " + pe.getType());
			System.out.println("     Username:   " + pe.getUsername());
			System.out.println("*************************");
		}
	}
}
