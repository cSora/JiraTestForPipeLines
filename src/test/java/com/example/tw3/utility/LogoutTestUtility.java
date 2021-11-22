package com.example.tw3.utility;

import com.codeborne.selenide.WebDriverRunner;
import com.example.tw3.pages.DashBoardPage;
import com.example.tw3.pages.LogoutPage;
import com.example.tw3.pages.ProfilePage;
import com.example.tw3.pages.dropdowns.ProfileOptionsDropDown;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.open;

public class LogoutTestUtility {
    WebDriverWait wait;

    DashBoardPage dashBoardPage = new DashBoardPage();
    ProfileOptionsDropDown profileOptionsDropDown = new ProfileOptionsDropDown();
    LogoutPage logoutPage = new LogoutPage();
    ProfilePage profilePage = new ProfilePage();

    public void logout() {
        wait = new WebDriverWait(WebDriverRunner.getWebDriver(), 5);
        dashBoardPage.getProfileBtn().click();
        wait.until(ExpectedConditions.visibilityOf(profileOptionsDropDown.getLogoutOption()));
        profileOptionsDropDown.getLogoutOption().click();
    }

    public boolean isMessageVisible() {
        wait = new WebDriverWait(WebDriverRunner.getWebDriver(), 5);
        wait.until(ExpectedConditions.urlContains(logoutPage.url));
        return logoutPage.getMessageWindow().isDisplayed();
    }

    public boolean isProfilePageAvailable() {
        open(profilePage.url);
        wait.withTimeout(Duration.ofSeconds(5));
        return WebDriverRunner.getWebDriver().getCurrentUrl().equals(profilePage.url);
    }
}
