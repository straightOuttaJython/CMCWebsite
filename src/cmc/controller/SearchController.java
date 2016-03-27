package cmc.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import cmc.controller.search.SchoolSearchClause;
import cmc.controller.search.SearchResult;
import cmc.entity.School;
import cmc.entity.dbmapping.SchoolDatabaseMapping;
import dblibrary.project.csci230.UniversityDBLibrary;

/**
 * The SearchController class controls how/when a Person would search for specific school.
 * 
 * @author Alex
 * @version March 9, 2016
 */
public class SearchController 
{
	
	private UniversityDBLibrary dbase = new UniversityDBLibrary("straightou", "straightou", "adem4");
	private String[][] schoolData = dbase.university_getUniversities();
	private String[][] emphasisData = dbase.university_getEmphases();
	
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
		School[] schoolList = new School[50];
		for (int i=0; i<50; i++) {
			schoolList[i] = results[results.length-i-1].getSchool();
		}
		return schoolList;
	}
	
		//SchoolSearchClause searchClause = SchoolDatabaseMapping.convertDatabaseItemToSearchClause(
		//								  SchoolDatabaseMapping.convertSchoolToDatabaseItem(school),school.getEmphases());
	
	/**
	 * The login method users an school name to find school
	 * 
	 * @param schoolName, the username that is entered.

	 * @return School object that was found based on the school name
	 */
	/** ---------------------------------------------------
	public ArrayList<School> search(String[] idealSchool) 
	{
		String[][] compSchools = dbase.university_getUniversities();
		String[][] emphases = dbase.university_getEmphases();
		double[] scores = new double[compSchools.length];
		double avg = 0;
		for (int i=0; i<compSchools.length; i++) {
			ArrayList<String> compEm = new ArrayList<String>();
			for (String[] em : emphases) {
				if (em[0].equals(compSchools[i][0]))
					compEm.add(em[1]);
			}
			scores[i] = this.calculateVector(idealSchool, compSchools[i], compEm);
			avg+=scores[i];
		}
		avg/=compSchools.length;
		ArrayList<Integer> matchIndexes = new ArrayList<Integer>();
		for (int i=0; i<scores.length; i++) {
			if (scores[i]>=avg)
				matchIndexes.add(i);
		}
		ArrayList<School> matchList = new ArrayList<School>();
		for (Integer i : matchIndexes) {
			ArrayList<String> compEm = new ArrayList<String>();
			for (String[] em : emphases) {
				if (em[0].equals(compSchools[i][0]))
					compEm.add(em[1]);
			}
			String[] emArray = {""};
			emArray = compEm.toArray(emArray);
			matchList.add(new School(compSchools[i][0],
									compSchools[i][1],
									compSchools[i][2],
									compSchools[i][3],
									Integer.parseInt(compSchools[i][4]),
									Double.parseDouble(compSchools[i][5]),
									Double.parseDouble(compSchools[i][6]),
									Double.parseDouble(compSchools[i][7]),
									Double.parseDouble(compSchools[i][8]),
									Double.parseDouble(compSchools[i][9]),
									Integer.parseInt(compSchools[i][10]),
									Double.parseDouble(compSchools[i][11]),
									Double.parseDouble(compSchools[i][12]),
									Integer.parseInt(compSchools[i][13]),
									Integer.parseInt(compSchools[i][14]),
									Integer.parseInt(compSchools[i][15]),
									emArray));
		}
		return matchList;
	}
	*/

	/**
	 * School String (must be unique among universities), State String, Location String, Control String,
	 * NumberOfStudents int, PercentFemales double (between 0 and 100), SATVerbal double (up to 800),
	 * SATMath double (up to 800), Expenses double, PercentFinancialAid double (between 0 and 100),
	 * NumberOfApplicants int, PercentAdmitted double (between 0 and 100), PercentEnrolled double (between 0 and 100),
	 * AcademicsScale int (between 1 and 5 where is best), SocialScale int (between 1 and 5 where is best),
	 * QualityOfLifeScale int (between 1 and 5 where is best).
	 * 
	 * @param idealSchool The school to be compared against
	 * @param compSchool The candidate school, represented as an array of Strings
	 * @param compEm List of emphases to be compared
	 * @return a number representing the similarity between the schools from 0-1
	 */
	/** ---------------------------------------------------
	private double calculateVector(String[] idealSchool, String[] compSchool, ArrayList<String> compEm) {
		double avg = 0;
		int divisor = 0;
		for (int index : STRING_LOCATIONS) {
			String idealString = idealSchool[index];
			if (idealString!=null) {
				divisor++;
				if (idealString.contains(compSchool[index]))
					avg+=1;
			}
		}
		for (int index : INT_LOCATIONS) {
			String[] idealRange = idealSchool[index].split("-");
			if (idealRange[0].equals("*")&&(!idealRange[1].equals("*"))) {
				divisor++;
				if (Integer.parseInt(compSchool[index])<=Integer.parseInt(idealRange[1]))
					avg+=1;
			}
			else if (idealRange[1].equals("*")&&(!idealRange[0].equals("*"))) {
				divisor++;
				if (Integer.parseInt(compSchool[index])>=Integer.parseInt(idealRange[0]))
					avg+=1;
			}
			else if ((!idealRange[0].equals("*"))&&(!idealRange[1].equals("*"))) {
				divisor++;
				if (Integer.parseInt(compSchool[index])>=Integer.parseInt(idealRange[0]) && 
					Integer.parseInt(compSchool[index])<=Integer.parseInt(idealRange[1]))
					avg+=1;
			}
		}
		for (int index : DOUBLE_LOCATIONS) {
			String[] idealRange = idealSchool[index].split("-");
			if (idealRange[0].equals("*")&&(!idealRange[1].equals("*"))) {
				divisor++;
				if (Double.parseDouble(compSchool[index])<=Double.parseDouble(idealRange[1]))
					avg+=1;
			}
			else if (idealRange[1].equals("*")&&(!idealRange[0].equals("*"))) {
				divisor++;
				if (Double.parseDouble(compSchool[index])>=Double.parseDouble(idealRange[0]))
					avg+=1;
			}
			else if ((!idealRange[0].equals("*"))&&(!idealRange[1].equals("*"))) {
				divisor++;
				if (Double.parseDouble(compSchool[index])>=Double.parseDouble(idealRange[0]) && 
					Double.parseDouble(compSchool[index])<=Double.parseDouble(idealRange[1]))
					avg+=1;
			}
		}
		if (idealSchool[16]!=null) {
			String[] idealEmphases = idealSchool[16].split(":");
			for (String em : compEm) {
				divisor++;
				boolean matches = false;
				for (String id : idealEmphases) {
					if (id.contains(em))
						matches = true;
				}
				if (matches)
					avg+=1;
			}
		}
		avg/=divisor;
		return avg;
	}
	
	private double calculateRecommendationVector(String[] idealSchool, String[] compSchool, ArrayList<String> compEm) {
		// TODO: make this work
		double avg = 0;
		int divisor = 0;
		for (int index : STRING_LOCATIONS) {
			String idealString = idealSchool[index];
			if (idealString!=null && !idealString.matches("-1")) {
				divisor++;
				if (idealString.matches(compSchool[index]))
					avg+=1;
			}
		}
		for (int index : INT_LOCATIONS) {
			String[] idealRange = idealSchool[index].split("-");
			if (idealRange[0].equals("*")&&(!idealRange[1].equals("*"))) {
				divisor++;
				if (Integer.parseInt(compSchool[index])<=Integer.parseInt(idealRange[1]))
					avg+=1;
			}
			else if (idealRange[1].equals("*")&&(!idealRange[0].equals("*"))) {
				divisor++;
				if (Integer.parseInt(compSchool[index])>=Integer.parseInt(idealRange[0]))
					avg+=1;
			}
			else if ((!idealRange[0].equals("*"))&&(!idealRange[1].equals("*"))) {
				divisor++;
				if (Integer.parseInt(compSchool[index])>=Integer.parseInt(idealRange[0]) && 
					Integer.parseInt(compSchool[index])<=Integer.parseInt(idealRange[1]))
					avg+=1;
			}
		}
		for (int index : DOUBLE_LOCATIONS) {
			String[] idealRange = idealSchool[index].split("-");
			if (idealRange[0].equals("*")&&(!idealRange[1].equals("*"))) {
				divisor++;
				if (Double.parseDouble(compSchool[index])<=Double.parseDouble(idealRange[1]))
					avg+=1;
			}
			else if (idealRange[1].equals("*")&&(!idealRange[0].equals("*"))) {
				divisor++;
				if (Double.parseDouble(compSchool[index])>=Double.parseDouble(idealRange[0]))
					avg+=1;
			}
			else if ((!idealRange[0].equals("*"))&&(!idealRange[1].equals("*"))) {
				divisor++;
				if (Double.parseDouble(compSchool[index])>=Double.parseDouble(idealRange[0]) && 
					Double.parseDouble(compSchool[index])<=Double.parseDouble(idealRange[1]))
					avg+=1;
			}
		}
		String[] idealEmphases = idealSchool[16].split(":");
		for (String em : compEm) {
			divisor++;
			boolean matches = false;
			for (String id : idealEmphases) {
				if (id.contains(em))
					matches = true;
			}
			if (matches)
				avg+=1;
		}
		avg/=divisor;
		return avg;
	}

	public ArrayList<School> getReccomendedSchools(School school) {
		String[][] compSchools = dbase.university_getUniversities();
		String[][] emphases = dbase.university_getEmphases();
		double[] scores = new double[compSchools.length];
		String[] idealSchool = makeSearchableSchool(school);
		for (int i=0; i<compSchools.length; i++) {
			ArrayList<String> compEm = new ArrayList<String>();
			for (String[] em : emphases) {
				if (em[0].equals(compSchools[i][0]))
					compEm.add(em[1]);
			}
			scores[i] = this.calculateRecommendationVector(idealSchool, compSchools[i], compEm);
		}
		ArrayList<Integer> matchIndexes = new ArrayList<Integer>();
		double[] scoresTop5 = Arrays.copyOf(scores,scores.length);
		Arrays.sort(scoresTop5);
		scoresTop5 = Arrays.copyOfRange(scoresTop5, scoresTop5.length-5, scoresTop5.length);
		for (double score : scoresTop5) {
			int foundIndex = 0;
			for (int i=0; i<scores.length; i++) {
				if (scores[i]==score)
					foundIndex = i;
			}
			matchIndexes.add(foundIndex);
		}
		ArrayList<School> matchList = new ArrayList<School>();
		for (Integer i : matchIndexes) {
			ArrayList<String> compEm = new ArrayList<String>();
			for (String[] em : emphases) {
				if (em[0].equals(compSchools[i][0]))
					compEm.add(em[1]);
			}
			String[] emArray = {""};
			emArray = compEm.toArray(emArray);
			matchList.add(new School(compSchools[i][0],
									compSchools[i][1],
									compSchools[i][2],
									compSchools[i][3],
									Integer.parseInt(compSchools[i][4]),
									Double.parseDouble(compSchools[i][5]),
									Double.parseDouble(compSchools[i][6]),
									Double.parseDouble(compSchools[i][7]),
									Double.parseDouble(compSchools[i][8]),
									Double.parseDouble(compSchools[i][9]),
									Integer.parseInt(compSchools[i][10]),
									Double.parseDouble(compSchools[i][11]),
									Double.parseDouble(compSchools[i][12]),
									Integer.parseInt(compSchools[i][13]),
									Integer.parseInt(compSchools[i][14]),
									Integer.parseInt(compSchools[i][15]),
									emArray));
		}
		return matchList;
	}
	
	private String[] makeSearchableSchool(School school) {
		String[] schoolArray = new String[17];
		schoolArray[0] = school.getName();
		schoolArray[1] = school.getState();
		schoolArray[2] = school.getLocation();
		schoolArray[3] = school.getControl();
		schoolArray[4] = ""+school.getNumStudentsEnrolled();
		schoolArray[5] = ""+school.getPercentFemEnrolled();
		schoolArray[6] = ""+school.getSatVerb();
		schoolArray[7] = ""+school.getSatMath();
		schoolArray[8] = ""+school.getTuition();
		schoolArray[9] = ""+school.getPercFinAid();
		schoolArray[10] = ""+school.getNumApplications();
		schoolArray[11] = ""+school.getAdmitRate();
		schoolArray[12] = ""+school.getDecideRate();
		schoolArray[13] = ""+school.getAcademics();
		schoolArray[14] = ""+school.getSocialLife();
		schoolArray[15] = ""+school.getQualityLife();
		StringBuilder sB = new StringBuilder();
		for (String em : school.getEmphases()) {
			sB.append(em+":");
		}
		schoolArray[16] = sB.substring(0, sB.length());
		return schoolArray;
	}
	*/
}
