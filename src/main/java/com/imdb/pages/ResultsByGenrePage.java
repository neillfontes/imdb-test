package com.imdb.pages;

import java.util.List;

import org.openqa.selenium.WebElement;

import com.imdb.helper.WebDriverHelper;

public class ResultsByGenrePage {
	
	private WebDriverHelper wdHelper;

	private static final String BODY	 			= "//body";
	private static final String BASE_URL			= "http://www.imdb.com/search/title?genres=";
	
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
	
	

}
