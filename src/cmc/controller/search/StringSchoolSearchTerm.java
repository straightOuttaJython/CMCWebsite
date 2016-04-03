package cmc.controller.search;
import java.util.IllegalFormatException;

/**
 * This is an implementation for the SchoolSearchTerm class for String
 * values. Values may be optionally restricted to a set of permitted values.
 * @author Alex
 * @version 4/1/16
 */
public class StringSchoolSearchTerm extends SchoolSearchTerm {

	/**
	 * An array containing all possible Strings this term may have as a value.
	 * If null, this term has no value restriction.
	 */
	private String[] permittedValues;
	
	/**
	 * The value of this search term. 
	 */
	private String value = null;
	
	/**
	 * Creates a new StringSchoolSearchTerm with the the specified fields.
	 * @param dbIndex the index of the represented attribute as it appears in the database mapping
	 * @param permittedValues an array of all possible Strings this term may have as a value
	 */
	public StringSchoolSearchTerm(int dbIndex, String[] permittedValues) {
		this.dbIndex = dbIndex;
		this.permittedValues = permittedValues;
	}
	
	/**
	 * {@inheritDoc SchoolSearchTerm#calculateMatch(String)}
	 * If this term has value restrictions, the comparison String must match the term's
	 * value exactly. If not, the comparison String only needs to contain the term.
	 */
	@Override
	public double calculateMatch(String comparison) {
		if (this.value==null)
			throw new IllegalStateException("Term value not set");
		comparison = comparison.toUpperCase();
		if (this.permittedValues!=null) {
			for (String per : this.permittedValues) {
				if (comparison.equals(per.toUpperCase()))
					return value.equals(comparison) ? 1.0 : 0.0;
			}
			throw new IllegalArgumentException("Not a permitted String");
		}
		else
			return value.contains(comparison) ? 1.0 : 0.0;
	}
	
	/**
	 * @throws IllegalArgumentException if the String is not permitted by the term's value restriction. 
	 */
	@Override
	public void setValue(String value) throws IllegalArgumentException {
		this.included = true;
		value = value.toUpperCase();
		if (this.permittedValues!=null) {
			for (String per : this.permittedValues) {
				if (value.equals(per.toUpperCase()))
					this.value = value;
			}
			if (this.value==null)
				throw new IllegalArgumentException("That String is not permitted here");
		}
		else {
			this.value = value;
		}
	}
}