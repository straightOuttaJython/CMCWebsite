package cmc.controller.search;

import cmc.entity.School;

public class SearchResult implements Comparable<SearchResult> {
	
	private double score;
	private School school;
	
	public SearchResult(double score, School associatedSchool) {
		super();
		this.score = score;
		this.school = associatedSchool;
	}
	
	public double getScore() {
		return this.score;
	}

	public School getSchool() {
		return school;
	}

	@Override
	public int compareTo(SearchResult sR) {
		return new Double(score).compareTo(new Double(sR.getScore()));
	}
}
