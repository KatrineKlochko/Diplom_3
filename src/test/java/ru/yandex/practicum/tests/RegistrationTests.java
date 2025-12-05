package ru.yandex.practicum.tests;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ru.yandex.practicum.LoginPage;
import ru.yandex.practicum.MainPage;
import ru.yandex.practicum.RegisterPage;
import static org.junit.Assert.assertTrue;


public class RegistrationTests extends BaseUITest {

    @Test
    @DisplayName("Успешная регистрация пользователя")
    @Description("Переход в регистрацию → ввод корректных данных → успешное создание аккаунта")
    public void successfulRegistrationTest() {

        MainPage main = new MainPage(driver, wait);
        main.clickPersonalAccount();

        LoginPage login = new LoginPage(driver, wait);
        login.clickRegisterLink();

        RegisterPage register = new RegisterPage(driver, wait);
        String email = "test" + System.currentTimeMillis() + "@ya.ru";

        register.fillName("TestUser");
        register.fillEmailRegistration(email);
        register.fillPasswordRegistration("123456");
        register.clickLoginRegistrationButton();

        assertTrue("Форма логина не открылась", login.isLoginButtonVisible());
    }
}
