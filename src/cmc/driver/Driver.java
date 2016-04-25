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
		
			
		System.out.println("***************REMEBER TO SEE ABOVE BEFORE GOING FORWARD***************\n");
		System.out.println("***************THIS IS AN INTRACTIVE VIEW OF OUR WEBSITE***************\n");
		LoginUI login = new LoginUI();
		if(login.getLoggedPerson().getType() == 'a') 
		{
			//admin stuff
			AdminUI admin = new AdminUI(login.getLoggedPerson());
		}
		else 
		{
			//user ui stuff
			UserUI user = new UserUI(login.getLoggedPerson());
		}
	}
}
