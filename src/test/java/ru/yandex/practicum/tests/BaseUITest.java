package ru.yandex.practicum.tests;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.config.LogConfig;
import io.restassured.http.ContentType;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseUITest {

    protected WebDriver driver;
    protected WebDriverWait wait;

    @Before
    public void setUp() {

        RestAssured.baseURI = "https://stellarburgers.education-services.ru";

        driver = WebDriverFactory.getDriver(System.getProperty("browser", "chrome"));
        driver.manage().window().maximize();
        driver.get("https://stellarburgers.education-services.ru/");

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        RestAssured.requestSpecification = new RequestSpecBuilder()
                .setBaseUri(RestAssured.baseURI)
                .setContentType(ContentType.JSON)
                .build();
        RestAssured.config = RestAssured
                .config()
                .logConfig(LogConfig.logConfig().enableLoggingOfRequestAndResponseIfValidationFails());

        RestAssured.defaultParser = io.restassured.parsing.Parser.JSON;
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
