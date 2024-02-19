package com.mag.poc.stepDefs;
import com.mag.poc.pages.BasePage;
import com.mag.poc.pages.homePage.HamBurgerPage;
import com.mag.poc.selenium.DriverActions;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.Properties;

public class HamBurger extends BasePage {
    HamBurgerPage hamBurgerPage;
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
        hamBurgerPage = new HamBurgerPage(getDriver(), Duration.ofSeconds(10));
    }

    @Given("user is on the Serravalle Website")
    public void userIsOnTheSerravalleWebsite() {
        hamBurgerPage.openURL(url);
    }

    @When("user click on the ham burger menu")
    public void userClickOnHamBurgerMenu() {
        hamBurgerPage.clickHamBurgerMenu();
    }

    @Then("address detail are displayed")
    public void verifyAddressDetails() {
        Assert.assertEquals("Designer Outlet Serravalle\n" +
                "Via della Moda 1 Serravalle Scrivia 15069", hamBurgerPage.getAddress());
    }

    @After
    public void tearDown(){
        hamBurgerPage.closeBrowser();
    }
}
