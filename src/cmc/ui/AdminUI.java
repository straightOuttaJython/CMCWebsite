/**
 * 
 */
package cmc.ui;

import java.util.Scanner;

import javax.swing.text.html.StyleSheet.ListPainter;

import cmc.entity.Person;
import cmc.entity.School;
import cmc.home.PersonHome;
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
		Scanner adminOptions = new Scanner(System.in);
		System.out.println("*** ADMIN MENU ***");
		System.out.println("    OPTIONS:");
		System.out.println("Type \"m\" to    - Manage Schools");
		System.out.println("Type \"l\" to    - Logout");
		System.out.println("Type \"r\" to    - Reset Form");
		System.out.println("Type \"a\" to    - Add User");
		System.out.println("Type \"e\" to    - Edit User");
		System.out.println("Type \"d\" to    - Deactivate User");
		
		String optionChose = adminOptions.nextLine();
		
		if(optionChose.equals("m"))
		{
			this.manageSchools();
		}
		else if(optionChose.equals("l"))
		{
			this.logout();
		}
		else if(optionChose.equals("r"))
		{
			this.resetForm();
		}
		else if(optionChose.equals("a"))
		{
			this.addUser();
		}
		else if(optionChose.equals("e"))
		{
			Scanner editUser =new Scanner(System.in);
			System.out.println("Enter the username of the user you want to edit");
			String user = editUser.nextLine();
			this.editUser(user);
		}
		else if(optionChose.equals("d"))
		{
			Scanner deactUser =new Scanner(System.in);
			System.out.println("Enter the username of the user you want to deactivate");
			String deUser = deactUser.nextLine();
			this.deactivate(deUser);
		}
		else
		{
			System.out.println("Please put a valid input.");
			this.viewMenu();
		}
		
	}
	
	/**
	 * Show Manage Schools menu
	 */
	public void manageSchools() 
	{
		Scanner addOrEdit = new Scanner(System.in);
		System.out.println("Type \" l \" if you want to see the list of School(CASE SENSATIVE)");
		System.out.println("Type \" a \" if you want to Add School (CASE SENSATIVE)");
		System.out.println("Type \" e \" if you want to Edit School(CASE SENSATIVE)");
		System.out.println("Type \" q \" if you want to quit (CASE SENSATIVE)");
		String choice = addOrEdit.nextLine();
		if(choice.equals("a"))
		{
			this.addSchool();
			this.manageSchools();
		}
		else if(choice.equals("e"))
		{
			System.out.println("Please enter the name of the school you wish to edit: (CASE SENSATIVE)");
			String schoolName = addOrEdit.nextLine();
			this.editSchool(schoolName);
			this.manageSchools();
		}
		else if(choice.equals("l"))
		{
			School[] s = sh.listOfSchools();
			System.out.println("*** LIST OF SCHOOLS ***");
			for(int i = 0; i < s.length; i++)
			{
				String name = s[i].getName();
				System.out.println(name);
			}
			this.manageSchools();
		}
		else if(choice.equals("q"))
		{
			this.viewMenu();
		}
	}
	
	/**
	 * Log Admin out of session
	 */
	public void logout() 
	{
		System.out.println("Are you sure you want to logout?");
		Scanner again = new Scanner(System.in);
		System.out.println("Type in \"y\" for yes or  \"n\" for no.");
		String decision = again.nextLine();
		if(decision.equals("y"))
		{
			System.out.println("*** YOU HAVE BEEN LOGGED OUT BY THE ALL MIGHTY IMAD RAHAL ***");
			System.exit(0);
		}
		else if(decision.equals("n"))
		{
			this.viewMenu();
		}
		else
		{
			System.out.println("Please type in a correct input.");
		}
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
		SchoolHome aSH = new SchoolHome();
		School[] listOfSchools = aSH.listOfSchools();
	
		Scanner in = new Scanner(System.in);
		System.out.println("Please enter the school name: ");
		String name = in.nextLine();
		
		for(int i =0; i < listOfSchools.length; i++)
		{
			if(listOfSchools[i].getName().equals(name))
			{
				this.denyAddSchool();
			}
		}
		
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
		
		System.out.println("****************** SCHOOL HAS BEEN ADDED ******************");
		this.manageSchools();
		
		
	}
	
	/**
	 * Update the given School with the data inside it.
	 * @param school the updated School
	 */
	public void editSchool(String school) 
	{
		SchoolHome eSH = new SchoolHome();
		School[] list = eSH.listOfSchools();
		for(int i =0; i < list.length; i++)
		{
			if(list[i].getName().equals(school))
			{
				Scanner inTwo = new Scanner(System.in);
				
				System.out.println("Please enter the school name: ");
				String name = inTwo.nextLine();
				
				System.out.println("Please enter the state that the school is located in. (***FULL NAME***):");
				String state = inTwo.nextLine();
				
				System.out.println("Please enter the location of the school. ex. \"Suburban\" or \"Urban\" etc.: ");
				String location = inTwo.nextLine();
				
				System.out.println("Please enter the control of the school. ex. \"Private\" or \"Public\" etc.: ");
				String control = inTwo.nextLine();
				
				System.out.println("Please enter the number of students that enrolled in the school (MUST BE A NUMBER, NO DECIMALS): ");
				int numStudentsEnrolled = inTwo.nextInt();
				
				System.out.println("Please enter the percentage of femals that enrolled in the school: (MUST HAVE A DECIMAL IN THE VALUE)");
				double percentFemEnrolled = inTwo.nextDouble();
				
				System.out.println("Please enter the SAT Verbal score needed to attend the school: (MUST HAVE A DECIMAL IN THE VALUE)");
				double satVerbal = inTwo.nextDouble();
				
				System.out.println("Please enter the SAT Mathmaic score needed to attend the school: (MUST HAVE A DECIMAL IN THE VALUE)");
				double satMath = inTwo.nextDouble();
				
				System.out.println("Please enter the tuition of the school: (MUST HAVE A DECIMAL IN THE VALUE)");
				double tuition = inTwo.nextDouble();
				
				System.out.println("Please enter the percent of people who receive finacial aid in the school: (MUST HAVE A DECIMAL IN THE VALUE)");
				double percentFinAid = inTwo.nextDouble();
				
				System.out.println("Please enter number of people who applied to the school: (MUST BE A NUMBER, NO DECIMALS)");
				int numApplicatns = inTwo.nextInt();
				
				System.out.println("Please enter the admition rate for the school: (MUST HAVE A DECIMAL IN THE VALUE)");
				double admitRate = inTwo.nextDouble();
				
				System.out.println("Please enter the enrolled rate for the school: (MUST HAVE A DECIMAL IN THE VALUE)");
				double decideRate = inTwo.nextDouble();
				
				System.out.println("Please enter a rating from 0-100 for the school: (MUST BE A NUMBER, NO DECIMALS)");
				int academics = inTwo.nextInt();
				
				System.out.println("Please enter a rating from 0-100 for the school: (MUST BE A NUMBER, NO DECIMALS)");
				int socialLife = inTwo.nextInt();
				
				System.out.println("Please enter a rating from 0-100 for the school: (MUST BE A NUMBER, NO DECIMALS)");
				int qualityLife = inTwo.nextInt();
				
				
				db.university_editUniversity(name,state,location,control,
						numStudentsEnrolled,percentFemEnrolled, satVerbal, satMath, tuition, percentFinAid,
						numApplicatns, admitRate,decideRate,academics,socialLife,qualityLife);
				System.out.println("************ EDITTING SCHOOL HAS BEEN COMPLETED *********");
			}
		}
		this.failureToEditSchool();	
	}
	
	/**
	 * Report to user that the School could not be added.
	 */
	private void denyAddSchool() 
	{
		System.out.println("*** A SCHOOL WITH THAT NAME ALREADY EXISTS, REVERTING BACK TO MANAGE SCHOOLS ***");
		this.manageSchools();
	}
	
	/**
	 * Leave the Edit School form and return to upper menu.
	 */
	public void cancelEditSchool() 
	{
		System.out.println("*** YOUR ATTEMPT TO EDIT A SCHOOL HAS BEEN CANCELED REVERTING BACK TO MANAGE SCHOOL***");
		this.manageSchools();
	}

	/**
	 * 
	 */
	private void failureToEditSchool() 
	{
		System.out.println("*** NO SUCH SCHOOL WAS FOUND TO EDIT, REVERTING BACK TO MANAGE SCHOOLS ***");
		this.manageSchools();
	}

	/**
	 * @param user
	 */
	public void editUser(String username)
	{
		PersonHome eSH = new PersonHome();
		Person[] list = eSH.getAllUsers();
		for(int i =0; i < list.length; i++)
		{
			if(list[i].getUsername().equals(username))
			{
				Scanner userNameIn = new Scanner(System.in);
				System.out.println("Please enter the new or existing username: ");
				String username1 = userNameIn.nextLine();
				
				System.out.println("Please enter the new or existing first name: ");
				String firstName = userNameIn.nextLine();
				
				System.out.println("Please enter the new or existing last name: ");
				String lastName = userNameIn.nextLine();
				
				System.out.println("Please enter the new or existing password: ");
				String password = userNameIn.nextLine();
				
				System.out.println("Please enter the new or existing type(NOTE THIS MUST BE ONLY AN \"a\" or \"u\" *** CASE SENSATIVE ***): ");
				char type = userNameIn.nextLine().charAt(0);
				
				if(type != 'a' || type != 'u')
				{
					System.out.println("********* NOT A VALID INPUT *********");
					System.out.println("********* REVERTING BACK TO ADMIN MENU *********");
					this.viewMenu();
				}
				
				db.user_editUser(username1, firstName, lastName, password, type, list[i].getStatus());
				
				System.out.println("********* USER HAS BEEN EDITED SUCCESFULLY *********");
				System.out.println("********* GOING BACK TO ADMIN MENU *********");
				this.viewMenu();
			}
		}
		this.failureToEditUser();
	}

	/**
	 * @param user
	 */
	public void deactivate(String username) 
	{
		PersonHome eSH = new PersonHome();
		Person[] list = eSH.getAllUsers();
		for(int i =0; i < list.length; i++)
		{
			if(list[i].getUsername().equals(username))
			{
				if(list[i].getStatus() == ('a'))
				{
					db.user_editUser(list[i].getUsername(), list[i].getFirstName(), list[i].getLastName(), 
							list[i].getPassword(), list[i].getType(), 'd');
				}
				else
				{
					db.user_editUser(list[i].getUsername(), list[i].getFirstName(), list[i].getLastName(), 
							list[i].getPassword(), list[i].getType(), 'a');
				}
			}
		}
	}
	
	/**
	 * 
	 */
	public void addUser() 
	{
		Scanner addUser = new Scanner(System.in);
		
		System.out.println("Please enter the first name of the person: ");
		String firstName = addUser.nextLine();
		
		System.out.println("Please enter the last name of the person: ");
		String lastName = addUser.nextLine();
		
		System.out.println("Please enter a username of the person: ");
		String username = addUser.nextLine();
		
		System.out.println("Please enter a password for the person: ");
		String password = addUser.nextLine();
		
		System.out.println("Please enter an \"a\" if the person is an Admin or a \"u\" if the person is a User: ");
		char type = addUser.nextLine().charAt(0);
		
		db.user_addUser(firstName, lastName, username, password, type);
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
		System.out.println("*** USER WAS NOT FOUND, REVERTING BACK TO ADMIN MENU ***");
		this.viewMenu();
	}

}
