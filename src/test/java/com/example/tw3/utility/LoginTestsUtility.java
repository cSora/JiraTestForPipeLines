package com.example.tw3.utility;

import com.codeborne.selenide.WebDriverRunner;
import com.example.tw3.pages.DashBoardPage;
import com.example.tw3.pages.LoginPage;
import com.example.tw3.pages.ProfilePage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginTestsUtility {
    WebDriverWait wait;

    private final DashBoardPage dashBoardPage = new DashBoardPage();
    private final ProfilePage profilePage = new ProfilePage();
    private final LoginPage loginPage = new LoginPage();



    public boolean isProfileButtonVisible() {
        wait =  new WebDriverWait(WebDriverRunner.getWebDriver(),5);
        wait.until(ExpectedConditions.visibilityOf(dashBoardPage.getProfileBtn()));
        return dashBoardPage.getProfileBtn().isDisplayed();
    }

    public void navigateToUserProfile(){
        WebDriverRunner.getWebDriver().get(profilePage.url);
    }

    public boolean isUserNameSame() {
        wait.until(ExpectedConditions.visibilityOf(profilePage.getDisplayedUserName()));
        return profilePage.getDisplayedUserName().text().equals(System.getProperty("username"));
    }

    public boolean isErrorMessageDisplayed(){
        wait =  new WebDriverWait(WebDriverRunner.getWebDriver(),5);
        wait.until(ExpectedConditions.visibilityOf(loginPage.getErrorMsg()));
        return loginPage.getErrorMsg().isDisplayed();
    }


    public boolean profileIsNotVisible() {
        navigateToUserProfile();
        wait.until(ExpectedConditions.visibilityOf(loginPage.getMustLogInMsg()));
        return loginPage.getMustLogInMsg().isDisplayed();
    }

}
