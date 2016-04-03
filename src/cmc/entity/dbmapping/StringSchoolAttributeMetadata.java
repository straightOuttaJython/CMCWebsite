package cmc.entity.dbmapping;

/**
 * An implementation of SchoolAttributeMetadata for representing 
 * String fields in the School class.
 * @author Alex
 * @version 3/27/16
 */
public class StringSchoolAttributeMetadata extends SchoolAttributeMetadata {

	/**
	 * An array of String values the represented attribute is permitted to have.
	 */
	private String[] permittedValues = null;
	
	/**
	 * ContrCreates a new StringSchoolAttributeMetadata object with no restrictions on permitted values.
	 * @param name the name of the School attribute represented
	 */
	public StringSchoolAttributeMetadata(String name) {
		super(name);
	}
	
	/**
	 * Creates a new DoubleSchoolAttributeMetadata object with the specified name and permitted values.
	 * @param name the name of the School attribute represented
	 * @param permittedValues this attribute's permitted values
	 */
	public StringSchoolAttributeMetadata(String name, String[] permittedValues) {
		super(name);
		this.permittedValues = permittedValues;
	}

	/**
	 * Public access method for {@link StringSchoolAttributeMetadata#permittedValues}.
	 * @return this attribute's permitted values
	 */
	public String[] getPermittedValues() {
		return permittedValues;
	}
	
	/**
	 * {@inheritDoc}
	 * Returns 's' for StringSchoolAttributeMetadata.
	 */
	@Override
	public char getType() {
		return 's';
	}

}
