package com.guru.insurance;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.*;

public class GuruInsuranceStep {

    private static final String PAGE = "http://demo.guru99.com/insurance/v1/index.php";
    private static final String WEBDRIVER_CHROME_NAME = "webdriver.chrome.driver";
    private static final String WEBDRIVER_CHROME_PATH = "/usr/bin/chromedriver";

    protected WebDriver driver;
    protected WebElement searchBox;

    @Given("Open GuruInsurance page")
    public void openGuruInsurancePage() {
        driver.get(PAGE);
    }

    @When("User clicks register button")
    public void userClicksRegister() {
        driver.findElement(By.xpath("//a[@href='register.php']")).click();
    }

    @Then("User should see {string}")
    public void userShouldSees(String string) {
        assertTrue(driver.getPageSource().contains(string));
    }

    @When("User fills registration form")
    public void userFillsRegistrationForm() {
        driver.findElement(By.id("user_firstname")).sendKeys("Test");
        driver.findElement(By.id("user_surname")).sendKeys("Test");
        driver.findElement(By.id("user_phone")).sendKeys("000000000000");
        driver.findElement(By.id("licencetype_f")).click();
        driver.findElement(By.id("user_address_attributes_street")).sendKeys("Test");
        driver.findElement(By.id("user_address_attributes_city")).sendKeys("Test");
        driver.findElement(By.id("user_address_attributes_county")).sendKeys("Test");
        driver.findElement(By.id("user_address_attributes_postcode")).sendKeys("Test");
        driver.findElement(By.id("user_user_detail_attributes_email")).sendKeys("test@gmail.com");
        driver.findElement(By.id("user_user_detail_attributes_password")).sendKeys("test");
        driver.findElement(By.id("user_user_detail_attributes_password_confirmation")).sendKeys("test");
        driver.findElement(By.xpath("//div/input[@name='submit']")).click();
    }

    @When("User logs in")
    public void userLogsIn() {
        driver.findElement(By.id("email")).sendKeys("test@gmail.com");
        driver.findElement(By.id("password")).sendKeys("test");
        driver.findElement(By.xpath("//div/input[@name='submit']")).click();
    }



    @Before
    public void beforeScenario() {
        System.out.println("This will run before the Scenario");
        System.setProperty(WEBDRIVER_CHROME_NAME, WEBDRIVER_CHROME_PATH);

        final ChromeOptions chromeOptions = new ChromeOptions();
        // chromeOptions.addArguments("--headless");
        chromeOptions.addArguments("--disable-gpu");
        chromeOptions.setCapability("setJavascriptEnabled", "true");

        driver = new ChromeDriver(chromeOptions);
    }

    @After
    public void afterScenario() {
        System.out.println("After The Scenario");
        //driver.quit();
    }
}
