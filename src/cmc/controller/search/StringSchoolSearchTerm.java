package cmc.controller.search;
import java.util.IllegalFormatException;

public class StringSchoolSearchTerm extends SchoolSearchTerm {

	private String[] permittedValues;
	private String value = null;
	
	public StringSchoolSearchTerm(int dbIndex, String[] permittedValues) {
		this.dbIndex = dbIndex;
		this.permittedValues = permittedValues;
	}
	
	@Override
	public double calculateMatch(String comparison) {
		if (this.value==null)
			throw new IllegalStateException("Term value not set");
		comparison = comparison.toUpperCase();
		if (permittedValues==null) {
			if (value.contains(comparison))
				return 1.0;
			else
				return 0.0;
		}
		else {
			for (String per : permittedValues) {
				if (comparison.equals(per))
					return 1.0;
			}
			return 0.0;
		}
	}
	
	@Override
	public void setValue(String value) {
		this.included = true;
		value = value.toUpperCase();
		if (permittedValues!=null) {
			for (String per : permittedValues) {
				if (value.equals(per))
					this.value = value;
			}
			if (this.value==null)
				throw new IllegalArgumentException("That String is not permitted here");
		}
		this.value = value;
	}
}