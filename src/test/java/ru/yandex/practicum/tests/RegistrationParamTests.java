package ru.yandex.practicum.tests;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.yandex.practicum.LoginPage;
import ru.yandex.practicum.MainPage;
import ru.yandex.practicum.RegisterPage;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class RegistrationParamTests extends BaseUITest {

    private final String entryPoint;

    public RegistrationParamTests(String entryPoint) {
        this.entryPoint = entryPoint;
    }

    @Parameterized.Parameters(name = "Точка входа: {0}")
    public static Object[][] data() {
        return new Object[][]{
                {"personal"},
                {"login"}
        };
    }

    @Test
    @DisplayName("Успешная регистрация пользователя разными способами входа")
    @Description("Переход в регистрацию из разных точек → ввод корректных данных → успешная регистрация")
    public void successfulRegistrationParameterizedTest() {

        MainPage main = new MainPage(driver, wait);
        LoginPage login = new LoginPage(driver, wait);
        RegisterPage register = new RegisterPage(driver, wait);

        main.clickLoginTopOrHeroButton(entryPoint);
        login.clickRegisterLink();

        String email = "test" + System.currentTimeMillis() + "@ya.ru";

        register.fillName("TestUser");
        register.fillEmailRegistration(email);
        register.fillPasswordRegistration("123456");
        register.clickLoginRegistrationButton();

        assertTrue("Форма логина не открылась", login.isLoginButtonVisible());
    }
}

