package ru.yandex.practicum.tests;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.yandex.practicum.LoginPage;
import ru.yandex.practicum.MainPage;
import ru.yandex.practicum.RegisterPage;
import ru.yandex.practicum.model.User;
import ru.yandex.practicum.steps.UserSteps;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class RegistrationParamTests extends BaseUITest {

    private final String entryPoint;
    private UserSteps userSteps = new UserSteps();
    private User user;

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

    @Before
    public void prepareUser(){

        user = new User();
        user
                .setEmail((RandomStringUtils.randomAlphabetic(10)) + "@example.com")
                .setPassword(RandomStringUtils.randomAlphabetic(10))
                .setName(RandomStringUtils.randomAlphabetic(10));
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

        register.fillName(user.getName());
        register.fillEmailRegistration(user.getEmail());
        register.fillPasswordRegistration(user.getPassword());
        register.clickLoginRegistrationButton();

        assertTrue("Форма логина не открылась", login.isLoginButtonVisible());
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

