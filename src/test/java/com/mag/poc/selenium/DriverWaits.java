package com.mag.poc.selenium;

import java.time.Duration;
import java.util.List;

import com.mag.poc.exceptions.TestRunnerException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverWaits {

	protected WebDriver webDriver;
	private WebDriverWait wait;
	private Duration defaultTimeout;

	public DriverWaits(WebDriver webDriver, Duration defaultTimeout) {
		this.webDriver = webDriver;
		this.defaultTimeout = defaultTimeout;
	}

	protected void waitUntilPageLoad() {
		waitUntilPageLoad(defaultTimeout);
	}

	protected void waitUntilPageLoad(Duration timeout) {
		wait = new WebDriverWait(webDriver, timeout);
		wait.until(webDriver -> ((JavascriptExecutor) webDriver)
				.executeScript("return document.readyState")
				.equals("complete"));
	}

	public void waitIdle(long timeInMilliseconds) {
		try {
			Thread.sleep(timeInMilliseconds);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void waitForWindowCountToBeAvailable(int noOfWindows, Duration timeout) {
		try {
			wait = new WebDriverWait(webDriver, timeout);
			wait.until(ExpectedConditions.numberOfWindowsToBe(noOfWindows));
		}
		catch(Exception ex) {
			throw new TestRunnerException(ex);
		}
	}

	protected WebElement waitUntilElementLocated(By by) {
		return waitUntilElementLocated(by, defaultTimeout);
	}

	protected WebElement waitUntilElementLocated(By by, Duration timeout) {
		try {
			wait = new WebDriverWait(webDriver, timeout);
			return wait.until(ExpectedConditions.presenceOfElementLocated(by));
		}
		catch(Exception ex) {
			throw new TestRunnerException(ex);
		}
	}

	protected WebElement waitUntilElementLocated(By by, Boolean throwExceptionIfAbsent) {
		return waitUntilElementLocated(by, throwExceptionIfAbsent, defaultTimeout);
	}

	protected WebElement waitUntilElementLocated(By by, Boolean throwExceptionIfAbsent, Duration timeout) {
		try {
			wait = new WebDriverWait(webDriver, timeout);
			return wait.until(ExpectedConditions.presenceOfElementLocated(by));
		}
		catch(Exception ex) {
			if (throwExceptionIfAbsent)
				throw new TestRunnerException(ex);
			else
				return null;
		}
	}

	protected WebElement waitUntilNestedElementLocated(By by, By nestedBy) {
		return waitUntilNestedElementLocated(by, nestedBy, defaultTimeout);
	}

	protected WebElement waitUntilNestedElementLocated(By by, By nestedBy, Duration timeout) {
		try {
			wait = new WebDriverWait(webDriver, timeout);
			return wait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(by, nestedBy));
		}
		catch(Exception ex) {
			throw new TestRunnerException(ex);
		}
	}

	protected WebElement waitUntilNestedElementLocated(By by, By nestedBy, Boolean throwExceptionIfAbsent) {
		return waitUntilNestedElementLocated(by, nestedBy, throwExceptionIfAbsent, defaultTimeout);
	}

	protected WebElement waitUntilNestedElementLocated(By by, By nestedBy, Boolean throwExceptionIfAbsent, Duration timeout) {
		try {
			wait = new WebDriverWait(webDriver, timeout);
			return wait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(by, nestedBy));
		}
		catch(Exception ex) {
			if (throwExceptionIfAbsent)
				throw new TestRunnerException(ex);
			else
				return null;
		}
	}

	protected WebElement waitUntilNestedElementLocated(WebElement element, By nestedBy) {
		return waitUntilNestedElementLocated(element, nestedBy, defaultTimeout);
	}

	protected WebElement waitUntilNestedElementLocated(WebElement element, By nestedBy, Duration timeout) {
		try {
			wait = new WebDriverWait(webDriver, timeout);
			return wait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(element, nestedBy));
		}
		catch(Exception ex) {
			throw new TestRunnerException(ex);
		}
	}

	protected WebElement waitUntilNestedElementLocated(WebElement element, By nestedBy, Boolean throwExceptionIfAbsent) {
		return waitUntilNestedElementLocated(element, nestedBy, throwExceptionIfAbsent, defaultTimeout);
	}

	protected WebElement waitUntilNestedElementLocated(WebElement element, By nestedBy, Boolean throwExceptionIfAbsent, Duration timeout) {
		try {
			wait = new WebDriverWait(webDriver, timeout);
			return wait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(element, nestedBy));
		}
		catch(Exception ex) {
			if (throwExceptionIfAbsent)
				throw new TestRunnerException(ex);
			else
				return null;
		}
	}

	protected List<WebElement> waitUntilNestedElementsLocated(By by, By nestedBy) {
		return waitUntilNestedElementsLocated(by, nestedBy, defaultTimeout);
	}

	protected List<WebElement> waitUntilNestedElementsLocated(By by, By nestedBy, Duration timeout) {
		try {
			wait = new WebDriverWait(webDriver, timeout);
			return wait.until(ExpectedConditions.presenceOfNestedElementsLocatedBy(by, nestedBy));
		}
		catch(Exception ex) {
			throw new TestRunnerException(ex);
		}
	}

	protected List<WebElement> waitUntilNestedElementsLocated(WebElement element, By nestedBy) {
		return waitUntilNestedElementsLocated(element, nestedBy, defaultTimeout);
	}

	protected List<WebElement> waitUntilNestedElementsLocated(WebElement element, By nestedBy, Duration timeout) {
		try {
			List<WebElement> elements = null;
			int attempts = 0;
			long maxAttempts = timeout.getSeconds()/10;
			while (elements == null && attempts < maxAttempts ) {
				elements = element.findElements(nestedBy);
				waitIdle(timeout.getSeconds()/10);
				attempts++;
			}
			return elements;
		}
		catch(Exception ex) {
			throw new TestRunnerException(ex);
		}
	}

	protected List<WebElement> waitUntilAllElementsLocated(By by) {
		return waitUntilAllElementsLocated(by, defaultTimeout);
	}

	protected List<WebElement> waitUntilAllElementsLocated(By by, Duration timeout) {
		try {
			wait = new WebDriverWait(webDriver, timeout);
			return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
		}
		catch(Exception ex) {
			throw new TestRunnerException(ex);
		}
	}

	protected List<WebElement> waitUntilAllElementsLocated(By by, Boolean throwExceptionIfAbsent) {
		return waitUntilAllElementsLocated(by, throwExceptionIfAbsent, defaultTimeout);
	}

	protected List<WebElement> waitUntilAllElementsLocated(By by, Boolean throwExceptionIfAbsent, Duration timeout) {
		try {
			wait = new WebDriverWait(webDriver, timeout);
			return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
		}
		catch(Exception ex) {
			if (throwExceptionIfAbsent)
				throw new TestRunnerException(ex);
			else
				return null;
		}
	}

	protected List<WebElement> waitUntilNumberOfElementsLocated(By by, int number) {
		return waitUntilNumberOfElementsLocated(by, number, defaultTimeout);
	}

	protected List<WebElement> waitUntilNumberOfElementsLocated(By by, int number, Duration timeout) {
		try {
			wait = new WebDriverWait(webDriver, timeout);
			return wait.until(ExpectedConditions.numberOfElementsToBe(by, number));
		}
		catch(Exception ex) {
			throw new TestRunnerException(ex);
		}
	}

	protected List<WebElement> waitUntilNumberOfElementsLocatedMoreThan(By by, int number) {
		return waitUntilNumberOfElementsLocatedMoreThan(by, number, defaultTimeout);
	}

	protected List<WebElement> waitUntilNumberOfElementsLocatedMoreThan(By by, int number, Duration timeout) {
		try {
			wait = new WebDriverWait(webDriver, timeout);
			return wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(by, number));}
		catch(Exception ex) {
			throw new TestRunnerException(ex);
		}
	}

	protected List<WebElement> waitUntilNumberOfElementsLocatedLessThan(By by, int number) {
		return waitUntilNumberOfElementsLocatedLessThan(by, number, defaultTimeout);
	}

	protected List<WebElement> waitUntilNumberOfElementsLocatedLessThan(By by, int number, Duration timeout) {
		try {
			wait = new WebDriverWait(webDriver, timeout);
			return wait.until(ExpectedConditions.numberOfElementsToBeLessThan(by, number));
		}
		catch(Exception ex) {
			throw new TestRunnerException(ex);
		}
	}

	protected void waitUntilElementVisible(WebElement element) {
		waitUntilElementVisible(element, defaultTimeout);
	}

	protected void waitUntilElementVisible(WebElement element, Duration timeout) {
		try {
			wait = new WebDriverWait(webDriver, timeout);
			wait.until(ExpectedConditions.visibilityOf(element));
		}
		catch(Exception ex) {
			throw new TestRunnerException(ex);
		}
	}

	protected void waitUntilElementClickable(By by) {
		waitUntilElementClickable(by, defaultTimeout);
	}

	protected void waitUntilElementClickable(By by, Duration timeout) {
		try {
			wait = new WebDriverWait(webDriver, timeout);
			wait.until(ExpectedConditions.elementToBeClickable(by));
		}
		catch(Exception ex) {
			throw new TestRunnerException(ex);
		}
	}

	protected void waitUntilElementClickable(WebElement element) {
		waitUntilElementClickable(element, defaultTimeout);
	}

	protected void waitUntilElementClickable(WebElement element, Duration timeout) {
		try {
			wait = new WebDriverWait(webDriver, timeout);
			wait.until(ExpectedConditions.elementToBeClickable(element));
		}
		catch(Exception ex) {
			throw new TestRunnerException(ex);
		}
	}

	protected void waitUntilElementAttributeEquals(By by, String attribute, String value) {
		waitUntilElementAttributeEquals(by, attribute, value, defaultTimeout);
	}

	protected void waitUntilElementAttributeEquals(By by, String attribute, String value, Duration timeout) {
		try {
			wait = new WebDriverWait(webDriver, timeout);
			wait.until(ExpectedConditions.attributeToBe(by, attribute, value));
		}
		catch(Exception ex) {
			throw new TestRunnerException(ex);
		}
	}

	protected void waitUntilElementAttributeEquals(WebElement element, String attribute, String value) {
		waitUntilElementAttributeEquals(element, attribute, value, defaultTimeout);
	}

	protected void waitUntilElementAttributeEquals(WebElement element, String attribute, String value, Duration timeout) {
		try {
			wait = new WebDriverWait(webDriver, timeout);
			wait.until(ExpectedConditions.attributeToBe(element, attribute , value));
		}
		catch(Exception ex) {
			throw new TestRunnerException(ex);
		}
	}

	protected void waitUntilElementAttributeContains(By by, String attribute, String value) {
		waitUntilElementAttributeContains(by, attribute, value, defaultTimeout);
	}

	protected void waitUntilElementAttributeContains(By by, String attribute, String value, Duration timeout) {
		try {
			wait = new WebDriverWait(webDriver, timeout);
			wait.until(ExpectedConditions.attributeContains(by, attribute, value));
		}
		catch(Exception ex) {
			throw new TestRunnerException(ex);
		}
	}

	protected void waitUntilElementAttributeContains(WebElement element, String attribute, String value) {
		waitUntilElementAttributeContains(element, attribute, value, defaultTimeout);
	}

	protected void waitUntilElementAttributeContains(WebElement element, String attribute, String value, Duration timeout) {
		try {
			wait = new WebDriverWait(webDriver, timeout);
			wait.until(ExpectedConditions.attributeContains(element, attribute , value));
		}
		catch(Exception ex) {
			throw new TestRunnerException(ex);
		}
	}

	protected void waitUntilElementSelected(By by) {
		waitUntilElementSelected(by, defaultTimeout);
	}

	protected void waitUntilElementSelected(By by, Duration timeout) {
		try {
			wait = new WebDriverWait(webDriver, timeout);
			wait.until(ExpectedConditions.elementToBeSelected(by));
		}
		catch(Exception ex) {
			throw new TestRunnerException(ex);
		}
	}

	protected void waitUntilElementSelected(WebElement element) {
		waitUntilElementSelected(element, defaultTimeout);
	}

	protected void waitUntilElementSelected(WebElement element, Duration timeout) {
		try {
			wait = new WebDriverWait(webDriver, timeout);
			wait.until(ExpectedConditions.elementToBeSelected(element));
		}
		catch(Exception ex) {
			throw new TestRunnerException(ex);
		}
	}

	protected void waitUntilElementTextContains(By by, String value) {
		waitUntilElementTextContains(by, value, defaultTimeout);
	}

	protected void waitUntilElementTextContains(By by, String value, Duration timeout) {
		try {
			wait = new WebDriverWait(webDriver, timeout);
			wait.until(ExpectedConditions.textToBePresentInElementLocated(by, value));
		}
		catch(Exception ex) {
			throw new TestRunnerException(ex);
		}
	}

	protected void waitUntilElementTextContains(WebElement element, String value) {
		waitUntilElementTextContains(element, value, defaultTimeout);
	}

	protected void waitUntilElementTextContains(WebElement element, String value, Duration timeout) {
		try {
			wait = new WebDriverWait(webDriver, timeout);
			wait.until(ExpectedConditions.textToBePresentInElement(element , value));
		}
		catch(Exception ex) {
			throw new TestRunnerException(ex);
		}
	}

	protected void waitUntilElementTextEquals(By by, String value) {
		waitUntilElementTextEquals(by, value, defaultTimeout);
	}

	protected void waitUntilElementTextEquals(By by, String value, Duration timeout) {
		try {
			wait = new WebDriverWait(webDriver, timeout);
			wait.until(ExpectedConditions.textToBe(by, value));
		}
		catch(Exception ex) {
			throw new TestRunnerException(ex);
		}
	}

	protected void waitUntilTitleEquals(String title) {
		waitUntilTitleEquals(title, defaultTimeout);
	}

	protected void waitUntilTitleEquals(String title, Duration timeout) {
		try {
			wait = new WebDriverWait(webDriver, timeout);
			wait.until(ExpectedConditions.titleIs(title));
		}
		catch(Exception ex) {
			throw new TestRunnerException(ex);
		}
	}

	protected void waitUntilTitleContains(String title) {
		waitUntilTitleContains(title, defaultTimeout);
	}

	protected void waitUntilTitleContains(String title, Duration timeout) {
		try {
			wait = new WebDriverWait(webDriver, timeout);
			wait.until(ExpectedConditions.titleContains(title));
		}
		catch(Exception ex) {
			throw new TestRunnerException(ex);
		}
	}

	protected void waitUntilUrlEquals(String url) {
		waitUntilUrlEquals(url, defaultTimeout);
	}

	protected void waitUntilUrlEquals(String url, Duration timeout) {
		try {
			wait = new WebDriverWait(webDriver, timeout);
			wait.until(ExpectedConditions.urlToBe(url));
		}
		catch(Exception ex) {
			throw new TestRunnerException(ex);
		}
	}

	protected void waitUntilUrlContains(String url) {
		waitUntilUrlContains(url, defaultTimeout);
	}

	protected void waitUntilUrlContains(String url, Duration timeout) {
		try {
			wait = new WebDriverWait(webDriver, timeout);
			wait.until(ExpectedConditions.urlContains(url));
		}
		catch(Exception ex) {
			throw new TestRunnerException(ex);
		}
	}

	protected void waitUntilFrameIsAvailableToSwitch(WebElement element) {
		waitUntilFrameIsAvailableToSwitch(element, defaultTimeout);
	}

	protected void waitUntilFrameIsAvailableToSwitch(WebElement element, Duration timeout) {
		try {
			wait = new WebDriverWait(webDriver, timeout);
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
		}
		catch(Exception ex) {
			throw new TestRunnerException(ex);
		}
	}

	protected void waitUntilFrameIsAvailableToSwitch(String frameNameOrID) {
		waitUntilFrameIsAvailableToSwitch(frameNameOrID, defaultTimeout);
	}

	protected void waitUntilFrameIsAvailableToSwitch(String frameNameOrID, Duration timeout) {
		try {
			wait = new WebDriverWait(webDriver, timeout);
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameNameOrID));
		}
		catch(Exception ex) {
			throw new TestRunnerException(ex);
		}
	}

	protected Alert waitUntilAlertIsAvailableToSwitch(Boolean throwExceptionIfAbsent) {
		return waitUntilAlertIsAvailableToSwitch(throwExceptionIfAbsent, defaultTimeout);
	}

	protected Alert waitUntilAlertIsAvailableToSwitch(Boolean throwExceptionIfAbsent, Duration timeout) {
		try {
			wait = new WebDriverWait(webDriver, timeout);
			return wait.until(ExpectedConditions.alertIsPresent());
		}
		catch(Exception ex) {
			if (throwExceptionIfAbsent)
				throw new TestRunnerException(ex);
			else
				return null;
		}
	}
}
