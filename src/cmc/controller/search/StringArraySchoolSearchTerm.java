package cmc.controller.search;

public class StringArraySchoolSearchTerm extends SchoolSearchTerm {

	private String[] value;
	
	@Override
	public double calculateMatch(String comparison) {
		if (this.value==null)
			throw new IllegalStateException("Term value not set");
		String[] comp = comparison.split(":");
		int dividend = 0;
		int divisor = comp.length;
		for (String c : comp) {
			for (String v : value) {
				if (c.toUpperCase().equals(v.toUpperCase()))
						dividend++;
			}
		}
		dividend/=2;
		assert dividend <= divisor : "dividend:"+dividend+" divisor:"+divisor;
		return dividend/divisor;
	}

	@Override
	public void setValue(String value) {
		this.value = value.split(":");
	}

}
