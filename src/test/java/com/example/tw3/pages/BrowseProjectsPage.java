package com.example.tw3.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class BrowseProjectsPage {
    public final String url = "https://jira-auto.codecool.metastage.net/secure/BrowseProjects.jspa";
    SelenideElement mainTestingProjectLink = $x("//a[contains(@original-title, 'Main Testing Project')]");
    SelenideElement projectTitle = $x("//a[contains(text(), 'Main Testing Project')]");
    SelenideElement projectKey = $x("//dd[contains(text(), 'MTP')]");

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
        this.projectTitle = $x("//a[contains(text(),"+projectTitle+" )]");
    }

    public void setProjectKey(String key) {
        this.projectKey = $x("//dd[contains(text(), "+key+")]");
    }
}
