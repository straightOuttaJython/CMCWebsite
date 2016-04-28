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
	
	/*
	 * number of emph
	 */
	private int num;
	
	/*
	 * final list of emph
	 */
	private String[] finalL;
	
	/**
	 * a list of schools
	 */
	private School[] schoolList;

	/**
	 * 2-D Array of emphases by name.
	 */
	String[][] emphasesList;
	
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
			
			int trackNum = 0;
			emphasesList = db.university_getNamesWithEmphases();
			for(int q = 0; q < emphasesList.length; q++) {
					if(emphasesList[q][0].equals(name)) {
						trackNum++;
					}
			}
			String[] emphases = new String[trackNum];
			trackNum = 0;
			for(int q = 0; q < emphasesList.length; q++) {
				if(emphasesList[q][0].equals(name)) {
					emphases[trackNum] = emphasesList[q][1];
					trackNum++;
				}
			}
			trackNum = 0;
			
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
		if (((percentFemEnrolled < 0 || percentFemEnrolled > 100) && percentFemEnrolled!=-1 ) ||
			((satVerbal < 0 || satVerbal > 800) && satVerbal!=-1 ) ||
			((satMath < 0 || satMath > 800) && satMath!=-1 ) ||
			((percentFinAid < 0 || percentFinAid > 100) && percentFinAid!=-1 ) ||
			((admitRate < 0 || admitRate > 100) && admitRate!=-1 ) ||
			((decideRate < 0 || decideRate > 100) && decideRate!=-1 ) ||
			((academics < 1 || academics > 5) && academics!=-1 ) ||
			((socialLife < 1 || socialLife > 5) && socialLife!=-1 ) ||
			((qualityLife < 1 || qualityLife > 5) && qualityLife!=-1)) {
			throw new IllegalArgumentException("Some number out of range");
		}
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
		if (((percentFemEnrolled < 0 || percentFemEnrolled > 100) && percentFemEnrolled!=-1 ) ||
			((satVerbal < 0 || satVerbal > 800) && satVerbal!=-1 ) ||
			((satMath < 0 || satMath > 800) && satMath!=-1 ) ||
			((percentFinAid < 0 || percentFinAid > 100) && percentFinAid!=-1 ) ||
			((admitRate < 0 || admitRate > 100) && admitRate!=-1 ) ||
			((decideRate < 0 || decideRate > 100) && decideRate!=-1 ) ||
			((academics < 1 || academics > 5) && academics!=-1 ) ||
			((socialLife < 1 || socialLife > 5) && socialLife!=-1 ) ||
			((qualityLife < 1 || qualityLife > 5) && qualityLife!=-1)) {
			throw new IllegalArgumentException("Some number out of range");
		}
		else {
			db.university_addUniversity(name,state,location,control,
					numStudentsEnrolled,percentFemEnrolled, satVerbal, satMath, tuition, percentFinAid,
					numApplicatns, admitRate,decideRate,academics,socialLife,qualityLife);
		}
	}

	public School getSchool(String school) throws IllegalArgumentException
	{
		School[] schoolArray = this.listOfSchools();
		School foundSchool = new School();
		for(int i = 0; i < schoolArray.length; i++) 
		{
			if(schoolArray[i].getName().equals(school)) 
			{
				foundSchool = schoolArray[i];
			} 
		} 
		if(!foundSchool.getName().equals(school)) 
		{
			throw new IllegalArgumentException("The entered school does not exist : " + school);
		}
		return foundSchool;
	}
	
	public void addSchoolEmph(String schoolName, String emph)
	{
		if (emph!=null && !emph.equals(""))
			db.university_addUniversityEmphasis(schoolName, emph);
	}
	
	public int getNumOfEmph(String school)
	{
		String[][] list =  db.university_getNamesWithEmphases();
		for(int i = 0; i<list.length; i++)
		{
			if(list[i][0].equals(school))
			{
				num = list[i].length;
			}
		}
		return num;
	}

	public void removeSchoolEmph(String schoolNm, String emp)
	{
		db.university_removeUniversityEmphasis(schoolNm, emp);
	}

	public String[] getEmp(String school) 
	{
		finalL = new String[5];
		String[][] allEmpList = db.university_getNamesWithEmphases();
		String[] listOfEmps = new String[allEmpList.length];
		int j = 0;
		for(int i = 0; i < listOfEmps.length; i++)
		{
			if(allEmpList[i][0].equals(school))
			{
				finalL[j] =  allEmpList[i][1];
				j = j+1;
			}
			if (j==5)
				break;
		}
		return finalL;
	}


}
