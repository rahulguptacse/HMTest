package com.automation.test.stepDefs;

import com.automation.test.common.Utility;
import com.automation.test.pages.homePage.HomePage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.assertj.core.api.SoftAssertions;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class HomePageSteps extends Utility{
    HomePage homePage;
    String url ;
    String input;
    String output;

    @Before
    public void setUp() throws IOException {
        Properties properties = new Properties();
        InputStream config = Files.newInputStream(Paths.get("src/test/java/com/automation/test/properties/config.properties")) ;
        properties.load(config);
        url = properties.getProperty("URL");
        homePage = new HomePage(properties.getProperty("Browser"),properties.getProperty("Device"));
    }

    @Given("for a car reg for {string} and {string}")
    public void getCarReg(String inputFile ,String outputFile) {
        input = "src/test/java/com/automation/test/testData/input/" + inputFile;
        output = "src/test/java/com/automation/test/testData/output/" + outputFile;
    }

    @Then("user car search the vehicle")
    public void searchVehicle() {
        SoftAssertions softAssertions = new SoftAssertions();
        List<String> registrationNumbers = retrieveRegistrationNumbers(input);
        Map<String, String[]> expectedCarDetails = readOutputFile(output);
        for (String registrationNumber : registrationNumbers) {
            String[] searchResult = homePage.performCarSearch(url, registrationNumber);
            if(searchResult!= null){
                for (Map.Entry<String, String[]> entry : expectedCarDetails.entrySet()) {
                    String[] expectedValues = entry.getValue();
                    if(entry.getKey().contains(registrationNumber))
                    {
                        softAssertions.assertThat(searchResult[0]).isEqualTo(expectedValues[0]).as("Make Model Doesn't Match");
                        softAssertions.assertThat(searchResult[1]).isEqualTo(expectedValues[1]).as("Variant Doesn't Match");
                        softAssertions.assertThat(searchResult[2]).isEqualTo(expectedValues[2]).as("Year Body Doesn't Match");
                    }
                }
            }
            else
            {
                softAssertions.assertThat(false).as("Car Reg "+ registrationNumber + " is not found ").isTrue();
            }
        }
        softAssertions.assertAll();
    }

    @After
    public void tearDown(){
        homePage.closeBrowser();
    }
}
