package cmc.entity.dbmapping;

/**
 * An implementation of SchoolAttributeMetadata for representing 
 * String array fields in the School class.
 * @author Alex
 * @version 3/27/16
 */
public class StringArraySchoolAttributeMetadata extends SchoolAttributeMetadata {
	
	/**
	 * ContrCreates a new StringArrayAttributeMetadata object with the specified name.
	 * @param name the name of the School attribute represented
	 */
	public StringArraySchoolAttributeMetadata(String name) {
		super(name);
	}
	
	/**
	 * {@inheritDoc}
	 * Returns 'a' for StringArraySchoolAttributeMetadata.
	 */
	@Override
	public char getType() {
		return 'a';
	}

}
