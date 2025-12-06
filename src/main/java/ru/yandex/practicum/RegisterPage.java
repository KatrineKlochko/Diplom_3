package ru.yandex.practicum;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage {

    private WebDriver driver;
    private final WebDriverWait wait;

    public RegisterPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    //поля формы Регистрация
    private static final By NAME_REGISTRATION_FIELD = By.xpath("//input[@name='name']");
    private static final By EMAIL_REGISTRATION_FIELD = By.xpath("//*[@id=\"root\"]/div/main/div/form/fieldset[2]/div/div/input");
    private static final By PASSWORD_REGISTRATION_FIELD = By.xpath("//input[@name='Пароль']");

    //кнопка Зарегистрироваться в форме Регистрация
    private static final By REGISTER_BUTTON = By.xpath("//button[contains(@class,'button_button__33qZ0') and text()='Зарегистрироваться']");

    //ошибка для некорректного пароля
    private static final By ERROR_PASSWORD_MESSAGE = By.xpath("//p[@class='input__error text_type_main-default' and text()='Некорректный пароль']");

    //кновка Войти в форме Регистрация
    private static final By LOGIN_REG_FORM_BUTTON = By.xpath("//a[@class='Auth_link__1fOlj' and text()='Войти']");


    @Step("Заполнение поля Имя")
    public void fillName(String name) {
        driver.findElement(NAME_REGISTRATION_FIELD).sendKeys(name);
    }

    @Step("Заполнение поля email")
    public void fillEmailRegistration(String email) {
        driver.findElement(EMAIL_REGISTRATION_FIELD).sendKeys(email);
    }

    @Step("Заполнение поля пароль")
    public void fillPasswordRegistration(String password) {
        driver.findElement(PASSWORD_REGISTRATION_FIELD).sendKeys(password);
    }

    @Step("Клик по кнопке Зарегистрироваться")
    public void clickLoginRegistrationButton() {
        wait.until(ExpectedConditions.elementToBeClickable(REGISTER_BUTTON)).click();
    }

    @Step("Видимость ошибки для некорректного пароля")
    public boolean isPasswordErrorVisible() {
        WebElement errorElement = wait.until(ExpectedConditions.visibilityOfElementLocated(ERROR_PASSWORD_MESSAGE));
        return errorElement.isDisplayed();
    }

    @Step("Клик по кнопке Войти")
    public void clickLoginHeroButton() {
        wait.until(ExpectedConditions.elementToBeClickable(LOGIN_REG_FORM_BUTTON)).click();
    }

}
