/**
 * 
 */
package controller.search;

import static org.junit.Assert.*;

import org.junit.Test;

import cmc.controller.LoginController.InactiveAccountException;
import cmc.controller.search.IntegerSchoolSearchTerm;

/**
 * @author Alex
 *
 */
public class IntegerSchoolSearchTermTest {
	
	IntegerSchoolSearchTerm searchTerm;

	/**
	 * Test method for {@link cmc.controller.search.IntegerSchoolSearchTerm#calculateMatch(java.lang.String)}.
	 */
	@Test (expected = IllegalStateException.class)
	public void testCalculateMatchFailIfUnset() {
		searchTerm = new IntegerSchoolSearchTerm(4,0,Integer.MAX_VALUE);
		searchTerm.calculateMatch("20");
	}
	
	/**
	 * Test method for {@link cmc.controller.search.IntegerSchoolSearchTerm#calculateMatch(java.lang.String)}.
	 */
	@Test (expected = NumberFormatException.class)
	public void testCalculateMatchFailIfNotInt() {
		searchTerm = new IntegerSchoolSearchTerm(4,0,Integer.MAX_VALUE);
		searchTerm.setValue("10:30");
		searchTerm.calculateMatch("G");
	}
	
	/**
	 * Test method for {@link cmc.controller.search.IntegerSchoolSearchTerm#calculateMatch(java.lang.String)}.
	 */
	@Test
	public void testCalculateMatchInRange() {
		searchTerm = new IntegerSchoolSearchTerm(4,0,Integer.MAX_VALUE);
		searchTerm.setValue("10:30");
		double expectedResult = 1.0;
		double result = searchTerm.calculateMatch("20");
		assertTrue("expected result: "+expectedResult+" actual result: "+result,result==expectedResult);
	}
	
	/**
	 * Test method for {@link cmc.controller.search.IntegerSchoolSearchTerm#calculateMatch(java.lang.String)}.
	 */
	@Test
	public void testCalculateMatchSingleNumber() {
		searchTerm = new IntegerSchoolSearchTerm(4,0,Integer.MAX_VALUE);
		searchTerm.setValue("20");
		double expectedResult = 1.0;
		double result = searchTerm.calculateMatch("20");
		assertTrue("expected result: "+expectedResult+" actual result: "+result,result==expectedResult);
	}
	
	/**
	 * Test method for {@link cmc.controller.search.IntegerSchoolSearchTerm#calculateMatch(java.lang.String)}.
	 */
	@Test
	public void testCalculateMatchOutOfRangeAboveNoGradient() {
		searchTerm = new IntegerSchoolSearchTerm(4,0,Integer.MAX_VALUE);
		searchTerm.setValue("10:30");
		double expectedResult = 0.0;
		double result = searchTerm.calculateMatch("40");
		assertTrue("expected result: "+expectedResult+" actual result: "+result,result==expectedResult);
	}
	
	/**
	 * Test method for {@link cmc.controller.search.IntegerSchoolSearchTerm#calculateMatch(java.lang.String)}.
	 */
	@Test
	public void testCalculateMatchOutOfRangeBelowNoGradient() {
		searchTerm = new IntegerSchoolSearchTerm(4,0,Integer.MAX_VALUE);
		searchTerm.setValue("10:30");
		double expectedResult = 0.0;
		double result = searchTerm.calculateMatch("5");
		assertTrue("expected result: "+expectedResult+" actual result: "+result,result==expectedResult);
	}
	
	/**
	 * Test method for {@link cmc.controller.search.IntegerSchoolSearchTerm#calculateMatch(java.lang.String)}.
	 */
	@Test
	public void testCalculateMatchOutOfRangeAboveWithLowRangeGradient() {
		searchTerm = new IntegerSchoolSearchTerm(4,0,100);
		searchTerm.setValue("20:40");
		double expectedResult = 0.6;
		double result = searchTerm.calculateMatch("64");
		assertTrue("expected result: "+expectedResult+" actual result: "+result,result==expectedResult);
	}
	
	/**
	 * Test method for {@link cmc.controller.search.IntegerSchoolSearchTerm#calculateMatch(java.lang.String)}.
	 */
	@Test
	public void testCalculateMatchOutOfRangeBelowWithLowRangeGradient() {
		searchTerm = new IntegerSchoolSearchTerm(4,0,100);
		searchTerm.setValue("20:40");
		double expectedResult = 0.8;
		double result = searchTerm.calculateMatch("8");
		assertTrue("expected result: "+expectedResult+" actual result: "+result,result==expectedResult);
	}
	
	/**
	 * Test method for {@link cmc.controller.search.IntegerSchoolSearchTerm#calculateMatch(java.lang.String)}.
	 */
	@Test
	public void testCalculateMatchOutOfRangeAboveWithHighRangeGradient() {
		searchTerm = new IntegerSchoolSearchTerm(4,0,100);
		searchTerm.setValue("60:80");
		double expectedResult = 0.8;
		double result = searchTerm.calculateMatch("92");
		assertTrue("expected result: "+expectedResult+" actual result: "+result,result==expectedResult);
	}
	
	/**
	 * Test method for {@link cmc.controller.search.IntegerSchoolSearchTerm#calculateMatch(java.lang.String)}.
	 */
	@Test
	public void testCalculateMatchOutOfRangeBelowWithHighRangeGradient() {
		searchTerm = new IntegerSchoolSearchTerm(4,0,100);
		searchTerm.setValue("60:80");
		double expectedResult = 0.4;
		double result = searchTerm.calculateMatch("24");
		assertTrue("expected result: "+expectedResult+" actual result: "+result,result==expectedResult);
	}

	/**
	 * Test method for {@link cmc.controller.search.IntegerSchoolSearchTerm#setValue(java.lang.String)}.
	 */
	@Test (expected = NumberFormatException.class)
	public void testSetValueFailForSingleInvalidInt() {
		searchTerm = new IntegerSchoolSearchTerm(4,0,Integer.MAX_VALUE);
		searchTerm.setValue("G");
	}
	
	/**
	 * Test method for {@link cmc.controller.search.IntegerSchoolSearchTerm#setValue(java.lang.String)}.
	 */
	@Test (expected = NumberFormatException.class)
	public void testSetValueFailForColon() {
		searchTerm = new IntegerSchoolSearchTerm(4,0,Integer.MAX_VALUE);
		searchTerm.setValue(":");
	}
	
	/**
	 * Test method for {@link cmc.controller.search.IntegerSchoolSearchTerm#setValue(java.lang.String)}.
	 */
	@Test (expected = NumberFormatException.class)
	public void testSetValueFailForTwoInvalidInts() {
		searchTerm = new IntegerSchoolSearchTerm(4,0,Integer.MAX_VALUE);
		searchTerm.setValue("G:H");
	}
	
	/**
	 * Test method for {@link cmc.controller.search.IntegerSchoolSearchTerm#setValue(java.lang.String)}.
	 */
	@Test (expected = IllegalArgumentException.class)
	public void testSetValueFailForBackwardsRange() {
		searchTerm = new IntegerSchoolSearchTerm(4,0,Integer.MAX_VALUE);
		searchTerm.setValue("40:20");
	}
	
	/**
	 * Test method for {@link cmc.controller.search.IntegerSchoolSearchTerm#setValue(java.lang.String)}.
	 */
	@Test (expected = IllegalArgumentException.class)
	public void testSetValueFailForOutOfRangeLower() {
		searchTerm = new IntegerSchoolSearchTerm(4,20,50);
		searchTerm.setValue("10:30");
	}
	
	/**
	 * Test method for {@link cmc.controller.search.IntegerSchoolSearchTerm#setValue(java.lang.String)}.
	 */
	@Test (expected = IllegalArgumentException.class)
	public void testSetValueFailForOutOfRangeUpper() {
		searchTerm = new IntegerSchoolSearchTerm(4,20,50);
		searchTerm.setValue("30:60");
	}

	/**
	 * Test method for {@link cmc.controller.search.IntegerSchoolSearchTerm#IntegerSchoolSearchTerm(int, int, int)}.
	 */
	@Test (expected = IllegalArgumentException.class)
	public void testConstructorFailForBackwardsRange() {
		searchTerm = new IntegerSchoolSearchTerm(4,40,20);
	}

}
