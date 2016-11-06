package com.imdb.demo;

import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.*;

import com.imdb.pages.ResultsByGenrePage;

public class ResultsByGenreTest {
	
	private static final int MINIMUM_RESULTS_EXPECTED 			= 1;
	private static final String POPULARITY_FILTER_LABEL 		= "Popularity";
	private static final String ALPHABETICAL_FILTER_LABEL 		= "Alphabetical";
	private static final String IMDB_RATING_FILTER_LABEL 		= "IMDb Rating";
	private static final String NUMBER_OF_VOTES_FILTER_LABEL 	= "Number of Votes";
	private static final String US_BOX_OFFICE_FILTER_LABEL 		= "US Box Office";
	private static final String RUNTIME_FILTER_LABEL 			= "Runtime";
	private static final String YEAR_FILTER_LABEL 				= "Year";
	private static final String RELEASE_DATE_FILTER_LABEL 		= "Release Date";
	
	ResultsByGenrePage rbgp = new ResultsByGenrePage();
	
	@Test
	@Parameters("genre")
	public void isResultsByGenrePageLoaded(String genre){
		assertThat(rbgp.getCurrentURL()).contains(rbgp.getBaseUrl() + genre.toLowerCase());
	}
	
	@Test (dependsOnMethods= { "isResultsByGenrePageLoaded" })
	public void areInitialResultsLoaded(){
		assertThat(rbgp.getNumberOfResultsLoaded()).isGreaterThan(MINIMUM_RESULTS_EXPECTED);
	}
	
	@Test (dependsOnMethods= { "areInitialResultsLoaded" })
	public void sortByPopularity() {
		rbgp.clickSortOption(POPULARITY_FILTER_LABEL);
		assertThat(rbgp.getNumberOfResultsLoaded()).isGreaterThan(MINIMUM_RESULTS_EXPECTED);
	}
	
	@Test (dependsOnMethods= { "areInitialResultsLoaded" })
	public void sortByAlphabetical() {
		rbgp.clickSortOption(ALPHABETICAL_FILTER_LABEL);
		assertThat(rbgp.getNumberOfResultsLoaded()).isGreaterThan(MINIMUM_RESULTS_EXPECTED);
	}
	
	@Test (dependsOnMethods= { "areInitialResultsLoaded" })
	public void sortByIMDBRating() {
		rbgp.clickSortOption(IMDB_RATING_FILTER_LABEL);
		assertThat(rbgp.getNumberOfResultsLoaded()).isGreaterThan(MINIMUM_RESULTS_EXPECTED);
	}
	
	@Test (dependsOnMethods= { "areInitialResultsLoaded" })
	public void sortByNumberOfVotes() {
		rbgp.clickSortOption(NUMBER_OF_VOTES_FILTER_LABEL);
		assertThat(rbgp.getNumberOfResultsLoaded()).isGreaterThan(MINIMUM_RESULTS_EXPECTED);
	}
	
	@Test (dependsOnMethods= { "areInitialResultsLoaded" })
	public void sortByUSBoxOffice() {
		rbgp.clickSortOption(US_BOX_OFFICE_FILTER_LABEL);
		assertThat(rbgp.getNumberOfResultsLoaded()).isGreaterThan(MINIMUM_RESULTS_EXPECTED);
	}
	
	@Test (dependsOnMethods= { "areInitialResultsLoaded" })
	public void sortByRuntime() {
		rbgp.clickSortOption(RUNTIME_FILTER_LABEL);
		assertThat(rbgp.getNumberOfResultsLoaded()).isGreaterThan(MINIMUM_RESULTS_EXPECTED);
	}
	
	@Test (dependsOnMethods= { "areInitialResultsLoaded" })
	public void sortByYear() {
		rbgp.clickSortOption(YEAR_FILTER_LABEL);
		assertThat(rbgp.getNumberOfResultsLoaded()).isGreaterThan(MINIMUM_RESULTS_EXPECTED);
	}
	
	@Test (dependsOnMethods= { "areInitialResultsLoaded" })
	public void sortByReleaseDate() {
		rbgp.clickSortOption(RELEASE_DATE_FILTER_LABEL);
		assertThat(rbgp.getNumberOfResultsLoaded()).isGreaterThan(MINIMUM_RESULTS_EXPECTED);
	}
	
	//further tests for results by genre page go here...
	
}