package com.automation.test.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	
	private final String browserType;
	private final String device;
	
	public DriverFactory (String browserType ,String device) {
		this.browserType = browserType;
		this.device =device;
	}
	
	public WebDriver setupWebDriver() {
		WebDriver webDriver;
		switch (browserType.toUpperCase()) {
		case "CHROME":
			WebDriverManager.chromedriver().setup();
			webDriver = new ChromeDriver(getChromeOptions());
			break;
		case "EDGE":
			WebDriverManager.edgedriver().setup();
			webDriver = new EdgeDriver(getEdgeOptions());
			webDriver.manage().deleteAllCookies();
			break;
		case "FIREFOX":
			WebDriverManager.firefoxdriver().setup();
			webDriver = new FirefoxDriver(getFirefoxOptions());
			break;
		case "IE":
			WebDriverManager.iedriver().setup();
			webDriver = new InternetExplorerDriver(getIEOptions());
			break;
		default:
			webDriver = null;
			break;
		}
		return webDriver;
	}
	
	
	private ChromeOptions getChromeOptions() {
		ChromeOptions chromeOptions = new ChromeOptions();
		if(device.toLowerCase().contains("desktop"))
		{
		chromeOptions.addArguments("--start-maximized",
				"--ignore-certificate-errors",
				"--disable-popup-blocking",
				"--disable-notifications",
				"--disable-in-process-stack-traces",
				"--disable-logging",
				"--log-level=3",
				"--remote-allow-origins=*");
		}
		else {
			chromeOptions.addArguments("--start-maximized",
					"--ignore-certificate-errors",
					"--disable-popup-blocking",
					"--disable-notifications",
					"--disable-in-process-stack-traces",
					"--disable-logging",
					"--log-level=3",
					"--remote-allow-origins=*");
			chromeOptions.addArguments("--window-size=" + 375 + "," + 912);
		}
		return chromeOptions;
	}

	private EdgeOptions getEdgeOptions() {
		EdgeOptions edgeOptions = new EdgeOptions();
		edgeOptions.addArguments("--start-maximized",
				"--inprivate");
		return edgeOptions;
	}
	
	private InternetExplorerOptions getIEOptions() {

		return new InternetExplorerOptions();
	}
	
	private FirefoxOptions getFirefoxOptions() {
		FirefoxOptions firefoxOptions = new FirefoxOptions();
		firefoxOptions.addArguments("--start-maximized",
				"--inprivate",
				"--remote-allow-origins=*");
		return firefoxOptions;
	}
}
