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

    public void clickHamBurgerMenu() {
        find.findElement(hamBurgerMenu()).click();
        System.out.printf("tets");
    }

//    private By footer() {
//        return By.xpath("//div/footer[@data-testid='footerTestId']");
//    }
//
//    private By footerHeadersOnMobile() {
//        return By.className("link-group");
//    }
//
//    private By brandLink(String value) {
//        return By.xpath("//img[contains(@alt, '" + value + "')]");
//}
//    private By footerSubHeadersonMobile() {
//        return By.className("link-group__link");
//    }
//    private By getAnimatedFieldCurrentValue(){
//        return By.xpath("//div[@data-testid='animatedFieldCurrentValue']");
//    }
//
//    private By selectorHeading(String value) {
//        return By.xpath("//div/h1[@data-testid='selectorHeading'and text()='" + value + "']");
//    }
//
//    private By logoText(String value) {
//        return By.xpath("//a[text()='" + value + "']");
//    }
//
//    private By addButton(String value) {
//        return By.xpath("//a[@aria-label='" + value + "']");
//    }
//
//    private By link(String value) {
//        return By.partialLinkText(value);
//    }
//
//    private By selectorFeatureCount(String value) {
//        return By.xpath("//div[@data-testid='selectorFeatureCount']//span[text()='" + value + "']");
//    }
//    private By getBookMark(){
//        return By.xpath("//div/i[@data-testid='progressBookmarkIndicatorId']");
//    }
//
//    public boolean verifySelectorPage(String code, String count) {
//        boolean flag = false;
//        int itr = 0;
//        while (!flag && itr <= 50) {
//            flag = (find.findElement(animatedFieldCurrentValue(code), false, Duration.ofSeconds(2)) != null
//                    && find.findElement(selectorFeatureCount(count), false, Duration.ofSeconds(2)) != null);
//            driverActions.scrollDownToPageHeight();
//            itr++;
//        }
//        return flag;
//    }

//    public void scrollToFooter() {
//        driverActions.scrollToBottom();
//    }
//
//    public void clickHeaderOnMobile(String header)
//    {
//        List<WebElement> headers = find.findElements(footerHeadersOnMobile(),false, Duration.ofSeconds(2));
//        switch (header.toLowerCase()) {
//            case "social":
//                headers.get(0).click();
//                break;
//            case "policies":
//                headers.get(1).click();
//                break;
//            case "brand":
//                headers.get(2).click();
//                break;
//            default:
//                System.out.println("Invalid input");
//                break;
//        }
//    }
//
//    public void clickWebsitePolicies()
//    {
//        List<WebElement> headers = find.findElements(footerHeadersOnMobile());
//        headers.get(1).click();
//    }
//
//    public void clickBrand()
//    {
//        List<WebElement> headers = find.findElements(footerHeadersOnMobile());
//        headers.get(1).click();
//    }
//
//    public boolean verifyCount(String count)
//    {
//        return find.findElement(selectorFeatureCount(count), false, Duration.ofSeconds(2)) != null;
//    }
//
//    public boolean verifySelectorHeadingText(String text)
//    {
//        return find.findElement(selectorHeading(text), false, Duration.ofSeconds(2)) != null;
//    }
//    public boolean verifyLogoText(String text)
//    {
//        return find.findElement(logoText(text), false, Duration.ofSeconds(2)) != null;
//    }
//
//    public void clickAddButton(String text)
//    {
//        find.findElement(addButton(text)).click();
//    }
//
    public void openURL(String url){
        driverActions.launchUrl(url);
    }
//
//    public void clickLink(String text)
//    {
//        originalWindow = driverActions.getWindowHandle();
//        find.findElement(link(text)).click();
//    }
//
//    public void clickBrandLinks(String brand){
//        originalWindow = driverActions.getWindowHandle();
//        find.findElement(brandLink(brand)).click();
//
//    }
//
//    public void verifyLink(String text)
//    {
//        for (String windowHandle : driverActions.getWindowHandles()) {
//            if(!originalWindow.contentEquals(windowHandle)) {
//                driverActions.switchToChildWindow(originalWindow);
//                break;
//            }
//        }
//        assert driverActions.getWindowHandles().size() == 2;
//        assert driverActions.getBrowserTitle().contains(text);
//    }
//
//    public void verifyAnimatedValues(){
//       List<WebElement> animatedValues= find.findElements(getAnimatedFieldCurrentValue());
//        for (WebElement ele:animatedValues) {
//            assertNotNull(ele.getText());
//        }
//    }
//
//    public boolean verifyBookMarkSection()
//    {
//        return find.findElement(getBookMark(), false, Duration.ofSeconds(2))!= null;
//    }
//
//    public void verifyFooterDesktop() {
//        List<WebElement> ele = find.findElements(footer());
//        assertTrue(ele.get(0).getText().contains("Facebook"));
//    }
//
//    public void verifyFooterMobile() {
//        List<WebElement> ele = find.findElements(footerSubHeadersonMobile());
//        assertTrue(ele.get(0).getText().contains("Facebook"));
//    }
}