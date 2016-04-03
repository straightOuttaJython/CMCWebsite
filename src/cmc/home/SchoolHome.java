package cmc.home;

import cmc.entity.School;
import dblibrary.project.csci230.UniversityDBLibrary;

/**
 * The SchoolHome controls the ebb and flow of Schools in the Choose my College system.
 * 
 * @author Matthew Kounniyom, Erin Queme
 * @version March 6, 2016
 */
public class SchoolHome 
{
	/**
	 * New database created to use
	 */
	private UniversityDBLibrary db = new UniversityDBLibrary("straightou", "straightou", "adem4");
	
	/**
	 * a list of schools
	 */
	private School[] schoolList;
	
	/**
	 * Creates a list of schools and places them into schoolList
	 */
	public School[] listOfSchools()
	{
		String[][] universities = db.university_getUniversities();
		schoolList = new School[universities.length];
		for(int i = 0; i < universities.length; i++)
		{
			String name = universities[i][0];
			String state = universities[i][1];
			String location = universities[i][2];
			String control = universities[i][3];
	
			String numStudentsEnrolled1 = universities[i][4];
			int numStudentsEnrolled = Integer.parseInt(numStudentsEnrolled1);
			
			String percentFemEnrolled1 = universities[i][5];
			double percentFemEnrolled = Double.parseDouble(percentFemEnrolled1);
			
			String satVerbal1 = universities[i][6];
			double satVerbal = Double.parseDouble(satVerbal1);
			
			String satMath1 = universities[i][7];
			double satMath = Double.parseDouble(satMath1);
			
			String tution1 = universities[i][8];
			double tuition = Double.parseDouble(tution1);
			
			String percentFinAid1 = universities[i][9];
			double percentFinAid = Double.parseDouble(percentFinAid1);
			
			String numApplicatns1 = universities[i][10];
			int numApplicatns = Integer.parseInt(numApplicatns1);
			
			String admitRate1 = universities[i][11];
			double admitRate = Double.parseDouble(admitRate1);
			
			String decideRate1 = universities[i][12];
			double decideRate = Double.parseDouble(decideRate1);
			
			String academics1 = universities[i][13];
			int academics = Integer.parseInt(academics1);
			
			String socialLife1 = universities[i][14];
			int socialLife = Integer.parseInt(socialLife1);
			
			String qualityLife1 = universities[i][15];
			int qualityLife = Integer.parseInt(qualityLife1);
			
			String emphases1 = universities[i][15];
			String emphases[] = emphases1.split(" ");
			
			schoolList[i] = new School(name,state,location,control,
					numStudentsEnrolled,percentFemEnrolled, satVerbal, satMath, tuition, percentFinAid,
					numApplicatns, admitRate,decideRate,academics,socialLife,qualityLife,
					emphases);
		}
		return schoolList;
	}	

	/**
	 * updates the school and saves the edits to the db
	 */
	public void updateSchool(String name, String state, String location, String control, int numStudentsEnrolled,
			double percentFemEnrolled, double satVerbal, double satMath, double tuition, double percentFinAid,
			int numApplicatns, double admitRate, double decideRate, int academics, int socialLife, int qualityLife) 
	{
		db.university_editUniversity(name,state,location,control,
						numStudentsEnrolled,percentFemEnrolled, satVerbal, satMath, tuition, percentFinAid,
						numApplicatns, admitRate,decideRate,academics,socialLife,qualityLife);	
	}
	
	/**
	 * adds a school and saves it into the db
	 */
	public void addSchool(String name, String state, String location, String control, int numStudentsEnrolled,
			double percentFemEnrolled, double satVerbal, double satMath, double tuition, double percentFinAid,
			int numApplicatns, double admitRate, double decideRate, int academics, int socialLife, int qualityLife) 
	{
		db.university_addUniversity(name,state,location,control,
				numStudentsEnrolled,percentFemEnrolled, satVerbal, satMath, tuition, percentFinAid,
				numApplicatns, admitRate,decideRate,academics,socialLife,qualityLife);
	}
}
