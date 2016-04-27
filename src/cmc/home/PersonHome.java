package cmc.home;

import java.util.ArrayList;

import cmc.entity.Person;
import cmc.entity.School;
import dblibrary.project.csci230.UniversityDBLibrary;

/**
 * The PersonHome controls the ebb and flow of Persons in the Choose my College system.
 * 
 * @author Matthew Kounniyom
 * @version April 1, 2016
 */
public class PersonHome {
	
	private UniversityDBLibrary db = new UniversityDBLibrary("straightou", "straightou", "adem4");
	
	/**
	 * The getPerson method takes in a username as a parameter and returns the Person associated with that username.
	 * 
	 * @param username
	 * @return the person object associated with the entered username.
	 * @throws IllegalArgumentException, if the username is not bound to an account.
	 */
	public Person getPerson(String username) throws IllegalArgumentException
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
		if(!foundPerson.getUsername().equals(username)) 
		{
			throw new IllegalArgumentException("The entered username is not bound to an account.");
		}
		return foundPerson;
	}
	
	/**
	 * The updatePerson method takes in the person to be updated in the Choose my College database. 
	 * 
	 * @param person, the Person to be updated
	 */
	public int updatePerson(String username, String firstName, String lastName, String password, char type,
			char status)
	{
		if(type != 'u' && type != 'a') 
			throw new IllegalArgumentException("Invalid Type");
		if(status != 'Y' && status != 'N') 
			throw new IllegalArgumentException("Invalid Status");
		return db.user_editUser(username, firstName, lastName, password, type, status);
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
			ArrayList<String> schoolsList = new ArrayList<String>(); 
			for (String[] pair : savedArray) {
				if (pair[0].equals(username))
					schoolsList.add(pair[1]);
			}
			String[] savedSchools = new String[0];
			savedSchools = schoolsList.toArray(savedSchools);
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
		db.user_editUser(user.getUsername(), user.getFirstName(), user.getLastName(), 
						 user.getPassword(), user.getType(), 'N');
	}
	
	/**
	 * The addUser method adds a new user to the Choose my College database. 
	 * 
	 * @param user, the new user to be added.
	 */
	public void addUser(String firstName, String lastName, String username, String password, char type)
	{
		db.user_addUser(firstName, lastName, username, password, type);	
	}
	
	/**
	 * The saveSchool method saves the input school from the input user's 
	 * saved school list.  
	 * 
	 * @param user, the user who will have the given school added to their list.
	 * @param school, the school to be added.
	 */
	public void saveSchool(Person user, School school) {
		int errorInt = db.user_saveSchool(user.getUsername(), school.getName());
		if (errorInt==-1) {
			throw new RuntimeException("Database Error");
		}
		else {
			String[] savedSchools = user.getSavedSchools();
			String[] newSaved = new String[savedSchools.length+1];
			int i;
			for(i = 0; i < savedSchools.length; i++) {
				if(savedSchools[i] != null) {
					newSaved[i] = savedSchools[i];
				}
			}
			newSaved[i] = school.getName();
			user.setSavedSchools(newSaved);
		}
	}
	
	/**
	 * The removeSchool method removes the input school from the input user's 
	 * saved school list.  
	 * 
	 * @param user, the user who will have the given school removed from their list.
	 * @param school, the school to be removed.
	 */
	public void removeSchool(Person user, School school) {
		int errorInt = db.user_removeSchool(user.getUsername(), school.getName());
		if (errorInt==-1) {
			throw new RuntimeException("Database Error");
		}
		else {			
			String[] savedSchools = user.getSavedSchools();
			String[] newSaved = new String[savedSchools.length-1];
			int i;
			for(i = 0; i < savedSchools.length; i++) {
				if(!savedSchools[i].equals(school.getName())) {
					newSaved[i] = savedSchools[i];
				}
			}
			user.setSavedSchools(newSaved);
		}
	}

}
