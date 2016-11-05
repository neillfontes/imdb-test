package com.imdb.helper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverHelper {

	private static WebDriverHelper webDriverHelper = new WebDriverHelper();
	private static WebDriver webDriver;

	private WebDriverHelper() {
	}

	public static WebDriverHelper getInstance() {
		return webDriverHelper;
	}

	public static void setDriver(WebDriver driver) {
		webDriver = driver;
	}

	public WebDriver getDriver() {
		return webDriver;
	}

	public void typeText(String xpathExp, String text) {
		WebElement el = webDriver.findElement(By.xpath(xpathExp));
		if (el != null) {
			el.sendKeys(text);
		}
	}

	public String getText(String xpathExp) {
		WebElement el = webDriver.findElement(By.xpath(xpathExp));
		if (el != null) {
			return el.getAttribute("value");
		}
		return "";
	}

	public void clickElement(String xpathExp) {
		webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement el = webDriver.findElement(By.xpath(xpathExp));
		if (el != null) {
			el.click();
		}
	}

	public boolean isElementVisible(String xpathExp ) {
		return isElementVisible(xpathExp, false);
	}
	
	public boolean isElementVisible(String xpathExp, boolean skipFailure) {
		webDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		WebElement el;
		
		if (skipFailure) {
			try {
				webDriver.findElement(By.xpath(xpathExp));
			} catch (StaleElementReferenceException | NoSuchElementException ex) {
				return false;
			}
			return true;
		} else {
			el = webDriver.findElement(By.xpath(xpathExp));
		}
		
		if (el != null) {
			return el.isDisplayed();
		}
		return false;
	}
	
	public boolean isElementHidden(String xpathExp){
		WebDriverWait wait = new WebDriverWait(webDriver, 10);
		Boolean isHidden = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(xpathExp)));
		return isHidden.booleanValue();
	}

	public boolean waitElementToBeHidden(String xpathExp) {
		WebDriverWait wait = new WebDriverWait(webDriver, 10);
		return wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(xpathExp)));
	}

	public boolean waitElementToBeVisible(String xpathExp) {
		WebDriverWait wait = new WebDriverWait(webDriver, 10);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathExp)));
		return element != null;
	}

	public boolean waitElementToBeLoaded(String xpathExp) {
		WebDriverWait wait = new WebDriverWait(webDriver, 30);
		WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathExp)));
		return element != null;
	}
	
	public WebElement getElement(String xpathExp) {
		webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement element = webDriver.findElement(By.xpath(xpathExp));
		if (element != null) {
			return element;
		}
		return null;
	}

	public List<WebElement> getListOfElements(String xpathExp) {
		webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		List<WebElement> element = webDriver.findElements(By.xpath(xpathExp));
		if (element != null) {
			return element;
		}
		return new ArrayList<>();
	}

	public boolean waitForJquery() {
		
		WebDriverWait wait = new WebDriverWait(webDriver, 30);

		ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				try {
					JavascriptExecutor js;
					js = (JavascriptExecutor) webDriver;
					return (Long) js.executeScript("return jQuery.active") == 0;
				} catch (Exception e) {
					return true;
				}
			}
		};
		
		return wait.until(jQueryLoad);
		
	}
	
	public boolean waitForJSLoad(){
		
		WebDriverWait wait = new WebDriverWait(webDriver, 30);
		
		ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				JavascriptExecutor js;
				js = (JavascriptExecutor) webDriver;
				return js.executeScript("return document.readyState").toString().equals("complete");
			}
		};
		
		return wait.until(jsLoad);
		
	}
	
	public void hoverOn(String xpathExp) {
		WebElement element = webDriver.findElement(By.xpath(xpathExp));
		Actions action = new Actions(webDriver);
		action.moveToElement(element).build().perform();
	}

	public boolean isSorted(List list){
		List tmp = new ArrayList(list);
		Collections.sort(tmp);
		return tmp.equals(list);
	}
	
	public Select getSelect(String xpathExp) {
		Select select = new Select(webDriver.findElement(By.xpath(xpathExp)));
		return select;
		
	}
	
	public void printURL(){
		System.out.println(webDriver.getCurrentUrl());
	}
	public void printSource(){
		System.out.println(webDriver.getPageSource());
	}
	
}
