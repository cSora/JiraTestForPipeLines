package com.example.tw3.utility;

import com.codeborne.selenide.WebDriverRunner;
import com.example.tw3.pages.BrowseProjectsPage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.codeborne.selenide.Selenide.open;

public class BrowseProjectUtility {
    WebDriverWait wait;


    BrowseProjectsPage browseProjectsPage = new BrowseProjectsPage();

    public void clickMainTestingProject(){
        open(browseProjectsPage.url);
        browseProjectsPage.getMainTestingProjectLink().click();
    }

    public boolean validateProjectKey(){
        wait =  new WebDriverWait(WebDriverRunner.getWebDriver(),5);
        wait.until(ExpectedConditions.visibilityOf(browseProjectsPage.getProjectKey()));
        return browseProjectsPage.getProjectKey().isDisplayed() && browseProjectsPage.getProjectKey().text().equals("MTP");
    }

    public boolean validateProjectName() {
        wait =  new WebDriverWait(WebDriverRunner.getWebDriver(),5);
        wait.until(ExpectedConditions.visibilityOf(browseProjectsPage.getProjectKey()));
        return browseProjectsPage.getProjectKey().isDisplayed() && browseProjectsPage.getProjectTitle().text().equals("Main Testing Project");
    }
}
