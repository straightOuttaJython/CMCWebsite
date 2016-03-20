import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import cmc.controller.LoginController;
import cmc.controller.LoginController.InactiveAccountException;

/**
 * Used WhiteBoxTesting
 * 
 * @author Matthew Kounniyom
 * @version March 20, 2016
 */
public class testLoginController {

	public LoginController lc;
	
	@Before
	public void setUp() throws Exception {
		lc = new LoginController();
	}

	@Test(expected = InactiveAccountException.class)
	public void testLogin_Case1() {
		lc.login("ImadUser", "Edited");
	}
	
	@Test
	public void testLogin_Case2() {
		lc.login("nadmin", "admin");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testLogin_Case3() {
		lc.login("nadmin", "1");
	}
	
	@Test
	public void testLogin_Case4() {
		lc.login("juser", "user");
	}
	
	@Test(expected = InactiveAccountException.class)
	public void testLogin_Case5() {
		lc.login("luser", "user");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testLogin_Case6() {
		lc.login("juser", "IAmJohnMiller");
	}
}
