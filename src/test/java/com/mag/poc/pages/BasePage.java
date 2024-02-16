package com.mag.poc.pages;

import com.mag.poc.selenium.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.html5.WebStorage;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.function.Function;
import java.util.logging.Logger;


public abstract class BasePage {

  private static final int TIMEOUT = 30;
  private static final int POLLING = 100;

  protected static final Logger LOGGER = Logger.getLogger(BasePage.class.getSimpleName());
  protected static WebDriver driver;

  public static WebDriver getDriver() {
    return driver;
  }

  protected void setDriver(String browser , String device) {
    DriverFactory driverFactory = new DriverFactory(browser,device);
    driver = driverFactory.setupWebDriver();
  }

  protected String getCurrentUrl() {
    return getDriver().getCurrentUrl();
  }

  public void refreshBrowser() {
    getDriver().navigate().refresh();
  }

  public void clearCookies() {
    getDriver().manage().deleteAllCookies();
  }

//  public void clearLocalStorage() {
//    try {
//      ((WebStorage) TestConfigurationFactory.getWebDriver()).getLocalStorage().clear();
//    } catch (Throwable e) {
//      LOGGER.warning(e.getMessage());
//    }
//  }

  protected JavascriptExecutor getJs() {
    return (JavascriptExecutor) getDriver();
  }

  protected WebDriverWait defaultWait() {
    return new WebDriverWait(getDriver(), Duration.ofSeconds(TIMEOUT), Duration.ofSeconds(POLLING));
  }

  protected <V> V until(Function<? super WebDriver, V> isTrue) {
    return defaultWait().until(isTrue);
  }

  protected <V> V until(Function<? super WebDriver, V> isTrue, String messageToPrintOnFailure) {
    return defaultWait().withMessage(messageToPrintOnFailure).until(isTrue);
  }

  public void waitForURLToChange(String url) {
    until(ExpectedConditions.not(ExpectedConditions.urlContains(url)));
  }

  public void waitForURLToContain(String url) {
    until(ExpectedConditions.urlContains(url));
  }


  protected Actions actions() {
    return new Actions(getDriver());
  }

  protected void performDrag(WebElement element, int x, int y) {
    until(ExpectedConditions.elementToBeClickable(element));
    actions().dragAndDropBy(element, x, y).perform();
  }

  public static void threadSleep(long period) {
    try {
      Thread.sleep(period);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  protected static LocalDate convertStringToDate(String dateString) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    return LocalDate.parse(dateString.replaceAll("\\.", ""), formatter);
  }

  protected boolean isElementPresent(By by) {
    return getDriver().findElements(by).size() > 0;
  }

  protected boolean isElementPresent(WebElement element, By by) {
    return element.findElements(by).size() > 0;
  }


}