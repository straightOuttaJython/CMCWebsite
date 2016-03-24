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
				33, 15.5, 200.0, 200.0, 30000.52, 35.5, 
				6500, 58.6, 36.8, 
				5,5,5, list);
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

	@Test
	public void testGetNumApplications_GetNumApplicationsOfSchool()
	{
		assertTrue("The number of applications enrolled should be defaultNum.", school.getNumApplications() == (defaultNum));
	}
	
	@Test
	public void testGetNumApplications_GetNumApplicationsOfFullSchool()
	{
		assertTrue("The number of applications enrolled should be 6500", fullSchool.getNumApplications() == (6500));
	}
	
	@Test
	public void testSetNumApplications_SetNumApplicationsOfSchool()
	{
		school.setNumApplications(46000);
		assertTrue("The number of students enrolled should be 300.", school.getNumApplications() == (46000));
	}
	
	@Test
	public void testSetNumApplications_SetNumApplicationsOfFullSchool()
	{
		fullSchool.setNumApplications(630);
		assertTrue("The number of students enrolled should be 300.", fullSchool.getNumApplications() == (630));
	}

	@Test
	public void testGetAcademics_GetAcademicsOfSchool()
	{
		assertTrue("The academic rating should be defaultNum.", school.getAcademics() == (defaultNum));
	}
	
	@Test
	public void testGetAcademics_GetAcademicsOfFullSchool()
	{
		assertTrue("The academic rating should be 5.", fullSchool.getAcademics() == (5));
	}
	
	@Test
	public void testSetAcademics_SetAcademicsOfSchool()
	{
		school.setAcademics(3);
		assertTrue("The academic rating should be 3.", school.getAcademics() == (3));
	}
	
	@Test
	public void testSetAcademics_SetAcademicsOfFullSchool()
	{
		fullSchool.setAcademics(1);
		assertTrue("The academic rating should be 1.", fullSchool.getAcademics() == (1));
	}
	
	@Test
	public void testGetSocialLife_GetSocialLifeOfSchool()
	{
		assertTrue("The social life rating should be defaultNum.", school.getSocialLife() == (defaultNum));
	}
	
	@Test
	public void testGetSocialLife_GetSocialLifeOfFullSchool()
	{
		assertTrue("The social life rating should be 5.", fullSchool.getSocialLife() == (5));
	}
	
	@Test
	public void testSetSocialLife_SetSocialLifeOfSchool()
	{
		school.setSocialLife(4);
		assertTrue("The social life rating should be 4.", school.getSocialLife() == 4);
	}
	
	@Test
	public void testSetSocialLife_SetSocialLifeOfFullSchool()
	{
		fullSchool.setSocialLife(3);
		assertTrue("The social life rating should be 3.", fullSchool.getSocialLife() == 3);
	}

	@Test
	public void testGetQualityLife_GetQualityLifeOfSchool()
	{
		assertTrue("The quality of life rating should be defaultNum.", school.getQualityLife() == (defaultNum));
	}
	
	@Test
	public void testGetQualityLife_GetQualityLifeOfFullSchool()
	{
		assertTrue("The quality of life rating should be 5.", fullSchool.getQualityLife() == (5));
	}
	
	@Test
	public void testSetQualityLife_SetQualityLifeOfSchool()
	{
		school.setQualLife(1);
		assertTrue("The quality of life rating should be 4.", school.getQualityLife() == 1);
	}
	
	@Test
	public void testSetQualityLife_SetQualityLifeOfFullSchool()
	{
		fullSchool.setQualLife(4);
		assertTrue("The quality of life rating should be 3.", fullSchool.getQualityLife() == 4);
	}
	
	@Test
	public void testGetPercentFemEnrolled_GetPercentFemEnrolledOfSchool()
	{
		assertTrue("The quality of life rating should be defaultNum.", school.getPercentFemEnrolled() == (defaultNum));
	}
	
	@Test
	public void testGetPercentFemEnrolled_GetPercentFemEnrolledOfFullSchool()
	{
		assertTrue("The quality of life rating should be 15.5.", fullSchool.getPercentFemEnrolled() == (15.5));
	}
	
	@Test
	public void testSetPercentFemEnrolled_SetPercentFemEnrolledOfSchool()
	{
		school.setPercFemEnrolled(18.3);
		assertTrue("The quality of life rating should be 18.3.", school.getPercentFemEnrolled() == 18.3);
	}
	
	@Test
	public void testSetPercentFemEnrolled_SetPercentFemEnrolledOfFullSchool()
	{
		fullSchool.setPercFemEnrolled(40.5);
		assertTrue("The quality of life rating should be 40.5.", fullSchool.getPercentFemEnrolled() == 40.5);
	}

	@Test
	public void testGetSatVerb_GetSatVerbOfSchool()
	{
		assertTrue("The SAT verbal requirements should be defaultNum.", school.getSatVerb() == (defaultNum));
	}
	
	@Test
	public void testGetSatVerb_GetSatVerbOfFullSchool()
	{
		assertTrue("The SAT verbal requirements should be 200.0.", fullSchool.getSatVerb() == (200.0));
	}
	
	@Test
	public void testSetSatVerb_SetSatVerbOfSchool()
	{
		school.setSatVerbal(220.0);
		assertTrue("The SAT verbal requirements should be 220.0.", school.getSatVerb() == 220.0);
	}
	
	@Test
	public void testSetSatVerb_SetSatVerbOfFullSchool()
	{
		fullSchool.setSatVerbal(250.0);
		assertTrue("The SAT verbal requirements should be 250.0.", fullSchool.getSatVerb() == 250.0);
	}

	@Test
	public void testGetSatMath_GetSatMathOfSchool()
	{
		assertTrue("The SAT mathmatic requirements should be defaultNum.", school.getSatMath() == (defaultNum));
	}
	
	@Test
	public void testGetSatMath_GetSatMathOfFullSchool()
	{
		assertTrue("The SAT mathmatic requirements should be 200.0.", fullSchool.getSatMath() == (200.0));
	}
	
	@Test
	public void testSetSatMath_SetSatMathOfSchool()
	{
		school.setSatMath(297.0);
		assertTrue("The SAT mathmatic requirements should be 220.0.", school.getSatMath() == 297.0);
	}
	
	@Test
	public void testSetSatMath_SetSatMathOfFullSchool()
	{
		fullSchool.setSatMath(250.9);
		assertTrue("The SAT mathmatic requirements should be 250.0.", fullSchool.getSatMath() == 250.9);
	}

	@Test
	public void testGetTuition_GetTuitionOfSchool()
	{
		assertTrue("The tuition cost should be defaultNum.", school.getTuition() == (defaultNum));
	}
	
	@Test
	public void testGetTuition_GetTuitionOfFullSchool()
	{
		assertTrue("The tuition cost should be should be 30000.52.", fullSchool.getTuition() == (30000.52));
	}
	
	@Test
	public void testSetTuition_SetTuitionOfSchool()
	{
		school.setTuition(29722.0);
		assertTrue("The tuition cost should be should be 29722.0.", school.getTuition() == 29722.0);
	}
	
	@Test
	public void testSetTuition_SetTuitionOfFullSchool()
	{
		fullSchool.setTuition(25039.9);
		assertTrue("The tuition cost should be 25039.9.", fullSchool.getTuition() == 25039.9);
	}

	@Test
	public void testGetPercFinAid_GetPercFinAidOfSchool()
	{
		assertTrue("The percent of finicial aid should be defaultNum.", school.getPercFinAid() == (defaultNum));
	}
	
	@Test
	public void testGetPercFinAid_GetPercFinAidOfFullSchool()
	{
		assertTrue("The percent of finicial aid should be 35.5.", fullSchool.getPercFinAid() == (35.5));
	}
	
	@Test
	public void testSetPercFinAid_SetPercFinAidOfSchool()
	{
		school.setPercFinAid(39.3);
		assertTrue("The percent of finicial aid should be 220.0.", school.getPercFinAid() == 39.3);
	}
	
	@Test
	public void testSetPercFinAid_SetPercFinAidOfFullSchool()
	{
		fullSchool.setPercFinAid(90.3);
		assertTrue("The percent of finicial aid should be 250.0.", fullSchool.getPercFinAid() == 90.3);
	}
	
	@Test
	public void testGetAdmitRate_GetAdmitRateOfSchool()
	{
		assertTrue("The admition rate should be defaultNum.", school.getAdmitRate() == (defaultNum));
	}
	
	@Test
	public void testGetAdmitRate_GetAdmitRateOfFullSchool()
	{
		assertTrue("The admition rate should be 58.6.", fullSchool.getAdmitRate() == (58.6));
	}
	
	@Test
	public void testSetAdmitRate_SetAdmitRateOfSchool()
	{
		school.setAdmitRate(90.3);
		assertTrue("The admition rate should be 90.3.", school.getAdmitRate() == 90.3);
	}
	
	@Test
	public void testSetAdmitRate_SetAdmitRateOfFullSchool()
	{
		fullSchool.setAdmitRate(65.3);
		assertTrue("The admition rate should be 65.3.", fullSchool.getAdmitRate() == 65.3);
	}

	@Test
	public void testGetDecideRate_GetDecideRateOfSchool()
	{
		assertTrue("The decision rate should be defaultNum.", school.getDecideRate() == (defaultNum));
	}
	
	@Test
	public void testGetDecideRate_GetDecideRateOfFullSchool()
	{
		assertTrue("The decision rate should be 58.6.", fullSchool.getDecideRate() == (36.8));
	}
	
	@Test
	public void testSetDecideRate_SetDecideRateOfSchool()
	{
		school.setDecideRate(52.3);
		assertTrue("The decision rate should be 90.3.", school.getDecideRate() == 52.3);
	}
	
	@Test
	public void testSetDecideRate_SetDecideRateOfFullSchool()
	{
		fullSchool.setDecideRate(61.3);
		assertTrue("The decision rate should be 65.3.", fullSchool.getDecideRate() == 61.3);
	}
}
