package com.imdb.demo;

import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.*;

import com.imdb.pages.TopChartsPage;

public class TopChartsPageTest {
	
	private static int MINIMUM_RESULTS_EXPECTED = 1;
	
	TopChartsPage tcp = new TopChartsPage();
	
	@Test
	public void isTopChartsPageLoaded(){
		assertThat(tcp.getPageTitle()).isEqualTo(tcp.getExpectedTitle());
	}
	
	@Test (dependsOnMethods= { "isTopChartsPageLoaded" })
	public void areInitialResultsLoaded() {
		assertThat(tcp.getNumberOfResultsLoaded()).isGreaterThan(MINIMUM_RESULTS_EXPECTED);
	}
	
	@Test (groups = { "resultCount" })
	public void selectByNumberOfRatings(){
		tcp.selectSortByNumberOfRatings();
		assertThat(tcp.getNumberOfResultsLoaded()).isGreaterThan(MINIMUM_RESULTS_EXPECTED);
	}
	
	@Test (groups = { "resultCount" })
	public void selectByRanking(){
		tcp.selectSortByRanking();
		assertThat(tcp.getNumberOfResultsLoaded()).isGreaterThan(MINIMUM_RESULTS_EXPECTED);
	}
	
	@Test (groups = { "resultCount" })
	public void selectIMDBRating(){
		tcp.selectSortByIMDBRating();
		assertThat(tcp.getNumberOfResultsLoaded()).isGreaterThan(MINIMUM_RESULTS_EXPECTED);
	}
	
	@Test (groups = { "resultCount" })
	public void selectByReleaseDate(){
		tcp.selectSortByReleaseDate();
		assertThat(tcp.getNumberOfResultsLoaded()).isGreaterThan(MINIMUM_RESULTS_EXPECTED);
	}
	
	@Test (groups = { "resultCount" })
	public void selectByYourRating(){
		tcp.selectSortByYourRating();
		assertThat(tcp.getNumberOfResultsLoaded()).isGreaterThan(MINIMUM_RESULTS_EXPECTED);
	}
	
	@Test (dependsOnGroups = { "resultCount" })
	@Parameters("initialGenre")
	public void clickOnGenre(String initialGenre){
		tcp.clickOnGenre(initialGenre);
	}
	
	//further tests for top chart page go here...
	
}