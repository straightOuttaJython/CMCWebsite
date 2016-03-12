/**
 * 
 */
package cmc.ui;

import cmc.entity.Person;
import cmc.entity.School;
import cmc.home.SchoolHome;
import dblibrary.project.csci230.UniversityDBLibrary;

/**
 * @author Alex Seefeldt
 *
 */
public class AdminUI implements AbstractUI {
	
	private UniversityDBLibrary db = new UniversityDBLibrary("straightou", "straightou", "adem4");
	
	private SchoolHome sh = new SchoolHome();
	/**
	 * Create a new AdminUI.
	 */
	public AdminUI() 
	{
		// TODO Auto-generated constructor stub
		
	}
	
	/**
	 * Show Admin menu
	 */
	public void viewMenu() {
		System.out.println("*** ADMIN MENU ***");
		System.out.println("    OPTIONS:");
		System.out.println("      - Manage Schools");
		System.out.println("      - Logout");
		System.out.println("      - Reset Form");
		System.out.println("      - Add User");
		System.out.println("      - Edit User");
		System.out.println("      - Deactivate User");
	}
	
	/**
	 * Show Manage Schools menu
	 */
	public void manageSchools() 
	{
		School[] s = sh.listOfSchools();
		System.out.println("*** LIST OF SCHOOLS ***");
		for(int i = 0; i < s.length; i++)
		{
			String name = s[i].getName();
			System.out.println(name);
		}
		System.out.println("      - Add School");
		System.out.println("      - Edit School");
	}
	
	/**
	 * Log Admin out of session
	 */
	public void logout() 
	{
		System.out.println("*** YOU HAVE BEEN LOGGED OUT BY THE ALL MIGHTY IMAD RAHAL ***");
	}
	
	/**
	 * Reset all fields in current form.
	 */
	public void resetForm() 
	{
		System.out.println("*** FORM WILL BE RESETED BY THE GREAT AND OMNIPOTENT BEING THAT IS IMAD RAHAL ***");
	}
	
	/**
	 * Add the given School object to the database.
	 * @param school the new School to be added
	 */
	public void addSchool(School school) 
	{
		db.university_addUniversity(school.getName(), school.getState(), school.getLocation(), school.getControl(),
				school.getNumStudentsEnrolled(), school.getPercentFemEnrolled(), school.getSatVerb(), school.getSatMath(), 
				school.getTuition(), school.getPercFinAid(), school.getNumApplications(), school.getAdmitRate(), 
				school.getDecideRate(), school.getAcademics(),school.getSocialLife(), school.getQualityLife());
	}
	
	/**
	 * Update the given School with the data inside it.
	 * @param school the updated School
	 */
	public void editSchool(School school) 
	{
		
	}
	
	
	/**
	 * Report to user that the School could not be added.
	 */
	private void denyAddSchool() 
	{
		System.out.println("*** YOUR ATTEMPT OF ADDING A SCHOOL HAS BEEN DENIED ***");
	}
	
	/**
	 * Leave the Edit School form and return to upper menu.
	 */
	public void cancelEditSchool() 
	{
		System.out.println("*** YOUR ATTEMPT TO EDIT A SCHOOL HAS BEEN CANCELED ***");
	}

	/**
	 * 
	 */
	private void failureToEditSchool() 
	{
		System.out.println("*** FAILURE TO EDIT SCHOOL... WAY TO GO ***");
	}

	
	/**
	 * 
	 */
	public void addAUser() 
	{
		
	}

	/**
	 * @param user
	 */
	public void editUser(Person user)
	{
		
	}
	
	/**
	 * @param user
	 */
	public void deactivate(Person user) 
	{
		
	}
	
	/**
	 * 
	 */
	public void addUser() 
	{
		
	}
	
	/**
	 * 
	 */
	private void denyAddUser() 
	{
		System.out.println("*** YOUR ATTEMPT OF ADDING A USER HAS BEEN DENIED ***");
	}
	
	/**
	 * 
	 */
	private void failureToEditUser() 
	{
		System.out.println("*** FAILURE TO EDIT USER... WAY TO GO ***");
	}

}
