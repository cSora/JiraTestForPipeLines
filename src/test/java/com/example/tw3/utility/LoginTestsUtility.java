package com.example.tw3.utility;

import com.codeborne.selenide.WebDriverRunner;
import com.example.tw3.pages.DashBoardPage;
import com.example.tw3.pages.ProfilePage;
import com.example.tw3.pages.dropdowns.ProfileOptionsDropDown;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginTestsUtility {
    WebDriverWait wait;


    DashBoardPage dashBoardPage = new DashBoardPage();
    ProfileOptionsDropDown profileOptionsDropDown = new ProfileOptionsDropDown();
    ProfilePage profilePage = new ProfilePage();


    public boolean isProfileButtonVisible(){
        wait =  new WebDriverWait(WebDriverRunner.getWebDriver(),5);
        wait.until(ExpectedConditions.visibilityOf(dashBoardPage.getProfileBtn()));
        return dashBoardPage.getProfileBtn().isDisplayed();
    }

    public void navigateToUserProfile(){
        dashBoardPage.getProfileBtn().click();
        wait.until(ExpectedConditions.visibilityOf(profileOptionsDropDown.getProfileOption()));
        profileOptionsDropDown.getProfileOption().click();
    }

    public boolean isUserNameSame(){
        wait.until(ExpectedConditions.visibilityOf(profilePage.getDisplayedUserName()));
        return profilePage.getDisplayedUserName().text().equals(System.getenv("username"));
    }

}
