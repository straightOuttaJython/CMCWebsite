package cmc.ui;

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
