package ru.yandex.practicum;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    private WebDriver driver;
    private final WebDriverWait wait;

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    //поля формы Вход
    private static final By EMAIL_LOGIN_FIELD = By.xpath("//input[@name='name']");
    private static final By PASSWORD_LOGIN_FIELD = By.xpath("//input[@name='Пароль']");

    //кнопка войти
    private static final By LOGIN_FORM_BUTTON = By.xpath("//button[contains(@class,'button_button__33qZ0') and text()='Войти']");

    //кнопки Зарегистрироваться и Восстановить пароль
    private static final By REGISTER_NEW_USER_BUTTON = By.xpath("//a[contains(@class,'Auth_link__1fOlj') and text()='Зарегистрироваться']");
    private static final By PASSWORD_RECOVER_BUTTON = By.xpath("//a[contains(@class,'Auth_link__1fOlj') and text()='Восстановить пароль']");


    @Step("Заполнение поля email")
    public void fillEmail(String email) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(EMAIL_LOGIN_FIELD)).sendKeys(email);
    }

    @Step("Заполнение поля пароль")
    public void fillPassword(String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(PASSWORD_LOGIN_FIELD)).sendKeys(password);
    }

    @Step("Клик по кнопке Войти")
    public void clickLoginButton() {
        wait.until(ExpectedConditions.elementToBeClickable(LOGIN_FORM_BUTTON)).click();
    }

    @Step("Клик по кнопке Зарегистрироваться")
    public void clickRegisterLink() {
        wait.until(ExpectedConditions.elementToBeClickable(REGISTER_NEW_USER_BUTTON)).click();
    }

    @Step("Клик по кнопке Восстановить пароль")
    public void clickForgotPassword() {
        wait.until(ExpectedConditions.elementToBeClickable(PASSWORD_RECOVER_BUTTON)).click();
    }

    @Step("Ожидание кнопки Вход в форме входа")
    public boolean isLoginButtonVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(LOGIN_FORM_BUTTON)).isDisplayed();
    }

}
