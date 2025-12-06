package ru.yandex.practicum;

import io.qameta.allure.Step;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginEntryNavigator {

    private static final Logger log = LoggerFactory.getLogger(LoginEntryNavigator.class);

    @Step("Переход в форму логина через точку входа: entryPoint")
    public void navigateToLoginFromEntryPoint(
            String entryPoint,
            MainPage main,
            LoginPage login,
            RegisterPage register,
            ForgotPasswordPage forgot
    ) {

        switch (entryPoint) {

            case "login":
                main.clickLoginButton();
                break;

            case "personal":
                main.clickPersonalAccount();
                break;

            case "reg":
                main.clickPersonalAccount();
                login.clickRegisterLink();
                register.clickLoginHeroButton();
                break;

            case "forgot":
                main.clickPersonalAccount();
                login.clickForgotPassword();
                forgot.clickLoginForgotButton();
                break;

            default:
                throw new IllegalArgumentException("Unknown entry point: " + entryPoint);
        }
    }
}
