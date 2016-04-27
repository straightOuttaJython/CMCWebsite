/**
 * 
 */
package cmc.ui;

import cmc.entity.Person;
import cmc.entity.School;
import cmc.home.PersonHome;
import cmc.home.SchoolHome;

/**
 * @author Erin Queme 
 * 
 * @version April 1, 2016
 *
 */
public class AdminUI {
	
	/**
	 * Creates a schoolHome to access and process the information of the database
	 */
	private SchoolHome sh;
	
	/**
	 * The Person logged into the UI
	 */
	private Person admin;

	/**
	 * Create a new AdminUI.
	 */
	public AdminUI(Person admin) 
	{
		this.admin = admin;
		sh = new SchoolHome();
	}
	
	/**
	 * Adds a school with the given attributes to the database
	 * @param name
	 * @param state
	 * @param location
	 * @param control
	 * @param numStudentsEnrolled
	 * @param percentFemEnrolled
	 * @param satVerbal
	 * @param satMath
	 * @param tuition
	 * @param percentFinAid
	 * @param numApplicants
	 * @param admitRate
	 * @param decideRate
	 * @param academics
	 * @param socialLife
	 * @param qualityLife
	 * @throws IllegalArgumentException if the system already contains a school with this name
	 */
	public void addSchool(String name, String state, String location, String control, 
			int numStudentsEnrolled, double percentFemEnrolled, double satVerbal, double satMath,
			double tuition, double percentFinAid, int numApplicants, double admitRate, 
			double decideRate, int academics, int socialLife, int qualityLife) throws IllegalArgumentException
	{
		SchoolHome aSH = new SchoolHome();
		School[] listOfSchools = aSH.listOfSchools();
		
		for(int i =0; i < listOfSchools.length; i++)
		{
			if(listOfSchools[i].getName().equals(name))
			{
				throw new IllegalArgumentException("The school " + name + " already exists in the system.");
			}
		}
		aSH.addSchool(name,state,location,control,
				numStudentsEnrolled,percentFemEnrolled, satVerbal, satMath, tuition, percentFinAid,
				numApplicants, admitRate,decideRate,academics,socialLife,qualityLife);
	}
	
	/**
	 * Updates the database representation of the given school
	 * @param name
	 * @param state
	 * @param location
	 * @param control
	 * @param numStudentsEnrolled
	 * @param percentFemEnrolled
	 * @param satVerbal
	 * @param satMath
	 * @param tuition
	 * @param percentFinAid
	 * @param numApplicants
	 * @param admitRate
	 * @param decideRate
	 * @param academics
	 * @param socialLife
	 * @param qualityLife
	 * @throws IllegalArgumentException if the school does not exist in the database
	 */
	public void editSchool(String name, String state, String location, String control, 
			int numStudentsEnrolled, double percentFemEnrolled, double satVerbal, double satMath,
			double tuition, double percentFinAid, int numApplicants, double admitRate, 
			double decideRate, int academics, int socialLife, int qualityLife) throws IllegalArgumentException
	{
		boolean notFound = true;
		SchoolHome eSH = new SchoolHome();
		School[] list = eSH.listOfSchools();
		for(int i =0; i < list.length; i++)
		{
			if(list[i].getName().equals(name))
			{
				notFound = false;
				eSH.updateSchool(name, state, location, control, numStudentsEnrolled, percentFemEnrolled, satVerbal, 
						satMath, tuition, percentFinAid, numApplicants, admitRate, decideRate, academics, socialLife, qualityLife);
			}
		}
		if(notFound) {
			throw new IllegalArgumentException("The school " + name + " does not exist in the system.");
		}
	}

	/**
	 * Updates user attributes. User is selected by given username.
	 * @param username
	 * @param firstName
	 * @param lastName
	 * @param password
	 * @param type
	 * @param status
	 * @throws IllegalArgumentException if no user with this username exists
	 */
	public void editUser(String username, String firstName, String lastName,
			String password, char type, char status) throws IllegalArgumentException
	{
		boolean notFound = true;
		PersonHome ph = new PersonHome();
		Person[] list = ph.getAllUsers();
		for(int i =0; i < list.length; i++)
		{
			if(list[i].getUsername().equals(username))
			{
				notFound = false;
				ph.updatePerson(username, firstName, lastName, password, type, status);
			} 
		}
		if(notFound) {
			throw new IllegalArgumentException("The account " + username + " does not exist.");
		}
	}

	/**
	 * Deactivates user by username
	 * @param username
	 */
	public void deactivate(String username) 
	{
		PersonHome ph = new PersonHome();
		Person dPerson = ph.getPerson(username);
		ph.deactivate(dPerson);
	}
	
	/**
	 * Adds a user with the given attributes to the database
	 * @param firstName
	 * @param lastName
	 * @param username
	 * @param password
	 * @param type
	 * @throws IllegalArgumentException if username already exists in system
	 */
	public void addUser(String firstName, String lastName, String username, String password, char type) throws IllegalArgumentException
	{
		boolean notFound = true;
		PersonHome ph = new PersonHome();
		Person[] list = ph.getAllUsers();
		for(int i =0; i < list.length; i++)
		{
			if(list[i].getUsername().equals(username))
			{
				notFound = false;
				ph.addUser(username, firstName, lastName, password, type);
			} 
		}
		if(notFound) {
			throw new IllegalArgumentException("The account " + username + " already exists.");
		}
	}

	public School[] getSchoolList()
	{
		return sh.listOfSchools();
	}

	public School getSchool(String schoolName) {
		SchoolHome sh = new SchoolHome();
		School school = sh.getSchool(schoolName);
		return school;
	}
	
	public String[] getEmph(String school)
	{
		return sh.getEmp(school);
	}
	
	/**
	 * Gets this UI's Person object
	 * @return the admin
	 */
	public Person getAdmin() {
		return this.admin;
	}
}
