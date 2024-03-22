package com.automation.test.pages;

import com.automation.test.selenium.DriverFactory;
import org.openqa.selenium.WebDriver;

public abstract class BasePage {

  protected static WebDriver driver;

  public static WebDriver getDriver() {
    return driver;
  }

  protected void setDriver(String browser , String device) {
    DriverFactory driverFactory = new DriverFactory(browser,device);
    driver = driverFactory.setupWebDriver();
  }
}