package com.guru.autoit;

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

public class GuruAutoitStep {

    private static final String PAGE = "http://demo.guru99.com/test/autoit.html";
    private static final String WEBDRIVER_CHROME_NAME = "webdriver.chrome.driver";
    private static final String WEBDRIVER_CHROME_PATH = "/usr/bin/chromedriver";

    protected WebDriver driver;
    protected WebElement searchBox;

    @Given("Open GuruAutoIt page")
    public void openGuruAutoItPage() {
        driver.get(PAGE);
    }

    @When("User clicks Create Course")
    public void userClicksCreateCourse() {
        driver.findElement(By.id("getjob")).click();
    }

    @Then("User sees {string}")
    public void userSees(String string) {
        assertTrue(driver.getPageSource().contains(string));
    }

    @When("User fills form")
    public void userFillsForm() {
        driver.switchTo().frame("JotFormIFrame-72320244964454");
        driver.findElement(By.id("input_3")).sendKeys("Test");
        driver.findElement(By.id("input_4")).sendKeys("test@gmail.com");
        driver.findElement(By.id("input_5")).sendKeys("/home/jonathancortes/sample.txt");
        driver.findElement(By.id("input_6")).sendKeys("Testing");
    }

    @And("User clicks Submit")
    public void userClicksSubmit() {
        driver.findElement(By.id("input_2")).click();
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
