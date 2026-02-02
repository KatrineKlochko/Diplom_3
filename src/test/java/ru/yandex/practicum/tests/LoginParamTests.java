package ru.yandex.practicum.tests;


import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.yandex.practicum.*;
import ru.yandex.practicum.model.User;
import ru.yandex.practicum.steps.UserSteps;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class LoginParamTests extends BaseUITest{

    private final String entryPoint;
    private UserSteps userSteps = new UserSteps();
    private User user;

    public LoginParamTests(String entryPoint) {
        this.entryPoint = entryPoint;
    }

    @Parameterized.Parameters(name = "Точка входа: {0}")
    public static Object[][] data() {
        return new Object[][] {
                {"login"},
                {"personal"},
                {"reg"},
                {"forgot"}
        };
    }

    @Before
    public void prepareUser(){

        user = new User();
        user
                .setEmail((RandomStringUtils.randomAlphabetic(12)) + "@example.com")
                .setPassword(RandomStringUtils.randomAlphabetic(12))
                .setName(RandomStringUtils.randomAlphabetic(12));
        userSteps.createUser(user);
    }

    @Test
    @DisplayName("Успешный вход пользователя разными способами")
    @Description("Проверка входа по четырём разным кнопкам навигации")
    public void loginViaDifferentEntryPointsTest() {

        MainPage main = new MainPage(driver, wait);
        LoginPage login = new LoginPage(driver, wait);
        RegisterPage register = new RegisterPage(driver, wait);
        ForgotPasswordPage forgot = new ForgotPasswordPage(driver, wait);
        LoginEntryNavigator navigator = new LoginEntryNavigator();

        navigator.navigateToLoginFromEntryPoint(entryPoint, main, login, register, forgot);

        login.fillEmail(user.getEmail());
        login.fillPassword(user.getPassword());
        login.clickLoginButton();

        assertTrue("Конструктор не открылся после авторизации",
                main.isBunsIngredientsVisible());
    }

    @After
    public void tearDownUser() {

        String accessToken = userSteps
                .loginUser(user)
                .extract()
                .body()
                .path("accessToken");

        if (accessToken != null) {
            user.setAccessToken(accessToken);
            userSteps.deleteUser(accessToken);
        }
    }


}
