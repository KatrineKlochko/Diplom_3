package ru.yandex.practicum.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;


public class WebDriverFactory {

    public static WebDriver getDriver(String browser) {

        switch (browser.toLowerCase()) {

            case "yandex":
                return getYandexDriver();

            case "chrome":
            default:
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver();
        }
    }

    private static WebDriver getYandexDriver() {

        System.setProperty("webdriver.chrome.driver",
                "src/test/resources/yandexdriver");

        ChromeOptions options = new ChromeOptions();
        options.setBinary("/Applications/Yandex.app/Contents/MacOS/Yandex");

        return new ChromeDriver(options);
    }
}
