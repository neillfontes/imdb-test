package com.imdb.pages;

import java.util.List;

import org.openqa.selenium.WebElement;

import com.imdb.helper.WebDriverHelper;

public class ResultsByGenrePage {
	
	private WebDriverHelper wdHelper;

	private static final String BASE_URL			= "http://www.imdb.com/search/title?genres=";
	private static final String TABLE_RESULTS_COUNT = "//div[contains(@class, 'lister-item mode-')]";
	private static final String SORTING_PLACEHOLDER = "%SORTING%";
	
	private String divSortingType					= "//div[@class = 'sorting']//*[text()[contains(., '%SORTING%')]]";
	
	public ResultsByGenrePage() {
		this.wdHelper = WebDriverHelper.getInstance();
	}
	
	public String getBaseUrl() {
		return BASE_URL;
	}

	public String getPageTitle() {
		return this.wdHelper.getDriver().getTitle();
	}
	
	public String getCurrentURL(){
		return this.wdHelper.getDriver().getCurrentUrl();
	}
	
	public int getNumberOfResultsLoaded() {
		List<WebElement> list = wdHelper.getListOfElements(TABLE_RESULTS_COUNT);
		return list.size();
	}
	
	public void clickSortOption(String option){
		wdHelper.clickElement(divSortingType.replace(SORTING_PLACEHOLDER, option));
	}

}
