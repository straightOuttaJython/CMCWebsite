package cmc.controller.search;

/**
 * This is an implementation for the SchoolSearchTerm class for double
 * values. The values can be single values or ranges.
 * @author Alex
 * @version 4/1/16
 */
public class DoubleSchoolSearchTerm extends SchoolSearchTerm {

	/**
	 * The minimum permitted value this term can have.
	 */
	private double min;
	
	/**
	 * The maximum permitted value this term can have.
	 */
	private double max;
	
	/**
	 * The lower bound for this term's range value.
	 */
	private double lower = -1;
	
	/**
	 * The upper bound for this term's range value.
	 */
	private double upper = -1;
	
	/**
	 * Constructs a new DoubleSchoolSearchTerm with the specified fields.
	 * @param dbIndex the index of the represented attribute as it appears in the database mapping
	 * @param min the minimum permitted value this term can have
	 * @param max the maximum permitted value this term can have
	 * @throws IllegalArgumentException if min is greater than max
	 */
	public DoubleSchoolSearchTerm(int dbIndex, double min, double max) throws IllegalArgumentException {
		this.dbIndex = dbIndex;
		if (min > max)
			throw new IllegalArgumentException("Minimum value is greater than maximum value");
		this.min = min;
		this.max = max;
	}
	
	/**
	 * {@inheritDoc SchoolSearchTerm#calculateMatch(String)}
	 * For IntegerSchoolSearchTerm, the method will return 1 for any value within
	 * the term's range value, 0 for the farthest possible value from the range,
	 * and a linear gradient from 0 to 1 for intermediate values.
	 * @throws NumberFormatException if the given String cannot be parsed by the method
	 * {@link java.lang.Double#parseDouble(String) Double.parseDouble(String)}
	 * @throws IllegalArgumentException if the given String represents a number outside this term's restricted range
	 */
	@Override
	public double calculateMatch(String comparison) throws NumberFormatException, IllegalArgumentException {
		if (this.lower==-1 || this.upper==-1)
			throw new IllegalStateException("Term value not set");
		double comp = Double.parseDouble(comparison);
		if (comp == -1.0) {
			return 0.0;
		}
		if (comp < min || comp > max)
			return 0.0;
		if (comp >= this.lower && comp <= this.upper)
			return 1.0;
		else if (this.max==Double.MAX_VALUE)
			return 0.0;
		else {
			double divisor = Double.max(lower - min, max - upper);
			double dividend = comp < lower ? divisor - (lower - comp) : divisor - (comp - upper);
			return dividend/divisor;
		}
	}

	/**
	 * {@inheritDoc SchoolSearchTerm#setValue(String)}
	 * For DoubleSchooSearchTerm, the method takes a String value representing a single double or a range 
	 * delineated by a colon (':'), e.g., "0:5.1", "15.4:16.8", "21.3:21.3", etc. A valid range from 
	 * {@code lower} to {@code upper} must be true for {@code (lower =< upper && lower >= this.min 
	 * || upper =< this.max)}
	 * @throws IllegalArgumentException if the given String cannot be parsed to a valid double range.
	 */
	@Override
	public void setValue(String value) {
		this.included = true;
		int dashIndex = value.indexOf(':');
		double lower;
		double upper;
		if (dashIndex==-1) {
			lower = Double.parseDouble(value);
			upper = Double.parseDouble(value);
		}
		else {
			lower = Double.parseDouble(value.substring(0,dashIndex));
			upper = Double.parseDouble(value.substring(dashIndex+1, value.length()));
		}
		if (lower > upper)
			throw new IllegalArgumentException("Lower value is greater than upper value");
		else if (lower < min || upper > max)
			throw new IllegalArgumentException("Numbers out of range ("+min+"-"+max+")");
		else {
			this.lower = lower;
			this.upper = upper;
		}
	}

}