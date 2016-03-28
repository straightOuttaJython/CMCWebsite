package cmc.ui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

import cmc.controller.SearchController;
import cmc.controller.search.DoubleSchoolSearchTerm;
import cmc.controller.search.IntegerSchoolSearchTerm;
import cmc.controller.search.SchoolSearchClause;
import cmc.controller.search.StringArraySchoolSearchTerm;
import cmc.controller.search.StringSchoolSearchTerm;
import cmc.entity.Person;
import cmc.entity.School;
import cmc.entity.dbmapping.DoubleSchoolAttributeMetadata;
import cmc.entity.dbmapping.IntegerSchoolAttributeMetadata;
import cmc.entity.dbmapping.SchoolAttributeMetadata;
import cmc.entity.dbmapping.SchoolDatabaseMapping;
import cmc.entity.dbmapping.StringSchoolAttributeMetadata;
import cmc.home.PersonHome;
import cmc.home.SchoolHome;
import dblibrary.project.csci230.UniversityDBLibrary;

/**
* The UserUI class controls user's action.
* 
* @author Duong, Matthew Kounniyom
* @version March 14, 2016
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
	
	/**
	 * This is the list of matches for the last search made.
	 */
	private School[] lastMatchList;
	
	/** Constructor
	 * @param user
	 */
	public UserUI(Person user) {
		this.user = user;
	}
	
	private static final int[] STRING_LOCATIONS = {0,1,2,3};
	private static final int[] INT_LOCATIONS = {4,10,13,14,15};
	private static final int[] DOUBLE_LOCATIONS = {5,6,7,8,9,11,12};
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
		char cmd = s.next().toLowerCase().charAt(0);
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
		System.out.println(" ** IF YOU WANT TO LEAVE OUT A FIELD LEAVE BLANK **");
		SchoolSearchClause searchClause = new SchoolSearchClause();
		for (int i=0; i<SchoolDatabaseMapping.MAPPING.length; i++) {
			String value = this.takeSearchInput(SchoolDatabaseMapping.MAPPING[i]);
			if (!value.equals(""))
				searchClause.setValueAtIndex(value, i);
		}
		this.searchForSchools(searchClause);
	}

	public void searchForSchools(SchoolSearchClause searchClause) {
		SearchController sC = new SearchController();
		School[] matchList =  sC.search(searchClause);
		this.lastMatchList = matchList;
		this.showResults(matchList);
	}
	
	private String takeSearchInput(SchoolAttributeMetadata sam) {
		s = new Scanner(System.in);
		System.out.println(sam.getName()+":");
		char type = sam.getType();
		if (type=='s') {
			String returnLine = s.nextLine();
			s.close();
			return returnLine;
		}
		else if (type=='i') {
			System.out.println("Minimum:");
			boolean validInput = false;
			Integer lower = null;
			while (lower==null) {
				try { lower = Integer.parseInt(s.nextLine()); }
				catch (NumberFormatException nFE) {
					System.out.println("Please enter a valid integer");
				}
			}
			System.out.println("Minimum:");
			validInput = false;
			Integer upper = null;
			while (upper==null) {
				try { upper = Integer.parseInt(s.nextLine()); }
				catch (NumberFormatException nFE) {
					System.out.println("Please enter a valid integer");
				}
			}
			s.close();
			return lower+":"+upper;
		}
		else if (type=='d') {
			System.out.println("Minimum:");
			boolean validInput = false;
			Double lower = null;
			while (lower==null) {
				try { lower = Double.parseDouble(s.nextLine()); }
				catch (NumberFormatException nFE) {
					System.out.println("Please enter a valid integer");
				}
			}
			System.out.println("Minimum:");
			validInput = false;
			Double upper = null;
			while (upper==null) {
				try { upper = Double.parseDouble(s.nextLine()); }
				catch (NumberFormatException nFE) {
					System.out.println("Please enter a valid integer");
				}
			}
			s.close();
			return lower+":"+upper;
		}
		else if (type=='a') {
			System.out.println("Type a dash '-' when done. Do not use colons ':'.");
			String input = s.nextLine();
			String inputList = "";
			while (!input.equals("-")) {
				if (!input.contains(":"))
					inputList+=":"+input;
				else
					System.out.println("Ignoring illegal input");
				input = s.nextLine();
			}
			s.close();
			return inputList.equals("") ? inputList : inputList.substring(1);
		}
		else {
			s.close();
			throw new RuntimeException("SchoolAttributeMetadata had invalid type");
		}
	}
	
	/**
	 * Shows search results.
	 */
	private void showResults(School[] matchList) {
		s = new Scanner(System.in);
		System.out.println("***SEARCH RESULTS***");
		int resultNum = 0;
		for (School match : matchList) {
			System.out.println("Match "+(resultNum++)+":");
			this.viewSimple(match);
		}
		System.out.println("Type a match number to see the Expanded School View, "
							+ "or type \"-\" to quit the search");
		System.out.println("Match number:");
		boolean validInput = false;
		Integer input = null;
		while (input==null) {
			String inputAttempt = s.nextLine();
			if (!inputAttempt.equals("-")) {
				try { input = Integer.parseInt(inputAttempt); }
				catch (NumberFormatException nFE) {
					System.out.println("Please enter a valid integer");
				}
				if (input < 0 || input >= matchList.length) {
					System.out.println("Please enter a valid integer");
					input = null;
				}
			}
			else
				return;
		}
		this.viewExpanded(matchList[input]);
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
		System.out.println("  Emphases: ");
		for (String em : school.getEmphases()) {
			System.out.println("    -"+em);
		}
		System.out.println("***Recommended Schools for "+school.getName()+"***");
		SearchController sC = new SearchController();
		String emphases = "";
		for (String emphasis : school.getEmphases())
			emphases+=":"+emphasis;
		SchoolSearchClause searchClause = new SchoolSearchClause(SchoolDatabaseMapping.convertSchoolToDatabaseItem(school),emphases);
		School[] recommendations = sC.search(searchClause); // here is where you implement the other fix
		int entryNum = 1;
		for (School rec : recommendations) {
			System.out.println("Entry "+(entryNum++));
			this.viewSimple(rec);
		} // Functionality to go to expanded view from here must be added later
		System.out.println(" ** To save or view a school, type a recommendation number **");
		System.out.println(" * Type \"-\" to quit *");
		s = new Scanner(System.in);
		String input = s.nextLine();
		while (input.length()==0 || input.charAt(0)!='-' && !input.matches("[1-5]")) {
			System.out.println("Please enter a valid recommendation number (1-5) or \"-\" to quit");
			input = s.nextLine();
		}
		if (input.charAt(0)!='-') {
			School schoolChoice =  recommendations[Integer.parseInt(input)-1];
			System.out.println(" ** To save the school, type \"s\". To view the school, type \"v\". **");
			input = s.nextLine();
			while (input.length()==0 || input.charAt(0)!='-' && input.toUpperCase().charAt(0)!='S' && input.toUpperCase().charAt(0)!='V') {
				System.out.println("To save the school, type \"s\". To view the school, type \"v\".");
				input = s.nextLine();
			}
			if (input.toUpperCase().charAt(0)=='S') {
				this.saveSchool(schoolChoice);
			}
			else if (input.toUpperCase().charAt(0)=='V') {
				this.viewExpanded(schoolChoice);
			}
		}
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
