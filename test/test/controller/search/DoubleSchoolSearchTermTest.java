/**
 * 
 */
package test.controller.search;

import static org.junit.Assert.*;

import org.junit.Test;

import cmc.controller.search.DoubleSchoolSearchTerm;

/**
 * @author Alex
 *
 */
public class DoubleSchoolSearchTermTest {
	
	DoubleSchoolSearchTerm searchTerm;

	/**
	 * Test method for {@link cmc.controller.search.DoubleSchoolSearchTerm#calculateMatch(java.lang.String)}.
	 */
	@Test (expected = IllegalStateException.class)
	public void testCalculateMatchFailIfUnset() {
		searchTerm = new DoubleSchoolSearchTerm(5,0,Double.MAX_VALUE);
		searchTerm.calculateMatch("20");
	}
	
	/**
	 * Test method for {@link cmc.controller.search.DoubleSchoolSearchTerm#calculateMatch(java.lang.String)}.
	 */
	@Test (expected = NumberFormatException.class)
	public void testCalculateMatchFailIfNotDouble() {
		searchTerm = new DoubleSchoolSearchTerm(5,0,Double.MAX_VALUE);
		searchTerm.setValue("10:30");
		searchTerm.calculateMatch("G");
	}
	
	/**
	 * Test method for {@link cmc.controller.search.DoubleSchoolSearchTerm#calculateMatch(java.lang.String)}.
	 */
	@Test
	public void testCalculateMatchInRange() {
		searchTerm = new DoubleSchoolSearchTerm(5,0,Double.MAX_VALUE);
		searchTerm.setValue("10:30");
		double expectedResult = 1.0;
		double result = searchTerm.calculateMatch("20");
		assertTrue("expected result: "+expectedResult+" actual result: "+result,result==expectedResult);
		expectedResult = 1.0;
		result = searchTerm.calculateMatch("10");
		assertTrue("expected result: "+expectedResult+" actual result: "+result,result==expectedResult);
		expectedResult = 1.0;
		result = searchTerm.calculateMatch("30");
		assertTrue("expected result: "+expectedResult+" actual result: "+result,result==expectedResult);
	}
	
	/**
	 * Test method for {@link cmc.controller.search.DoubleSchoolSearchTerm#calculateMatch(java.lang.String)}.
	 */
	@Test
	public void testCalculateMatchSingleNumber() {
		searchTerm = new DoubleSchoolSearchTerm(5,0,Double.MAX_VALUE);
		searchTerm.setValue("20");
		double expectedResult = 1.0;
		double result = searchTerm.calculateMatch("20");
		assertTrue("expected result: "+expectedResult+" actual result: "+result,result==expectedResult);
	}
	
	/**
	 * Test method for {@link cmc.controller.search.DoubleSchoolSearchTerm#calculateMatch(java.lang.String)}.
	 */
	@Test
	public void testCalculateMatchOutOfRangeAboveNoGradient() {
		searchTerm = new DoubleSchoolSearchTerm(5,0,Double.MAX_VALUE);
		searchTerm.setValue("10:30");
		double expectedResult = 0.0;
		double result = searchTerm.calculateMatch("40");
		assertTrue("expected result: "+expectedResult+" actual result: "+result,result==expectedResult);
	}
	
	/**
	 * Test method for {@link cmc.controller.search.DoubleSchoolSearchTerm#calculateMatch(java.lang.String)}.
	 */
	@Test
	public void testCalculateMatchOutOfRangeBelowNoGradient() {
		searchTerm = new DoubleSchoolSearchTerm(5,0,Double.MAX_VALUE);
		searchTerm.setValue("10:30");
		double expectedResult = 0.0;
		double result = searchTerm.calculateMatch("5");
		assertTrue("expected result: "+expectedResult+" actual result: "+result,result==expectedResult);
	}
	
	/**
	 * Test method for {@link cmc.controller.search.DoubleSchoolSearchTerm#calculateMatch(java.lang.String)}.
	 */
	@Test
	public void testCalculateMatchOutOfRangeAboveWithLowRangeGradient() {
		searchTerm = new DoubleSchoolSearchTerm(5,0,100);
		searchTerm.setValue("20:40");
		double expectedResult = 0.6;
		double result = searchTerm.calculateMatch("64");
		assertTrue("expected result: "+expectedResult+" actual result: "+result,result==expectedResult);
	}
	
	/**
	 * Test method for {@link cmc.controller.search.DoubleSchoolSearchTerm#calculateMatch(java.lang.String)}.
	 */
	@Test
	public void testCalculateMatchOutOfRangeBelowWithLowRangeGradient() {
		searchTerm = new DoubleSchoolSearchTerm(5,0,100);
		searchTerm.setValue("20:40");
		double expectedResult = 0.8;
		double result = searchTerm.calculateMatch("8");
		assertTrue("expected result: "+expectedResult+" actual result: "+result,result==expectedResult);
	}
	
	/**
	 * Test method for {@link cmc.controller.search.DoubleSchoolSearchTerm#calculateMatch(java.lang.String)}.
	 */
	@Test
	public void testCalculateMatchOutOfRangeAboveWithHighRangeGradient() {
		searchTerm = new DoubleSchoolSearchTerm(5,0,100);
		searchTerm.setValue("60:80");
		double expectedResult = 0.8;
		double result = searchTerm.calculateMatch("92");
		assertTrue("expected result: "+expectedResult+" actual result: "+result,result==expectedResult);
	}
	
	/**
	 * Test method for {@link cmc.controller.search.DoubleSchoolSearchTerm#calculateMatch(java.lang.String)}.
	 */
	@Test
	public void testCalculateMatchOutOfRangeBelowWithHighRangeGradient() {
		searchTerm = new DoubleSchoolSearchTerm(5,0,100);
		searchTerm.setValue("60:80");
		double expectedResult = 0.4;
		double result = searchTerm.calculateMatch("24");
		assertTrue("expected result: "+expectedResult+" actual result: "+result,result==expectedResult);
	}

	/**
	 * Test method for {@link cmc.controller.search.DoubleSchoolSearchTerm#setValue(java.lang.String)}.
	 */
	@Test (expected = NumberFormatException.class)
	public void testSetValueFailForSingleInvalidDouble() {
		searchTerm = new DoubleSchoolSearchTerm(5,0,Double.MAX_VALUE);
		searchTerm.setValue("G");
	}
	
	/**
	 * Test method for {@link cmc.controller.search.DoubleSchoolSearchTerm#setValue(java.lang.String)}.
	 */
	@Test (expected = NumberFormatException.class)
	public void testSetValueFailForColon() {
		searchTerm = new DoubleSchoolSearchTerm(5,0,Double.MAX_VALUE);
		searchTerm.setValue(":");
	}
	
	/**
	 * Test method for {@link cmc.controller.search.DoubleSchoolSearchTerm#setValue(java.lang.String)}.
	 */
	@Test (expected = NumberFormatException.class)
	public void testSetValueFailForTwoInvalidDoubles() {
		searchTerm = new DoubleSchoolSearchTerm(5,0,Double.MAX_VALUE);
		searchTerm.setValue("G:H");
	}
	
	/**
	 * Test method for {@link cmc.controller.search.DoubleSchoolSearchTerm#setValue(java.lang.String)}.
	 */
	@Test (expected = IllegalArgumentException.class)
	public void testSetValueFailForBackwardsRange() {
		searchTerm = new DoubleSchoolSearchTerm(5,0,Double.MAX_VALUE);
		searchTerm.setValue("40:20");
	}
	
	/**
	 * Test method for {@link cmc.controller.search.DoubleSchoolSearchTerm#setValue(java.lang.String)}.
	 */
	@Test (expected = IllegalArgumentException.class)
	public void testSetValueFailForOutOfRangeLower() {
		searchTerm = new DoubleSchoolSearchTerm(5,20,50);
		searchTerm.setValue("10:30");
	}
	
	/**
	 * Test method for {@link cmc.controller.search.DoubleSchoolSearchTerm#setValue(java.lang.String)}.
	 */
	@Test (expected = IllegalArgumentException.class)
	public void testSetValueFailForOutOfRangeUpper() {
		searchTerm = new DoubleSchoolSearchTerm(5,20,50);
		searchTerm.setValue("30:60");
	}
	
	/**
	 * Test method for {@link cmc.controller.search.DoubleSchoolSearchTerm#setValue(java.lang.String)}.
	 */
	@Test
	public void testSetValueSuccess() {
		searchTerm = new DoubleSchoolSearchTerm(5,20,50);
		searchTerm.setValue("20:30");
		assertTrue("Term is included (i.e., value has been set)",searchTerm.isIncluded());
		searchTerm = new DoubleSchoolSearchTerm(5,20,50);
		searchTerm.setValue("20:50");
		assertTrue("Term is included (i.e., value has been set)",searchTerm.isIncluded());
		searchTerm = new DoubleSchoolSearchTerm(5,20,50);
		searchTerm.setValue("30:50");
		assertTrue("Term is included (i.e., value has been set)",searchTerm.isIncluded());
		searchTerm = new DoubleSchoolSearchTerm(5,20,50);
		searchTerm.setValue("20");
		assertTrue("Term is included (i.e., value has been set)",searchTerm.isIncluded());
	}

	/**
	 * Test method for {@link cmc.controller.search.DoubleSchoolSearchTerm#DoubleSchoolSearchTerm(Double, Double, Double)}.
	 */
	@Test (expected = IllegalArgumentException.class)
	public void testConstructorFailForBackwardsRange() {
		searchTerm = new DoubleSchoolSearchTerm(5,40,20);
	}

}
