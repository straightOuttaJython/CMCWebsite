package cmc.entity.dbmapping;

/**
 * An implementation of SchoolAttributeMetadata for representing 
 * double fields in the School class.
 * @author Alex
 * @version 3/27/16
 */
public class DoubleSchoolAttributeMetadata extends SchoolAttributeMetadata {

	/**
	 * The minimum value this attribute can have. Defaults to 0.
	 */
	private double min = 0;
	
	/**
	 * The maximum value this attribute can have. Defaults to {@link java.lang.Double#MAX_VALUE}.
	 */
	private double max = Double.MAX_VALUE;
	
	/**
	 * Creates a new DoubleSchoolAttributeMetadata object with default range.
	 * @param name the name of the School attribute represented
	 */
	public DoubleSchoolAttributeMetadata(String name) {
		super(name);
	}
	
	/**
	 * Creates a new DoubleSchoolAttributeMetadata object with the specified name and range.
	 * @param name the name of the School attribute represented
	 * @param min this attribute's minimum
	 * @param max this attribute's maximum
	 */
	public DoubleSchoolAttributeMetadata(String name, double min, double max) {
		super(name);
		this.min = min;
		this.max = max;
	}
	
	/**
	 * Public access method for {@link DoubleSchoolAttributeMetadata#min}.
	 * @return this attribute's minimum
	 */
	public double getMin() {
		return this.min;
	}
	
	/**
	 * Public access method for {@link DoubleSchoolAttributeMetadata#max}.
	 * @return this attribute's maximum
	 */
	public double getMax() {
		return this.max;
	}
	
	/**
	 * {@inheritDoc}
	 * Returns 'd' for DoubleSchoolAttributeMetadata.
	 */
	@Override
	public char getType() {
		return 'd';
	}

}