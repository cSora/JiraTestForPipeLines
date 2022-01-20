package com.example.tw3.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$x;

public class BrowseProjectsPage {
    public final String url = "https://jira-auto.codecool.metastage.net/secure/BrowseProjects.jspa";
    String browseUrl;
    SelenideElement mainTestingProjectLink = $x("//a[contains(@original-title, 'Main Testing Project')]");
    SelenideElement sideBarToggle = $x("//button[@original-title = 'Expand sidebar ( [ )']");
    SelenideElement projectTitle;
    SelenideElement MTPprojectTitle = $x("//img[@alt='Main Testing Project']");
    By byMTPprojectTitle = By.xpath("//img[@alt='Main Testing Project']");
    SelenideElement projectKey = $x("//dd[contains(text(), 'MTP')]");
    String projectKeyXpath = "//dd[contains(text(), 'MTP')]";

    public SelenideElement getMainTestingProjectLink() {
        return mainTestingProjectLink;
    }

    public SelenideElement getProjectTitle() {
        return projectTitle;
    }

    public SelenideElement getProjectKey() {
        return projectKey;
    }

    public void setProjectTitle(String projectTitle) {
        this.projectTitle = $x("//a[contains(text(),'"+projectTitle+"' )]");
    }

    public void setProjectKey(String key) {
        this.projectKey = $x("//dd[contains(text(), '"+key+"')]");
    }

    public String getBrowseUrl() {
        return browseUrl;
    }

    public void setBrowseUrl(String key) {
        this.browseUrl = "https://jira-auto.codecool.metastage.net/projects/"+key+"/summary";
    }

    public String getProjectKeyXpath() {
        return projectKeyXpath;
    }

    public SelenideElement getMTPprojectTitle() {
        return MTPprojectTitle;
    }

    public SelenideElement getSideBarToggle() {
        return sideBarToggle;
    }

    public By getByMTPprojectTitle() {
        return byMTPprojectTitle;
    }
}
