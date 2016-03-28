/**
 * 
 */
package entity.dbmapping;

import static org.junit.Assert.*;

import org.junit.Test;

import cmc.entity.School;
import cmc.entity.dbmapping.SchoolDatabaseMapping;

/**
 * @author Alex
 *
 */
public class SchoolDatabaseMappingTest {

	String[] testDatabaseItem = {"Test University",
								"Georgia",
								"SUBURBAN",
								"STATE",
								"10000",
								"45.0",
								"600.0",
								"550.0",
								"29000.0",
								"34.0",
								"6000",
								"40.0",
								"90.0",
								"3",
								"4",
								"2"};
	String[] testEmphases = 	{"Math","Science","Art"};
	School testSchool = new School( "Test University",
									"Georgia",
									"SUBURBAN",
									"STATE",
									10000,
									45.0,
									600.0,
									550.0,
									29000.0,
									34.0,
									6000,
									40.0,
									90.0,
									3,
									4,
									2,
									new String[]{"Math","Science","Art"});
	
	/**
	 * Test method for {@link cmc.entity.dbmapping.SchoolDatabaseMapping#convertSchoolToDatabaseItem(cmc.entity.School)}.
	 */
	@Test
	public void testConvertSchoolToDatabaseItem() {
		String[] resultDatabaseItem = SchoolDatabaseMapping.convertSchoolToDatabaseItem(testSchool);
		for (int i = 0; i < testDatabaseItem.length; i++) {
			String expectedResult = testDatabaseItem[i];
			String result = resultDatabaseItem[i];
			assertTrue("index:"+i+" expected result: "+expectedResult+" actual result: "+result,result.equals(expectedResult));
		}
	}

	/**
	 * Test method for {@link cmc.entity.dbmapping.SchoolDatabaseMapping#convertDatabaseItemToSchool(java.lang.String[], java.lang.String[])}.
	 */
	@Test
	public void testConvertDatabaseItemToSchool() {
		School result = SchoolDatabaseMapping.convertDatabaseItemToSchool(testDatabaseItem, testEmphases);
		assertTrue("expected School should match actual School",result.equals(testSchool));
	}
}
