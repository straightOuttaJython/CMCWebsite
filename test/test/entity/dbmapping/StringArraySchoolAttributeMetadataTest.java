/**
 * 
 */
package test.entity.dbmapping;

import static org.junit.Assert.*;

import org.junit.Test;

import cmc.entity.dbmapping.IntegerSchoolAttributeMetadata;
import cmc.entity.dbmapping.StringArraySchoolAttributeMetadata;

/**
 * @author Alex
 *
 */
public class StringArraySchoolAttributeMetadataTest {

	StringArraySchoolAttributeMetadata meta;
	
	/**
	 * Test method for {@link cmc.entity.dbmapping.StringArraySchoolAttributeMetadata#getType()}.
	 */
	@Test
	public void testGetType() {
		meta = new StringArraySchoolAttributeMetadata("Places to Hide Vegetables");
		char expected = 'a';
		char result = meta.getType();
		assertTrue("expected result: "+expected+" actual result: "+result,result==expected);
	}

}
