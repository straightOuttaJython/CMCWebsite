import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import cmc.entity.School;

public class testSchool {

	public School school, fullSchool;
	public String list[], Default;
	public int defaultNum;
	
	@Before
	public void setUp() throws Exception 
	{
		school = new School();
		list = new String[3];
		
		Default = "";
		defaultNum = 0;
		
		list[0] = "Fav School";
		list[1] = "Fav School1";
		list[2] = "Fav School2";
	
		fullSchool = new School("College University", "Texas", "Urban", "Private", 
				33, 15.5, 200.0, 200.0, 30000.52, 35.5, 6500,
				58.6, 36.8, 5,5,5, list);
	}
	
	@Test
	public void testGetName_checksEmptyNameOfSchool()
	{
		assertTrue("The name should be set to default", school.getName().equals(Default));
	}

	@Test
	public void testGetName_checksNameOfFullSchool()
	{
		assertTrue("The name should be Collge University.", fullSchool.getName().equals("College University"));
	}
	
	@Test
	public void testSetName_changesNameOfSchool()
	{
		school.setName("Univerity of College");
		assertTrue("The name should be Collge University.", school.getName().equals("Univerity of College"));
	}
	
	@Test
	public void testSetName_changesNameOfFullSchool()
	{
		fullSchool.setName("Lit College");
		assertTrue("The name should be Collge University.", fullSchool.getName().equals("Lit College"));
	}
	
	@Test
	public void testGetState_getsStateOfSchool()
	{
		assertTrue("The state should be default.", school.getState().equals(Default));
	}
	
	@Test
	public void testGetState_getsStateOfFullSchool()
	{
		assertTrue("The state should be Collge University.", fullSchool.getState().equals("Texas"));
	}
	
	@Test
	public void testSetState_setsStateOfSchool()
	{
		school.setState("Iowa");
		assertTrue("The state should be changed to Iowa.", school.getState().equals("Iowa"));
	}
	
	@Test
	public void testSetState_setsStateOfFullSchool()
	{
		fullSchool.setState("California");
		assertTrue("The state should be changed to California.", fullSchool.getState().equals("California"));
	}
	
	@Test
	public void testGetLocation_getsLocationsOfSchool()
	{
		assertTrue("The location should be Default.", school.getLocation().equals(Default));
	}
	
	@Test
	public void testGetLocation_getsLocationsOfFullSchool()
	{
		assertTrue("The location should be Urban", fullSchool.getLocation().equals("Urban"));
	}
	
	@Test
	public void testSetLocation_setsLocationsOfSchool()
	{
		school.setLocation("Urban");
		assertTrue("The location should changed to Urban.", school.getLocation().equals("Urban"));
	}
	
	@Test
	public void testSetLocation_setsLocationsOfFullSchool()
	{
		fullSchool.setLocation("Suburban");
		assertTrue("The location should change to Suburban", fullSchool.getLocation().equals("Suburban"));
	}
	
	@Test
	public void testGetControl_getsControlOfSchool()
	{
		assertTrue("The Control should be Default.", school.getControl().equals(Default));
	}
	
	@Test
	public void testGetControl_getsControlOfFullSchool()
	{
		assertTrue("The Control should be Private", fullSchool.getControl().equals("Private"));
	}
	
	@Test
	public void testSetControl_setsControlOfSchool()
	{
		school.setControl("Public");
		assertTrue("The Control should be changed to Public.", school.getControl().equals("Public"));
	}
	
	@Test
	public void testSetControl_setsControlOfFullSchool()
	{
		fullSchool.setControl("Public");
		assertTrue("The Control should be changed to Public", fullSchool.getControl().equals("Public"));
	}
	
	@Test
	public void testGetEmphases_getsEmphasesOfSchool()
	{
		assertTrue("The Emphases[0] should be Default.", school.getEmphases()[0].equals(Default));
		assertTrue("The Emphases[1] should be Default.", school.getEmphases()[1].equals(Default));
		assertTrue("The Emphases[2] should be Default.", school.getEmphases()[2].equals(Default));
	}
	
	@Test
	public void testGetEmphases_getsEmphasesOfFullSchool()
	{
		assertTrue("The Control should be Private", fullSchool.getEmphases()[0].equals(list[0]));
		assertTrue("The Control should be Private", fullSchool.getEmphases()[1].equals(list[1]));
		assertTrue("The Control should be Private", fullSchool.getEmphases()[2].equals(list[2]));
	}

	@Test
	public void testSetEmphases_setsEmphasesOfSchool()
	{
		String schoolList[] = new String[3];
		schoolList[0] = "Saint Johns University";
		schoolList[1] = "Instagram College";
		schoolList[2] = "DoWeReallyHaveASpringBreak University";
		
		school.setEmphases(schoolList);
		assertTrue("The Emphases[0] should change to Saint Johns University.", school.getEmphases()[0].equals("Saint Johns University"));
		assertTrue("The Emphases[1] should change to Instagram College.", school.getEmphases()[1].equals("Instagram College"));
		assertTrue("The Emphases[2] should change to DoWeReallyHaveASpringBreak University.", school.getEmphases()[2].equals("DoWeReallyHaveASpringBreak University"));
	}
	
	@Test
	public void testSetEmphases_setsEmphasesOfFullSchool()
	{
		list[0] = "Saint Johns UniversityV2";
		list[1] = "Instagram College";
		list[2] = "DoWeReallyHaveASpringBreak University";
		
		school.setEmphases(list);
		
		assertTrue("The Emphases[0] should change to Saint Johns University.", fullSchool.getEmphases()[0].equals("Saint Johns UniversityV2"));
		assertTrue("The Emphases[1] should change to Instagram College.", fullSchool.getEmphases()[1].equals("Instagram College"));
		assertTrue("The Emphases[2] should change to DoWeReallyHaveASpringBreak University.", fullSchool.getEmphases()[2].equals("DoWeReallyHaveASpringBreak University"));
	}

	@Test
	public void testGetNumStudentsEnrolled_getsGetNumStudentsEnrolledOfSchool()
	{
		assertTrue("The number of students enrolled should be defaultNum.", school.getNumStudentsEnrolled() == (defaultNum));
	}
	
	@Test
	public void testGetNumStudentsEnrolled_getsGetNumStudentsEnrolledOfFullSchool()
	{
		assertTrue("The number of students enrolled should be 33", fullSchool.getNumStudentsEnrolled() == (33));
	}
	
	@Test
	public void testSetNumStudentsEnrolled_setsGetNumStudentsEnrolledOfSchool()
	{
		school.setNumStudentsEnrolled(300);
		assertTrue("The number of students enrolled should be 300.", school.getNumStudentsEnrolled() == (300));
	}
	
	@Test
	public void testSetNumStudentsEnrolled_setsGetNumStudentsEnrolledOfFullSchool()
	{
		fullSchool.setNumStudentsEnrolled(3256);
		assertTrue("The Control should be changed to Public.", fullSchool.getNumStudentsEnrolled() == (3256));
	}

	
}
