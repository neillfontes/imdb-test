package com.imdb.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.imdb.helper.WebDriverHelper;

public class TopChartsPage {
	
	private WebDriverHelper wdHelper;

	private static final String BODY	 							= "//body";
	private static final String EXPECTED_TITLE						= "IMDb Top 250 - IMDb";
	private static final String TABLE_RESULTS_COUNT					= "//table[@class = 'chart full-width']//tbody//tr";
	private static final String SELECT_SORTING						= "//select[@class = 'lister-sort-by']";
	private static final String SELECT_SORTING_IMDB_RATING			= "ir:descending";
	private static final String SELECT_SORTING_RELEASE_DATE			= "us:descending";
	private static final String SELECT_SORTING_YOUR_RATING			= "ir:descending";
	private static final String SELECT_SORTING_RANKING				= "rk:ascending";
	private static final String SELECT_SORTING_NUMBER_OF_RATINGS	= "nv:descending";
	
	private static final String GENRE_PLACEHOLDER					= "%GENRE%";
	private String listGenres										= "//li/a[text()[contains(., '%GENRE%')]]";
	
	public TopChartsPage() {
		this.wdHelper = WebDriverHelper.getInstance();
	}

	public String getPageTitle() {
		return this.wdHelper.getDriver().getTitle();
	}

	public String getExpectedTitle() {
		return EXPECTED_TITLE;
	}
	
	public int getNumberOfResultsLoaded() {
		List<WebElement> list = wdHelper.getListOfElements(TABLE_RESULTS_COUNT);
		return list.size();
	}
	
	public void selectSortByIMDBRating(){
		this.selectSortingTypeByValue(SELECT_SORTING_IMDB_RATING);
		wdHelper.waitForJSLoad();
	}
	
	public void selectSortByReleaseDate(){
		this.selectSortingTypeByValue(SELECT_SORTING_RELEASE_DATE);
		wdHelper.waitForJSLoad();
	}
	
	public void selectSortByYourRating(){
		this.selectSortingTypeByValue(SELECT_SORTING_YOUR_RATING);
		wdHelper.waitForJSLoad();
	}
	
	public void selectSortByRanking(){
		this.selectSortingTypeByValue(SELECT_SORTING_RANKING);
		wdHelper.waitForJSLoad();
	}
	
	public void selectSortByNumberOfRatings(){
		this.selectSortingTypeByValue(SELECT_SORTING_NUMBER_OF_RATINGS);
		wdHelper.waitForJSLoad();
	}
	
	private void selectSortingTypeByValue(String value){
		Select select = wdHelper.getSelect(SELECT_SORTING);
		select.selectByValue(value);
	}
	
	public void clickOnGenre(String genre) {
		wdHelper.clickElement(listGenres.replace(GENRE_PLACEHOLDER, genre));
	}

}
