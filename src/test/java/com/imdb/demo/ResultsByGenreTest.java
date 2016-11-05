package com.imdb.demo;

import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import com.imdb.pages.HomePage;
import com.imdb.pages.ResultsByGenrePage;
import com.imdb.pages.TopChartsPage;

public class ResultsByGenreTest {
	
	private static int MINIMUM_RESULTS_EXPECTED = 1;
	
	ResultsByGenrePage rbgp = new ResultsByGenrePage();
	
	@Test
	@Parameters("genre")
	public void isResultsByGenrePageLoaded(String genre){
		assertThat(rbgp.getCurrentURL()).contains(rbgp.getBaseUrl() + genre.toLowerCase());
	}
	
	//further tests for results by genre page go here...
	
}