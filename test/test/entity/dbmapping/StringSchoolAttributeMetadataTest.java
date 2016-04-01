/**
 * 
 */
package test.entity.dbmapping;

import static org.junit.Assert.*;

import org.junit.Test;

import cmc.entity.dbmapping.StringSchoolAttributeMetadata;

/**
 * @author Alex
 *
 */
public class StringSchoolAttributeMetadataTest {

	StringSchoolAttributeMetadata meta;
	
	/**
	 * Test method for {@link cmc.entity.dbmapping.StringSchoolAttributeMetadata#getType()}.
	 */
	@Test
	public void testGetType() {
		meta = new StringSchoolAttributeMetadata("Scary House");
		char expected = 's';
		char result = meta.getType();
		assertTrue("expected result: "+expected+" actual result: "+result,result==expected);
	}

	/**
	 * Test method for {@link cmc.entity.dbmapping.StringSchoolAttributeMetadata#getPermittedValues()}.
	 */
	@Test
	public void testGetPermittedValues() {
		meta = new StringSchoolAttributeMetadata("Scary House",new String[]{"Ghoul","Ghost","Piece of Toast"});
		String[] expected = {"Ghoul","Ghost","Piece of Toast"};
		String[] result = meta.getPermittedValues();
		assertTrue("expected result length: "+expected.length+" actual result length: "+result.length,result.length==expected.length);
		for (int i = 0; i<expected.length; i++) {
			assertTrue("index: "+i+"expected result: "+expected[i]+" actual result: "+result[i],result[i].equals(expected[i]));
		}
	}

}
