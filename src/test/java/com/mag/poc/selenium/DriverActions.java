package com.mag.poc.selenium;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.mag.poc.exceptions.InvalidInputException;
import com.mag.poc.exceptions.TestRunnerException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import javax.imageio.ImageIO;

public class DriverActions extends DriverWaits {
	
	public DriverActions(WebDriver webDriver, Duration defaultTimeout) {
		super(webDriver, defaultTimeout);
	}

	public void closeBrowser() {
		webDriver.close();
	}
	
	public void waitForPageLoadComplete() {
		waitUntilPageLoad();
	}
	
	public void launchUrl(String url) {
		webDriver.get(url);
	}
	
	public String getCurrentUrl() {
		return webDriver.getCurrentUrl();
	}
	
	public String getBrowserTitle() {
		return webDriver.getTitle();
	}
	
	public void switchToFrame(String frameNameOrID) {
		webDriver.switchTo().frame(frameNameOrID);
	}
	
	public void switchToDefault() {
		webDriver.switchTo().defaultContent();
	}
	
	public String getWindowHandle() {
		return webDriver.getWindowHandle();
	}
	
	public Set<String> getWindowHandles() {
		return webDriver.getWindowHandles();
	}
	
	public void switchToChildWindow(String parentWindow) {
		Set<String> windows = getWindowHandles();
		for (String window: windows) {
			if (!window.equalsIgnoreCase(parentWindow)) {
				webDriver.switchTo().window(window);
				break;
			}
		}
	}
	
	public void switchToChildWindow(List<String> parentWindows) {
		Set<String> windows = getWindowHandles();
		for (String window: windows) {
			if (!parentWindows.contains(window)) {
				webDriver.switchTo().window(window);
				break;
			}
		}
	}
	
	public void switchToDefaultWindow(String parentWindow) {
		webDriver.switchTo().window(parentWindow);
	}
	
	public void scrollToBottom() {
	    JavascriptExecutor js=(JavascriptExecutor) webDriver;
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}

	public void scrollDownToPageHeight()
	{
//			String docBodyScrollHeight = String.valueOf(((JavascriptExecutor) webDriver).executeScript("return document.body.scrollHeight"));
			String clientHeight = String.valueOf(((JavascriptExecutor) webDriver).executeScript("return document.documentElement.clientHeight"));
			long heightToScroll = Long.parseLong(clientHeight);
			((JavascriptExecutor) webDriver).executeScript("window.scrollBy(0," + heightToScroll + ")");
	}

	public void scrollUpToPageHeight()
	{
		String clientHeight = String.valueOf(((JavascriptExecutor) webDriver).executeScript("return document.documentElement.clientHeight"));
		long heightToScroll = Long.parseLong(clientHeight);
		((JavascriptExecutor) webDriver).executeScript("window.scrollBy(0," + -heightToScroll + ")");
	}
	public void captureFullPageScreenshot(String filePath, String fileName, long anyHeightToIgnore) {
		String docBodyScrollHeight = String.valueOf(((JavascriptExecutor) webDriver).executeScript("return document.body.scrollHeight"));
		String clientHeight = String.valueOf(((JavascriptExecutor) webDriver).executeScript("return document.documentElement.clientHeight"));
		long heightToScroll = Long.parseLong(clientHeight) - anyHeightToIgnore;
		List<File> screenshots = new ArrayList<File>();
		screenshots.add(captureScreenshotAsFile());
		while (true) {
			((JavascriptExecutor) webDriver).executeScript("window.scrollBy(0," + heightToScroll + ")");
			String yOffset = String.valueOf(((JavascriptExecutor) webDriver).executeScript("return window.pageYOffset"));
			if ((Long.parseLong(yOffset) + heightToScroll) >= Long.parseLong(docBodyScrollHeight))
				break;
			else
				screenshots.add(captureScreenshotAsFile());
		}
		int rows = screenshots.size();
		int cols = 1;
		try {
			BufferedImage sample = ImageIO.read(screenshots.get(0));
			BufferedImage finalImg = new BufferedImage(sample.getWidth() * cols, sample.getHeight() * rows, sample.getType());
			int index = 0;
			for (int i = 0; i < rows; i++) {
				for (int j = 0; j < cols; j++) {
					BufferedImage temp = ImageIO.read(screenshots.get(index));
					finalImg.createGraphics().drawImage(temp, sample.getWidth() * j, sample.getHeight() * i, null);
					index++;
				}
			}
			File final_Image = new File(filePath + fileName + ".png");
			ImageIO.write(finalImg, "PNG", final_Image);
		}
		catch (IOException ex){
			throw new TestRunnerException("Error while capturing full page screenshot");
		}
	}
	public File captureScreenshotAsFile() {
		return ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.FILE);
	}
	
	public byte[] captureScreenshotAsBytes() {
		return ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BYTES);
	}
	
	public void acceptAlertIfExists() {
		Alert alert = waitUntilAlertIsAvailableToSwitch(false, Duration.ofSeconds(2));
		if (alert != null)
			alert.accept();
	}

	public void cancelAlertIfExists() {
		Alert alert = waitUntilAlertIsAvailableToSwitch(false, Duration.ofSeconds(2));
		if (alert != null)
			alert.dismiss();
	}
	
	public String getAlertTextIfExist() {
		Alert alert = waitUntilAlertIsAvailableToSwitch(false, Duration.ofSeconds(2));
		if (alert != null)
			return alert.getText();
		else {
			return "";
		}
	}
	
	public Boolean checkIfAlertExistWithTextAndAccept(String text) {
		Alert alert = waitUntilAlertIsAvailableToSwitch(false, Duration.ofSeconds(2));
		if (alert != null && alert.getText().trim().contains(text)) {
			alert.accept();
			return true;	
		}			
		else {
			return false;
		}
	}
	
	public void waitforUrlContains(String text) {
		waitUntilUrlContains(text);
	}
}
