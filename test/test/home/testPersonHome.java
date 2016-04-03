package test.home;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cmc.entity.Person;
import cmc.home.PersonHome;
import dblibrary.project.csci230.UniversityDBLibrary;

/**
 * Tests the PersonHome class that is apart of the CMC Software.
 * 
 * @author Matthew Kounniyom
 * @version April 1, 2016
 */
public class testPersonHome {

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
		assertEquals("Username of Person is equal to " + username, username, ph.getPerson(username).getUsername());
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
	
	@After
	public void resetJohn() {
		ph.updatePerson("juser", "John", "Miller", "user", 'u', 'Y');
	}

}
