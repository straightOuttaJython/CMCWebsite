package cmc;

/*
 * This saves the information for a given school
 * @Erin Queme
 * @1.0 
 */

public class School 
{
	private String name, state, location, control, emphases[];
	private int numStudentsEnrolled, numApplications,academics, 
		socialLife, qualityLife;
	private Double percentFemEnrolled, satVerbal, 
		satMath, tuition, percentFinAid, admitRate, decideRate;

	/*
	 * Sets the parameters with the variables
	 * @param String name,state,location,control,enphases[]
	 * @param int numStudentsEnrolled, numApplications,academics,socialLife, qualityLife
	 * @param Double percentFemEnrolled, satVerbal, satMath, tuition, percentFinAid, admitRate, decideRate
	 */
	public School(String name, String state, String location, String control, String emphases[], 
			int numStudentsEnrolled, int numApplications,int academics, 
			int socialLife, int qualityLife, Double percentFemEnrolled, Double satVerbal, 
			Double satMath,  Double tuition, Double percentFinAid, Double admitRate, Double decideRate)
	{
		this.name = name;
		this.state = state;
		this.location = location;
		this.control = control;
		this.emphases = emphases;
		this.numStudentsEnrolled = numStudentsEnrolled;
		this.numApplications = numApplications;
		this.academics = academics;
		this.socialLife = socialLife;
		this.qualityLife = qualityLife;
		this.percentFemEnrolled = percentFemEnrolled;
		this.satVerbal = satVerbal;
		this.satMath = satMath;
		this.tuition = tuition;
		this.percentFinAid = percentFinAid;
		this.admitRate = admitRate;
		this.decideRate = decideRate;
				
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
	public Double getPercentFemEnrolled() 
	{
		return percentFemEnrolled;
	}

	/*
	 * Sets the percentage of Female Enrolled
	 * @param double percFemEnrolled
	 */
	public void setPercFemEnrolled(Double percFemEnrolled) 
	{
		this.percentFemEnrolled = percFemEnrolled;
	}
	
	/*
	 * Gets the SAT Verbal score
	 */
	public Double getSatVerb() 
	{
		return satVerbal;
	}

	/*
	 * Sets the SAT Verbal Score
	 * @param double satVerb
	 */
	public void setSatVerbal(Double satVerb) 
	{
		this.satVerbal = satVerb;
	}
	
	/*
	 * Gets the SAT Math score
	 */
	public Double getSatMath() 
	{
		return satMath;
	}
	
	/*
	 * Sets the SAT Math Score
	 * @param double satMath
	 */
	public void setSatMath(Double satMath) 
	{
		this.satMath = satMath;
	}

	/*
	 * Gets the tuition of the school
	 */
	public Double getTuition() 
	{
		return tuition;
	}

	/*
	 * Sets tuition of a school
	 * @param double tuition
	 */
	public void setTution(Double tuition) 
	{
		this.tuition = tuition;
	}

	/*
	 * Gets the percentage of financial aid of the school
	 */
	public Double getPercFinAid() 
	{
		return percentFinAid;
	}

	/*
	 * Sets the percentage of financial aid of the school
	 * @param double percFinAid
	 */
	public void setPercFinAid(Double percFinAid) 
	{
		this.percentFinAid = percFinAid;
	}

	/*
	 * Gets the admit rate of a school
	 */
	public Double getAdmitRate() 
	{
		return admitRate;
	}

	/*
	 * Sets the admit rate of the school
	 * @param double admitRate
	 */
	public void setAdmitRate(Double admitRate) 
	{
		this.admitRate = admitRate;
	}

	/*
	 * Gets the decision rate
	 */
	public Double getDecideRate() 
	{
		return decideRate;
	}
	
	/*
	 * Sets the deciding rate
	 * @param double decideRate
	 */
	public void setDecideRate(Double decideRate) 
	{
		this.decideRate = decideRate;
	}
}
