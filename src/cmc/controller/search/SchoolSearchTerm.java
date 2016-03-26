package cmc.controller.search;

public abstract class SchoolSearchTerm {
	
	protected int dbIndex;
	protected boolean included = false;
	
	public abstract double calculateMatch(String comparison);
	
	public abstract void setValue(String value);
	
	public int getDbIndex() {
		return dbIndex;
	}

	public boolean isIncluded() {
		return included;
	}
}