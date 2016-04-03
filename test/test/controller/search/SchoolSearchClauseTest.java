/**
 * 
 */
package test.controller.search;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import cmc.controller.search.SchoolSearchClause;

/**
 * @author Alex
 * @version March 27, 2016
 */
public class SchoolSearchClauseTest {

	String[] searchCriteria = {	"Test University",
								"Georgia",
								"SUBURBAN",
								"STATE",
								"10000",
								"45",
								"600",
								"550",
								"29000",
								"34",
								"6000",
								"40",
								"90",
								"3",
								"4",
								"2"};
	String searchEmphases = 	"Math:Science:Art";
	
	String[] badMatch = {	"Bad Match University",
							"New York",
							"URBAN",
							"PRIVATE",
							"5000",
							"100",
							"0",
							"0",
							"45000",
							"100",
							"7000",
							"100",
							"0",
							"1",
							"1",
							"5"};
	String badEmphases =	"Reading:Writing:Arithmetic";
	
	SchoolSearchClause searchClause;

	/**
	 * Test method for {@link cmc.controller.search.SchoolSearchClause#scoreSchoolData(java.lang.String[], java.lang.String)}.
	 */
	@Test
	public void testScoreSchoolDataPerfectMatch() {
		searchClause = new SchoolSearchClause(searchCriteria,searchEmphases);
		double expectedScore = 1.0;
		double score = searchClause.scoreSchoolData(searchCriteria, searchEmphases);
		assertTrue("expected score: "+expectedScore+" actual score: "+score,score==expectedScore);
	}
	
	/**
	 * Test method for {@link cmc.controller.search.SchoolSearchClause#scoreSchoolData(java.lang.String[], java.lang.String)}.
	 */
	@Test
	public void testScoreSchoolDataBadMatch() {
		searchClause = new SchoolSearchClause(searchCriteria,searchEmphases);
		double expectedScore = 0.0;
		double score = searchClause.scoreSchoolData(badMatch, badEmphases);
		assertTrue("expected score: "+expectedScore+" actual score: "+score,score==expectedScore);
	}
	
	/**
	 * Test method for {@link cmc.controller.search.SchoolSearchClause#scoreSchoolData(java.lang.String[], java.lang.String)}.
	 */
	@Test
	public void testScoreSchoolDataStringMatch() {
		searchClause = new SchoolSearchClause();
		searchClause.setValueAtIndex(searchCriteria[0], 0);
		double expectedScore = 1.0;
		double score = searchClause.scoreSchoolData(searchCriteria, searchEmphases);
		assertTrue("expected score: "+expectedScore+" actual score: "+score,score==expectedScore);
	}
	
	/**
	 * Test method for {@link cmc.controller.search.SchoolSearchClause#scoreSchoolData(java.lang.String[], java.lang.String)}.
	 */
	@Test
	public void testScoreSchoolDataIntegerMatch() {
		searchClause = new SchoolSearchClause();
		searchClause.setValueAtIndex(searchCriteria[4], 4);
		double expectedScore = 1.0;
		double score = searchClause.scoreSchoolData(searchCriteria, searchEmphases);
		assertTrue("expected score: "+expectedScore+" actual score: "+score,score==expectedScore);
	}
	
	/**
	 * Test method for {@link cmc.controller.search.SchoolSearchClause#scoreSchoolData(java.lang.String[], java.lang.String)}.
	 */
	@Test
	public void testScoreSchoolDataDoubleMatch() {
		searchClause = new SchoolSearchClause();
		searchClause.setValueAtIndex(searchCriteria[5], 5);
		double expectedScore = 1.0;
		double score = searchClause.scoreSchoolData(searchCriteria, searchEmphases);
		assertTrue("expected score: "+expectedScore+" actual score: "+score,score==expectedScore);
	}
	
	/**
	 * Test method for {@link cmc.controller.search.SchoolSearchClause#scoreSchoolData(java.lang.String[], java.lang.String)}.
	 */
	@Test
	public void testScoreSchoolDataStringArrayMatch() {
		searchClause = new SchoolSearchClause();
		searchClause.setValueAtIndex(this.searchEmphases, 16);
		double expectedScore = 1.0;
		double score = searchClause.scoreSchoolData(searchCriteria, searchEmphases);
		assertTrue("expected score: "+expectedScore+" actual score: "+score,score==expectedScore);
	}
	
	/**
	 * Test method for {@link cmc.controller.search.SchoolSearchClause#scoreSchoolData(java.lang.String[], java.lang.String)}.
	 */
	@Test
	public void testScoreSchoolDataHalfMatch() {
		searchClause = new SchoolSearchClause();
		searchClause.setValueAtIndex(searchCriteria[0], 0);
		searchClause.setValueAtIndex(badMatch[1], 1);
		double expectedScore = 0.5;
		double score = searchClause.scoreSchoolData(searchCriteria, searchEmphases);
		assertTrue("expected score: "+expectedScore+" actual score: "+score,score==expectedScore);
	}

}
