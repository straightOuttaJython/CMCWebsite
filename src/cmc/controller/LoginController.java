package cmc.controller;

import cmc.entity.Person;
import dblibrary.project.csci230.UniversityDBLibrary;

/**
 * The LoginController class controls how/when a Person would log in.
 * 
 * @author Matthew
 * @version March 6, 2016
 */
public class LoginController {
	/**
	 * The login method users an entered username and password to find a Person that matches those parameters and returns that Person.
	 * 
	 * @param username, the username that is entered.
	 * @param password, the password that is entered.
	 * @param database, the database to search through.
	 * @return Person object that was found based on the username and password. 
	 */
	public Person login(String username, String password, UniversityDBLibrary dataBase) 
	{
		String user = username;
		String pass = password;
		String[][] array = dataBase.user_getUsers();
		System.out.println(array.toString());
		return new Person();
	}
}
