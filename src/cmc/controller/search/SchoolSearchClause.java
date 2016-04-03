package cmc.controller.search;

import cmc.entity.dbmapping.DoubleSchoolAttributeMetadata;
import cmc.entity.dbmapping.IntegerSchoolAttributeMetadata;
import cmc.entity.dbmapping.SchoolAttributeMetadata;
import cmc.entity.dbmapping.SchoolDatabaseMapping;
import cmc.entity.dbmapping.StringSchoolAttributeMetadata;

/**
 * SchoolSearchClause is a collection of SchoolSearchTerms used for scoring database-representation
 * schools against the user's search input.
 * @author Alex
 * @version 4/1/16
 */
public class SchoolSearchClause {

	/**
	 * An array of SchoolSearchTerms used by this SchoolSearchClause in evaluating search candidates
	 */
	private SchoolSearchTerm[] terms;
	
	/**
	 * Constructs a new SchoolSearchClause consisting of empty SearchTerms.
	 */
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
	
	/**
	 * Constructs a new SchoolSearchClause consisting of SearchTerms with the corresponding values given.
	 * @param school an array of school attributes in String form
	 * @param emphases a String of emphases delineated by colons (':')
	 */
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
	
	/**
	 * Calls {@link cmc.controller.search.SchoolSearchTerm#setValue(String)} on the given index
	 * with the given value as the argument.
	 * @param value the value argument for the method call
	 * @param index the index of the SchoolSearchTerm to be set
	 */
	public void setValueAtIndex(String value, int index) {
		terms[index].setValue(value);
	}
	
	/**
	 * Takes attribute information for a candidate school and returns a double
	 * representing its average score against each SchoolSearchTerm included in
	 * this SchoolSearchClause.
	 * @param school an array of school attributes in String form
	 * @param emphases a String of emphases delineated by colons (':')
	 * @return the given school's score against this SchoolSearchClause represented
	 * as a double from 0.0 to 1.0
	 * @throws IllegalStateException if no SchoolSearchTerms are included in this SchoolSearchClause 
	 */
	public double scoreSchoolData(String[] school, String emphases) throws IllegalStateException {
		double dividend = 0;
		double divisor = 0;
		for (int i=0; i<17; i++) {
			SchoolSearchTerm term = terms[i];
			if (term.isIncluded()) {
				divisor++;
				if (SchoolDatabaseMapping.MAPPING[i].getType()=='a')
					dividend+=term.calculateMatch(emphases);
				else
					dividend+=term.calculateMatch(school[i]);
			}
		}
		if (divisor==0) {
			throw new IllegalStateException("No SearchTerms set");
		}
		return dividend/divisor;
	}
	
}
