package com.automation.test.pages.homePage;

import com.automation.test.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class HomePage extends BasePage {
    private static final int TIMEOUT_SECONDS = 5;

    public HomePage(String browser, String device) {
        setDriver(browser,device);
        WebDriver driver = getDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIMEOUT_SECONDS));
    }

    private final By vehicleRegInputField = By.id("vrm");

    private final By searchButton =  By.xpath("//button/span[contains(text(), 'Get started')]");
    private final By cookieAcceptButton =  By.xpath("//button/span[contains(text(), 'Accept All')]");


    private final By makeAndModel =By.xpath("//div/h1[contains(@class, 'MakeAndModel')]");

    private final By variant= By.xpath("//div/h2");


    private final By yearAndBody = By.xpath("//div/p/strong");

    public void enterReg(String registrationNumber){
        driver.findElement(vehicleRegInputField).sendKeys(registrationNumber);
    }
    public void clickSearch(){
        driver.findElement(searchButton).click();
    }

    public String getMakeAndModel(){
        return driver.findElement(makeAndModel).getText();
    }

    public String getVariant(){
        return driver.findElements(variant).get(1).getText().replace("| ", "");
    }

    public String getYearAndBody(){
        return driver.findElement(yearAndBody).getText().replace("| ", "");
    }

    public void openURL(String url){
        driver.get(url);
        try{
            driver.findElement(cookieAcceptButton).click();
        }
        catch (Exception ignored){
        }

    }

    public void closeBrowser(){
        driver.quit();
    }

    public String[] performCarSearch(String url , String registrationNumber) {
        openURL(url);
        enterReg(registrationNumber);
        clickSearch();
        try{
            getMakeAndModel();
        }
        catch (Exception ie){
            return null;
        }
        return new String[]{getMakeAndModel(), getVariant(), getYearAndBody()};

    }
}