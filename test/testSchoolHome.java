import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import cmc.entity.School;
import cmc.home.SchoolHome;
import dblibrary.project.csci230.UniversityDBLibrary;

public class testSchoolHome 
{

	private SchoolHome sh;
	private UniversityDBLibrary db;
	private School[] schoolList;
	private String[][] wholeList;
	public School school;
	public String list[];
	
	@Before
	public void setUp() throws Exception 
	{
		sh = new SchoolHome();
		db = new UniversityDBLibrary("straightou", "straightou", "adem4");
		school = new School("College Test University", "Texas", "Urban", "Private", 
				33, 15.5, 200.0, 200.0, 30000.52, 35.5, 
				6500, 58.6, 36.8, 
				5,5,5, list);
		
		wholeList = db.university_getUniversities();
		schoolList = new School[wholeList.length];
		for(int i = 0; i < wholeList.length; i++)
		{
			String name = wholeList[i][0];
			String state = wholeList[i][1];
			String location = wholeList[i][2];
			String control = wholeList[i][3];
	
			String numStudentsEnrolled1 = wholeList[i][4];
			int numStudentsEnrolled = Integer.parseInt(numStudentsEnrolled1);
			
			String percentFemEnrolled1 = wholeList[i][5];
			double percentFemEnrolled = Double.parseDouble(percentFemEnrolled1);
			
			String satVerbal1 = wholeList[i][6];
			double satVerbal = Double.parseDouble(satVerbal1);
			
			String satMath1 = wholeList[i][7];
			double satMath = Double.parseDouble(satMath1);
			
			String tution1 = wholeList[i][8];
			double tuition = Double.parseDouble(tution1);
			
			String percentFinAid1 = wholeList[i][9];
			double percentFinAid = Double.parseDouble(percentFinAid1);
			
			String numApplicatns1 = wholeList[i][10];
			int numApplicatns = Integer.parseInt(numApplicatns1);
			
			String admitRate1 = wholeList[i][11];
			double admitRate = Double.parseDouble(admitRate1);
			
			String decideRate1 = wholeList[i][11];
			double decideRate = Double.parseDouble(decideRate1);
			
			String academics1 = wholeList[i][12];
			int academics = Integer.parseInt(academics1);
			
			String socialLife1 = wholeList[i][13];
			int socialLife = Integer.parseInt(socialLife1);
			
			String qualityLife1 = wholeList[i][14];
			int qualityLife = Integer.parseInt(qualityLife1);
			
			String emphases1 = wholeList[i][15];
			String emphases[] = emphases1.split(" ");
			
			schoolList[i] = new School(name,state,location,control,
					numStudentsEnrolled,percentFemEnrolled, satVerbal, satMath, tuition, percentFinAid,
					numApplicatns, admitRate,decideRate,academics,socialLife,qualityLife,
					emphases);
		}
	}

	@Test
	public void testTheListofSchools()
	{
		assertTrue("The list of schools should equal to schoolList", sh.listOfSchools()[1].getName().equals(schoolList[1].getName()));
	}

	@Test
	public void testUpdateSchool()
	{
		assertTrue("Checks if school name is still College Test University",school.getName().equals("College Test University") );
		sh.updateSchool("College Test University", "Loser", "Urban", "Private", 
				33, 15.5, 200.0, 200.0, 30000.52, 35.5, 
				6500, 58.6, 36.8, 
				5,5,5);
		assertTrue("Changes the College Test University name to test1 University", school.getState().equals("Loser") );
	}
	
	@Test
	public void testAddSchool()
	{
		boolean t = false;
		
		sh.addSchool("nschool", "Loser", "Urban", "Private", 
				33, 15.5, 200.0, 200.0, 30000.52, 35.5, 
				6500, 58.6, 36.8, 
				5,5,5);
		
		for(int i =0; i < schoolList.length; i++)
		{
			if(schoolList[i].getName().equals("nschool"))
			{
				t = true;
			}
		}
		
		assertTrue("There is a school named New School added", t == true);
	}
	
	
}
