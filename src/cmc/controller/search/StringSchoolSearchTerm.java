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
		if (this.permittedValues!=null)
			return value.equals(comparison) ? 1.0 : 0.0;
		else
			return value.contains(comparison) ? 1.0 : 0.0;
	}
	
	@Override
	public void setValue(String value) {
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