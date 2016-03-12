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
	
	public void listOfSchools()
	{
		String[][] universities = db.university_getUniversities();
		schoolList = new School[universities.length];
		for(int i = 0; i < universities.length; i++)
		{
			
		}
		
		sch = new School();
	}
}
