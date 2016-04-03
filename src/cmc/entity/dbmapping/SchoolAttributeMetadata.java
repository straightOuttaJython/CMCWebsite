package cmc.entity.dbmapping;

/**
 * SchoolAttributeMetadata holds relevant information for a School attribute.
 * @author Alex
 * @version 3/27/16
 */
public abstract class SchoolAttributeMetadata {
	
	/**
	 * The name of the School attribute represented
	 */
	protected String name;
	
	/**
	 * Constructs a new SchoolAttributeMetadata object with the given name.
	 * @param name the name of the School attribute represented
	 */
	public SchoolAttributeMetadata(String name) {
		this.name = name;
	}

	/**
	 * Public access method for {@link SchoolAttributeMetadata#name}.
	 * @return the name of the School attribute represented
	 */
	public String getName() {
		return name;
	}

	/**
	 * Returns a char representing the data type of this SchoolAttributeMetadata.
	 * @return a char representing the this SchoolAttributeMetadata's type
	 */
	public abstract char getType();
	
}
