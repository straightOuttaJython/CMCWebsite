package test.controller;

import org.junit.Test;

import cmc.controller.SearchController;
import cmc.controller.search.SchoolSearchClause;
import cmc.entity.School;

public class SearchControllerTestOnDB {

	@Test
	public void testSearch() {
		SearchController sc = new SearchController();
		SchoolSearchClause sClause = new SchoolSearchClause();
		sClause.setValueAtIndex("200:600", 6);
		School[] results = sc.search(sClause);
		for (School s: results) {
			System.out.println(s.getName());
		}
	}

}
