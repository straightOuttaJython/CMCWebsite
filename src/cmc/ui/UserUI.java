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
* @version April 1, 2016
*/
public class UserUI {
	
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
	 * Handles the User wanting to search for schools.
	 * @return 
	 * 
	 * @throws ResetException if the user is trying to reset.
	 */
	public School[] searchForSchools(String[] school, String[] emphases) {
		SchoolSearchClause searchClause = new SchoolSearchClause();
		String value;
		String emphasisString = "";
		for (int i=0; i<emphases.length; i++) {
			value = emphases[i];
			if (!value.equals("") && value!=null)
				emphasisString+=":"+value;
		}
		if (!emphasisString.equals(""))
			searchClause.setValueAtIndex(emphasisString.substring(1), 16);
		for (int i=0; i<school.length; i++) {
			value = school[i];
			if (!value.equals(""))
				searchClause.setValueAtIndex(value, i);
		}
		return new SearchController().search(searchClause);
	}
	
	/**
	 * Manages the users saved school list.
	 */
	public School[] manageSchools() {
		return this.user.getSavedSchools();
	}
	
	/**
	 * Saves the currently viewed school.
	 * 
	 * @param school, the school to be saved.
	 */
	public void saveSchool(School school) {
		new PersonHome().removeSchool(this.user, school);
	}
	
	/**
	 * Removes the given school, from the users saved school list.
	 * 
	 * @param school, the school to be removed.
	 */
	public void removeSchool(School school) {
		new PersonHome().removeSchool(this.user, school);
	}
	
	/**
	 * Changes the users firstname, lastname, and password based on the given parameters.
	 * 
	 * @param firstName, the firstname to be changed to.
	 * @param lastName, the lastname to be changed to.
	 * @param password, the password to change to.
	 */
	public void editUser(String firstName, String lastName, String password) {
		new PersonHome().updatePerson(this.user.getUsername(), firstName, lastName, password, user.getType(), user.getStatus());
	}
	
	/**
	 * Used to view all of the details of a school.
	 * 
	 * @param school, the school to be viewed in full.
	 */
	public School[] getRecommendations(School school) {
		String[] schoolArray = SchoolDatabaseMapping.convertSchoolToDatabaseItem(school);
		String[] emphases = school.getEmphases();
		School[] fullMatchList = this.searchForSchools(schoolArray, emphases);
		School[] shortList = Arrays.copyOf(fullMatchList, 5);
		return shortList;
	}
}
