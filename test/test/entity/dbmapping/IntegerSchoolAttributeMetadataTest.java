/**
 * 
 */
package test.entity.dbmapping;

import static org.junit.Assert.*;

import org.junit.Test;

import cmc.entity.dbmapping.IntegerSchoolAttributeMetadata;

/**
 * @author Alex
 *
 */
public class IntegerSchoolAttributeMetadataTest {
	
	IntegerSchoolAttributeMetadata meta;

	/**
	 * Test method for {@link cmc.entity.dbmapping.IntegerSchoolAttributeMetadata#getType()}.
	 */
	@Test
	public void testGetType() {
		meta = new IntegerSchoolAttributeMetadata("Cats on Stilts");
		char expected = 'i';
		char result = meta.getType();
		assertTrue("expected result: "+expected+" actual result: "+result,result==expected);
	}

	/**
	 * Test method for {@link cmc.entity.dbmapping.IntegerSchoolAttributeMetadata#getMin()}
	 * and {@link cmc.entity.dbmapping.IntegerSchoolAttributeMetadata#getMax()}.
	 */
	@Test
	public void testGetMinAndGetMax() {
		meta = new IntegerSchoolAttributeMetadata("Cats on Stilts",6,12);
		int expected = 6;
		int result = meta.getMin();
		assertTrue("expected result: "+expected+" actual result: "+result,result==expected);
		expected = 12;
		result = meta.getMax();
		assertTrue("expected result: "+expected+" actual result: "+result,result==expected);
	}
}
