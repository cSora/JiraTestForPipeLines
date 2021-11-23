package com.example.tw3.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class BrowseIssue {
    public final String preSetIssueUrl = "https://jira-auto.codecool.metastage.net/browse/MTP-1188";
    String customIssueUrl = "https://jira-auto.codecool.metastage.net/browse/";
    SelenideElement issueSummary = $x("//h1[@id='summary-val']");
    SelenideElement issueKey = $x("//a[@id='key-val']");
}
