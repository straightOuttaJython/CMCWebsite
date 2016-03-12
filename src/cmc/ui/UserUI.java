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
	
	/** manage school
	 * 
	 */
	public void manageSchool(){
		
	}
	
	/** manage user 
	 * 
	 */
	public void mangeUsers(){
		
	}
	
	/** log out 
	 * 
	 */
	public void logout(){
		
	}
	
	/** resetForm
	 * 
	 */
	public void resetForm(){
		
	}
	
	/** add a school
	 * 
	 */
	public void addASchool(School school){
		
	}
	
	/** edit a school
	 * 
	 */
	public void editASchool(School school){
		
	}
	
	/** deny add school
	 * 
	 */
	public void denyAddSchool(){
		
	}
	
	/** cancel edit school
	 * 
	 */
	public void cancelEditSchool(){
		
	}
	
	/** fail to edit school
	 * 
	 */
	public void failureToEditSchool(){
		
	}
	
	/** fail to edit user
	 * 
	 */
	public void failureToEditUSer(){
		
	}
	
	/** add user
	 * 
	 */
	public void addUser(){
		
	}
	
	/** deny add user
	 * 
	 */
	public void denyAddUser(){
		
	}
	
	/** edit user
	 * 
	 */
	public void editUser(Person user){
		
	}
	
	/** deactivate user
	 * 
	 */
	public void deactivateUser(Person user){
		
	}
}
