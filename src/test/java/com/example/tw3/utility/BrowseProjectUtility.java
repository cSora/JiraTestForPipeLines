package com.example.tw3.utility;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.example.tw3.pages.BrowseProjectsPage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Objects;

import static com.codeborne.selenide.Selenide.open;

public class BrowseProjectUtility {
    private WebDriverWait wait;


    BrowseProjectsPage browseProjectsPage = new BrowseProjectsPage();

    public void navigateToMainTestingProjectSummary(){
        open(browseProjectsPage.url);
        wait =  new WebDriverWait(WebDriverRunner.getWebDriver(),10);
        browseProjectsPage.getMainTestingProjectLink().click();
        if(Objects.equals(Configuration.browser, "firefox")) {
            wait.withTimeout(Duration.ofSeconds(10));
        }
        browseProjectsPage.getMTPprojectTitle().click();

    }

    public boolean validateProjectKey(){
        wait =  new WebDriverWait(WebDriverRunner.getWebDriver(),5);
        wait.until(ExpectedConditions.visibilityOf(browseProjectsPage.getProjectKey()));
        return browseProjectsPage.getProjectKey().isDisplayed() && browseProjectsPage.getProjectKey().text().equals("MTP");
    }

    public boolean validateProjectKey(String projectKey){
        browseProjectsPage.setProjectKey(projectKey);
        System.out.println(browseProjectsPage.getProjectKey());
        wait =  new WebDriverWait(WebDriverRunner.getWebDriver(),5);
        wait.until(ExpectedConditions.visibilityOf(browseProjectsPage.getProjectKey()));
        System.out.println(browseProjectsPage.getProjectKey().text());
        System.out.println(projectKey);
        return browseProjectsPage.getProjectKey().isDisplayed() && browseProjectsPage.getProjectKey().text().equals(projectKey);
    }

    public boolean validateProjectName() {
        wait =  new WebDriverWait(WebDriverRunner.getWebDriver(),5);
        wait.until(ExpectedConditions.visibilityOf(browseProjectsPage.getProjectKey()));
        return browseProjectsPage.getProjectKey().isDisplayed() && browseProjectsPage.getProjectKey().text().equals("MTP");
    }

    public boolean validateProjectName(String projectName) {
        browseProjectsPage.setProjectTitle(projectName);
        System.out.println(browseProjectsPage.getProjectTitle());
        wait =  new WebDriverWait(WebDriverRunner.getWebDriver(),5);
        wait.until(ExpectedConditions.visibilityOf(browseProjectsPage.getProjectTitle()));
        System.out.println(browseProjectsPage.getProjectTitle().text());
        System.out.println(projectName);
        return browseProjectsPage.getProjectKey().isDisplayed() && browseProjectsPage.getProjectTitle().text().equals(projectName);
    }


    public void setProjectUrl(String key){
        browseProjectsPage.setBrowseUrl(key);
        open(browseProjectsPage.getBrowseUrl());
    }
}
