package com.imdb.demo;

import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import com.imdb.pages.HomePage;

public class HomePageTest {
	
	private String baseUrl = "http://www.imdb.com";
	private WebDriver driver;
	private HomePage hp;
	
	public HomePageTest() {
	}
	
	@BeforeSuite
	public void startWebdriver(){
		driver = new FirefoxDriver();
		driver.get(baseUrl);
		driver.manage().deleteAllCookies();
		hp = new HomePage(driver);
	}
	
	@AfterSuite
	public void finishWebDriver(){
		driver.quit();
	}
	
	@BeforeClass
	public void logClass(){
		
	}
	
	@Test
	public void isHomePageLoaded(){
		assertThat(hp.isHomePageLoaded()).isTrue();
	}
	
	@Test (dependsOnMethods= { "isHomePageLoaded" })
	public void shouldDisplayMenuOnHover(){ 
		hp.hoverOnMoviesMenu();
		assertThat(hp.shouldDisplayMoviesMenu()).isTrue();
	}
	
	@Test (dependsOnMethods= { "shouldDisplayMenuOnHover" })
	public void clickTopChartMenu(){
		hp.clickTopChartMenuOption();
	}
	
	//further tests for home page go here...
	
}