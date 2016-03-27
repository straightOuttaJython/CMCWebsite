package cmc.entity.dbmapping;

import java.util.ArrayList;
import cmc.controller.search.SchoolSearchClause;
import cmc.entity.School;

public class SchoolDatabaseMapping {
	
	public static final SchoolAttributeMetadata[] MAPPING = 
		{new StringSchoolAttributeMetadata("Name"),
		 new StringSchoolAttributeMetadata("State"),
		 new StringSchoolAttributeMetadata("Location",new String[]{"SUBURBAN","URBAN","SMALL-CITY","-1"}),
		 new StringSchoolAttributeMetadata("Control",new String[]{"PRIVATE","STATE","CITY","-1"}),
		 new IntegerSchoolAttributeMetadata("Number of Students"),
		 new DoubleSchoolAttributeMetadata("Percentage of Female Students",0,100),
		 new DoubleSchoolAttributeMetadata("Average SAT Verbal",0,800),
		 new DoubleSchoolAttributeMetadata("Average SAT Math",0,800),
		 new DoubleSchoolAttributeMetadata("Tuition"),
		 new DoubleSchoolAttributeMetadata("Percentage of Financial Aid Recipients",0,100),
		 new IntegerSchoolAttributeMetadata("Number of Applicants"),
		 new DoubleSchoolAttributeMetadata("Percentage of Applicants Admitted",0,100),
		 new DoubleSchoolAttributeMetadata("Percentage of Admitted Applicants Enrolled",0,100),
		 new IntegerSchoolAttributeMetadata("Academics Rating",1,5),
		 new IntegerSchoolAttributeMetadata("Social Rating",1,5),
		 new IntegerSchoolAttributeMetadata("Quality of Life Rating",1,5),
		 new StringArraySchoolAttributeMetadata("Emphases")
		};
	
	public static String[] convertSchoolToDatabaseItem(School school) {
		return new String[]{school.getName(),
							school.getState(),
							school.getLocation(),
							school.getControl(),
							""+school.getNumStudentsEnrolled(),
							""+school.getPercentFemEnrolled(),
							""+school.getSatVerb(),
							""+school.getSatMath(),
							""+school.getTuition(),
							""+school.getPercFinAid(),
							""+school.getNumApplications(),
							""+school.getAdmitRate(),
							""+school.getDecideRate(),
							""+school.getAcademics(),
							""+school.getSocialLife(),
							""+school.getQualityLife()};
	}
	
	public static School convertDatabaseItemToSchool(String[] dbItem, String[] emphasesArray) {
		return new School(dbItem[0],
						  dbItem[1],
						  dbItem[2],
						  dbItem[3],
						  Integer.parseInt(dbItem[4]),
						  Double.parseDouble(dbItem[5]),
						  Double.parseDouble(dbItem[6]),
						  Double.parseDouble(dbItem[7]),
						  Double.parseDouble(dbItem[8]),
						  Double.parseDouble(dbItem[9]),
						  Integer.parseInt(dbItem[10]),
						  Double.parseDouble(dbItem[11]),
						  Double.parseDouble(dbItem[12]),
						  Integer.parseInt(dbItem[13]),
						  Integer.parseInt(dbItem[14]),
						  Integer.parseInt(dbItem[15]),
						  emphasesArray);
	}
	
	public static SchoolSearchClause convertDatabaseItemToSearchClause(String[] dbItem, String[] emphasesArray) {
		String emphases = "";
		for (String emphasis : emphasesArray)
			emphases+=":"+emphasis;
		return new SchoolSearchClause(dbItem,emphases.substring(1));
	}
}
