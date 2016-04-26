package test.home;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cmc.entity.Person;
import cmc.entity.School;
import cmc.home.PersonHome;
import cmc.home.SchoolHome;
import dblibrary.project.csci230.UniversityDBLibrary;

/**
 * Tests the PersonHome class that is apart of the CMC Software.
 * 
 * @author Matthew Kounniyom
 * @version April 1, 2016
 */
public class PersonHomeTest {

	private PersonHome ph;
	private String username, fName, lName, password;
	private char type, status;
	
	@Before
	public void setUp() throws Exception {
		ph = new PersonHome();
	}

	/* BlackBox Test for PersonHome.getPerson(username) 
	 * 
	 * Description							Input username			Expected Output
	 * 
	 * Returns the correct Person			luser					The username of the returned person is equal to the inputed userame
	 * 
	 * Invalid Username						nautilus				IllegalArgumentException
	 * 
	 */
	@Test
	public void testGetPerson_case1() {
		username = "luser";
		Person user = ph.getPerson(username);
		assertEquals("Username of Person is equal to " + username, username, user.getUsername());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testGetPerson_case2() {
		username = "nautilus";
		ph.getPerson(username);
	}

	/* BlackBox Test for PersonHome.updatePerson(username, firstName, lastName, password, type, status) 
	 * 
	 * Description							Input username		Input firstName		Input lastName		Input password		Input type		Input status		Expected Output
	 * 
	 * Update password						juser				John				Miller				123					u				Y					The updated password should be equal to the new one.
	 * 
	 * Update type							juser				John				Miller				user				a				Y					The updated type should be equal to the new one.
	 * 
	 * Invalid type							juser				John				Miller				user				l				Y					IllegalArgumentException
	 * 
	 * Update lastName						juser				John				M					user				u				Y					The updated lastName should be equal to the new one.
	 * 
	 * Update status						juser				John				Miller				user				u				N					The updated status should be equal to the new one.
	 * 
	 * Invalid status						juser				John				Miller				user				u				y					IllegalArgumentException
	 * 
	 * Update firstname						juser				J					Miller				user				u				Y					The updated firstName should be equal to the new one.
	 * 
	 */
	@Test
	public void testUpdatePerson_case1() {
		username = "juser";
		fName = "John";
		lName = "Miller";
		password = "123";
		type = 'u';
		status = 'Y';
		ph.updatePerson(username, fName, lName, password, type, status);
		assertTrue("Persons password has changed.", ph.getPerson(username).getPassword().equals(password));
	}
	
	@Test
	public void testUpdatePerson_case2() {
		username = "juser";
		fName = "John";
		lName = "Miller";
		password = "user";
		type = 'a';
		status = 'Y';
		ph.updatePerson(username, fName, lName, password, type, status);
		assertTrue("Persons type has changed.", ph.getPerson(username).getType() == type);
	}
	

	@Test(expected = IllegalArgumentException.class)
	public void testUpdatePerson_case3() {
		username = "juser";
		fName = "John";
		lName = "Miller";
		password = "user";
		type = 'l';
		status = 'Y';
		ph.updatePerson(username, fName, lName, password, type, status);
	}
	

	@Test
	public void testUpdatePerson_case4() {
		username = "juser";
		fName = "John";
		lName = "M";
		password = "user";
		type = 'u';
		status = 'Y';
		ph.updatePerson(username, fName, lName, password, type, status);
		assertTrue("Persons last name has changed.", ph.getPerson(username).getLastName().equals(lName));
	}
	

	@Test
	public void testUpdatePerson_case6() {
		username = "juser";
		fName = "John";
		lName = "Miller";
		password = "user";
		type = 'a';
		status = 'N';
		ph.updatePerson(username, fName, lName, password, type, status);
		assertTrue("Persons status has changed.", ph.getPerson(username).getStatus() == 'N');
	}
	

	@Test(expected = IllegalArgumentException.class)
	public void testUpdatePerson_case7() {
		username = "juser";
		fName = "John";
		lName = "Miller";
		password = "user";
		type = 'a';
		status = 'y';
		ph.updatePerson(username, fName, lName, password, type, status);
	}
	
	@Test
	public void testUpdatePerson_case8() {
		username = "juser";
		fName = "J";
		lName = "Miller";
		password = "user";
		type = 'u';
		status = 'Y';
		ph.updatePerson(username, fName, lName, password, type, status);
		assertTrue("Persons first name has changed.", ph.getPerson(username).getFirstName().equals(fName));
	}

	/* Basic Test for PersonHome.getAllUsers()
	 * 
	 * Description						Expected Output
	 * 
	 * ValidArray						A non-null array.
	 * 
	 */
	
	
	@Test
	public void testGetAllUsers() {
		Person[] allUsers = ph.getAllUsers();
		assertNotNull(allUsers);
	}

	/*
	 * WhiteBox Test for PersonHome.deactivate(user)
	 * 
	 * Description							Input user			Expected Output
	 * 
	 * Change status from Y to N			juser				juser should be deactivated
	 * 										
	 * 										bob					bob should be deactivated
	 * 
	 * Change status from N to Y			luser				luser should be activated
	 * 										
	 * 										bob					bob should be activated
	 * 
	 */
	@Test
	public void testDeactivate_case1() {
		username = "juser";
		ph.deactivate(ph.getPerson(username));
		assertTrue("juser status is set from Y to N", ph.getPerson(username).getStatus() == 'N');
		ph.deactivate(ph.getPerson(username));
	}
	
	@Test
	public void testDeactivate_case2() {
		username = "luser";
		Person lynn = ph.getPerson(username);
		ph.updatePerson(lynn.getUsername(), lynn.getFirstName(), lynn.getLastName(), lynn.getPassword(), lynn.getType(), 'N');
		ph.getPerson(username).setStatus('N');
		ph.deactivate(ph.getPerson(username));
		assertTrue("luser status is set from N to Y", ph.getPerson(username).getStatus() == 'Y');
		ph.deactivate(ph.getPerson(username));
	}
	
	@Test
	public void testDeactivate_case3() {
		username = "bob";
		Person bob = ph.getPerson(username);
		ph.updatePerson(bob.getUsername(), bob.getFirstName(), bob.getLastName(), bob.getPassword(), bob.getType(), 'N');
		ph.deactivate(ph.getPerson(username));
		assertTrue("bob status is set from N to Y", ph.getPerson(username).getStatus() == 'Y');
	}
	
	@Test
	public void testDeactivate_case4() {
		username = "bob";
		ph.getPerson(username).setStatus('Y');
		ph.deactivate(ph.getPerson(username));
		assertTrue("bob status is set from Y to N", ph.getPerson(username).getStatus() == 'N');
	}

	/*
	 * Basic Test for PersonHome.addUser(firstName, lastName, username, password, type)
	 * 
	 * Description				Input firstName			Input lastName		Input username		Input password		Input type		Expected Output
	 * 
	 * Add New User				Matthew					Kounniyom			makounniyom			123456				u				User has been added.
	 * 
	 */
	@Test
	public void testAddUser() {
		fName = "Matthew";
		lName = "Kounniyom";
		username = "makounniyom";
		password = "123456";
		type = 'u';
		ph.addUser(fName, lName, username, password, type);
		Person matt = ph.getPerson(username);
		assertTrue("User name is equal", matt.getUsername().equals(username));
		assertTrue("First name is equal", matt.getFirstName().equals(fName));
		assertTrue("Last name is equal", matt.getLastName().equals(lName));
		assertTrue("Password is equal", matt.getPassword().equals(password));
		assertTrue("Type is equal", matt.getType() == type);
		UniversityDBLibrary db = new UniversityDBLibrary("straightou", "straightou", "adem4");
		db.user_deleteUser(username);
	}
	
	/*
	 * WhiteBox Testing for PersonHome.saveSchool(user, school)
	 * 
	 * Description				Input user			Input school		Expected Output
	 *
	 * save error				matt				default school		RuntimeException
	 * 
	 * save complete			matt				BARD				BARD has been added to the users saved schools.
	 *
	 */
	@Test(expected=RuntimeException.class)
	public void testSaveSchool_case1() {
		fName = "Matthew";
		lName = "Kounniyom";
		username = "makounniyom";
		password = "123456";
		type = 'u';
		ph.addUser(fName, lName, username, password, type);
		Person matt = ph.getPerson(username);
		School school = new School();
		
		ph.saveSchool(matt, school);
		
		UniversityDBLibrary db = new UniversityDBLibrary("straightou", "straightou", "adem4");
		db.user_deleteUser(username);
	}
	
	@Test
	public void testSaveSchool_case2() {
		fName = "Matthew";
		lName = "Kounniyom";
		username = "makounniyom";
		password = "123456";
		type = 'u';
		ph.addUser(fName, lName, username, password, type);
		Person matt = ph.getPerson(username);
		SchoolHome sh = new SchoolHome();
		School[] sList = sh.listOfSchools();
		School school = new School();
		for(int i = 0; i < sList.length; i++) {
			if(sList[i].getName().equals("BARD")) {
				school = sList[i];
			}
		}
		
		ph.saveSchool(matt, school);
		String[] strList = matt.getSavedSchools();
		for(int i = 0; i < strList.length; i++) {
			if(sList[i].getName().equals("BARD")) {
				assertTrue("The added school exists.", sList[i].equals(school.getName()));
			}
		}
		UniversityDBLibrary db = new UniversityDBLibrary("straightou", "straightou", "adem4");
		db.user_removeSchool(username, "BARD");
		db.user_deleteUser(username);
	}
	
	/*
	 * WhiteBox Testing for PersonHome.removeSchool(user, school)
	 * 
	 * Description				Input user			Input school		Expected Output
	 *
	 * remove error				matt				default school		RuntimeException
	 * 
	 * remove complete			matt				BARD				BARD has been removed from the users saved schools.
	 */
	@Test(expected=RuntimeException.class)
	public void testRemoveSchool_case1() {
		fName = "Matthew";
		lName = "Kounniyom";
		username = "makounniyom";
		password = "123456";
		type = 'u';
		ph.addUser(fName, lName, username, password, type);
		Person matt = ph.getPerson(username);
		School school = new School();
		
		ph.removeSchool(matt, null);
		
		UniversityDBLibrary db = new UniversityDBLibrary("straightou", "straightou", "adem4");
		db.user_deleteUser(username);
	}
	
	@Test
	public void testRemoveSchool_case2() {
		fName = "Matthew";
		lName = "Kounniyom";
		username = "makounniyom";
		password = "123456";
		type = 'u';
		ph.addUser(fName, lName, username, password, type);
		Person matt = ph.getPerson(username);
		SchoolHome sh = new SchoolHome();
		School[] sList = sh.listOfSchools();
		School school = new School();
		for(int i = 0; i < sList.length; i++) {
			if(sList[i].getName().equals("BARD")) {
				school = sList[i];
			}
		}
		
		ph.saveSchool(matt, school);
		ph.removeSchool(matt, school);
		String[] strList = matt.getSavedSchools();
		for(int i = 0; i < strList.length; i++) {
			assertTrue("The removed school exists.", !(sList[i].equals(school.getName())));
		}
		UniversityDBLibrary db = new UniversityDBLibrary("straightou", "straightou", "adem4");
		db.user_deleteUser(username);
	}
	
	@After
	public void resetJohn() {
		ph.updatePerson("juser", "John", "Miller", "user", 'u', 'Y');
	}

}
