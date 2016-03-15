package cmc.controller;

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
	/**
	 * The login method users an school name to find school
	 * 
	 * @param schoolName, the username that is entered.

	 * @return School object that was found based on the school name
	 */
	public School[] search(School idealSchool) 
	{
		UniversityDBLibrary dbase = new UniversityDBLibrary("straightou", "straightou", "adem4");
		String[][] rawSchools = dbase.university_getUniversities();
		double[] scores = new double[rawSchools.length];
		for (int i=0; i<rawSchools.length; i++) {
			scores[i] = this.calculateVector(idealSchool, rawSchools[i]);
		}
	}

	pastebin

	public void getRecSchool(School school)
	{

	}
}
