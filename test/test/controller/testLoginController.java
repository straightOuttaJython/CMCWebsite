package test.controller;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import cmc.controller.LoginController;
import cmc.controller.LoginController.InactiveAccountException;
import cmc.entity.Person;

/**
 * Used WhiteBoxTesting
 * 
 * @author Matthew Kounniyom
 * @version April 1, 2016
 */
public class testLoginController {

	private LoginController lc;
	private Person p;
	
	@Before
	public void setUp() throws Exception {
		lc = new LoginController();
	}

	/**
	 * Only used WhiteBox Testing for the LoginController because there is only one method.
	 */
	
	/*
	Description							Input username		Input password		Expected output
	
	Inactive account					ImadUser			Edited				InactiveAccountException
	
										luser				user				InactiveAccountException
	
	Login successful					nadmin				admin				Person Object with username nadmin, and password admin
			
										bob					obo					Person Object with username juser, and password user
	
	Invalid password					nadmin				1					InvalidArgumentException
				
										juser				IAmJohnMiller		InvalidArgumentException
	
	
	

 */
	
	@Test(expected = InactiveAccountException.class)
	public void testLogin_Case1() {
		lc.login("ImadUser", "Edited");
	}
	
	@Test
	public void testLogin_Case2() {
		p = lc.login("nadmin", "admin");
		assertTrue("p's username is nadmin.", p.getUsername().equals("nadmin"));
		assertTrue("p's password is admin.", p.getPassword().equals("admin"));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testLogin_Case3() {
		lc.login("nadmin", "1");
	}
	
	@Test
	public void testLogin_Case4() {
		p = lc.login("juser", "user");
		assertTrue("p's username is nadmin.", p.getUsername().equals("juser"));
		assertTrue("p's password is admin.", p.getPassword().equals("user"));
	}
	
	@Test(expected = InactiveAccountException.class)
	public void testLogin_Case5() {
		lc.login("bob", "obo");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testLogin_Case6() {
		lc.login("juser", "IAmJohnMiller");
	}
}
