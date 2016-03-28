package cmc.entity;

/*
 * This saves the information for a given school
 * @author Erin Queme
 * @Version March 6, 2016
 */

public class School 
{
	private String name, state, location, control, emphases[];
	private int numStudentsEnrolled, numApplications,academics, 
		socialLife, qualityLife;
	private double percentFemEnrolled, satVerbal, 
		satMath, tuition, percentFinAid, admitRate, decideRate;

	/*
	 * Sets the parameters with the variables
	 * @param String name,state,location,control,enphases[]
	 * @param int numStudentsEnrolled, numApplications,academics,socialLife, qualityLife
	 * @param double percentFemEnrolled, satVerbal, satMath, tuition, percentFinAid, admitRate, decideRate
	 */
	public School(String name, String state, String location, String control, 
			int numStudentsEnrolled,double percentFemEnrolled, double satVerbal, double satMath, double tuition, double percentFinAid,
			int numApplications, double admitRate, double decideRate, 
			int academics,int socialLife, int qualityLife, 
			String emphases[])
	{
		this.name = name;
		this.state = state;
		this.location = location;
		this.control = control;
		
		this.numStudentsEnrolled = numStudentsEnrolled;
		this.percentFemEnrolled = percentFemEnrolled;
		this.satVerbal = satVerbal;
		this.satMath = satMath;
		this.tuition = tuition;
		this.percentFinAid = percentFinAid;
		
		this.numApplications = numApplications;
		this.admitRate = admitRate;
		this.decideRate = decideRate;
		
		this.academics = academics;
		this.socialLife = socialLife;
		this.qualityLife = qualityLife;
		
		this.emphases = emphases;
	}
	
	/*
	 * Sets the variables as a default state
	 * @param String name,state,location,control,enphases[]
	 * @param int numStudentsEnrolled, numApplications,academics,socialLife, qualityLife
	 * @param double percentFemEnrolled, satVerbal, satMath, tuition, percentFinAid, admitRate, decideRate
	 */
	public School()
	{
		this.name = "";
		this.state = "";
		this.location = "";
		this.control = "";
		this.numStudentsEnrolled = 0;
		this.numApplications = 0;
		this.academics = 0;
		this.socialLife = 0;
		this.qualityLife = 0;
		this.percentFemEnrolled = 0.0;
		this.satVerbal = 0.0;
		this.satMath = 0.0;
		this.tuition = 0.0;
		this.percentFinAid = 0.0;
		this.admitRate = 0.0;
		this.decideRate = 0.0;
		this.emphases = new String[3];
		
		this.emphases[0] = "";
		this.emphases[1] = "";
		this.emphases[2] = "";
	}
	/*
	 * Gets name of school
	 */
	public String getName() 
	{
		return name;
	}

	/*
	 * Set the name for the school name
	 * @param String schoolName
	 */
	public void setName(String schoolName) 
	{
		this.name = schoolName;
	}

	/*
	 * This gets the state of the School
	 */
	public String getState() 
	{
		return state;
	}
	
	/*
	 * Sets the state of the school
	 * @param String state
	 */
	public void setState(String state) 
	{
		this.state = state;
	}

	/*
	 * Gets the location of the school
	 */
	public String getLocation() 
	{
		return location;
	}
	
	/*
	 * Sets the location of the school
	 * @param String location
	 */
	public void setLocation(String location) 
	{
		this.location = location;
	}
	
	/*
	 * Gets the control for the school
	 */
	public String getControl() 
	{
		return control;
	}
	
	/*
	 * Sets the control for the school
	 * @param String control
	 * @return
	 * @throws 
	 */
	public void setControl(String control) 
	{
		this.control = control;
	}
	
	/*
	 * Gets the emphases for the school
	 */
	public String[] getEmphases() 
	{
		return emphases;
	}

	/*
	 * Sets the Emphases for the school.
	 * @param String[] emphases
	 */
	public void setEmphases(String[] emphases) 
	{
		this.emphases = emphases;
	}
	
	/*
	 * Get the number of students enrolled in the school
	 */
	public int getNumStudentsEnrolled() 
	{
		return numStudentsEnrolled;
	}
	
	/*
	 * Sets the number of students Enrolled
	 * @param int numStudentsEnrolled
	 */
	public void setNumStudentsEnrolled(int numStudentsEnrolled) 
	{
		this.numStudentsEnrolled = numStudentsEnrolled;
	}
	
	/*
	 * Gets the number of applicants for the school
	 */
	public int getNumApplications() 
	{
		return numApplications;
	}
	
	/*
	 * Sets the number of applicants for the school.
	 */
	public void setNumApplications(int numApplications) 
	{
		this.numApplications = numApplications;
	}
	
	/*
	 * Get the academics for the school
	 */
	public int getAcademics() 
	{
		return academics;
	}
	
	/*
	 * Sets the academics for the school
	 * @param in academics
	 */
	public void setAcademics(int academics) 
	{
		this.academics = academics;
	}

	/*
	 * Gets the social life of the school
	 */
	public int getSocialLife()
	{
		return socialLife;
	}
	
	/*
	 * Sets the social life of the school
	 * @param in socialLife
	 */
	public void setSocialLife(int socialLife) 
	{
		this.socialLife = socialLife;
	}
	
	/*
	 * Gets the quality of life for the school
	 */
	public int getQualityLife()
	{
		return qualityLife;
	}
	
	/*
	 * Sets the quality of Life for the school
	 * @param in qualLife
	 */
	public void setQualLife(int qualLife) 
	{
		this.qualityLife = qualLife;
	}

	/*
	 * Gets the percentage of Females that enrolled
	 */
	public double getPercentFemEnrolled() 
	{
		return percentFemEnrolled;
	}

	/*
	 * Sets the percentage of Female Enrolled
	 * @param double percFemEnrolled
	 */
	public void setPercFemEnrolled(double percFemEnrolled) 
	{
		this.percentFemEnrolled = percFemEnrolled;
	}
	
	/*
	 * Gets the SAT Verbal score
	 */
	public double getSatVerb() 
	{
		return satVerbal;
	}

	/*
	 * Sets the SAT Verbal Score
	 * @param double satVerb
	 */
	public void setSatVerbal(double satVerb) 
	{
		this.satVerbal = satVerb;
	}
	
	/*
	 * Gets the SAT Math score
	 */
	public double getSatMath() 
	{
		return satMath;
	}
	
	/*
	 * Sets the SAT Math Score
	 * @param double satMath
	 */
	public void setSatMath(double satMath) 
	{
		this.satMath = satMath;
	}

	/*
	 * Gets the tuition of the school
	 */
	public double getTuition() 
	{
		return tuition;
	}

	/*
	 * Sets tuition of a school
	 * @param double tuition
	 */
	public void setTuition(double tuition) 
	{
		this.tuition = tuition;
	}

	/*
	 * Gets the percentage of financial aid of the school
	 */
	public double getPercFinAid() 
	{
		return percentFinAid;
	}

	/*
	 * Sets the percentage of financial aid of the school
	 * @param double percFinAid
	 */
	public void setPercFinAid(double percFinAid) 
	{
		this.percentFinAid = percFinAid;
	}

	/*
	 * Gets the admit rate of a school
	 */
	public double getAdmitRate() 
	{
		return admitRate;
	}

	/*
	 * Sets the admit rate of the school
	 * @param double admitRate
	 */
	public void setAdmitRate(double admitRate) 
	{
		this.admitRate = admitRate;
	}

	/*
	 * Gets the decision rate
	 */
	public double getDecideRate() 
	{
		return decideRate;
	}
	
	/*
	 * Sets the deciding rate
	 * @param double decideRate
	 */
	public void setDecideRate(double decideRate) 
	{
		this.decideRate = decideRate;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof School) {
			School school = (School)obj;
			String[] emphases = school.getEmphases();
			if (this.name.equals(school.getName()) &&
					this.state.equals(school.getState()) &&
					this.location.equals(school.getLocation()) &&
					this.control.equals(school.getControl()) &&
					this.numStudentsEnrolled==school.getNumStudentsEnrolled() &&
					this.percentFemEnrolled==school.getPercentFemEnrolled() &&
					this.satVerbal==school.getSatVerb() &&
					this.satMath==school.getSatMath() &&
					this.tuition==school.getTuition() &&
					this.percentFinAid==school.getPercFinAid() &&
					this.numApplications==school.getNumApplications() &&
					this.admitRate==school.getAdmitRate() &&
					this.decideRate==school.getDecideRate() &&
					this.academics==school.getAcademics() &&
					this.socialLife==school.getSocialLife() &&
					this.qualityLife==school.getQualityLife() &&
					this.emphases.length==emphases.length) {
				for (int i = 0; i < this.emphases.length; i++) {
					if (this.emphases[i].equals(emphases[i]))
						return true;
				}
			}
		}
		return false;
	}

}
