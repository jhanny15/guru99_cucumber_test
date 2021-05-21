package com.guru.delete;

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

public class GuruDeleteStep {

    private static final String PAGE = "http://demo.guru99.com/test/delete_customer.php";
    private static final String WEBDRIVER_CHROME_NAME = "webdriver.chrome.driver";
    private static final String WEBDRIVER_CHROME_PATH = "/usr/bin/chromedriver";

    protected WebDriver driver;
    protected WebElement searchBox;


    @Given("Open GuruDelete page")
    public void openGuruDeletePage() {
        driver.get(PAGE);
    }

    @When("User types {string}")
    public void userTypes(String string) {
        driver.findElement(By.xpath("//td/input[@name='cusid']")).sendKeys(string);
    }

    @And("User clicks submit button")
    public void userClicksSubmit() {
        driver.findElement(By.xpath("//td/input[@name='submit']")).click();
    }

    @Then("User sees confirm button")
    public void userSeesConfirm() {
        assertTrue(driver.switchTo().alert().getText().contains("Do you really want to delete this Customer?"));
    }

    @And("User clicks confirm")
    public void userClicksConfirm() {
        driver.switchTo().alert().accept();
    }

    @Then("User sees success alert")
    public void userSeesSuccess() {
        assertTrue(driver.switchTo().alert().getText().contains("Customer Successfully Delete!"));
    }


    @Before
    public void beforeScenario() {
        System.out.println("This will run before the Scenario");
        System.setProperty(WEBDRIVER_CHROME_NAME, WEBDRIVER_CHROME_PATH);

        final ChromeOptions chromeOptions = new ChromeOptions();
        //chromeOptions.addArguments("--headless");
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
