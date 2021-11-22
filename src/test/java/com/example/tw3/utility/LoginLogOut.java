package com.example.tw3.utility;

import com.codeborne.selenide.WebDriverRunner;
import com.example.tw3.pages.LoginPage;
import com.example.tw3.pages.SecondaryLoginPage;

import static com.codeborne.selenide.Selenide.open;

public interface LoginLogOut {
    LoginPage loginPage = new LoginPage();
    SecondaryLoginPage secondaryLoginPage = new SecondaryLoginPage();

    static void loginPrimary(){
        open(loginPage.url);
        loginPage.getUsernameField().sendKeys(System.getenv("username"));
        loginPage.getPasswordField().sendKeys(System.getenv("password"));
        loginPage.getLoginForm().submit();
    }

    static void loginSecondary(){
        open(secondaryLoginPage.url);
        secondaryLoginPage.getUsernameField().sendKeys(System.getenv("username"));
        secondaryLoginPage.getPasswordField().sendKeys(System.getenv("password"));
        secondaryLoginPage.getLoginForm().submit();
    }

    static void logInWithWrongPassword(String password) {
        open(loginPage.url);
        loginPage.getUsernameField().sendKeys(System.getenv("username"));
        loginPage.getPasswordField().sendKeys(password);
        loginPage.getLoginForm().submit();
    }

    static void closeDriver(){
        WebDriverRunner.getWebDriver().close();
    }
}
