/**
 * 
 */
package cmc.ui;

import java.util.Scanner;

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
	 * 
	 */
	public void addSchool() 
	{
		Scanner in = new Scanner(System.in);
		System.out.println("Please enter the school name: ");
		String name = in.nextLine();
		
		System.out.println("Please enter the state that the school is located in. (***FULL NAME***):");
		String state = in.nextLine();
		
		System.out.println("Please enter the location of the school. ex. \"Suburban\" or \"Urban\" etc.: ");
		String location = in.nextLine();
		
		System.out.println("Please enter the control of the school. ex. \"Private\" or \"Public\" etc.: ");
		String control = in.nextLine();
		
		System.out.println("Please enter the number of students that enrolled in the school (MUST BE A NUMBER, NO DECIMALS): ");
		int numStudentsEnrolled = in.nextInt();
		
		System.out.println("Please enter the percentage of femals that enrolled in the school: (MUST HAVE A DECIMAL IN THE VALUE)");
		double percentFemEnrolled = in.nextDouble();
		
		System.out.println("Please enter the SAT Verbal score needed to attend the school: (MUST HAVE A DECIMAL IN THE VALUE)");
		double satVerbal = in.nextDouble();
		
		System.out.println("Please enter the SAT Mathmaic score needed to attend the school: (MUST HAVE A DECIMAL IN THE VALUE)");
		double satMath = in.nextDouble();
		
		System.out.println("Please enter the tuition of the school: (MUST HAVE A DECIMAL IN THE VALUE)");
		double tuition = in.nextDouble();
		
		System.out.println("Please enter the percent of people who receive finacial aid in the school: (MUST HAVE A DECIMAL IN THE VALUE)");
		double percentFinAid = in.nextDouble();
		
		System.out.println("Please enter number of people who applied to the school: (MUST BE A NUMBER, NO DECIMALS)");
		int numApplicatns = in.nextInt();
		
		System.out.println("Please enter the admition rate for the school: (MUST HAVE A DECIMAL IN THE VALUE)");
		double admitRate = in.nextDouble();
		
		System.out.println("Please enter the enrolled rate for the school: (MUST HAVE A DECIMAL IN THE VALUE)");
		double decideRate = in.nextDouble();
		
		System.out.println("Please enter a rating from 0-100 for the school: (MUST BE A NUMBER, NO DECIMALS)");
		int academics = in.nextInt();
		
		System.out.println("Please enter a rating from 0-100 for the school: (MUST BE A NUMBER, NO DECIMALS)");
		int socialLife = in.nextInt();
		
		System.out.println("Please enter a rating from 0-100 for the school: (MUST BE A NUMBER, NO DECIMALS)");
		int qualityLife = in.nextInt();
		
		db.university_addUniversity(name,state,location,control,
				numStudentsEnrolled,percentFemEnrolled, satVerbal, satMath, tuition, percentFinAid,
				numApplicatns, admitRate,decideRate,academics,socialLife,qualityLife);
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
