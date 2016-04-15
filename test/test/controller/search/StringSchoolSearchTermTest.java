/**
 * 
 */
package test.controller.search;

import static org.junit.Assert.*;

import org.junit.Test;

import cmc.controller.search.IntegerSchoolSearchTerm;
import cmc.controller.search.StringSchoolSearchTerm;

/**
 * @author Alex
 *
 */
public class StringSchoolSearchTermTest {

	StringSchoolSearchTerm searchTerm;
	
	/**
	 * Test method for {@link cmc.controller.search.StringSchoolSearchTerm#calculateMatch(java.lang.String)}.
	 */
	@Test (expected = IllegalStateException.class)
	public void testCalculateMatchFailIfUnset() {
		searchTerm = new StringSchoolSearchTerm(0,new String[]{"Cat","Dog","Bunny","-1"});
		searchTerm.calculateMatch("Cat");
	}
	
	/**
	 * Test method for {@link cmc.controller.search.StringSchoolSearchTerm#calculateMatch(java.lang.String)}.
	 */
	@Test
	public void testCalculateMatchPerfectMatch() {
		searchTerm = new StringSchoolSearchTerm(0,null);
		searchTerm.setValue("Cat");
		double expectedResult = 1.0;
		double result = searchTerm.calculateMatch("Cat");
		assertTrue("expected result: "+expectedResult+" actual result: "+result,result==expectedResult);
		searchTerm = new StringSchoolSearchTerm(0,new String[]{"Cat","Dog","Bunny","-1"});
		searchTerm.setValue("Cat");
		expectedResult = 1.0;
		result = searchTerm.calculateMatch("Cat");
		assertTrue("expected result: "+expectedResult+" actual result: "+result,result==expectedResult);
	}
	
	/**
	 * Test method for {@link cmc.controller.search.StringSchoolSearchTerm#calculateMatch(java.lang.String)}.
	 */
	@Test
	public void testCalculateMatchPartialMatch() {
		searchTerm = new StringSchoolSearchTerm(0,null);
		searchTerm.setValue("Cat");
		double expectedResult = 1.0;
		double result = searchTerm.calculateMatch("at");
		assertTrue("expected result: "+expectedResult+" actual result: "+result,result==expectedResult);
	}
	
	/**
	 * Test method for {@link cmc.controller.search.StringSchoolSearchTerm#calculateMatch(java.lang.String)}.
	 */
	@Test
	public void testCalculateMatchAlternateCaptialization() {
		searchTerm = new StringSchoolSearchTerm(0,new String[]{"Cat","Dog","Bunny","-1"});
		searchTerm.setValue("CAt");
		double expectedResult = 1.0;
		double result = searchTerm.calculateMatch("CaT");
		assertTrue("expected result: "+expectedResult+" actual result: "+result,result==expectedResult);
		searchTerm = new StringSchoolSearchTerm(0,null);
		searchTerm.setValue("CAt");
		expectedResult = 1.0;
		result = searchTerm.calculateMatch("CaT");
		assertTrue("expected result: "+expectedResult+" actual result: "+result,result==expectedResult);
	}
	
	/**
	 * Test method for {@link cmc.controller.search.StringSchoolSearchTerm#calculateMatch(java.lang.String)}.
	 */
	@Test
	public void testCalculateMatchBadMatch() {
		searchTerm = new StringSchoolSearchTerm(0,new String[]{"Cat","Dog","Bunny","-1"});
		searchTerm.setValue("Cat");
		double expectedResult = 0.0;
		double result = searchTerm.calculateMatch("Dog");
		assertTrue("expected result: "+expectedResult+" actual result: "+result,result==expectedResult);
		searchTerm = new StringSchoolSearchTerm(0,null);
		searchTerm.setValue("Cat");
		expectedResult = 0.0;
		result = searchTerm.calculateMatch("Horse");
		assertTrue("expected result: "+expectedResult+" actual result: "+result,result==expectedResult);
	}
	
	/**
	 * Test method for {@link cmc.controller.search.StringSchoolSearchTerm#calculateMatch(java.lang.String)}.
	 */
	@Test
	public void testCalculateMatchBadPermittedMatch() {
		searchTerm = new StringSchoolSearchTerm(0,new String[]{"Cat","Dog","Bunny","-1"});
		searchTerm.setValue("Cat");
		double expectedResult = 0.0;
		double result = searchTerm.calculateMatch("Dog");
		assertTrue("expected result: "+expectedResult+" actual result: "+result,result==expectedResult);
	}
	
	/**
	 * Test method for {@link cmc.controller.search.StringSchoolSearchTerm#setValue(java.lang.String)}.
	 */
	@Test
	public void testSetValueSuccess() {
		searchTerm = new StringSchoolSearchTerm(0,new String[]{"Cat","Dog","Bunny","-1"});
		searchTerm.setValue("Cat");
		assertTrue("Term is included (i.e., value has been set)",searchTerm.isIncluded());
	}

	/**
	 * Test method for {@link cmc.controller.search.StringSchoolSearchTerm#setValue(java.lang.String)}.
	 */
	@Test (expected = IllegalArgumentException.class)
	public void testSetValueFailForIllegalString() {
		searchTerm = new StringSchoolSearchTerm(0,new String[]{"Cat","Dog","Bunny","-1"});
		searchTerm.setValue("Horse");
	}

}
