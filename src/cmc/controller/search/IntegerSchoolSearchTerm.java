package cmc.controller.search;

/**
 * This is an implementation for the SchoolSearchTerm class for integer
 * values. The values can be single values or ranges.
 * @author Alex
 *
 */
public class IntegerSchoolSearchTerm extends SchoolSearchTerm {

	/**
	 * The minimum permitted value this term can have.
	 */
	private int min;
	
	/**
	 * The maximum permitted value this term can have.
	 */
	private int max;
	
	/**
	 * The lower bound for this term's range value.
	 */
	private int lower = -1;
	
	/**
	 * The upper bound for this term's range value.
	 */
	private int upper = -1;
	
	/**
	 * Constructs a new IntegerSchoolSearchTerm with the specified fields.
	 * @param dbIndex the index of the represented attribute as it appears in the database mapping
	 * @param min the minimum permitted value this term can have
	 * @param max the maximum permitted value this term can have
	 * @throws IllegalArgumentException if min is greater than max
	 */
	public IntegerSchoolSearchTerm(int dbIndex, int min, int max) throws IllegalArgumentException {
		this.dbIndex = dbIndex;
		if (min > max)
			throw new IllegalArgumentException("Minimum value is greater than maximum value");
		this.min = min;
		this.max = max;
	}
	
	/**
	 * {@inheritDoc SchoolSearchTerm#calculateMatch(String)}
	 * For IntegerSchoolSearchTerm, the method will return 1 for any value within
	 * the term's range value, 0 for the furthest possible value from the range,
	 * and a linear gradient from 0 to 1 for intermediate values.
	 * @throws NumberFormatException if the given String cannot be parsed by the method
	 * {@link java.lang.Integer#parseInt(String) Integer.parseInt(String)}
	 * @throws IllegalArgumentException if the given String represents a number outside this term's restricted range
	 */
	@Override
	public double calculateMatch(String comparison) throws NumberFormatException, IllegalArgumentException {
		if (this.lower==-1 || this.upper==-1)
			throw new IllegalStateException("Term value not set");
		int comp = Integer.parseInt(comparison);
		if (comp < min || comp > max)
			throw new IllegalArgumentException("Outside of valid range for this term ("+min+"-"+max+")");
		if (comp >= this.lower && comp <= this.upper)
			return 1.0;
		else if (this.max==Integer.MAX_VALUE)
			return 0.0;
		else {
			int divisor = Integer.max(lower - min, max - upper);
			int dividend = comp < lower ? divisor - (lower - comp) : divisor - (comp - upper);
			return (double)dividend/divisor;
		}
	}

	/**
	 * {@inheritDoc SchoolSearchTerm#setValue(String)}
	 * For IntegerSchoolSearchTerm, the method takes a String value representing a single double or a range 
	 * delineated by a colon (':'), e.g., "0:5", "15:16", "21:21", etc. A valid range from
	 * {@code lower} to {@code upper} must be true for {@code (lower =< upper && lower >= this.min 
	 * || upper =< this.max)}
	 * @throws IllegalArgumentException if the given String cannot be parsed to a valid integer range.
	 */
	@Override
	public void setValue(String value) throws IllegalArgumentException {
		this.included = true;
		int dashIndex = value.indexOf(':');
		int lower;
		int upper;
		if (dashIndex==-1) {
			lower = Integer.parseInt(value);
			upper = Integer.parseInt(value);
		}
		else {
			lower = Integer.parseInt(value.substring(0,dashIndex));
			upper = Integer.parseInt(value.substring(dashIndex+1, value.length()));
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