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

    //поля формы Восстановление пароля
    private static final By EMAIL_FIELD_FORGOT_PASSWORD = By.xpath("//button[contains(@class,'Auth_fieldset__1QzWN mb-6') and text()='Email']");

    //кнопка Восстановить в форме Восстановление пароля
    private static final By RESTORE_BUTTON = By.xpath("//button[contains(@class,'button_button__33qZ0') and text()='Восстановить']");


    @Step("Заполнение поля email")
    public void fillEmailForgotPassword(String email) {
        driver.findElement(EMAIL_FIELD_FORGOT_PASSWORD).sendKeys(email);
    }

    @Step("Клик по кнопке Восстановить")
    public void clickRestoreButton() {
        wait.until(ExpectedConditions.elementToBeClickable(RESTORE_BUTTON)).click();
    }


}
