package cmc.entity.dbmapping;

public class StringSchoolAttributeMetadata extends SchoolAttributeMetadata {

	private String[] permittedValues = null;
	
	public StringSchoolAttributeMetadata(String name) {
		super(name);
	}
	
	public StringSchoolAttributeMetadata(String name, String[] permittedValues) {
		super(name);
		this.permittedValues = permittedValues;
	}

	public String[] getPermittedValues() {
		return permittedValues;
	}
	
	@Override
	public char getType() {
		return 's';
	}

}
