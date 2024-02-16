package com.mag.poc.selenium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementFind extends DriverWaits{
	
	public ElementFind(WebDriver webDriver, Duration defaultTimeout) {
		super(webDriver, defaultTimeout);
	}
	
	public WebElement findElement(By locator) {
		return waitUntilElementLocated(locator);
	}

	public WebElement findElement(By locator, Duration timeout) {
		return waitUntilElementLocated(locator, timeout);
	}
	
	public WebElement findElement(By locator, Boolean throwExceptionIfAbsent) {
		return waitUntilElementLocated(locator, throwExceptionIfAbsent);
	}

	public WebElement findElement(By locator, Boolean throwExceptionIfAbsent, Duration timeout) {
		return waitUntilElementLocated(locator, throwExceptionIfAbsent, timeout);
	}
	
	public WebElement findElement(By parentLocator, By childLocator) {
		return waitUntilNestedElementLocated(parentLocator, childLocator);
	}

	public WebElement findElement(By parentLocator, By childLocator, Duration timeout) {
		return waitUntilNestedElementLocated(parentLocator, childLocator, timeout);
	}
	
	public WebElement findElement(By parentLocator, By childLocator, Boolean throwExceptionIfAbsent) {
		return waitUntilNestedElementLocated(parentLocator, childLocator, throwExceptionIfAbsent);
	}

	public WebElement findElement(By parentLocator, By childLocator, Boolean throwExceptionIfAbsent, Duration timeout) {
		return waitUntilNestedElementLocated(parentLocator, childLocator, throwExceptionIfAbsent, timeout);
	}
	
	public WebElement findElement(WebElement parentElement, By childLocator) {
		return waitUntilNestedElementLocated(parentElement, childLocator);
	}

	public WebElement findElement(WebElement parentElement, By childLocator, Duration timeout) {
		return waitUntilNestedElementLocated(parentElement, childLocator, timeout);
	}
	
	public WebElement findElement(WebElement parentElement, By childLocator, Boolean throwExceptionIfAbsent) {
		return waitUntilNestedElementLocated(parentElement, childLocator);
	}

	public WebElement findElement(WebElement parentElement, By childLocator, Boolean throwExceptionIfAbsent, Duration timeout) {
		return waitUntilNestedElementLocated(parentElement, childLocator, throwExceptionIfAbsent, timeout);
	}
	
	public List<WebElement> findElements(By parentLocator, By childLocator) {
		return waitUntilNestedElementsLocated(parentLocator, childLocator);
	}

	public List<WebElement> findElements(By parentLocator, By childLocator, Duration timeout) {
		return waitUntilNestedElementsLocated(parentLocator, childLocator, timeout);
	}
	
	public List<WebElement> findElements(WebElement parentElement, By childLocator) {
		return waitUntilNestedElementsLocated(parentElement, childLocator);
	}

	public List<WebElement> findElements(WebElement parentElement, By childLocator, Duration timeout) {
		return waitUntilNestedElementsLocated(parentElement, childLocator, timeout);
	}
	
	public List<WebElement> findElements(By locator) {
		return waitUntilAllElementsLocated(locator);
	}

	public List<WebElement> findElements(By locator, Duration timeout) {
		return waitUntilAllElementsLocated(locator, timeout);
	}
	
	public List<WebElement> findElements(By locator, Boolean throwExceptionIfAbsent) {
		return waitUntilAllElementsLocated(locator, throwExceptionIfAbsent);
	}

	public List<WebElement> findElements(By locator, Boolean throwExceptionIfAbsent, Duration timeout) {
		return waitUntilAllElementsLocated(locator, throwExceptionIfAbsent, timeout);
	}
	
	public List<WebElement> findElements(By locator, int untilNumberOfElementsFound) {
		return waitUntilNumberOfElementsLocated(locator, untilNumberOfElementsFound);
	}

	public List<WebElement> findElements(By locator, int untilNumberOfElementsFound, Duration timeout) {
		return waitUntilNumberOfElementsLocated(locator, untilNumberOfElementsFound, timeout);
	}
}
