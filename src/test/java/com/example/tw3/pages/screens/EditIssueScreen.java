package com.example.tw3.pages.screens;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class EditIssueScreen {
    private final SelenideElement editIssueDialog = $x("//section[@id='edit-issue-dialog']");
    private final SelenideElement issueSummaryField = $x("//input[@id='summary']");
    private final SelenideElement issueUpdateBtn = $x("//input[@id='edit-issue-submit']");


    public SelenideElement getEditIssueDialog() {
        return editIssueDialog;
    }

    public SelenideElement getIssueSummaryField() {
        return issueSummaryField;
    }

    public SelenideElement getIssueUpdateBtn() {
        return issueUpdateBtn;
    }
}
