package cmc.ui;

import java.util.Arrays;

import cmc.controller.SearchController;
import cmc.controller.search.SchoolSearchClause;
import cmc.entity.Person;
import cmc.entity.School;
import cmc.entity.dbmapping.SchoolDatabaseMapping;
import cmc.home.PersonHome;
import cmc.home.SchoolHome;

/**
* The UserUI class controls user's action.
* 
* @author Duong Do, Matthew Kounniyom, Alex Seefeldt
* @version April 23, 2016
*/
public class UserUI {
	
	/**
	 * Creates a schoolHome to access and process the information of the database
	 */
	private SchoolHome sh = new SchoolHome();
	
	/**
	 * Creates a personHome to access and process the information of the database
	 */
	private PersonHome ph = new PersonHome();
	
	/**
	 * The Person logged into the UI
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
		SearchController sc = new SearchController();
		SchoolSearchClause searchClause = sc.prepareSearchClause(searchValues,emphases);
		return sc.search(searchClause);
	}
	
	/**
	 * Access method for .jsp pages when managing a user's list of saved schools.
	 * @return an array of this user's saved Schools
	 */
	public String[] manageSchools() {
		return this.user.getSavedSchools();
	}
	
	/**
	 * Access method for .jsp pages to {@link cmc.home.PersonHome#saveSchool(Person, School)}
	 * @param school the School to be saved
	 */
	public void saveSchool(School school) {
		ph.saveSchool(this.user, school);
	}
	
	/**
	 * Access method for .jsp pages to {@link cmc.home.PersonHome#removeSchool(Person, School)}
	 * @param school the School to be removed
	 */
	public void removeSchool(School school) {
		ph.removeSchool(this.user, school);
	}
	
	/**
	 * Limited access method for .jsp pages to
	 * {@link cmc.home.PersonHome#updatePerson(String, String, String, String, char, char)}
	 * @param firstName the firstname to be changed to
	 * @param lastName the lastname to be changed to
	 * @param password the password to change to
	 */
	public void editUser(String firstName, String lastName, String password) {
		ph.updatePerson(this.user.getUsername(), firstName, lastName, password, user.getType(), user.getStatus());
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
	
	/**
	 * The method getSchool, finds the school with the given schoolName and returns
	 * the school object that it belongs to.
	 * 
	 * @param String schoolName, is the string value that is the name of a school.
	 * @return School school, the school object that has the given schoolName.
	 */
	public School getSchool(String schoolName) {
		School school = sh.getSchool(schoolName);
		return school;
	}

	/**
	 * Gets this UI's Person object
	 * @return the user
	 */
	public Person getUser() {
		return this.user;
	}
	
	/**
	 * Check the user has this school or not
	 * @param String schoolName
	 * @return true or false
	 */
	public boolean hasSchool(String schoolName){
		String[] schools = user.getSavedSchools();
		for(int i = 0; i < schools.length; i++){
			if(schools[i].equals(schoolName)){
				return true;
			}
		}
		return false;
	}
}
