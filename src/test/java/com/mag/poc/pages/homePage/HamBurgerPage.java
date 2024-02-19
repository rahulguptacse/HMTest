package com.mag.poc.pages.homePage;

import com.mag.poc.pages.BasePage;
import com.mag.poc.selenium.DriverActions;
import com.mag.poc.selenium.ElementFind;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.*;

public class HamBurgerPage extends BasePage {

    ElementFind find;
    DriverActions driverActions;
    String originalWindow;

    public HamBurgerPage(WebDriver driver, Duration defaultTimeout) {
        find = new ElementFind(getDriver(), Duration.ofSeconds(10));
        driverActions = new DriverActions(getDriver(), Duration.ofSeconds(10));
    }

    private By hamBurgerMenu() {
        return By.className("Header__menu-icon");
    }

    private By addrress() {
        return By.className("Header__menu__address");
    }

    public void clickHamBurgerMenu() {
        find.findElement(hamBurgerMenu()).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String getAddress()
    {
        return find.findElement(addrress()).getText();
    }
    public void openURL(String url){
        driverActions.launchUrl(url);
    }

    public void closeBrowser(){
        driverActions.closeBrowser();
    }
}