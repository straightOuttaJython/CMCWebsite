package cmc.entity.dbmapping;

public abstract class SchoolAttributeMetadata {
	
	protected String name;
	
	public SchoolAttributeMetadata(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	// return 's','i','d','a' depending  on type
	public abstract char getType();
	
}
