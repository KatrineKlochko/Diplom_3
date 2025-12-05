package ru.yandex.practicum;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {

    private WebDriver driver;
    private final WebDriverWait wait;

    public MainPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    //кнопка войти в аккаунт
    private static final By LOGIN_BUTTON = By.xpath("//button[contains(@class,'button_button__33qZ0') and text()='Войти в аккаунт']");

    //кнопка личный кабинет
    private static final By PERSONAL_ACCOUNT_BUTTON = By.xpath("//p[contains(@class,'AppHeader_header__linkText__3q_va') and text()='Личный Кабинет']");

    //кнопка булки
    private static final By BUN_BUTTON = By.xpath("//div[contains(@class,'tab_tab__1SPyG') and text()='Булки']");

    //кнопка соусы
    private static final By SOUS_BUTTON = By.xpath("//div[contains(@class,'tab_tab__1SPyG') and text()='Соусы']");

    //кнопка начинки
    private static final By FILLING_BUTTON = By.xpath("//div[contains(@class,'tab_tab__1SPyG') and text()='Начинки']");

    //заголовок вкладки булки
    //private static final By BUN_HEADER = By.xpath("//h2[text()='Булки']");

    //заголовок вкладки соусы
    //private static final By SOUS_HEADER = By.xpath("//h2[text()='Соусы']");

    //заголовок вкладки начинки
    //private static final By FILLING_HEADER = By.xpath("//h2[text()='Начинки']");

    //лист ингридиентов булки
    private static final By BUN_INGREDIENTS = By.xpath("//*[@id=\"root\"]/div/main/section[1]/div[2]/ul[1]");

    //лист ингридиентов соусы
    private static final By SOUS_INGREDIENTS = By.xpath("//*[@id=\"root\"]/div/main/section[1]/div[2]/ul[2]");

    //лист ингридиентов начинки
    private static final By FILLING_INGREDIENTS = By.xpath("//*[@id=\"root\"]/div/main/section[1]/div[2]/ul[3]");


    @Step("Клик по кнопке 'Войти в аккаунт'")
    public void clickLoginButton() {
        wait.until(ExpectedConditions.elementToBeClickable(LOGIN_BUTTON)).click();
    }

    @Step("Клик по кнопке 'Личный кабинет'")
    public void clickPersonalAccount() {
        wait.until(ExpectedConditions.elementToBeClickable(PERSONAL_ACCOUNT_BUTTON)).click();
    }

    @Step("Клик по кнопке Булки")
    public void clickBunButton() {
        wait.until(ExpectedConditions.elementToBeClickable(BUN_BUTTON)).click();
    }

    @Step("Клик по кнопке Соусы")
    public void clickSousButton() {
        wait.until(ExpectedConditions.elementToBeClickable(SOUS_BUTTON)).click();
    }

    @Step("Клик по кнопке Начинки")
    public void clickFillingButton() {
        wait.until(ExpectedConditions.elementToBeClickable(FILLING_BUTTON)).click();
    }

    @Step("Видимость листа ингридиентов Булки")
    public boolean isBunsIngredientsVisible() {
        WebElement errorElement = wait.until(ExpectedConditions.visibilityOfElementLocated(BUN_INGREDIENTS));
        return errorElement.isDisplayed();
    }

    @Step("Видимость листа ингридиентов Соусы")
    public boolean isSousIngredientsVisible() {
        WebElement errorElement = wait.until(ExpectedConditions.visibilityOfElementLocated(SOUS_INGREDIENTS));
        return errorElement.isDisplayed();
    }

    @Step("Видимость листа ингридиентов Начинки")
    public boolean isFillingIngredientsVisible() {
        WebElement errorElement = wait.until(ExpectedConditions.visibilityOfElementLocated(FILLING_INGREDIENTS));
        return errorElement.isDisplayed();
    }

    public void clickLoginTopOrHeroButton(String buttonType) {
        By locator;
        switch (buttonType) {
            case "personal":
                locator = PERSONAL_ACCOUNT_BUTTON;
                break;
            case "login":
                locator = LOGIN_BUTTON;
                break;
            default:
                throw new IllegalArgumentException("Неизвестный тип кнопки: " + buttonType);
        }
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();

    }

}
