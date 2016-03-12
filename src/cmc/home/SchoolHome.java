package cmc.home;

import cmc.entity.Person;
import cmc.entity.School;
import dblibrary.project.csci230.UniversityDBLibrary;

public class SchoolHome 
{
	private UniversityDBLibrary db = new UniversityDBLibrary("straightou", "straightou", "adem4");
	private School sch;
	private School[] schoolList;
	
	public void addSchool(School school)
	{
		
	}
	
	public void updateSchool(School school)
	{
		
	}
	
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
			
			String decideRate1 = universities[i][11];
			double decideRate = Double.parseDouble(decideRate1);
			
			String academics1 = universities[i][12];
			int academics = Integer.parseInt(academics1);
			
			String socialLife1 = universities[i][13];
			int socialLife = Integer.parseInt(socialLife1);
			
			String qualityLife1 = universities[i][14];
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
}
