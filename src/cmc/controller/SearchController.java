package cmc.controller;

import java.util.ArrayList;

import cmc.entity.School;
import dblibrary.project.csci230.UniversityDBLibrary;

/**
 * The SearchController class controls how/when a Person would search for specific school.
 * 
 * @author Duong
 * @version March 9, 2016
 */
public class SearchController 
{
	
	private static final int[] STRING_LOCATIONS = {0,1,2,3};
	private static final int[] INT_LOCATIONS = {4,10,13,14,15};
	private static final int[] DOUBLE_LOCATIONS = {5,6,7,8,9,11,12};
	
	
	/**
	 * The login method users an school name to find school
	 * 
	 * @param schoolName, the username that is entered.

	 * @return School object that was found based on the school name
	 */
	public ArrayList<School> search(String[] idealSchool) 
	{
		UniversityDBLibrary dbase = new UniversityDBLibrary("straightou", "straightou", "adem4");
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
			//construct the school as newSchool
			matchList.add(newSchool);
		}
		return matchList;
	}

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

	public void getRecSchool(School school)
	{

	}
}
