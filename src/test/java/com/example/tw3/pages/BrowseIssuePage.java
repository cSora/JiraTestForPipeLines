package com.example.tw3.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class BrowseIssuePage {
    public final String preSetIssueUrl = "https://jira-auto.codecool.metastage.net/browse/MTP-1188";
    private String customIssueUrl = "https://jira-auto.codecool.metastage.net/browse/";
    private final SelenideElement issueSummary = $x("//h1[@id='summary-val']");
    private final SelenideElement issueKey = $x("//a[@id='key-val']");
    private final SelenideElement issueError = $x("//div[@class='issue-error']");
    private final SelenideElement editIssueBtn = $x("//a[@id='edit-issue']");


    public SelenideElement getIssueSummary() {
        return issueSummary;
    }

    public SelenideElement getIssueKey() {
        return issueKey;
    }

    public String getCustomIssueUrl() {
        return customIssueUrl;
    }

    public void setCustomIssueUrl(String issueKey) {
        this.customIssueUrl = customIssueUrl + issueKey;
    }

    public SelenideElement getIssueError() {
        return issueError;
    }

    public SelenideElement getEditIssueBtn() {
        return editIssueBtn;

    }
}
