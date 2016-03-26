package cmc.controller.search;

public class DoubleSchoolSearchTerm extends SchoolSearchTerm {

	private double min = 0;
	private double max = Double.MAX_VALUE;
	private double lower = -1;
	private double upper = -1;
	
	public DoubleSchoolSearchTerm(int dbIndex, double min, double max) {
		this.dbIndex = dbIndex;
		this.min = min;
		this.max = max;
	}
	
	public DoubleSchoolSearchTerm(int dbIndex) {
		this.dbIndex = dbIndex;
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
		else {
			double dividend;
			double divisor;
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
		int dashIndex = value.indexOf(':');
		double lower = Double.parseDouble(value.substring(0,dashIndex));
		double upper = Double.parseDouble(value.substring(dashIndex+1, value.length()));
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
