package cmc.entity.dbmapping;

public class IntegerSchoolAttributeMetadata extends SchoolAttributeMetadata {

	private int min = 0;
	private int max = Integer.MAX_VALUE;
	
	public IntegerSchoolAttributeMetadata(String name) {
		super(name);
	}
	
	public IntegerSchoolAttributeMetadata(String name, int min, int max) {
		super(name);
		this.min = min;
		this.max = max;
	}
	
	public int getMin() {
		return this.min;
	}
	
	public int getMax() {
		return this.max;
	}
	
	@Override
	public char getType() {
		return 'i';
	}

}
