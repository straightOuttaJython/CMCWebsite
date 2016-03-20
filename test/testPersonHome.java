import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import cmc.entity.Person;
import cmc.home.PersonHome;

/**
 * Tests the PersonHome class that is apart of the CMC Software.
 * 
 * @author Matthew Kounniyom
 * @version March 20, 2016
 */
public class testPersonHome {

	public PersonHome ph;
	private String username, fName, lName, password;
	private char type, status;
	
	@Before
	public void setUp() throws Exception {
		ph = new PersonHome();
	}

	/**
	 * BlackBox
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

	/**
	 * BlackBox
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

	/**
	 * Basic
	 */
	@Test
	public void testGetAllUsers() {
		Person[] allUsers = ph.getAllUsers();
		assertNotNull(allUsers);
	}

	/**
	 * WhiteBox
	 */
	@Test
	public void testDeactivate_case1() {
		username = "juser";
		ph.deactivate(ph.getPerson(username));
		assertTrue("juser status is set from Y to N", ph.getPerson(username).getStatus() == 'N');
	}
	
	@Test
	public void testDeactivate_case2() {
		username = "luser";
		Person lynn = ph.getPerson(username);
		ph.updatePerson(lynn.getUsername(), lynn.getFirstName(), lynn.getLastName(), lynn.getPassword(), lynn.getType(), 'N');
		ph.getPerson(username).setStatus('N');
		ph.deactivate(ph.getPerson(username));
		assertTrue("luser status is set from N to Y", ph.getPerson(username).getStatus() == 'Y');
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

	/**
	 * Basic
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
	}

}
