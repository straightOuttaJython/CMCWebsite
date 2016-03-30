/**
 * 
 */
package test.controller;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

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
								{ "-1", "SMALL-CITY", "URBAN"},
								{"-1", "CITY", "PRIVATE"},
								{"5000"},
								{"70", "100"},
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
	 * Test method for {@link test.controller.SearchControllerTest#generateSchoolDataForIndex(int)}.
	 */
	@Test
	public void testGenerateSchoolDataForIndex() {
		String[][] expectedResults = {{"Test University","Georgia","SUBURBAN","STATE","10000","45","600","550",
										"29000","34","6000","40","90","3","4","2"},
									{"Test University","Georgia","SUBURBAN","STATE","5000","45","600","550",
										"29000","34","6000","40","90","3","4","2"}};
		String[][] actualResults = this.generateSchoolDataForIndex(4);
		assertTrue("expectedResults length:"+expectedResults.length+" actualResults length:"+actualResults.length,expectedResults.length==actualResults.length);
		for (int i=0; i<expectedResults.length; i++) {
			for (int j=0; j<expectedResults[i].length; j++) {
				String expectedResult = expectedResults[i][j];
				String result = actualResults[i][j];
				assertTrue("expected result: "+expectedResult+" actual result: "+result,result.equals(expectedResult));
			}
		}
	}
	
	/**
	 * Test method for {@link test.controller.SearchControllerTest#generateSchoolDataForIndex(int)}.
	 */
	@Test
	public void testGenerateSchoolDataForIndexSpecialCase() {
		String[][] expectedResults = {{"Rocket Class","Georgia","SUBURBAN","STATE","10000","45","600","550",
										"29000","34","6000","40","90","3","4","2"},
									{"Cedar Mountain","Georgia","SUBURBAN","STATE","10000","45","600","550",
										"29000","34","6000","40","90","3","4","2"},
									{"Alex School","Georgia","SUBURBAN","STATE","10000","45","600","550",
										"29000","34","6000","40","90","3","4","2"},
									{"Mighty College","Georgia","SUBURBAN","STATE","10000","45","600","550",
										"29000","34","6000","40","90","3","4","2"},
									{"Tall University","Georgia","SUBURBAN","STATE","10000","45","600","550",
										"29000","34","6000","40","90","3","4","2"}};
		String[][] actualResults = this.generateSchoolDataForIndex(16);
		assertTrue("expectedResults length:"+expectedResults.length+" actualResults length:"+actualResults.length,expectedResults.length==actualResults.length);
		for (int i=0; i<expectedResults.length; i++) {
			for (int j=0; j<expectedResults[i].length; j++) {
				String expectedResult = expectedResults[i][j];
				String result = actualResults[i][j];
				assertTrue("expected result: "+expectedResult+" actual result: "+result,result.equals(expectedResult));
			}
		}
	}
	
	/**
	 * Test method for {@link test.controller.SearchControllerTest#generateSchoolDataForIndex(int)}.
	 */
	@Test
	public void testGenerateEmphasisData() {
		String[][] expectedResults = {{"Test University", "Math"},
										{"Test University", "Science"},
										{"Test University", "Art"},
										{"Test University", "Music"},
										{"Bad Match University", "Math"},
										{"Bad Match University", "Science"},
										{"Bad Match University", "Art"},
										{"Bad Match University", "Music"}};
		String[][] schoolData = this.generateSchoolDataForIndex(0);
		String[][] actualResults = this.generateEmphasisData(schoolData);
		assertTrue("expectedResults length:"+expectedResults.length+" actualResults length:"+actualResults.length,expectedResults.length==actualResults.length);
		for (int i=0; i<expectedResults.length; i++) {
			for (int j=0; j<expectedResults[i].length; j++) {
				String expectedResult = expectedResults[i][j];
				String result = actualResults[i][j];
				assertTrue("expected result: "+expectedResult+" actual result: "+result,result.equals(expectedResult));
			}
		}
	}
	
	/**
	 * Test method for {@link test.controller.SearchControllerTest#generateSchoolDataForIndex(int)}.
	 */
	@Test
	public void testGenerateEmphasisDataSpecialCase() {
		String[][] expectedResults = {{"Rocket Class", "Math"},
										{"Rocket Class", "Science"},
										{"Rocket Class", "Art"},
										{"Rocket Class", "Music"},
										{"Cedar Mountain", "Math"},
										{"Cedar Mountain", "Science"},
										{"Cedar Mountain", "Art"},
										{"Cedar Mountain", "Politics"},
										{"Alex School", "Math"},
										{"Alex School", "Writing"},
										{"Alex School", "Art"},
										{"Alex School", "Politics"},
										{"Mighty College", "Reading"},
										{"Mighty College", "Writing"},
										{"Mighty College", "Art"},
										{"Mighty College", "Politics"},
										{"Tall University", "Reading"},
										{"Tall University", "Writing"},
										{"Tall University", "Arithmetic"},
										{"Tall University", "Politics"}};
		String[][] schoolData = this.generateSchoolDataForIndex(16);
		String[][] actualResults = this.generateEmphasisData(schoolData, true);
		assertTrue("expectedResults length:"+expectedResults.length+" actualResults length:"+actualResults.length,expectedResults.length==actualResults.length);
		for (int i=0; i<expectedResults.length; i++) {
			for (int j=0; j<expectedResults[i].length; j++) {
				String expectedResult = expectedResults[i][j];
				String result = actualResults[i][j];
				assertTrue("expected result: "+expectedResult+" actual result: "+result,result.equals(expectedResult));
			}
		}
	}
	
	/**
	 * Test method for {@link test.controller.SearchControllerTest#generateSchoolDataForIndex(int)}.
	 */
	@Test
	public void testGenerateEmphasisDataOneSchool() {
		String[][] expectedResults = {{"Test University", "Math"},
										{"Test University", "Science"},
										{"Test University", "Art"},
										{"Test University", "Music"}};
		String[][] schoolData = this.generateSchoolDataForIndex(5);
		String[][] actualResults = this.generateEmphasisData(schoolData);
		assertTrue("expectedResults length:"+expectedResults.length+" actualResults length:"+actualResults.length,expectedResults.length==actualResults.length);
		for (int i=0; i<expectedResults.length; i++) {
			for (int j=0; j<expectedResults[i].length; j++) {
				String expectedResult = expectedResults[i][j];
				String result = actualResults[i][j];
				assertTrue("expected result: "+expectedResult+" actual result: "+result,result.equals(expectedResult));
			}
		}
	}
	
	/**
	 * Test method for {@link test.controller.SearchControllerTest#generateSchoolDataForIndex(int)}.
	 */
	@Test
	public void testGenerateExpectedSchoolResults() {
		expectedResults = new School[]{SchoolDatabaseMapping.convertDatabaseItemToSchool(
										new String[]{"Test University","Georgia","SUBURBAN","STATE","10000","45","600","550",
													"29000","34","6000","40","90","3","4","2"}, searchEmphases.split(":")),
									SchoolDatabaseMapping.convertDatabaseItemToSchool(
										new String[]{"Test University","Georgia","SUBURBAN","STATE","10000","45","600","550",
													"29000","34","6000","40","90","2","4","2"}, searchEmphases.split(":")),
									SchoolDatabaseMapping.convertDatabaseItemToSchool(
										new String[]{"Test University","Georgia","SUBURBAN","STATE","10000","45","600","550",
													"29000","34","6000","40","90","1","4","2"}, searchEmphases.split(":"))};
		String[][] schoolData = this.generateSchoolDataForIndex(13);
		actualResults = this.generateExpectedSchoolResults(schoolData);
		assertTrue("expectedResults length:"+expectedResults.length+" actualResults length:"+actualResults.length,expectedResults.length==actualResults.length);
		for (int i=0; i<expectedResults.length; i++) {
			School expectedResult = expectedResults[i];
			School result = actualResults[i];
			assertTrue("expected result: "+expectedResult+" actual result: "+result,result.equals(expectedResult));
		}
	}
	
	/**
	 * Test method for {@link test.controller.SearchControllerTest#generateSchoolDataForIndex(int)}.
	 */
	@Test
	public void testGenerateExpectedSchoolResultsSpecialCase() {
		expectedResults = new School[]{SchoolDatabaseMapping.convertDatabaseItemToSchool(
										new String[]{"Rocket Class","Georgia","SUBURBAN","STATE","10000","45","600","550",
												"29000","34","6000","40","90","3","4","2"}, testEmphases[0]),
									SchoolDatabaseMapping.convertDatabaseItemToSchool(
										new String[]{"Cedar Mountain","Georgia","SUBURBAN","STATE","10000","45","600","550",
												"29000","34","6000","40","90","3","4","2"}, testEmphases[1]),
									SchoolDatabaseMapping.convertDatabaseItemToSchool(
										new String[]{"Alex School","Georgia","SUBURBAN","STATE","10000","45","600","550",
												"29000","34","6000","40","90","3","4","2"}, testEmphases[2]),
									SchoolDatabaseMapping.convertDatabaseItemToSchool(
										new String[]{"Mighty College","Georgia","SUBURBAN","STATE","10000","45","600","550",
												"29000","34","6000","40","90","3","4","2"}, testEmphases[3]),
									SchoolDatabaseMapping.convertDatabaseItemToSchool(
										new String[]{"Tall University","Georgia","SUBURBAN","STATE","10000","45","600","550",
												"29000","34","6000","40","90","3","4","2"}, testEmphases[4])};
		String[][] schoolData = this.generateSchoolDataForIndex(16);
		actualResults = this.generateExpectedSchoolResults(schoolData, true);
		assertTrue("expectedResults length:"+expectedResults.length+" actualResults length:"+actualResults.length,expectedResults.length==actualResults.length);
		for (int i=0; i<expectedResults.length; i++) {
			School expectedResult = expectedResults[i];
			School result = actualResults[i];
			assertTrue("expected result: "+expectedResult+" actual result: "+result,result.equals(expectedResult));
		}
	}
	
	/**
	 * Test method for {@link cmc.controller.SearchController#search(cmc.controller.search.SchoolSearchClause)}.
	 */
	@Test
	public void testSearchOnSingleAttributes() {
		for (int attribute=0; attribute<16; attribute++) {
			searchClause = new SchoolSearchClause();
			searchClause.setValueAtIndex(searchCriteria[attribute], attribute);
			schoolData = generateSchoolDataForIndex(attribute);
			emphasisData = generateEmphasisData(schoolData);
			expectedResults = generateExpectedSchoolResults(schoolData);
			searchController = new SearchController(schoolData, emphasisData);
			actualResults = searchController.search(searchClause);
			assertTrue("expectedResults length:"+expectedResults.length+" actualResults length:"+actualResults.length,expectedResults.length==actualResults.length);
			if (attribute==2 || attribute==3) {
				ArrayList<School> actualSchoolList = new ArrayList<School>(Arrays.asList(actualResults));
				assertTrue("first item should still be the same. attribute: "+attribute,expectedResults[0].equals(actualResults[0]));
				for (School expectedSchool : expectedResults) {
					assertTrue("actualSchoolList should contain this school. attribute: "+attribute,actualSchoolList.remove(expectedSchool));
				}
			}
			else {
				for (int i = 0; i < actualResults.length; i++) {
					assertTrue("One term test for attribute "+attribute+", index "+i,expectedResults[i].equals(actualResults[i]));
				}
			}
			searchClause = new SchoolSearchClause(searchCriteria,searchEmphases);
			actualResults = searchController.search(searchClause);
			assertTrue("expectedResults length:"+expectedResults.length+" actualResults length:"+actualResults.length,expectedResults.length==actualResults.length);
			if (attribute==2 || attribute==3) {
				ArrayList<School> actualSchoolList = new ArrayList<School>(Arrays.asList(actualResults));
				assertTrue("first item should still be the same. attribute: "+attribute,expectedResults[0].equals(actualResults[0]));
				for (School expectedSchool : expectedResults) {
					assertTrue("actualSchoolList should contain this school. attribute: "+attribute,actualSchoolList.remove(expectedSchool));
				}
			}
			else {
				for (int i = 0; i < actualResults.length; i++) {
					assertTrue("One term test for attribute "+attribute+", index "+i,expectedResults[i].equals(actualResults[i]));
				}
			}
		}
	}
	
	/**
	 * Test method for {@link cmc.controller.SearchController#search(cmc.controller.search.SchoolSearchClause)}.
	 */
	@Test
	public void testSearchOnEmphases() {
		searchClause = new SchoolSearchClause();
		searchClause.setValueAtIndex(searchEmphases, 16);
		schoolData = generateSchoolDataForIndex(16);
		emphasisData = generateEmphasisData(schoolData, true);
		expectedResults = generateExpectedSchoolResults(schoolData, true);
		searchController = new SearchController(schoolData, emphasisData);
		actualResults = searchController.search(searchClause);
		assertTrue("expectedResults length:"+expectedResults.length+" actualResults length:"+actualResults.length,expectedResults.length==actualResults.length);
		for (int i = 0; i < actualResults.length; i++) {
			assertTrue("One term test for attribute "+16+", index "+i,expectedResults[i].equals(actualResults[i]));
		}
		searchClause = new SchoolSearchClause(searchCriteria,searchEmphases);
		actualResults = searchController.search(searchClause);
		assertTrue("expectedResults length:"+expectedResults.length+" actualResults length:"+actualResults.length,expectedResults.length==actualResults.length);
		for (int i = 0; i < actualResults.length; i++) {
			assertTrue("Many term test for attribute "+16+", index "+i,expectedResults[i].equals(actualResults[i]));
		}
	}
	
	/**
	 * Test method for {@link cmc.controller.SearchController#search(cmc.controller.search.SchoolSearchClause)}.
	 */
	@Test
	public void testSearchOnMultipleAttributes() {
		searchClause = new SchoolSearchClause();
		searchClause.setValueAtIndex(searchCriteria[0], 0);
		searchClause.setValueAtIndex(searchCriteria[5], 5);
		searchClause.setValueAtIndex(searchCriteria[13], 13);
		schoolData = new String[][]{{"Test University", "Georgia", "SUBURBAN", "STATE", "10000", "45", "600", "550", "29000", "34", "6000", "40", "90", "3", "4", "2"},
									{"Test University", "Georgia", "SUBURBAN", "STATE", "10000", "67", "600", "550", "29000", "34", "6000", "40", "90", "3", "4", "2"},
									{"Test University", "Georgia", "SUBURBAN", "STATE", "10000", "100", "600", "550", "29000", "34", "6000", "40", "90", "3", "4", "2"},
									{"Test University", "Georgia", "SUBURBAN", "STATE", "10000", "45", "600", "550", "29000", "34", "6000", "40", "90", "2", "4", "2"},
									{"Test University", "Georgia", "SUBURBAN", "STATE", "10000", "67", "600", "550", "29000", "34", "6000", "40", "90", "2", "4", "2"},
									{"Test University", "Georgia", "SUBURBAN", "STATE", "10000", "100", "600", "550", "29000", "34", "6000", "40", "90", "2", "4", "2"},
									{"Test University", "Georgia", "SUBURBAN", "STATE", "10000", "45", "600", "550", "29000", "34", "6000", "40", "90", "1", "4", "2"},
									{"Test University", "Georgia", "SUBURBAN", "STATE", "10000", "67", "600", "550", "29000", "34", "6000", "40", "90", "1", "4", "2"},
									{"Test University", "Georgia", "SUBURBAN", "STATE", "10000", "100", "600", "550", "29000", "34", "6000", "40", "90", "1", "4", "2"},
									{"Bad Match University", "Georgia", "SUBURBAN", "STATE", "10000", "45", "600", "550", "29000", "34", "6000", "40", "90", "3", "4", "2"},
									{"Bad Match University", "Georgia", "SUBURBAN", "STATE", "10000", "67", "600", "550", "29000", "34", "6000", "40", "90", "3", "4", "2"},
									{"Bad Match University", "Georgia", "SUBURBAN", "STATE", "10000", "100", "600", "550", "29000", "34", "6000", "40", "90", "3", "4", "2"},
									{"Bad Match University", "Georgia", "SUBURBAN", "STATE", "10000", "45", "600", "550", "29000", "34", "6000", "40", "90", "2", "4", "2"},
									{"Bad Match University", "Georgia", "SUBURBAN", "STATE", "10000", "67", "600", "550", "29000", "34", "6000", "40", "90", "2", "4", "2"},
									{"Bad Match University", "Georgia", "SUBURBAN", "STATE", "10000", "100", "600", "550", "29000", "34", "6000", "40", "90", "2", "4", "2"},
									{"Bad Match University", "Georgia", "SUBURBAN", "STATE", "10000", "45", "600", "550", "29000", "34", "6000", "40", "90", "1", "4", "2"},
									{"Bad Match University", "Georgia", "SUBURBAN", "STATE", "10000", "67", "600", "550", "29000", "34", "6000", "40", "90", "1", "4", "2"},
									{"Bad Match University", "Georgia", "SUBURBAN", "STATE", "10000", "100", "600", "550", "29000", "34", "6000", "40", "90", "1", "4", "2"}};
		emphasisData = generateEmphasisData(schoolData);
		expectedResults = new School[]{SchoolDatabaseMapping.convertDatabaseItemToSchool(new String[]{"Test University", "Georgia", "SUBURBAN", "STATE", "10000", "45", "600",
											"550", "29000", "34", "6000", "40", "90", "3", "4", "2"}, searchEmphases.split(":")),
										SchoolDatabaseMapping.convertDatabaseItemToSchool(new String[]{"Test University", "Georgia", "SUBURBAN", "STATE", "10000", "67", "600",
											"550", "29000", "34", "6000", "40", "90", "3", "4", "2"}, searchEmphases.split(":")),
										SchoolDatabaseMapping.convertDatabaseItemToSchool(new String[]{"Test University", "Georgia", "SUBURBAN", "STATE", "10000", "45", "600",
											"550", "29000", "34", "6000", "40", "90", "2", "4", "2"}, searchEmphases.split(":")),
										SchoolDatabaseMapping.convertDatabaseItemToSchool(new String[]{"Test University", "Georgia", "SUBURBAN", "STATE", "10000", "67", "600",
											"550", "29000", "34", "6000", "40", "90", "2", "4", "2"}, searchEmphases.split(":")),
										SchoolDatabaseMapping.convertDatabaseItemToSchool(new String[]{"Test University", "Georgia", "SUBURBAN", "STATE", "10000", "100", "600",
											"550", "29000", "34", "6000", "40", "90", "3", "4", "2"}, searchEmphases.split(":")),
										SchoolDatabaseMapping.convertDatabaseItemToSchool(new String[]{"Test University", "Georgia", "SUBURBAN", "STATE", "10000", "45", "600",
											"550", "29000", "34", "6000", "40", "90", "1", "4", "2"}, searchEmphases.split(":")),
										SchoolDatabaseMapping.convertDatabaseItemToSchool(new String[]{"Bad Match University", "Georgia", "SUBURBAN", "STATE", "10000", "45", "600",
											"550", "29000", "34", "6000", "40", "90", "3", "4", "2"}, searchEmphases.split(":")),
										SchoolDatabaseMapping.convertDatabaseItemToSchool(new String[]{"Test University", "Georgia", "SUBURBAN", "STATE", "10000", "67", "600",
											"550", "29000", "34", "6000", "40", "90", "1", "4", "2"}, searchEmphases.split(":")),
										SchoolDatabaseMapping.convertDatabaseItemToSchool(new String[]{"Bad Match University", "Georgia", "SUBURBAN", "STATE", "10000", "67", "600",
											"550", "29000", "34", "6000", "40", "90", "3", "4", "2"}, searchEmphases.split(":")),
										SchoolDatabaseMapping.convertDatabaseItemToSchool(new String[]{"Test University", "Georgia", "SUBURBAN", "STATE", "10000", "100", "600",
											"550", "29000", "34", "6000", "40", "90", "2", "4", "2"}, searchEmphases.split(":")),
										SchoolDatabaseMapping.convertDatabaseItemToSchool(new String[]{"Bad Match University", "Georgia", "SUBURBAN", "STATE", "10000", "45", "600",
											"550", "29000", "34", "6000", "40", "90", "2", "4", "2"}, searchEmphases.split(":")),
										SchoolDatabaseMapping.convertDatabaseItemToSchool(new String[]{"Bad Match University", "Georgia", "SUBURBAN", "STATE", "10000", "67", "600",
											"550", "29000", "34", "6000", "40", "90", "2", "4", "2"}, searchEmphases.split(":")),
										SchoolDatabaseMapping.convertDatabaseItemToSchool(new String[]{"Test University", "Georgia", "SUBURBAN", "STATE", "10000", "100", "600",
											"550", "29000", "34", "6000", "40", "90", "1", "4", "2"}, searchEmphases.split(":")),
										SchoolDatabaseMapping.convertDatabaseItemToSchool(new String[]{"Bad Match University", "Georgia", "SUBURBAN", "STATE", "10000", "100", "600",
											"550", "29000", "34", "6000", "40", "90", "3", "4", "2"}, searchEmphases.split(":")),
										SchoolDatabaseMapping.convertDatabaseItemToSchool(new String[]{"Bad Match University", "Georgia", "SUBURBAN", "STATE", "10000", "45", "600",
											"550", "29000", "34", "6000", "40", "90", "1", "4", "2"}, searchEmphases.split(":")),
										SchoolDatabaseMapping.convertDatabaseItemToSchool(new String[]{"Bad Match University", "Georgia", "SUBURBAN", "STATE", "10000", "67", "600",
											"550", "29000", "34", "6000", "40", "90", "1", "4", "2"}, searchEmphases.split(":")),
										SchoolDatabaseMapping.convertDatabaseItemToSchool(new String[]{"Bad Match University", "Georgia", "SUBURBAN", "STATE", "10000", "100", "600",
											"550", "29000", "34", "6000", "40", "90", "2", "4", "2"}, searchEmphases.split(":")),
										SchoolDatabaseMapping.convertDatabaseItemToSchool(new String[]{"Bad Match University", "Georgia", "SUBURBAN", "STATE", "10000", "100", "600",
											"550", "29000", "34", "6000", "40", "90", "1", "4", "2"}, searchEmphases.split(":"))};
		searchController = new SearchController(schoolData, emphasisData);
		actualResults = searchController.search(searchClause);
		assertTrue("expectedResults length:"+expectedResults.length+" actualResults length:"+actualResults.length,expectedResults.length==actualResults.length);
		for (int i : new int[]{0,1,2,3,11,15,16,17}) {
			assertTrue("Three term test for three attributes, index "+i,expectedResults[i].equals(actualResults[i]));
		}
		ArrayList<School> equivalentList;
		int[][] equivalentIndexes = {{4,5,6},{7,8},{9,10,11},{12,13,14}};
		for (int i=0; i<equivalentIndexes.length; i++) {
			equivalentList = new ArrayList(Arrays.asList(Arrays.copyOfRange(actualResults,equivalentIndexes[i][0],equivalentIndexes[i][equivalentIndexes[i].length-1]+1)));
			for (int j : equivalentIndexes[i]) {
				boolean containsSchool = equivalentList.remove(expectedResults[j]);
				assertTrue("actualSchoolList should contain this school. (Three term test)",containsSchool);
			}
		}
		searchClause = new SchoolSearchClause(searchCriteria,searchEmphases);
		actualResults = searchController.search(searchClause);
		assertTrue("expectedResults length:"+expectedResults.length+" actualResults length:"+actualResults.length,expectedResults.length==actualResults.length);
		for (int i : new int[]{0,1,2,3,11,15,16,17}) {
			assertTrue("Many term test for three attributes, index "+i,expectedResults[i].equals(actualResults[i]));
		}
		for (int i=0; i<equivalentIndexes.length; i++) {
			equivalentList = new ArrayList(Arrays.asList(Arrays.copyOfRange(actualResults,equivalentIndexes[i][0],equivalentIndexes[i][equivalentIndexes[i].length-1]+1)));
			for (int j : equivalentIndexes[i]) {
				boolean containsSchool = equivalentList.remove(expectedResults[j]);
				assertTrue("actualSchoolList should contain this school. (Three term test)",containsSchool);
			}
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
				if (!uniqueNames.contains(school[0]))
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
				if (!uniqueNames.contains(school[0]))
					uniqueNames.add(school[0]);
			}
			String[][] emphasisData = new String[uniqueNames.size()*testEmphases[0].length][2];
			int index = 0;
			for (int i = 0; i < uniqueNames.size(); i++) {
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
			schoolData[0] = Arrays.copyOf(searchCriteria,searchCriteria.length);
			for (int j=1; j<schoolData.length; j++) {
				schoolData[j] = Arrays.copyOf(searchCriteria,searchCriteria.length);
				schoolData[j][i] = testSchoolData[i][j-1];
			}
			return schoolData;
		}
		else {
			String[][] schoolData = new String[testSchoolData[i].length][16];
			for (int j=0; j<schoolData.length; j++) {
				schoolData[j] = Arrays.copyOf(searchCriteria,searchCriteria.length);
				schoolData[j][0] = testSchoolData[i][j];
			}
			return schoolData;
		}
	}

}
