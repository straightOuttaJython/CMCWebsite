package cmc.controller;

import cmc.entity.Person;
import cmc.home.PersonHome;

/**
 * The LoginController class controls how/when a Person would log in.
 * 
 * @author Matthew Kounniyom
 * @version March 20, 2016
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
	 * @throws InactiveAccountException, if the the account bound to the input username is inactive.
	 * @throws IllegalArgumentException, if the the account bound to the input username is inactive.
	 */
	public Person login(String username, String password) throws InactiveAccountException, IllegalArgumentException
	{
		personHome = new PersonHome();
		Person foundPerson = personHome.getPerson(username);
		if (foundPerson.getStatus() == 'N') {
			throw new InactiveAccountException("That account is Deactivated");
		} else {
			if(foundPerson.getPassword().equals(password)) {
				return foundPerson;
			} else {
				throw new IllegalArgumentException("Password is invalid.");
			}
		}
	}
	
	/**
	 * Custom Exception used for when an account is found inactive.
	 * 
	 * @author Matthew Kounniyom
	 * @version March 20, 2016
	 */
	public class InactiveAccountException extends IllegalArgumentException{
		
		/**
		 * Constructs a new InactiveAccountException with null as its detail message.
		 */
		public InactiveAccountException() {
			super();
		}
		
		/**
		 *  Constructs a new InactiveAccountException with a specified detail message.
		 */
		public InactiveAccountException(String message) {
			super(message);
		}
		
		/**
		 *  Constructs a new InactiveAccountException with a specified detail message and cause.
		 */
		public InactiveAccountException(String message, Throwable cause) {
			super(message, cause);
		}
		
		/**
		 *  Constructs a new InactiveAccountException with a specified cause.
		 */
		public InactiveAccountException(Throwable cause) {
			super(cause);
		}
	}
}
