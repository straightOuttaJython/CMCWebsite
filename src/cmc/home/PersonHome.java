package cmc.home;

import cmc.entity.Person;
import cmc.entity.School;
import dblibrary.project.csci230.UniversityDBLibrary;

/**
 * The PersonHome controls the ebb and flow of Persons in the Choose my College system.
 * 
 * @author Matthew Kounniyom
 * @version March 6, 2016
 */
public class PersonHome {
	
	private UniversityDBLibrary db = new UniversityDBLibrary("straightou", "straightou", "adem4");
	
	/**
	 * The getPerson method takes in a username as a parameter and returns the Person associated with that username.
	 * 
	 * @param username
	 * @return the person object associated with the entered username.
	 */
	public Person getPerson(String username) 
	{
		Person[] personArray = this.getAllUsers();
		Person foundPerson = new Person();
		for(int i = 0; i < personArray.length; i++) 
		{
			if(personArray[i].getUsername().equals(username)) 
			{
				foundPerson = personArray[i];
			}
		}
		return foundPerson;
	}
	
	/**
	 * The updatePerson method takes in the person to be updated in the Choose my College database. 
	 * 
	 * @param person, the Person to be updated
	 */
	public void updatePerson(Person person) 
	{
		
	}
	
	/**
	 * The getAllUsers method returns an array of Persons that are all the users in the Choose my College database. 
	 * 
	 * @return an array of Persons.
	 */
	public Person[] getAllUsers() 
	{
		String[][] stringArray = db.user_getUsers();
		Person[] personArray = new Person[stringArray.length];
		for(int i = 0; i < stringArray.length; i++) 
		{
			String firstname = stringArray[i][0];
			String lastname = stringArray[i][1];
			String username = stringArray[i][2];
			String password = stringArray[i][3];
			char type = stringArray[i][4].charAt(0);
			char status = stringArray[i][5].charAt(0);
			String[][] savedArray = db.user_getUsernamesWithSavedSchools();
			School[] savedSchools = new School[10];
			if(savedArray != null) {
				int numberOfSavedSchools = 0;
				for(int p = 0; p < savedArray.length; p++) {
					if(savedArray[p].equals(username)) {
						numberOfSavedSchools++;
					}
				}
				savedSchools = new School[numberOfSavedSchools];
				if(numberOfSavedSchools > 0) {
					int length = 0;
					for(int p = 0; p < savedArray.length; p++) {
						if(savedArray[p].equals(username)) {
							String schoolName =  savedArray[p][0];
							SchoolHome sh = new SchoolHome();
							School[] school = sh.listOfSchools();
							for(int o = 0; 0 < school.length; o++) {
								if(school[o].getName().equals(schoolName))
									savedSchools[length] = school[o];
							}
							length++;
						}
					}
				}
			}
			personArray[i] = new Person(firstname, lastname, username, password, type, status, savedSchools);
		}
		return personArray;
	}
	
	/**
	 * The deactivate method deactivates the given user so that they no longer have access to the Choose my College system.
	 * 
	 * @param user, the user to be deactivated.
	 */
	public void deactivate(Person user) 
	{
		
	}
	
	/**
	 * The addUser method adds a new user to the Choose my College database. 
	 * 
	 * @param user, the new user to be added.
	 */
	public void addUser(Person user) {
		
	}
}
