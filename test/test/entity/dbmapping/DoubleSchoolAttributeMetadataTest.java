/**
 * 
 */
package test.entity.dbmapping;

import static org.junit.Assert.*;

import org.junit.Test;

import cmc.entity.dbmapping.DoubleSchoolAttributeMetadata;

/**
 * @author Alex
 *
 */
public class DoubleSchoolAttributeMetadataTest {
	
	DoubleSchoolAttributeMetadata meta;

	/**
	 * Test method for {@link cmc.entity.dbmapping.DoubleSchoolAttributeMetadata#getType()}.
	 */
	@Test
	public void testGetType() {
		meta = new DoubleSchoolAttributeMetadata("Birth Rate");
		char expected = 'd';
		char result = meta.getType();
		assertTrue("expected result: "+expected+" actual result: "+result,result==expected);
	}

	/**
	 * Test method for {@link cmc.entity.dbmapping.DoubleSchoolAttributeMetadata#getMin()}
	 * and {@link cmc.entity.dbmapping.DoubleSchoolAttributeMetadata#getMax()}.
	 */
	@Test
	public void testGetMinAndGetMax() {
		meta = new DoubleSchoolAttributeMetadata("Birth Rate",5.45,100);
		double expected = 5.45;
		double result = meta.getMin();
		assertTrue("expected result: "+expected+" actual result: "+result,result==expected);
		expected = 100;
		result = meta.getMax();
		assertTrue("expected result: "+expected+" actual result: "+result,result==expected);
	}

	/**
	 * Test method for {@link cmc.entity.dbmapping.SchoolAttributeMetadata#getName()}.
	 */
	@Test
	public void testGetName() {
		meta = new DoubleSchoolAttributeMetadata("Birth Rate");
		String expected = "Birth Rate";
		String result = meta.getName();
		assertTrue("expected result: "+expected+" actual result: "+result,result.equals(expected));
	}

}
