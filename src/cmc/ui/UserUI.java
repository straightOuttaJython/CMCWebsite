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
* @author Duong Do, Matthew Kounniyom, Alex Seefeldt
* @version April 3, 2016
*/
public class UserUI {
	
	/**
	 * Instance variable
	 */
	private Person user;
	
	/**
	 * Constructs a new UserUI serving the specified user.
	 * @param user the user being served by this UserUI
	 */
	public UserUI(Person user) {
		this.user = user;
	}
	
	/**
	 * Takes two String arrays: one containing all search values for this search
	 * (besides emphases) and the other containing the emphasis search values. If any
	 * search value is the empty string or null, the search will ignore that attribute.
	 * Returns an array of up to 50 Schools best matching the search terms. 
	 * @param searchValues the values being searched for
	 * @param emphases the emphasis values being searched for
	 * @return an array of matching Schools
	 */
	public School[] searchForSchools(String[] searchValues, String[] emphases) {
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
		for (int i=0; i<searchValues.length; i++) {
			value = searchValues[i];
			if (!value.equals(""))
				searchClause.setValueAtIndex(value, i);
		}
		return new SearchController().search(searchClause);
	}
	
	/**
	 * Access method for .jsp pages when managing a user's list of saved schools.
	 * @return an array of this user's saved Schools
	 */
	public School[] manageSchools() {
		return this.user.getSavedSchools();
	}
	
	/**
	 * Access method for .jsp pages to {@link cmc.home.PersonHome#saveSchool(Person, School)}
	 * @param school the School to be saved
	 */
	public void saveSchool(School school) {
		new PersonHome().saveSchool(this.user, school);
	}
	
	/**
	 * Access method for .jsp pages to {@link cmc.home.PersonHome#removeSchool(Person, School)}
	 * @param school the School to be removed
	 */
	public void removeSchool(School school) {
		new PersonHome().removeSchool(this.user, school);
	}
	
	/**
	 * Limited access method for .jsp pages to
	 * {@link cmc.home.PersonHome#updatePerson(String, String, String, String, char, char)}
	 * @param firstName the firstname to be changed to
	 * @param lastName the lastname to be changed to
	 * @param password the password to change to
	 */
	public void editUser(String firstName, String lastName, String password) {
		new PersonHome().updatePerson(this.user.getUsername(), firstName, lastName, password, user.getType(), user.getStatus());
	}
	
	/**
	 * Returns an array of 5 Schools closely matching the given school. Used for displaying
	 * the expanded view of a school.
	 * @param school the School for which these recommendations are generated
	 * @return an School array of length 5 containing the recommended Schools 
	 */
	public School[] getRecommendations(School school) {
		String[] schoolArray = SchoolDatabaseMapping.convertSchoolToDatabaseItem(school);
		String[] emphases = school.getEmphases();
		School[] fullMatchList = this.searchForSchools(schoolArray, emphases);
		School[] shortList = Arrays.copyOf(fullMatchList, 5);
		return shortList;
	}
}
