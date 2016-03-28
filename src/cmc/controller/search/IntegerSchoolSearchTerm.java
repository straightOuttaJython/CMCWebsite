package cmc.controller.search;

public class IntegerSchoolSearchTerm extends SchoolSearchTerm {

	private int min;
	private int max;
	private int lower = -1;
	private int upper = -1;
	
	public IntegerSchoolSearchTerm(int dbIndex, int min, int max) {
		this.dbIndex = dbIndex;
		if (min > max)
			throw new IllegalArgumentException("Minimum value is greater than maximum value");
		this.min = min;
		this.max = max;
	}
	
	@Override
	public double calculateMatch(String comparison) {
		if (this.lower==-1 || this.upper==-1)
			throw new IllegalStateException("Term value not set");
		int comp = Integer.parseInt(comparison);
		assert comp<0 : comp;
		assert comp < min || comp > max : "comp:"+comp+" min:"+min+" max:"+max;
		if (comp >= this.lower && comp <= this.upper)
			return 1.0;
		else if (this.max==Integer.MAX_VALUE)
			return 0.0;
		else {
			int dividend;
			int divisor;
			divisor = Integer.max(lower - min, max - upper);
			dividend = comp < lower ? divisor - (lower - comp) : divisor - (comp - upper);
			return (double)dividend/divisor;
		}
	}

	@Override
	public void setValue(String value) {
		this.included = true;
		int dashIndex = value.indexOf(':');
		if (dashIndex==-1) {
			this.lower = Integer.parseInt(value);
			this.upper = Integer.parseInt(value);
			return;
		}
		int lower = Integer.parseInt(value.substring(0,dashIndex));
		int upper = Integer.parseInt(value.substring(dashIndex+1, value.length()));
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