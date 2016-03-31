package cmc.test.entity;
import cmc.entity.School;

public class SchoolTest {
	
	private School testSchool;
	// TODO: Also add in an array of test arguments
	
	public static void main(String[] args) {
		// TODO: create test school and run each test, if they return false, print an error, if not, print a confirmation
	}

	public boolean testSchoolConstructor1(String name, String state, String location, String control, 
			int numStudentsEnrolled,Double percentFemEnrolled, Double satVerbal, Double satMath, Double tuition, Double percentFinAid,
			int numApplications, Double admitRate, Double decideRate, 
			int academics,int socialLife, int qualityLife, 
			String emphases[]) {
		// TODO: call constructor with all the info and params, make sure it returns a School;
		return false;
	}

	public boolean testSchoolConstructor2() {
		// TODO: call constructor without info, make sure it returns an empty School;
		return false;
	}

	
	public boolean testSetName(String schoolName) {
		testSchool.setName(schoolName);
		return testSchool.getName().equals(schoolName);
	}

	
	public boolean testSetState(String state) {
		testSchool.setState(state);
		return testSchool.getState().equals(state);
	}

	
	public boolean testSetLocation(String location) {
		testSchool.setLocation(location);
		return testSchool.getLocation().equals(location);
	}

	
	public boolean testSetControl(String control) {
		testSchool.setControl(control);
		return testSchool.getControl().equals(control);
	}

	
	public boolean testSetEmphases(String[] emphases) {
		// TODO: test the setEmphases method in the same way as the others
		return false;
	}

	
	public boolean testSetNumStudentsEnrolled(int numStudentsEnrolled) {
		testSchool.setNumStudentsEnrolled(numStudentsEnrolled);
		return testSchool.getNumStudentsEnrolled()==numStudentsEnrolled;
	}

	
	public boolean testSetNumApplications(int numApplications) {
		testSchool.setNumApplications(numApplications);
		return testSchool.getNumApplications()==numApplications;
	}

	
	public boolean testSetAcademics(int academics) {
		testSchool.setAcademics(academics);
		return testSchool.getAcademics()==academics;
	}

	
	public boolean testSetSocialLife(int socialLife) {
		testSchool.setSocialLife(socialLife);
		return testSchool.getSocialLife()==socialLife;
	}

	
	public boolean testSetQualLife(int qualLife) {
		testSchool.setQualLife(qualLife);
		return testSchool.getQualityLife()==qualLife;
	}

	
	public boolean testSetPercFemEnrolled(double percFemEnrolled) {
		testSchool.setPercFemEnrolled(percFemEnrolled);
		return testSchool.getPercentFemEnrolled() == percFemEnrolled;
	}

	
	public boolean testSetSatVerbal(double satVerb) {
		testSchool.setSatVerbal(satVerb);
		return testSchool.getSatVerb() == satVerb;
	}

	
	public boolean testSetSatMath(double satMath) {
		testSchool.setSatMath(satMath);
		return testSchool.getSatMath() == satMath;
	}

	
	public boolean testSetTuition(double tuition) {
		testSchool.setTuition(tuition);
		return testSchool.getTuition() == tuition;
	}

	
	public boolean testSetPercFinAid(double percFinAid) {
		testSchool.setPercFinAid(percFinAid);
		return testSchool.getPercFinAid() == percFinAid;
	}

	
	public boolean testSetAdmitRate(double admitRate) {
		testSchool.setAdmitRate(admitRate);
		return testSchool.getAdmitRate() == admitRate;
	}

	
	public boolean testSetDecideRate(double decideRate) {
		testSchool.setDecideRate(decideRate);
		return testSchool.getDecideRate() == decideRate;
	}

}
