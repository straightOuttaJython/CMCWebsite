/**
 * 
 */
package cmc.ui;

import java.util.Scanner;


import cmc.entity.Person;
import cmc.entity.School;
import cmc.home.PersonHome;
import cmc.home.SchoolHome;

/**
 * @author Alex Seefeldt, Erin Queme 
 * 
 * @version April 1, 2016
 *
 */
public class AdminUI {
	
	/**
	 * Creates a schoolHome to access and process the information of the database
	 */
	private SchoolHome sh;

	/**
	 * Scanner used in various methods.
	 */
	private Scanner adminOptions, editUser, deactUser, addOrEdit, again, in, inTwo, userNameIn, addUser;

	/**
	 * Create a new AdminUI.
	 */
	public AdminUI() 
	{
		// TODO Auto-generated constructor stub
		sh = new SchoolHome();
	}
	
	/**
	 * Add the given School object to the database. 
	 */
	public void addSchool(String name, String state, String location, String control, 
			int numStudentsEnrolled, double percentFemEnrolled, double satVerbal, double satMath,
			double tuition, double percentFinAid, int numApplicants, double admitRate, 
			double decideRate, int academics, int socialLife, int qualityLife) throws IllegalArgumentException
	{
		SchoolHome aSH = new SchoolHome();
		School[] listOfSchools = aSH.listOfSchools();
		
		for(int i =0; i < listOfSchools.length; i++)
		{
			if(listOfSchools[i].getName().equals(name))
			{
				throw new IllegalArgumentException("The school " + name + " already exists in the system.");
			}
		}
		aSH.addSchool(name,state,location,control,
				numStudentsEnrolled,percentFemEnrolled, satVerbal, satMath, tuition, percentFinAid,
				numApplicants, admitRate,decideRate,academics,socialLife,qualityLife);
	}
	
	/**
	 * Update the given School with the data inside it.
	 * @param school the updated School
	 */
	public void editSchool(String name, String state, String location, String control, 
			int numStudentsEnrolled, double percentFemEnrolled, double satVerbal, double satMath,
			double tuition, double percentFinAid, int numApplicants, double admitRate, 
			double decideRate, int academics, int socialLife, int qualityLife) 
	{
		boolean notFound = true;
		SchoolHome eSH = new SchoolHome();
		School[] list = eSH.listOfSchools();
		for(int i =0; i < list.length; i++)
		{
			if(list[i].getName().equals(name))
			{
				notFound = false;
				eSH.updateSchool(name, state, location, control, numStudentsEnrolled, percentFemEnrolled, satVerbal, 
						satMath, tuition, percentFinAid, numApplicants, admitRate, decideRate, academics, socialLife, qualityLife);
			}
		}
		if(notFound) {
			throw new IllegalArgumentException("The school " + name + " already exists in the system.");
		}
	}

	/**
	 * Lets you update the Users info by username
	 * @param username
	 */
	public void editUser(String username, String firstName, String lastName,
			String password, char type, char status) throws IllegalArgumentException
	{
		boolean notFound = true;
		PersonHome ph = new PersonHome();
		Person[] list = ph.getAllUsers();
		for(int i =0; i < list.length; i++)
		{
			if(list[i].getUsername().equals(username))
			{
				notFound = false;
				ph.updatePerson(username, firstName, lastName, password, type, status);
			} 
		}
		if(notFound) {
			throw new IllegalArgumentException("The account " + username + " does not exist.");
		}
	}

	/**
	 * Lets you deactivate the user by their username
	 * @param username
	 */
	public void deactivate(String username) 
	{
		PersonHome ph = new PersonHome();
		Person[] list = ph.getAllUsers();
		for(int i =0; i < list.length; i++)
		{
			if(list[i].getUsername().equals(username))
			{
				ph.deactivate(list[i]);
			}
		}
		
	}
	
	/**
	 * Lets you add a new User
	 */
	public void addUser(String firstName, String lastName, String username, String password, char type) 
	{
		boolean notFound = true;
		PersonHome ph = new PersonHome();
		Person[] list = ph.getAllUsers();
		for(int i =0; i < list.length; i++)
		{
			if(list[i].getUsername().equals(username))
			{
				notFound = false;
				ph.addUser(username, firstName, lastName, password, type);
			} 
		}
		if(notFound) {
			throw new IllegalArgumentException("The account " + username + " already exists.");
		}
	}
}
