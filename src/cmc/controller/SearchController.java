package cmc.controller;

import java.util.Arrays;
import java.util.Collections;

import cmc.controller.search.SchoolSearchClause;
import cmc.entity.School;
import cmc.entity.dbmapping.SchoolDatabaseMapping;
import dblibrary.project.csci230.UniversityDBLibrary;

/**
 * SearchController handles communication with the UniversityDBLibrary and
 * match sorting for CMC's search function.
 * 
 * @author Alex Seefeldt
 * @version 4/1/16
 */
public class SearchController 
{

	/**
	 * The database output of school data used by this SearchController when conducting a search.
	 */
	private String[][] schoolData;
	
	/**
	 * The database output of emphasis data used by this SearchController when conducting a search.
	 */
	private String[][] emphasisData;
	
	/**
	 * Constructs a new SearchController, pulling data from UniversityDBLibrary 
	 */
	public SearchController() {
		UniversityDBLibrary dbase = new UniversityDBLibrary("straightou", "straightou", "adem4");
		schoolData = dbase.university_getUniversities();
		emphasisData = dbase.university_getNamesWithEmphases();
	}

	/**
	 * Constructs a new SearchController, taking its data from the given arrays. This constructor
	 * was used only in testing, to make testing against consistent database output possible. 
	 * @param schoolData a 2-dimensional array simulating database output of school data
	 * @param emphasisData a 2-dimensional array simulating database output of emphasis data
	 */
	public SearchController(String[][] schoolData, String[][] emphasisData) {
		this.schoolData = schoolData;
		this.emphasisData = emphasisData;
	}

	/**
	 * Iterates through this SearchController's search data and constructs a list of SearchResults
	 * @param searchClause the SchoolSearchClause used in this search
	 * @return an unsorted array of SearchResults
	 */
	private SearchResult[] getResultList(SchoolSearchClause searchClause) {
		SearchResult[] results = new SearchResult[schoolData.length]; 
		for (int i=0; i<schoolData.length; i++) {
			String emphases = "";
			for (String[] em : emphasisData) {
				if (em[0].equals(schoolData[i][0]))
					emphases+=":"+em[1];
			}
			if (emphases.length()>0) {
				emphases = emphases.substring(1);
			}
			results[i] = new SearchResult(searchClause.scoreSchoolData(schoolData[i], emphases),
						SchoolDatabaseMapping.convertDatabaseItemToSchool(schoolData[i], emphases.split(":")));
		}
		return results;
	}
	
	/**
	 * Generates search results according to the given SchoolSearchClause, sorts them, and returns the 
	 * resulting list of up to 50 Schools. 
	 * @param searchClause the SchoolSearchClause used in this search
	 * @return a ranked array of Schools, with the best match appearing first
	 */
	public School[] search(SchoolSearchClause searchClause) {
		SearchResult[] results = this.getResultList(searchClause);
		Collections.reverse(Arrays.asList(results));
		Arrays.sort(results);
		int schoolListLength = Integer.min(results.length, 50);
		School[] schoolList = new School[schoolListLength];
		for (int i=0; i<schoolListLength; i++) {
			schoolList[i] = results[results.length-i-1].getSchool();
		}
		return schoolList;
	}
	
	/**
	 * An ancillary class that allows Schools to be easily sorted by their scores.
	 * @author Alex
	 * @version 3/27/16
	 */
	private class SearchResult implements Comparable<SearchResult> {
		
		/**
		 * The score the school received when compared to the SchoolSearchClause.
		 */
		private double score;
		
		/**
		 * The scored School that needs to be ranked.
		 */
		private School school;
		
		/**
		 * Constructs a new SearchResult with the given fields.
		 * @param score score the school has receieved
		 * @param associatedSchool scored School associated with score
		 */
		public SearchResult(double score, School associatedSchool) {
			super();
			this.score = score;
			this.school = associatedSchool;
		}
		
		/**
		 * Access method for private field {@link SearchResult#score}
		 * @return this SearchResult's score
		 */
		public double getScore() {
			return this.score;
		}

		/**
		 * Access method for private field {@link SearchResult#school}
		 * @return this SearchResult's associated School
		 */
		public School getSchool() {
			return school;
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public int compareTo(SearchResult sR) {
			return new Double(score).compareTo(new Double(sR.getScore()));
		}
	}
}
