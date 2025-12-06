package ru.yandex.practicum;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ForgotPasswordPage {

    private WebDriver driver;
    private final WebDriverWait wait;

    public ForgotPasswordPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    //кновка Войти в форме Регистрация
    private static final By LOGIN_FORGOT_FORM_BUTTON = By.xpath("//a[@class='Auth_link__1fOlj' and text()='Войти']");


    @Step("Клик по кнопке Войти")
    public void clickLoginForgotButton() {
        wait.until(ExpectedConditions.elementToBeClickable(LOGIN_FORGOT_FORM_BUTTON)).click();
    }
}
