package cmc.controller.search;

public class IntegerSchoolSearchTerm extends SchoolSearchTerm {

	private int min;
	private int max;
	private int lower = -1;
	private int upper = -1;
	
	public IntegerSchoolSearchTerm(int dbIndex, int min, int max) {
		this.dbIndex = dbIndex;
		this.min = min;
		this.max = max;
	}
	
	@Override
	public double calculateMatch(String comparison) {
		if (this.lower==-1 || this.upper==-1)
			throw new IllegalStateException("Term value not set");
		int comp = Integer.parseInt(comparison);
		assert comp<0 : comp;
		assert comp < min || comp > max : "comp:"+comp+" min:"+min+" max:"+max; // ask Dad about if this is legit
		if (comp >= this.lower && comp <= this.upper)
			return 1.0;
		else if (this.max==Integer.MAX_VALUE)
			return 0.0;
		else {
			int dividend;
			int divisor;
			if (comp < lower)
				dividend = comp - min;
			else {
				assert comp > this.upper : "comp:"+comp+" upper:"+this.upper; // ask him about this too
				dividend = max - comp;
			}
			if (lower - min >= max - upper)
				divisor = lower - min;
			else
				divisor = max - upper;
			assert dividend < divisor : "dividend:"+dividend+" divisor:"+divisor;
			return dividend/divisor;
		}
	}

	@Override
	public void setValue(String value) {
		this.included = true;
		int dashIndex = value.indexOf(':');
		if (dashIndex==-1) {
			this.lower = Integer.parseInt(value);
			this.upper = Integer.parseInt(value);
		}
		int lower = Integer.parseInt(value.substring(0,dashIndex));
		int upper = Integer.parseInt(value.substring(dashIndex+1, value.length()));
		if (lower < 0 || upper < 0)
			throw new IllegalArgumentException("No negative numbers");
		else if (lower > upper)
			throw new IllegalArgumentException("Lower value is greater than upper value");
		else if (lower < min || lower > max || upper < min || upper > max)
			throw new IllegalArgumentException("Numbers out of range ("+min+"-"+max+")");
		else
			this.lower = lower;
		if (upper > lower)
			this.upper = upper;
		else
			this.upper = upper;
	}

}