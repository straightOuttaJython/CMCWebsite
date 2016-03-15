package cmc.ui;

/**
 * Abstract for admin UI
 * 
 * @author Alex Seefeldt, Erin Queme
 * @version March 11, 2016
 */

public interface AbstractUI {
	
	/**
	 * Show menu
	 */
	public void viewMenu();
	
	/**
	 * Log Person out of session
	 */
	public void logout();
	
	/**
	 * Reset all fields in current form.
	 */
	public void resetForm();

}
