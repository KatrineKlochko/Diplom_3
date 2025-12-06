package ru.yandex.practicum.tests;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import ru.yandex.practicum.LoginPage;
import ru.yandex.practicum.MainPage;
import ru.yandex.practicum.RegisterPage;
import static org.junit.Assert.assertTrue;


public class RegistrationErrorTests extends BaseUITest {

    @Test
    @DisplayName("Ошибка при регистрации: пароль меньше 6 символов")
    @Description("Невозможно зарегистрироваться с коротким паролем — появляется сообщение об ошибке")
    public void incorrectPasswordRegistrationTest() {

        MainPage main = new MainPage(driver, wait);
        LoginPage login = new LoginPage(driver, wait);
        RegisterPage register = new RegisterPage(driver, wait);

        main.clickPersonalAccount();
        login.clickRegisterLink();

        register.fillName("TestUser");
        register.fillEmailRegistration("test" + System.currentTimeMillis() + "@ya.ru");
        register.fillPasswordRegistration("123");
        register.clickLoginRegistrationButton();

        assertTrue("Ошибка 'Некорректный пароль' не отображается",
                register.isPasswordErrorVisible());
    }
}
