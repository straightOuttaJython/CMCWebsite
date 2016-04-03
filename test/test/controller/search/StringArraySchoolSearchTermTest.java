/**
 * 
 */
package test.controller.search;

import static org.junit.Assert.*;

import org.junit.Test;

import cmc.controller.search.StringArraySchoolSearchTerm;
import cmc.controller.search.StringSchoolSearchTerm;

/**
 * @author Alex
 *
 */
public class StringArraySchoolSearchTermTest {

	StringArraySchoolSearchTerm searchTerm;
	
	/**
	 * Test method for {@link cmc.controller.search.StringSchoolSearchTerm#calculateMatch(java.lang.String)}.
	 */
	@Test (expected = IllegalStateException.class)
	public void testCalculateMatchFailIfUnset() {
		searchTerm = new StringArraySchoolSearchTerm(16);
		searchTerm.calculateMatch("Cat");
	}
	
	/**
	 * Test method for {@link cmc.controller.search.StringSchoolSearchTerm#calculateMatch(java.lang.String)}.
	 */
	@Test
	public void testCalculateMatchPerfectMatch() {
		searchTerm = new StringArraySchoolSearchTerm(16);
		searchTerm.setValue("Cat:Dog:Bunny:Cow");
		double expectedResult = 1.0;
		double result = searchTerm.calculateMatch("Cat:Dog:Bunny:Cow");
		assertTrue("expected result: "+expectedResult+" actual result: "+result,result==expectedResult);
		result = searchTerm.calculateMatch("Cat:Dog:Bunny:Cow:Horse");
		assertTrue("expected result: "+expectedResult+" actual result: "+result,result==expectedResult);
	}
	
	/**
	 * Test method for {@link cmc.controller.search.StringSchoolSearchTerm#calculateMatch(java.lang.String)}.
	 */
	@Test
	public void testCalculateMatchDuplicatesInArray() {
		searchTerm = new StringArraySchoolSearchTerm(16);
		searchTerm.setValue("Cat:Dog:Bunny:Cow");
		double expectedResult = 1.0;
		double result = searchTerm.calculateMatch("Cat:Dog:Bunny:Cow:Dog");
		assertTrue("expected result: "+expectedResult+" actual result: "+result,result==expectedResult);
		searchTerm.setValue("Cat:Dog:Bunny:Cow:Dog");
		result = searchTerm.calculateMatch("Cat:Dog:Bunny:Cow");
		assertTrue("expected result: "+expectedResult+" actual result: "+result,result==expectedResult);
	}
	
	/**
	 * Test method for {@link cmc.controller.search.StringSchoolSearchTerm#calculateMatch(java.lang.String)}.
	 */
	@Test
	public void testCalculateMatchPartialMatch() {
		searchTerm = new StringArraySchoolSearchTerm(16);
		searchTerm.setValue("Cat:Dog:Bunny:Cow");
		double expectedResult = 0.75;
		double result = searchTerm.calculateMatch("Cat:Dog:Cow");
		assertTrue("expected result: "+expectedResult+" actual result: "+result,result==expectedResult);
		searchTerm = new StringArraySchoolSearchTerm(16);
		searchTerm.setValue("Cat:Dog:Bunny:Cow");
		expectedResult = 0.5;
		result = searchTerm.calculateMatch("Cat:Dog:Horse");
		assertTrue("expected result: "+expectedResult+" actual result: "+result,result==expectedResult);
		searchTerm = new StringArraySchoolSearchTerm(16);
		searchTerm.setValue("Cat:Dog:Bunny:Cow");
		expectedResult = 0.75;
		result = searchTerm.calculateMatch("Cat:Dog:Horse:Bunny");
		assertTrue("expected result: "+expectedResult+" actual result: "+result,result==expectedResult);
	}
	
	/**
	 * Test method for {@link cmc.controller.search.StringSchoolSearchTerm#calculateMatch(java.lang.String)}.
	 */
	@Test
	public void testCalculateMatchAlternateCaptialization() {
		searchTerm = new StringArraySchoolSearchTerm(16);
		searchTerm.setValue("Cat:Dog:Bunny:Cow");
		double expectedResult = 1.0;
		double result = searchTerm.calculateMatch("CaT:DoG:BuNnY:CoW");
		assertTrue("expected result: "+expectedResult+" actual result: "+result,result==expectedResult);
		searchTerm = new StringArraySchoolSearchTerm(16);
		searchTerm.setValue("Cat:Dog:Bunny:Cow");
		expectedResult = 0.5;
		result = searchTerm.calculateMatch("cAt:dOg");
		assertTrue("expected result: "+expectedResult+" actual result: "+result,result==expectedResult);
	}
	
	/**
	 * Test method for {@link cmc.controller.search.StringSchoolSearchTerm#calculateMatch(java.lang.String)}.
	 */
	@Test
	public void testCalculateMatchBadMatch() {
		searchTerm = new StringArraySchoolSearchTerm(16);
		searchTerm.setValue("Cat:Dog:Bunny:Cow");
		double expectedResult = 0.0;
		double result = searchTerm.calculateMatch("Horse:Eel:Echidna:Beaver");
		assertTrue("expected result: "+expectedResult+" actual result: "+result,result==expectedResult);
	}

}
