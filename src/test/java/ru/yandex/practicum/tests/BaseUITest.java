package ru.yandex.practicum.tests;

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
        driver = WebDriverFactory.getDriver(System.getProperty("browser", "chrome"));
        driver.manage().window().maximize();
        driver.get("https://stellarburgers.education-services.ru/");

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
