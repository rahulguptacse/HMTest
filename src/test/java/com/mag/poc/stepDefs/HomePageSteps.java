package com.mag.poc.stepDefs;
import com.mag.poc.pages.BasePage;
import com.mag.poc.pages.homePage.HomePage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

public class HomePageSteps extends BasePage {
    HomePage homePage;
    String url ;

    @Before
    public void setUp() throws IOException {
        Properties properties = new Properties();
        InputStream input = Files.newInputStream(Paths.get("src/test/java/com/mag/poc/properties/config.properties")) ;
        properties.load(input);
        url = properties.getProperty("URL");
        String browser = properties.getProperty("Browser");
        String device = System.getProperty("device");
        setDriver(browser,device);
        homePage = new HomePage();
    }

    @Given("user is on the Serravalle Website")
    public void userIsOnTheSerravalleWebsite() {
        homePage.openURL(url);
    }

    @When("user click on the ham burger menu")
    public void userClickOnHamBurgerMenu() {
        homePage.clickHamBurgerMenu();
    }

    @Then("address detail are displayed")
    public void verifyAddressDetails() {
        Assert.assertEquals("Designer Outlet Serravalle\n" +
                "Via della Moda 1 Serravalle Scrivia 15069", homePage.getAddress());
    }

    @Then("Home Page is displayed")
    public void verifyHomePage() {
        Assert.assertEquals("Style", homePage.getHomePageHeader());
    }

    @When("on clicking {string}")
    public void verifyFooter(String link) {
        homePage.clickLink(link);
    }

    @Then("{string} is open")
    public void verifyLink(String link) {
        homePage.verifyLink(link);
    }

    @Then("Social Links are displayed")
    public void verifySocialLink() {
        List<WebElement> socialItems = homePage.getSocialItems();
        Assert.assertTrue(socialItems.get(0).getAttribute("class").contains("facebook"));
        Assert.assertTrue(socialItems.get(1).getAttribute("class").contains("twitter"));
        Assert.assertTrue(socialItems.get(2).getAttribute("class").contains("instagram"));

    }
    @When("user click on visit option and answer the questions")
    public void userClickOnVisitOption() {
        homePage.clickVisit();
        homePage.answerQuestionOptionClick();
        homePage.clickFamilyOption();
        homePage.clickShoppingOption();
        homePage.clickFunActivityOption();
        homePage.clickLocalOption();
        homePage.clickVisitWebsiteOption();
    }

    @After
    public void tearDown(){
        homePage.closeBrowser();
    }
}
