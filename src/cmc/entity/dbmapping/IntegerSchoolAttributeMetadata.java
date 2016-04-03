package cmc.entity.dbmapping;

/**
 * An implementation of SchoolAttributeMetadata for representing 
 * integer fields in the School class.
 * @author Alex
 * @version 3/27/16
 */
public class IntegerSchoolAttributeMetadata extends SchoolAttributeMetadata {

	/**
	 * The minimum value this attribute can have. Defaults to 0.
	 */
	private int min = 0;
	
	/**
	 * The maximum value this attribute can have. Defaults to {@link java.lang.Integer#MAX_VALUE}.
	 */
	private int max = Integer.MAX_VALUE;
	
	/**
	 * Creates a new IntegerSchoolAttributeMetadata object with default range.
	 * @param name the name of the School attribute represented
	 */
	public IntegerSchoolAttributeMetadata(String name) {
		super(name);
	}
	
	/**
	 * Creates a new IntegerSchoolAttributeMetadata object with the specified name and range.
	 * @param name the name of the School attribute represented
	 * @param min this attribute's minimum
	 * @param max this attribute's maximum
	 */
	public IntegerSchoolAttributeMetadata(String name, int min, int max) {
		super(name);
		this.min = min;
		this.max = max;
	}
	
	/**
	 * Public access method for {@link IntegerSchoolAttributeMetadata#min}.
	 * @return this attribute's minimum
	 */
	public int getMin() {
		return this.min;
	}
	
	/**
	 * Public access method for {@link IntegerSchoolAttributeMetadata#max}.
	 * @return this attribute's maximum
	 */
	public int getMax() {
		return this.max;
	}
	
	/**
	 * {@inheritDoc}
	 * Returns 'i' for IntegerSchoolAttributeMetadata.
	 */
	@Override
	public char getType() {
		return 'i';
	}

}
