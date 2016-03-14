package cmc.ui;

import java.util.Arrays;
import java.util.Scanner;

import cmc.entity.Person;
import cmc.entity.School;
import cmc.home.SchoolHome;
import dblibrary.project.csci230.UniversityDBLibrary;

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
	
	/**
	 * Scanner used in various methods.
	 */
	private Scanner s;
	
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
		System.out.println("   - Search For Schools: (\"search\")");
		System.out.println("   - Manage Saved Schools: (\"saved\")");
		System.out.println("   - Manage User Profile: (\"profile\")");
		System.out.println("   - Logout: (\"logout\")");
		s = new Scanner(System.in);
		System.out.print("  Please enter a valid command: ");
		String cmd = s.next();
		switch (cmd) {
			case "search":
				this.searchForSchools();
				break;
			case "saved":
				this.manageSchools();
				break;
			case "profile":
				this.manageUserProfile();
				break;
			case "logout":
				this.logout();
				break;
			default:
				System.out.println("*** INVALID ENTRY RESETTING ***");
				this.resetForm('v');
				break;
		}
		this.viewMenu();
	}
	
	/**
	 * Handles the User wanting to search for schools.
	 */
	public void searchForSchools() {
		System.out.println("*** PLEASE ENTER THE REQUIREMENTS FOR A SCHOOL YOU WANT TO SEARCH ***");
		System.out.println(" ** IF YOU WANT TO LEAVE OUT A FIELD LEAVE BLANK FOR STRINGS ** \n ** PUT A 0 FOR INTEGERS OR DOUBLES **");
		s = new Scanner(System.in);
		
		System.out.print("  School Name (String): ");
		String schoolName = s.nextLine().toUpperCase();
		
		System.out.print("  State (String): ");
		String state = s.nextLine().toUpperCase();
		
		System.out.print("  Location (SUBURBAN, URBAN, SMALL-CITY, -1 if Unknown): ");
		String location = s.nextLine().toUpperCase();
		
		System.out.print("  Control (PRIVATE, STATE, CITY, -1 if Unknown): ");
		String control = s.nextLine().toUpperCase();
		
		System.out.println("  Number of Students Enrolled (Integer): ");
		System.out.print("   Lower Value: ");
		int numStudentsEnrolledLower = Integer.parseInt(s.nextLine());
		System.out.print("   Upper Value: ");
		int numStudentsEnrolledUpper = Integer.parseInt(s.nextLine());
		
		System.out.println("  Percent of Females Enrolled (0.0-100.0): ");
		System.out.print("   Lower Value: ");
		double percFemEnrolledLower = Double.parseDouble(s.nextLine());
		System.out.print("   Upper Value: ");
		double percFemEnrolledUpper = Double.parseDouble(s.nextLine());
		
		System.out.println("  SAT Verbal (0.0-800.0): ");
		System.out.print("   Lower Value: ");
		double satVerbalLower = Double.parseDouble(s.nextLine());
		System.out.print("   Upper Value: ");
		double satVerbalUpper = Double.parseDouble(s.nextLine());
		
		System.out.println("  SAT Math (0.0-800.0): ");
		System.out.print("   Lower Value: ");
		double satMathLower = Double.parseDouble(s.nextLine());
		System.out.print("   Upper Value: ");
		double satMathUpper = Double.parseDouble(s.nextLine());
		
		System.out.println("  Tuition (Double): ");
		System.out.print("   Lower Value: ");
		double tuitionLower = Double.parseDouble(s.nextLine());
		System.out.print("   Upper Value: ");
		double tuitionUpper = Double.parseDouble(s.nextLine());
		
		System.out.println("  % Financial Aid (0.0-100.0): ");
		System.out.print("   Lower Value: ");
		double percentFinAidLower = Double.parseDouble(s.nextLine());
		System.out.print("   Upper Value: ");
		double percentFinAidUpper = Double.parseDouble(s.nextLine());
		
		System.out.println("  Number of Applicants (Integer): ");
		System.out.print("   Lower Value: ");
		int numApplicantsLower = Integer.parseInt(s.nextLine());
		System.out.print("   Upper Value: ");
		int numApplicantsUpper = Integer.parseInt(s.nextLine());
		
		System.out.println("  %  Admit Rate (0.0-100.0): ");
		System.out.print("   Lower Value: ");
		double admitRateLower = Double.parseDouble(s.nextLine());
		System.out.print("   Upper Value: ");
		double admitRateUpper = Double.parseDouble(s.nextLine());
		
		System.out.println("  %  Decide Rate (0.0-100.0): ");
		System.out.print("   Lower Value: ");
		double decideRateLower = Double.parseDouble(s.nextLine());
		System.out.print("   Upper Value: ");
		double decideRateUpper = Double.parseDouble(s.nextLine());
		
		System.out.println("  Academics Scale (1-5): ");
		System.out.print("   Lower Value: ");
		int academicsLower = Integer.parseInt(s.nextLine());
		System.out.print("   Upper Value: ");
		int academicsUpper = Integer.parseInt(s.nextLine());
		
		System.out.println("  Social Life Scale (1-5): ");
		System.out.print("   Lower Value: ");
		int socLifeLower = Integer.parseInt(s.nextLine());
		System.out.print("   Upper Value: ");
		int socLifeUpper = Integer.parseInt(s.nextLine());
		
		System.out.println("  Quality Life Scale (1-5): ");
		System.out.print("   Lower Value: ");
		int qualLifeLower = Integer.parseInt(s.nextLine());
		System.out.print("   Upper Value: ");
		int qualLifeUpper = Integer.parseInt(s.nextLine());
		
		System.out.println("  Emphases: ");
		String[] emphases = new String[5];
		System.out.print("   1: ");
		emphases[0] = s.nextLine().toUpperCase();
		System.out.print("   2: ");
		emphases[1] = s.nextLine().toUpperCase();
		System.out.print("   3: ");
		emphases[2] = s.nextLine().toUpperCase();
		System.out.print("   4: ");
		emphases[3] = s.nextLine().toUpperCase();
		System.out.print("   5: ");
		emphases[4] = s.nextLine().toUpperCase();
		
		
		//School school = new School();
		//this.search(school);
		//this.viewSimple(school);
		//this.viewExpanded(school);
		//this.viewMenu();
		//make new school
		//set every field that is not black to the above ^^
		//this method will use this.search(above school)
		//controller will get a list of all schools, compare their fields to above school
		//display options
		//you can add/view simple/ view expanded
	}
	
	/**
	 * Manages the users saved school list.
	 */
	public void manageSchools() {
		School[] schoolArray = this.user.getSavedSchools();
		//lists names
		System.out.println("*** LIST OF ALL OF YOUR SAVED SCHOOLS ***");
		for(School sc: schoolArray) {
			System.out.println(sc.getName());
		}
		//remove
		//view
	}
	
	/**
	 * Manages the users profile.
	 */
	public void manageUserProfile() {
		System.out.println("*** MANAGING PROFILE ***");
		System.out.println(" - Current Data: ");
		System.out.println("     Username: " + user.getUsername());
		System.out.println("     First name: " + user.getFirstName());
		System.out.println("     Last name: " + user.getLastName());
		System.out.println("     Password: " + user.getPassword());
		System.out.println("     Type: " + user.getType());
		System.out.println(" ** Enter ($) if you don't want to change them **");
		System.out.println(" * ENTER \"reset\" IF RESET IS NEEDED *");
		s = new Scanner(System.in);
		System.out.print("   - Enter new first name: ");
		String newFirst = s.next();
		if(newFirst.equals("reset")) {
			this.resetForm('u');
		} else {
			System.out.print("   - Enter new last name: ");
			String newLast = s.next();
			if(newLast.equals("reset")) {
				this.resetForm('u');
			} else {
				System.out.print("   - Enter new password: ");
				String newPass = s.next();
				if(newPass.equals("reset")) {
					this.resetForm('u');
				} else {
					this.editUser(newFirst, newLast, newPass);
				}
			}
		}
	}
	
	/**
	 * Logs out the user.
	 */
	public void logout() {
		UniversityDBLibrary db = new UniversityDBLibrary("straightou", "straightou", "adem4");
		db.user_editUser(user.getUsername(), user.getFirstName(), user.getLastName(), 
				user.getPassword(), user.getType(), user.getStatus());
		user = new Person();
		System.out.println("*** WOULD YOU LIKE TO QUIT Y or N ***");
		s = new Scanner(System.in);
		System.out.print(" - ");
		char answer = s.next().charAt(0);
		if(answer == 'Y' || answer == 'y') {
			System.exit(0);
		}
	}
	
	/**
	 * Searchs for a specific school given by the user.
	 * 
	 * @param idealSchool, the school entered by the user.
	 */
	public void search(School idealSchool) {
		SchoolHome sch = new SchoolHome();
		School[] scl = sch.listOfSchools();
		System.out.println("*** SEARCH RESULTS ***"); 
		for(int i = 0; i < scl.length; i++){
			if (idealSchool.getName().equals(scl[i].getName())){
				System.out.println("  - " + idealSchool.getName());
			}
		}
		System.out.println("*** END SEARCH RESULTS ***"); 
		
	}
	
	/**
	 * Resets the search form.
	 * 
	 * @param method, indicates which method it was called from.
	 */
	private void resetForm(char method) {
		if(method == 'u') {
			this.manageUserProfile();
		} else if (method == 'v') {
			this.viewMenu();
		}
	}
	
	/**
	 * Pulls up a simple view of the entered school, which contains some information of the school.
	 * 
	 * @param school, the school to be viewed.
	 */
	public void viewSimple(School school) {
		System.out.print("  School: ");
		System.out.print(school.getName() + "\n");
		System.out.print("  Location: ");
		System.out.print(school.getLocation() + "\n");
		System.out.print("  State: ");
		System.out.print(school.getState() + "\n");
		System.out.print("  Control: ");
		System.out.print(school.getControl() + "\n");
		System.out.print("  Number of Students: ");
		System.out.print(school.getNumStudentsEnrolled() + "\n");
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
		if(!firstName.equals("$")) {
			this.user.setFirstName(firstName);
		} 
		if(!lastName.equals("$")) {
			this.user.setLastName(lastName);
		} 
		if(!password.equals("$")) {
			this.user.setPassword(password);
		} 
		System.out.println("*** YOUR PROFILE HAS BEEN CHANGED SUCCESSFULLY ***");
		UniversityDBLibrary db = new UniversityDBLibrary("straightou", "straightou", "adem4");
		db.user_editUser(user.getUsername(), user.getFirstName(), user.getLastName(), 
		user.getPassword(), user.getType(), user.getStatus());
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
		System.out.println(school.getName());
		System.out.println("  State: ");
		System.out.println(school.getState());
		System.out.println("  Location: ");
		System.out.println(school.getLocation());
		System.out.println("  Control: ");
		System.out.println(school.getControl());
		System.out.println("  Number of Students Enrolled: ");
		System.out.println(school.getNumStudentsEnrolled());
		System.out.println("  Percent of Females Enrolled: ");
		System.out.println(school.getPercentFemEnrolled());
		System.out.println("  SAT Verbal: ");
		System.out.println(school.getSatVerb());
		System.out.println("  SAT Math: ");
		System.out.println(school.getSatMath());
		System.out.println("  Tuition: ");
		System.out.println(school.getTuition());
		System.out.println("  % Financial Aid: ");
		System.out.println(school.getPercFinAid());
		System.out.println("  Number of Applicants : ");
		System.out.println(school.getNumApplications());
		System.out.println("  %  Admit Rate: ");
		System.out.println(school.getAdmitRate());
		System.out.println("  %  Decide Rate: ");
		System.out.println(school.getDecideRate());
		System.out.println("  Academics Scale (1-5): ");
		System.out.println(school.getAcademics());
		System.out.println("  Social Life Scale (1-5): ");
		System.out.println(school.getSocialLife());
		System.out.println("  Quality Life Scale (1-5): ");
		System.out.println(school.getQualityLife());
	}
	
	/**
	 * Saves the currently viewed school.
	 * 
	 * @param school, the school to be saved.
	 */
	public void saveSchool(School school) {
		School[] sc = user.getSavedSchools();
		sc = Arrays.copyOf(sc, sc.length+1);
		if(!failureToSave(school)){
			sc[sc.length-1] = school;
		}
	}
	
	/**
	 * Shows a failure message if the school is already in the saved schools list.
	 */
	private boolean failureToSave(School school) {
		School[] sc = user.getSavedSchools();  
		for(int i = 0; i < sc.length; i ++){
			if(school.equals(sc[i])){
				System.out.println("School is already in saved list");
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Gets the current user.
	 * 
	 * @return user, the current user.
	 */
	public Person getUser() {
		return this.user;
	}
}
