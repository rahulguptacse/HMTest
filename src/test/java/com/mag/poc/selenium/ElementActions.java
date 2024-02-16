package com.mag.poc.selenium;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ElementActions extends DriverActions {
	
	public ElementActions(WebDriver webDriver, Duration defaultTimeout) {
		super(webDriver, defaultTimeout);
	}
	
	public void enterText(WebElement element, String value) {
		waitUntilElementClickable(element);
		element.clear();
		element.sendKeys(value);
	}
	
	public void enterTextUsingJavaExecutor(WebElement element, String value) {
		waitUntilElementClickable(element);
		element.clear();
		JavascriptExecutor js=(JavascriptExecutor) webDriver;
		js.executeScript("arguments[0].value='" + value + "'", element);
	}
	
	public String getText(WebElement element) {
		if (element == null)
			return "";
		else
			return element.getText().trim();
			
	}
	
	public String getTextOnceReady(WebElement element) {
		if (element == null)
			return "";
		else {
			waitUntilElementClickable(element);
			return element.getText().trim();
		}
			
	}

	public void click(WebElement element) {
		waitUntilElementClickable(element);
		element.click();
	}
	
	public String getAttributeValue(WebElement element, String attribute) {
		return element.getAttribute(attribute).trim();
	}
	
	public void switchToFrame(WebElement element) {
		webDriver.switchTo().frame(element);
	}

	public void clearTxtbox(WebElement element) {
		element.clear();
	}
	
	public void scrollToElement(WebElement element) {
		JavascriptExecutor js=(JavascriptExecutor) webDriver;
	    js.executeScript("arguments[0].scrollIntoView(true);", element);
	    waitUntilElementClickable(element);
	  }
	
	public void enterTextThenTab(WebElement element, String value) {
		Actions action = new Actions(webDriver);
		element.clear();
		action.sendKeys(element, value).sendKeys(Keys.TAB);
		action.sendKeys(Keys.TAB);
	}
	
	public void clickWithActionClass(WebElement element) {
		waitUntilElementClickable(element);
		Actions action = new Actions(webDriver);
		action.moveToElement(element).build().perform();
		action.moveToElement(element).click().build().perform();
	}
	
	public void clickWithJavaExecutor(WebElement element) {
		waitUntilElementClickable(element);
		JavascriptExecutor js=(JavascriptExecutor) webDriver;
		js.executeScript("arguments[0].click();", element);
	}
	
	public Boolean isSelected(WebElement element) {
		return element.isSelected();
	}
	
	public Boolean isDisplayed(WebElement element) {
		return element.isDisplayed();
	}
	
	public Boolean isEnabled(WebElement element) {
		return element.isEnabled();
	}
	
	public void performMouseHover(WebElement element) {
		waitUntilElementClickable(element);
		Actions action = new Actions(webDriver);
		action.moveToElement(element).build().perform();
	}
}
