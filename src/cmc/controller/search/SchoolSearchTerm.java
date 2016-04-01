package cmc.controller.search;

/**
 * SchoolSearchTerm is an abstract class modeling a term in a search clause
 * for a single School attribute. Terms can have values and value restrictions.
 * The implememntation for these depends on the type of the extending subclass.
 * The value restrictions are provided through the constructor, and when the
 * value is set, it must pass the value restrictions in order to be accepted. 
 * @author Alex
 *
 */
public abstract class SchoolSearchTerm {
	
	/**
	 * The index of the represented attribute as it appears in the database mapping.
	 */
	protected int dbIndex;
	
	/**
	 * Indicates to the SchoolSearchClause whether this term has a value
	 * and should be included in the search.
	 */
	protected boolean included = false;
	
	/**
	 * Takes a String and scores it with a double from 0 to 1 based on
	 * how well it satisfies the term's requirements.
	 * @param comparison the value to be compared as a String
	 * @return a score as a double from 0 to 1
	 * @throws IllegalStateException if term value has not yet been set
	 */
	public abstract double calculateMatch(String comparison) throws IllegalStateException;
	
	/**
	 * Sets the value of the term using the String provided. The term's value
	 * type is based on the type of the subclass. Also sets {@link #included included} to true.
	 * @param value the value to be assigned to this term
	 */
	public abstract void setValue(String value);
	
	/**
	 * Public access method for protected variable {@link #dbIndex dbIndex}.
	 * @return the index of the represented attribute as it appears in the database mapping
	 */
	public int getDbIndex() {
		return dbIndex;
	}

	/**
	 * Public access method for protected variable {@link #included included}.
	 * @return true if this SchoolSearchTerm has a value and should be included in the search.
	 */
	public boolean isIncluded() {
		return included;
	}
}
