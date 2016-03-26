package cmc.entity.dbmapping;

public class DoubleSchoolAttributeMetadata extends SchoolAttributeMetadata {

	private double min = 0;
	private double max = Double.MAX_VALUE;
	
	public DoubleSchoolAttributeMetadata(String name) {
		super(name);
	}
	
	public DoubleSchoolAttributeMetadata(String name, double min, double max) {
		super(name);
		this.min = min;
		this.max = max;
	}
	
	public double getMin() {
		return this.min;
	}
	
	public double getMax() {
		return this.max;
	}
	
	@Override
	public char getType() {
		return 'd';
	}

}