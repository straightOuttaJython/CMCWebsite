package cmc.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import cmc.controller.search.SchoolSearchClause;
import cmc.entity.School;
import cmc.entity.dbmapping.SchoolDatabaseMapping;
import dblibrary.project.csci230.UniversityDBLibrary;

/**
 * The SearchController class controls how/when a Person would search for specific school.
 * 
 * @author Alex
 * @version March 27, 2016
 */
public class SearchController 
{

	private String[][] schoolData;
	private String[][] emphasisData;
	
	public SearchController() {
		UniversityDBLibrary dbase = new UniversityDBLibrary("straightou", "straightou", "adem4");
		schoolData = dbase.university_getUniversities();
		emphasisData = dbase.university_getNamesWithEmphases();
	}

	public SearchController(String[][] schoolData, String[][] emphasisData) {
		this.schoolData = schoolData;
		this.emphasisData = emphasisData;
	}

	private SearchResult[] getResultList(SchoolSearchClause searchClause) {
		SearchResult[] results = new SearchResult[schoolData.length]; 
		for (int i=0; i<schoolData.length; i++) {
			String emphases = "";
			for (String[] em : emphasisData) {
				if (em[0].equals(schoolData[i][0]))
					emphases+=":"+em[1];
			}
			results[i] = new SearchResult(searchClause.scoreSchoolData(schoolData[i], emphases),
						SchoolDatabaseMapping.convertDatabaseItemToSchool(schoolData[i], emphases.split(":")));
		}
		return results;
	}
	
	public School[] search(SchoolSearchClause searchClause) {
		SearchResult[] results = this.getResultList(searchClause);
		Arrays.sort(results);
		int schoolListLength = Integer.min(results.length, 50);
		School[] schoolList = new School[schoolListLength];
		for (int i=0; i<schoolListLength; i++) {
			schoolList[i] = results[results.length-i-1].getSchool();
		}
		return schoolList;
	}
	
	private class SearchResult implements Comparable<SearchResult> {
		
		private double score;
		private School school;
		
		public SearchResult(double score, School associatedSchool) {
			super();
			this.score = score;
			this.school = associatedSchool;
		}
		
		public double getScore() {
			return this.score;
		}

		public School getSchool() {
			return school;
		}

		@Override
		public int compareTo(SearchResult sR) {
			return new Double(score).compareTo(new Double(sR.getScore()));
		}
	}
}
