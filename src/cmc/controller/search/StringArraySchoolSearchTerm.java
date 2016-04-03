package cmc.controller.search;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

/**
 * This is an implementation for the SchoolSearchTerm class for String
 * array values.
 * @author Alex
 * @version 4/1/16
 */
public class StringArraySchoolSearchTerm extends SchoolSearchTerm {

	/**
	 * The value of this search term.
	 */
	private String[] value;
	
	/**
	 * Creates a new StringArraySchoolSearchTerm with the the specified fields.
	 * @param dbIndex the index of the represented attribute as it appears in the database mapping
	 */
	public StringArraySchoolSearchTerm(int dbIndex) {
		this.dbIndex = dbIndex;
	}
	
	/**
	 * {@inheritDoc SchoolSearchTerm#calculateMatch(String)}
	 * For StringArraySchoolSearchTerm, the method interprets the given String as an array
	 * with elements delineated by a colon (':'), e.g., "Planes:Trains:Automobiles", 
	 * "Lions:Tigers:Bears:Oh my", etc. The result is a fractional value:
	 * (number of matching Strings in comparison)/(total number of Strings in value array).
	 */
	@Override
	public double calculateMatch(String comparison) {
		if (this.value==null)
			throw new IllegalStateException("Term value not set");
		String[] comp = comparison.split(":");
		comp = removeDuplicates(comp);
		double dividend = 0;
		double divisor = value.length;
		for (String c : comp) {
			for (String v : value) {
				if (c.toUpperCase().equals(v.toUpperCase()))
						dividend++;
			}
		}
		return dividend/divisor;
	}

	/**
	 * {@inheritDoc SchoolSearchTerm#setValue(String)}
	 * For StringArraySchoolSearchTerm, the method interprets the given String as an array
	 * with elements delineated by a colon (':'), e.g., "Planes:Trains:Automobiles", 
	 * "Lions:Tigers:Bears:Oh my", etc.
	 */
	@Override
	public void setValue(String value) {
		this.included = true;
		this.value = value.split(":");
		this.value = removeDuplicates(this.value);
	}

	private String[] removeDuplicates(String[] array) {
		HashSet<String> set = new HashSet<String>(Arrays.asList(array));
		String[] newArray = new String[set.size()];
		Iterator<String> iter = set.iterator();
		for (int i=0; i<set.size(); i++) {
			newArray[i] = iter.next();
		}
		return newArray;
	}
}
