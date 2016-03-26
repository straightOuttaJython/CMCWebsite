package cmc.entity.dbmapping;

public class StringArraySchoolAttributeMetadata extends SchoolAttributeMetadata {
	
	public StringArraySchoolAttributeMetadata(String name) {
		super(name);
	}
	
	@Override
	public char getType() {
		return 'a';
	}

}
