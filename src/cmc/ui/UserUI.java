package cmc.ui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import cmc.controller.SearchController;
import cmc.entity.Person;
import cmc.entity.School;
import cmc.home.PersonHome;
import dblibrary.project.csci230.UniversityDBLibrary;

/**
* The UserUI class controls user's action.
* 
* @author Duong, Matthew Kounniyom
* @version March 14, 2016
*/
public class UserUI 
{
	
	/**
	 * A Person named user is created to access its information
	 */
	private Person user;
	
	/**
	 * Scanner used in various methods.
	 */
	private Scanner s;
	
	/**
	 * String Locations
	 */
	private static final int[] STRING_LOCATIONS = {0,1,2,3};
	
	/**
	 * Integer locations
	 */
	private static final int[] INT_LOCATIONS = {4,10,13,14,15};
	
	/**
	 * double Locations
	 */
	private static final int[] DOUBLE_LOCATIONS = {5,6,7,8,9,11,12};
	
	/**
	 * Messages shown for entry messages
	 */
	private static final String[] SEARCH_ENTRY_MESSAGES = {"  School Name (String): ",
															"  State (String): ",
															"  Location (SUBURBAN, URBAN, SMALL-CITY, -1 if Unknown): ",
															"  Control (PRIVATE, STATE, CITY, -1 if Unknown): ",
															"  Number of Students Enrolled (Integer) Minimum: ",
															"  Percent of Females Enrolled (0.0-100.0) Minimum: ",
															"  SAT Verbal (0.0-800.0) Minimum: ",
															"  SAT Math (0.0-800.0) Minimum: ",
															"  Tuition (Double) Minimum: ",
															"  % Financial Aid (0.0-100.0) Minimum: ",
															"  Number of Applicants (Integer) Minimum: ",
															"  %  Admit Rate (0.0-100.0) Minimum: ",
															"  %  Decide Rate (0.0-100.0) Minimum: ",
															"  Academics Scale (1-5) Minimum: ",
															"  Social Life Scale (1-5) Minimum: ",
															"  Quality Life Scale (1-5) Minimum: ",
															"  Emphases (type \"-\" when done): "};
	
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
		System.out.println("   - Search For Schools: (\"s\")");
		System.out.println("   - Manage Saved Schools: (\"v\")");
		System.out.println("   - Manage User Profile: (\"p\")");
		System.out.println("   - Logout: (\"l\")");
		s = new Scanner(System.in);
		System.out.print("  Please enter a valid command: ");
		char cmd = s.next().charAt(0);
		switch (cmd) {
			case 's':
				this.searchForSchools();
				break;
			case 'v':
				this.manageSchools();
				break;
			case 'p':
				this.manageUserProfile();
				break;
			case 'l':
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
	 * 
	 * @throws ResetException if the user is trying to reset.
	 */
	public void searchForSchools() {
		System.out.println("*** PLEASE ENTER THE REQUIREMENTS FOR A SCHOOL YOU WANT TO SEARCH ***");
		System.out.println(" ** IF YOU WANT TO LEAVE OUT A FIELD LEAVE BLANK FOR STRINGS ** \n ** PUT A 0 FOR INTEGERS OR DOUBLES **");
		s = new Scanner(System.in);
		String input;
		boolean inputDone;
		ArrayList<String> idealSchool = new ArrayList<String>(); 
		for (int i=0; i<17; i++) {
			inputDone = false;
			while (!inputDone) {
				System.out.println(SEARCH_ENTRY_MESSAGES[i]);
				String nextString = s.nextLine().toUpperCase();
				if (nextString.equals("RESET")) {
					searchForSchools();
					return;
				}
				if (Arrays.binarySearch(STRING_LOCATIONS,i)>=0) {
					if (nextString.length()==0) {
						idealSchool.add(null);
					}
					else {
						if (!nextString.matches("[A-Z]*"))
							System.out.println("Bad input; please try again! (Letters only please)");
						else {
							idealSchool.add(nextString);
							inputDone = true;
						}
					}
				}
				if (Arrays.binarySearch(INT_LOCATIONS,i)>=0) {
					String min = "*", max = min;
					if (nextString.length()!=0) {
						try {Integer.parseInt(nextString);}
						catch (NumberFormatException nFE) {
							System.out.println("Bad input; please try again! (input an int)");
							continue;
						}
						min = nextString;
					}
					while (!inputDone) {
						System.out.println("Maximum:  ");
						nextString = s.nextLine().toUpperCase();
						if (nextString.equals("RESET")) {
							searchForSchools();
							return;
						}
						if (nextString.length()!=0) {
							try {Integer.parseInt(nextString);}
							catch (NumberFormatException nFE) {
								System.out.println("Bad input; please try again! (input an int)");
								continue;
							}
							max = nextString;
						}
						inputDone = true;
					}
					idealSchool.add(min+"-"+max);
				}
				if (Arrays.binarySearch(DOUBLE_LOCATIONS,i)>=0) {
					String min = "*", max = min;
					if (nextString.length()!=0) {
						try {Double.parseDouble(nextString);}
						catch (NumberFormatException nFE) {
							System.out.println("Bad input; please try again! (input a double)");
							continue;
						}
						min = nextString;
					}
					while (!inputDone) {
						System.out.println("Maximum:  ");
						nextString = s.nextLine().toUpperCase();
						if (nextString.equals("RESET")) {
							searchForSchools();
							return;
						}
						if (nextString.length()!=0) {
							try {Double.parseDouble(nextString);}
							catch (NumberFormatException nFE) {
								System.out.println("Bad input; please try again! (input a double)");
								continue;
							}
							max = nextString;
						}
						inputDone = true;
					}
					idealSchool.add(min+"-"+max);
				}
				else {
					if (nextString.length()==0 || nextString.charAt(0)=='-') {
						idealSchool.add(null);
						inputDone = true;
						continue;
					}
					if (!nextString.matches("[A-Z]*"))
						System.out.println("Bad input; please try again! (Letters only please)");
					else {
						StringBuilder sB = new StringBuilder(nextString+":");
						nextString = s.nextLine().toUpperCase();
						while (nextString.charAt(0)!='-') {
							if (!nextString.matches("[A-Z]*"))
								System.out.println("Bad input; please try again! (Letters only please)");
							else
								sB.append(nextString+":");
							nextString = s.nextLine().toUpperCase();
						}
						idealSchool.add(sB.substring(0, sB.length()-1));
					}
				}
			}
		}
		SearchController sC = new SearchController();
		ArrayList<School> matchList = sC.search((String[])idealSchool.toArray());
		int resultNum = 0;
		for (School match : matchList) {
			// display simple school information
		}
		// get input of match's index and go to expanded view
		// ^ should be able to call another method for that I think (I hope)
		// have a quit option like '-' or something
		// anything else???
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
	 * Resets the search form.
	 * 
	 * @param method, indicates which method it was called from.
	 */
	private void resetForm(char method) {
		if(method == 'u') {
			this.manageUserProfile();
		} else if (method == 'v') {
			this.viewMenu();
		} else if (method == 's') {
			this.searchForSchools();
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
		new PersonHome().updatePerson(user.getUsername(), user.getFirstName(), user.getLastName(), 
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
