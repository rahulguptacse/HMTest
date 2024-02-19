package com.mag.poc.pages.homePage;

import com.mag.poc.pages.BasePage;
import com.mag.poc.selenium.DriverActions;
import com.mag.poc.selenium.ElementActions;
import com.mag.poc.selenium.ElementFind;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {

    ElementFind find;
    DriverActions driverActions;
    ElementActions elementActions;
    String originalWindow;

    public HomePage() {
        find = new ElementFind(getDriver(), Duration.ofSeconds(10));
        driverActions = new DriverActions(getDriver(), Duration.ofSeconds(10));
        elementActions = new ElementActions(getDriver(), Duration.ofSeconds(10));
    }

    private By link(String value) {
        return By.partialLinkText(value);
    }
    private By hamBurgerMenu() {
        return By.className("Header__menu-icon");
    }

    private By address() {
        return By.className("Header__menu__address");
    }
    private By homePageHeader() {
        return By.className("HeroBlock__tag");
    }

    private By visit() {
        return By.className("HeroBlock__your-visit");
    }

    private By answerQuestion() {
        return By.xpath("//button[contains(text(),'Answer')]");
    }

    private By familyOption() {
        return By.id("2-1");
    }
    private By shoppingOption() {
        return By.id("3-1");
    }

    private By funActivityOption() {
        return By.id("4-1");
    }
    private By localOptionOption() {
        return By.id("5-1");
    }

    private By visitWebsite() {
        return By.xpath("//button[contains(text(), 'View Website')]");
    }

    private By socialItems() {
        return By.xpath("//div[@class='Socials']/a/i");
    }


    public void clickHamBurgerMenu() {
        elementActions.click(find.findElement(hamBurgerMenu()));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void clickVisit() {
        elementActions.click(find.findElement(visit()));
    }

    public void clickLocalOption() {
        elementActions.click(find.findElement(localOptionOption()));
    }
    public void clickVisitWebsiteOption() {
        elementActions.click(find.findElement(visitWebsite()));
    }

    public void clickFamilyOption() {
        elementActions.click(find.findElement(familyOption()));
    }
    public void clickShoppingOption() {
        elementActions.click(find.findElement(shoppingOption()));
    }
    public void clickFunActivityOption() {
        elementActions.click(find.findElement(funActivityOption()));

    }

    public void answerQuestionOptionClick() {
        elementActions.click(find.findElement(answerQuestion()));
    }

    public String getAddress()
    {
        return find.findElement(address(),false, Duration.ofSeconds(2)).getText();
    }

    public String getHomePageHeader()
    {
        return find.findElement(homePageHeader(),false, Duration.ofSeconds(2)).getText();
    }
    public void openURL(String url){
        driverActions.launchUrl(url);
    }

    public void closeBrowser(){
        driverActions.closeBrowser();
    }

    public void clickLink(String text)
    {
        originalWindow = driverActions.getWindowHandle();
        find.findElement(link(text)).click();
    }

    public void verifyLink(String text)
    {
        for (String windowHandle : driverActions.getWindowHandles()) {
            if(!originalWindow.contentEquals(windowHandle)) {
                driverActions.switchToChildWindow(originalWindow);
                break;
            }
        }
        assert driverActions.getWindowHandles().size() == 2;
        assert driverActions.getBrowserTitle().contains(text);
    }

    public List<WebElement> getSocialItems() {
       return find.findElements(socialItems(),false, Duration.ofSeconds(2));
    }
}