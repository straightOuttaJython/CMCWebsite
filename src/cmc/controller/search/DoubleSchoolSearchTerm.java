package cmc.controller.search;

public class DoubleSchoolSearchTerm extends SchoolSearchTerm {

	private double min;
	private double max;
	private double lower = -1;
	private double upper = -1;
	
	public DoubleSchoolSearchTerm(int dbIndex, double min, double max) {
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
		double comp = Double.parseDouble(comparison);
		assert comp<0 : comp;
		assert comp < min || comp > max : "comp:"+comp+" min:"+min+" max:"+max;
		if (comp >= this.lower && comp <= this.upper)
			return 1.0;
		else if (this.max==Double.MAX_VALUE)
			return 0.0;
		else {
			double dividend;
			double divisor;
			divisor = Double.max(lower - min, max - upper);
			dividend = comp < lower ? divisor - (lower - comp) : divisor - (comp - upper);
			return dividend/divisor;
		}
	}

	@Override
	public void setValue(String value) {
		this.included = true;
		int dashIndex = value.indexOf(':');
		if (dashIndex==-1) {
			this.lower = Double.parseDouble(value);
			this.upper = Double.parseDouble(value);
			return;
		}
		double lower = Double.parseDouble(value.substring(0,dashIndex));
		double upper = Double.parseDouble(value.substring(dashIndex+1, value.length()));
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
