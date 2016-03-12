package cmc.ui;

import cmc.entity.Person;
import cmc.entity.School;

/**
* The UserUI class controls user's action.
* 
* @author Duong, Matthew Kounniyom
* @version March 11, 2016
*/
public class UserUI{
	
	/**
	 * Instance variable
	 */
	private Person user;
	
	/** Constructor
	 * @param user
	 */
	public UserUI(Person user) {
		this.user = user;
	}
	
	/**
	 *  Displays a menu full of all the options available to a "user".
	 */
	public void viewMenu(){
		System.out.println("*** USER MENU ***");
		System.out.println("   - Manage Saved Schools");
		System.out.println("   - Manage Saved Schools");
	}
	
	/**
	 * Handles the User wanting to search for schools.
	 */
	public void searchForSchools() {
		
	}
	
	/**
	 * Manages the users saved school list.
	 */
	public void manageSchools() {
		
	}
	
	/**
	 * Manages the users profile.
	 */
	public void manageUserProfile() {
		
	}
	
	/**
	 * Logs out the user.
	 */
	public void logout() {
		
	}
	
	/**
	 * Searchs for a specific school given by the user.
	 * 
	 * @param idealSchool, the school entered by the user.
	 */
	public void search(School idealSchool) {
		
	}
	
	/**
	 * Resets the search form.
	 */
	public void resetForm() {
		
	}
	
	/**
	 * Pulls up a simple view of the entered school, which contains some information of the school.
	 * 
	 * @param school, the school to be viewed.
	 */
	public void viewSimple(School school) {
		
	}
	
	/**
	 * Removes the given school, from the users saved school list.
	 * 
	 * @param school, the school to be removed.
	 */
	public void removeSchool(School school) {
		
	}
	
	/**
	 * Changes the users firstname, lastname, and password based on the given parameters.
	 * 
	 * @param firstName, the firstname to be changed to.
	 * @param lastName, the lastname to be changed to.
	 * @param password, the password to change to.
	 */
	public void editUser(String firstName, String lastName, String password) {
		
	}
	
	/**
	 * Denies the an edit if given arguments are invalid.
	 */
	private void denyEdit() {
		
	}
	
	/**
	 * Shows search results.
	 */
	private void showResults() {
		
	}
	
	/**
	 * Used to view all of the details of a school.
	 * 
	 * @param school, the school to be viewed in full.
	 */
	public void viewExpanded(School school) {
		
	}
	
	/**
	 * Saves the currently viewed school.
	 * 
	 * @param school, the school to be saved.
	 */
	public void saveSchool(School school) {
		
	}
	
	/**
	 * Shows a failure message if the school is already in the saved schools list.
	 */
	private void failureToSave() {
		
	}
}
