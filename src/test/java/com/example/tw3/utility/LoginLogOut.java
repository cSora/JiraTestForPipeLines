package com.example.tw3.utility;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.example.tw3.pages.DashBoardPage;
import com.example.tw3.pages.LoginPage;
import com.example.tw3.pages.LogoutPage;
import com.example.tw3.pages.SecondaryLoginPage;
import com.example.tw3.pages.dropdowns.ProfileOptionsDropDown;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Objects;

import static com.codeborne.selenide.Selenide.open;

public interface LoginLogOut {
    LoginPage loginPage = new LoginPage();
    LogoutPage logOutPage = new LogoutPage();
    SecondaryLoginPage secondaryLoginPage = new SecondaryLoginPage();
    DashBoardPage dashBoardPage = new DashBoardPage();
    ProfileOptionsDropDown profileOptionsDropDown = new ProfileOptionsDropDown();

    static void setFireFoxDriver(){
        Configuration.browser = "firefox";

    }

    static void loginPrimary(){
        setFireFoxDriver();
        open(loginPage.url);
        WebDriverWait wait = new WebDriverWait(WebDriverRunner.getWebDriver(), 10);
        loginPage.getUsernameField().sendKeys(System.getenv("username"));
        loginPage.getPasswordField().sendKeys(System.getenv("password"));
        loginPage.getLoginForm().submit();
        wait.until(ExpectedConditions.visibilityOf(dashBoardPage.getProfileBtn()));

    }

    static void loginSecondary(){
        setFireFoxDriver();
        open(secondaryLoginPage.url);
        secondaryLoginPage.getUsernameField().sendKeys(System.getenv("username"));
        secondaryLoginPage.getPasswordField().sendKeys(System.getenv("password"));
        secondaryLoginPage.getLoginForm().submit();
    }

    static void logInWithWrongPassword(String password) {
        setFireFoxDriver();
        open(loginPage.url);
        loginPage.getUsernameField().sendKeys(System.getenv("username"));
        loginPage.getPasswordField().sendKeys(Objects.requireNonNullElse(password, ""));
        loginPage.getLoginForm().submit();
    }

    static void closeDriver(){
        WebDriverRunner.getWebDriver().close();
    }

    static void logout() {
        setFireFoxDriver();
        WebDriverWait wait = new WebDriverWait(WebDriverRunner.getWebDriver(), 5);
        dashBoardPage.getProfileBtn().click();
        wait.until(ExpectedConditions.visibilityOf(profileOptionsDropDown.getLogoutOption()));
        profileOptionsDropDown.getLogoutOption().click();
        wait.until(ExpectedConditions.visibilityOf(logOutPage.getAtlasssianLogo()));
        if(logOutPage.getMessageWindow1().isDisplayed()){
            logOutPage.getAltLogOutBtn().click();
        }
    }
}
