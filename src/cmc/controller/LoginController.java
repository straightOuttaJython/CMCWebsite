package cmc.controller;

import cmc.entity.Person;
import cmc.home.PersonHome;
import dblibrary.project.csci230.UniversityDBLibrary;

/**
 * The LoginController class controls how/when a Person would log in.
 * 
 * @author Matthew
 * @version March 6, 2016
 */
public class LoginController {
	
	/**
	 * personHome is used to help access the person objects in the database.
	 */
	private PersonHome personHome;
	
	/**
	 * The login method users an entered username and password to find a Person that matches those parameters and returns that Person.
	 * 
	 * @param username, the username that is entered.
	 * @param password, the password that is entered.
	 * @param database, the database to search through.
	 * @return Person object that was found based on the username and password. 
	 */
	public Person login(String username, String password) 
	{
		personHome = new PersonHome();
		Person foundPerson = personHome.getPerson(username);
		if(foundPerson.getPassword().equals(password)) {
			return foundPerson;
		}
		return new Person();
	}
}
