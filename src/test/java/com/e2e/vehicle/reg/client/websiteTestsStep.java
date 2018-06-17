package com.e2e.vehicle.reg.client;


import com.e2e.vehicle.reg.model.VehicleRegistrationDetails;
import com.e2e.vehicle.reg.service.VehicleRegistrationService;
import com.e2e.vehicle.reg.service.VehicleRegistrationServiceImpl;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class websiteTestsStep {

    private VehicleRegistrationService vehicleRegistrationService = new VehicleRegistrationServiceImpl();
    private ChromeDriver chromeBrowser = new ChromeDriver();
    private static final String DVLAURL = "https://www.gov.uk/get-vehicle-information-from-dvla";
    private final String DVLACSVPATH = "testData/test1.csv";
    private VehicleRegistrationClient vehicleRegistrationClient = new VehicleRegistrationClientImpl(vehicleRegistrationService);
    private VehicleRegistrationDetails vehicleRegistrationDetails = null;

    @Before
    public void init() {
        System.setProperty(
                "webdriver.chrome.driver",
                "src/test/resources/chromedriver/chromedriver/");
        chromeBrowser.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
    }

    @Given("^DVLA user in on the vehicle check website$")
    public void i_am_a_user_of_the_website() throws Throwable {
        chromeBrowser.get(DVLAURL);
        chromeBrowser.findElementByCssSelector("p#get-started > a").click();
    }


    @When("^User enters values from testdata CSV file$")
    public void i_enter_values_from_CSV_file() {
        vehicleRegistrationDetails = vehicleRegistrationClient.findVehicleRegistrationDetailsFromFile(DVLACSVPATH);
        chromeBrowser.findElementByCssSelector("#Vrm").sendKeys(vehicleRegistrationDetails.getVehicleRegistrationNumber());
        chromeBrowser.findElementByCssSelector("main#content button[type=\"submit\"]").click();

    }

    @Then("^User will be shown the correct make and colour as per expected CSV values$")
    public void i_will_receive_the_correct_make_and_colour_as_per_the_CSV_values() {
        assertEquals(chromeBrowser.findElementByCssSelector("div#pr3 li:nth-child(2) > span:nth-child(2) > strong").getText(), vehicleRegistrationDetails.getVehicleColour());
        assertEquals(chromeBrowser.findElementByCssSelector("div#pr3 li:nth-child(3) > span:nth-child(2) > strong").getText(), vehicleRegistrationDetails.getVehicleModel());
        chromeBrowser.findElementByCssSelector("input#Correct_False").click();
        chromeBrowser.findElementByCssSelector("div#pr3 button[type=\"submit\"]");
    }

    @When("^User enters invalid registration plate$")
    public void user_enters_invalid_registration_plate() throws Throwable {
        chromeBrowser.findElementByCssSelector("#Vrm").sendKeys("AHJAHJ");
        chromeBrowser.findElementByCssSelector("main#content button[type=\"submit\"]").click();
    }

    @Then("^User will be shown an invalid error message$")
    public void user_will_be_shown_an_invalid_error_message() {
        assertTrue(chromeBrowser.findElementByCssSelector("span#Vrm-error").isEnabled());
    }

    @When("^User enters nothing in registration box$")
    public void user_enters_nothing_in_registration_box() {
        chromeBrowser.findElementByCssSelector("main#content button[type=\"submit\"]").click();
    }

    @After
    public void teardown() {
        chromeBrowser.quit();
    }

}
