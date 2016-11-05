package com.imdb.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.imdb.helper.WebDriverHelper;

public class HomePage {
	
	private static final String BODY	 				= "//body";
	private static final String A_MENU_MOVIES			= "//a[text() = 'Movies']";
	private static final String DIV_MENU_MOVIES			= "//div[@id = 'navMenu1']";
	private static final String A_MENU_MOVIES_TOP		= "//a[text() = 'Top Rated Movies']";
	
	private WebDriverHelper wdHelper;
	
	public HomePage(WebDriver driver) {
		this.wdHelper = WebDriverHelper.getInstance();
		WebDriverHelper.setDriver(driver);
	}
	
	public boolean isHomePageLoaded(){
		return wdHelper.waitElementToBeLoaded(BODY);
	}
	
	public void hoverOnMoviesMenu(){
		this.wdHelper.hoverOn(A_MENU_MOVIES);
	}
	
	public boolean shouldDisplayMoviesMenu(){
		return this.wdHelper.waitElementToBeVisible(DIV_MENU_MOVIES);
	}
	
	public void clickTopChartMenuOption(){
		wdHelper.clickElement(A_MENU_MOVIES_TOP);
	}
	
}
