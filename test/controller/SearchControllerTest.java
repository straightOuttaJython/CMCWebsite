/**
 * 
 */
package controller;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import cmc.controller.SearchController;
import cmc.controller.search.SchoolSearchClause;
import cmc.entity.School;
import cmc.entity.dbmapping.SchoolDatabaseMapping;

/**
 * @author Alex
 *
 */
public class SearchControllerTest {

	String[] searchCriteria = {"Test University",
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
	String searchEmphases = 	"Math:Science:Art:Music";
	
	String[][] testSchoolData = {{"Bad Match University"},
								{"New York"},
								{"URBAN", "SMALL-CITY", "-1"},
								{"PRIVATE", "CITY", "-1"},
								{"5000"},
								{"50", "60", "70", "80", "90", "100"},
								{"500", "400", "300", "200", "100"},
								{"500", "400", "300", "200", "100"},
								{"45000"},
								{"50", "60", "70", "80", "90", "100"},
								{"7000"},
								{"50", "60", "70", "80", "90", "100"},
								{"50", "40", "30", "20", "10", "0"},
								{"2", "1"},
								{"3", "2", "1"},
								{"3", "4", "5"},
								{"Rocket Class", "Cedar Mountain", "Alex School", "Mighty College", "Tall University"}};
	String[][] testEmphases = 	{{"Math","Science","Art","Music"},
								{"Math","Science","Art","Politics"},
								{"Math","Writing","Art","Politics"},
								{"Reading","Writing","Art","Politics"},
								{"Reading","Writing","Arithmetic","Politics"}};
	
	SearchController searchController;
	SchoolSearchClause searchClause;
	String[][] schoolData, emphasisData;
	School[] expectedResults, actualResults;
	
	/**
	 * Test method for {@link cmc.controller.SearchController#search(cmc.controller.search.SchoolSearchClause)}.
	 */
	@Test
	public void testSearchName() { /// Your issues from last night: the search controller is sending back badly formed emphasis data
		searchClause = new SchoolSearchClause();
		searchClause.setValueAtIndex(searchCriteria[0], 0);
		schoolData = generateSchoolDataForIndex(0);
		emphasisData = generateEmphasisData(schoolData);
		expectedResults = generateExpectedSchoolResults(schoolData);
		searchController = new SearchController(schoolData, emphasisData);
		actualResults = searchController.search(searchClause);
		for (int i = 0; i < actualResults.length; i++) {
			assertTrue("One term test, index "+i,expectedResults[i].equals(actualResults[i]));
		}
		searchClause = new SchoolSearchClause(searchCriteria,searchEmphases);
		actualResults = searchController.search(searchClause);
		for (int i = 0; i < actualResults.length; i++) {
			assertTrue("Many term test, index "+i,expectedResults[i].equals(actualResults[i]));
		}
	}

	private School[] generateExpectedSchoolResults(String[][] schoolData) {
		return generateExpectedSchoolResults(schoolData, false);
	}

	private School[] generateExpectedSchoolResults(String[][] schoolData, boolean specialCase) {
		if (!specialCase) {
			School[] expectedResults = new School[schoolData.length];
			for (int i = 0; i < expectedResults.length; i++) {
				expectedResults[i] = SchoolDatabaseMapping.convertDatabaseItemToSchool(schoolData[i], searchEmphases.split(":")); 
			}
			return expectedResults;
		}
		else {
			School[] expectedResults = new School[schoolData.length];
			for (int i = 0; i < expectedResults.length; i++) {
				expectedResults[i] = SchoolDatabaseMapping.convertDatabaseItemToSchool(schoolData[i], testEmphases[i]); 
			}
			return expectedResults;
		}
	}

	private String[][] generateEmphasisData(String[][] schoolData) {
		return generateEmphasisData(schoolData, false);
	}

	private String[][] generateEmphasisData(String[][] schoolData, boolean specialCase) {
		if (!specialCase) {
			ArrayList<String> uniqueNames = new ArrayList<String>();
			String[] searchEmphases = this.searchEmphases.split(":");
			for (String[] school : schoolData) {
				uniqueNames.add(school[0]);
			}
			String[][] emphasisData = new String[uniqueNames.size()*searchEmphases.length][2];
			int index = 0;
			for (String name : uniqueNames) {
				for (String emphasis : searchEmphases) {
					emphasisData[index++] = new String[]{name, emphasis};
				}
			}
			return emphasisData;
		}
		else {
			ArrayList<String> uniqueNames = new ArrayList<String>();
			for (String[] school : schoolData) {
				uniqueNames.add(school[0]);
			}
			String[][] emphasisData = new String[uniqueNames.size()*testEmphases[0].length][2];
			int index = 0;
			for (int i = 0; i < emphasisData.length; i++) {
				for (String emphasis : testEmphases[i]) {
					emphasisData[index++] = new String[]{uniqueNames.get(i), emphasis};
				}
			}
			return emphasisData;
		}
	}

	private String[][] generateSchoolDataForIndex(int i) {
		if (i!=16) {
			String[][] schoolData = new String[testSchoolData[i].length+1][16];
			schoolData[0] = searchCriteria;
			for (int j=1; j<schoolData.length; j++) {
				schoolData[j] = searchCriteria;
				schoolData[j][i] = testSchoolData[i][j-1];
			}
			return schoolData;
		}
		else {
			String[][] schoolData = new String[testSchoolData[i].length+1][16];
			for (int j=0; j<schoolData.length; j++) {
				schoolData[j] = searchCriteria;
				schoolData[j][0] = testSchoolData[i][j-1];
			}
			return schoolData;
		}
	}

}
