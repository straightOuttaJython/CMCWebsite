package cmc.entity;


/**
 * Person class represents an entity that will be typed as either a student or an admin in our Choose my College web-application. Each having basic details
 * such as firstname, lastname, username, password, type, and status.
 *  - A Person of type student will have use an extra field for their saved schools so that they can browse them later. 
 *  - A Person of type admin will just ignore the saved schools variable.
 *  
 * @author Matthew Kounniyom
 * @version March 6, 2016
 */
public class Person {

	/**
	 * Attribute firstName holds the first name of the person.
	 */
	private String firstName;
	
	/**
	 * Attribute lastName holds the last name of the person.
	 */
	private String lastName;
	
	/**
	 * Attribute username holds the user name of the person.
	 */
	private String username;
	
	/**
	 * Attribute password holds the password of the person.
	 */
	private String password;
	
	/**
	 * Attribute type keeps track of whether the person is a student (s) or an admin (a).
	 */
	private char type;
	
	/**
	 * Attribute status keeps track of whether the person is active (y) or inactive (n).
	 */
	private char status;
	
	/**
	 * Attribute savedSchools is an array that holds all the schools the student would want to look at later.
	 */
	private String[] savedSchools;
	
	/**
	 * Default constructor for the Person class. 
	 *  
	 * @param firstName, used to set the first name of the person.
	 * @param lastName, used to set the last name of the person.
	 * @param username, used to set the user name of the person.
	 * @param password, used to set the password of the person.
	 * @param type, used to set the type of the person
	 * @param status, used to set the status of the person.
	 * @param savedSchools, used to set the array for saved schools.
	 */
	public Person(String firstName, String lastName, String username, String password, char type, char status, String[] savedSchools) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.type = type;
		this.status = status;
		this.savedSchools = savedSchools;
	}
	
	public Person()
	{
		this.firstName = "";
		this.lastName = "";
		this.username = "";
		this.password = "";
		this.type = ' ';
		this.status = ' ';
	}

	/**
	 * Generic getter for firstName.
	 * 
	 * @return the current String value for firstName.
	 */
	public String getFirstName() {
		return firstName;
	}
	
	/**
	 * Generic setter for firstName. 
	 * 
	 * @param firstName, is the String value to set firstName to. 
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Generic getter for lastName.
	 * 
	 * @return the current String value for lastName.
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Generic setter for lastName. 
	 * 
	 * @param lastName, is the String value to set lastName to. 
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Generic getter for username.
	 * 
	 * @return the current String value for username.
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Generic setter for username. 
	 * 
	 * @param username, is the String value to set username to. 
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * Generic getter for password.
	 * 
	 * @return the current String value for password.
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Generic setter for password. 
	 * 
	 * @param password, is the String value to set password to. 
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Generic getter for type.
	 * 
	 * @return the current char value for type.
	 */
	public char getType() {
		return type;
	}

	/**
	 * Generic setter for type. 
	 * 
	 * @param type, is the char value to set type to. 
	 */
	public void setType(char type) {
		this.type = type;
	}

	/**
	 * Generic getter for status.
	 * 
	 * @return the current char value for status.
	 */
	public char getStatus() {
		return status;
	}

	/**
	 * Generic setter for status. 
	 * 
	 * @param status, is the char value to set status to. 
	 */
	public void setStatus(char status) {
		this.status = status;
	}

	/**
	 * Generic getter for savedSchools.
	 * 
	 * @return the current array of schools for savedSchools.
	 */
	public String[] getSavedSchools() {
		return savedSchools;
	}

	/**
	 * Generic setter for savedSchools
	 * 
	 * @param savedSchools, is the new array of schools to set savedSchools to.
	 */
	public void setSavedSchools(String[] savedSchools) {
		this.savedSchools = savedSchools;
	}
		
}
