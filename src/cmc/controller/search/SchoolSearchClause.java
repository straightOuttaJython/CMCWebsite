package cmc.controller.search;

import cmc.entity.dbmapping.DoubleSchoolAttributeMetadata;
import cmc.entity.dbmapping.IntegerSchoolAttributeMetadata;
import cmc.entity.dbmapping.SchoolAttributeMetadata;
import cmc.entity.dbmapping.SchoolDatabaseMapping;
import cmc.entity.dbmapping.StringSchoolAttributeMetadata;

public class SchoolSearchClause {

	private SchoolSearchTerm[] terms;
	
	public SchoolSearchClause() {
		this.terms = new SchoolSearchTerm[17];
		for (int i=0; i<17; i++) {
			SchoolAttributeMetadata metadata = SchoolDatabaseMapping.MAPPING[i];
			SchoolSearchTerm term = null;
			switch (metadata.getType()) {
				case 's':	term = new StringSchoolSearchTerm(i,((StringSchoolAttributeMetadata)metadata).getPermittedValues());
							break;
				case 'i':	term = new IntegerSchoolSearchTerm(i,((IntegerSchoolAttributeMetadata)metadata).getMin(),
																 ((IntegerSchoolAttributeMetadata)metadata).getMax());
							break;
				case 'd':	term = new DoubleSchoolSearchTerm(i,((DoubleSchoolAttributeMetadata)metadata).getMin(),
						 										((DoubleSchoolAttributeMetadata)metadata).getMax());
							break;
				case 'a':	term = new StringArraySchoolSearchTerm(i);
							break;
			}
			terms[i] = term;
		}
	}
	
	public SchoolSearchClause(String[] school, String emphases) {
		this.terms = new SchoolSearchTerm[17];
		for (int i=0; i<17; i++) {
			SchoolAttributeMetadata metadata = SchoolDatabaseMapping.MAPPING[i];
			SchoolSearchTerm term = null;
			switch (metadata.getType()) {
				case 's':	term = new StringSchoolSearchTerm(i,((StringSchoolAttributeMetadata)metadata).getPermittedValues());
							term.setValue(school[i]);
							break;
				case 'i':	term = new IntegerSchoolSearchTerm(i,((IntegerSchoolAttributeMetadata)metadata).getMin(),
																 ((IntegerSchoolAttributeMetadata)metadata).getMax());

							term.setValue(school[i]);
							break;
				case 'd':	term = new DoubleSchoolSearchTerm(i,((DoubleSchoolAttributeMetadata)metadata).getMin(),
						 										((DoubleSchoolAttributeMetadata)metadata).getMax());
							term.setValue(school[i]);
							break;
				case 'a':	term = new StringArraySchoolSearchTerm(i);
							term.setValue(emphases);
							break;
			}			
			terms[i] = term;
		}
	}
	
	public void setValueAtIndex(String value, int index) {
		terms[index].setValue(value);
	}
	
	public double scoreSchoolData(String[] school, String emphases) {
		double dividend = 0;
		double divisor = 0;
		for (int i=0; i<17; i++) {
			SchoolSearchTerm term = terms[i];
			if (term.isIncluded()) {
				divisor++;
				if (SchoolDatabaseMapping.MAPPING[i].getType()=='a') {
					dividend+=term.calculateMatch(emphases);
				}
				else {
					dividend+=term.calculateMatch(school[i]);
				}
			}
		}
		assert dividend > divisor : "dividend:"+dividend+" divisor:"+divisor;
		return dividend/divisor;
	}
	
}
