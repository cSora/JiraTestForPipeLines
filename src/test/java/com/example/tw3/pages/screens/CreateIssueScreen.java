package com.example.tw3.pages.screens;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;

public class CreateIssueScreen {
    private SelenideElement screen = $x("//section[@id='create-issue-dialog']");
    private SelenideElement createBtn = $x("//input[@value='Create']");
    private SelenideElement projectField = $x("//input[@id='project-field']");
    private SelenideElement issueTypeField = $x("//input[@id='issuetype-field']");
    private SelenideElement summaryField = $x("//input[@id='summary']");

    public SelenideElement getScreen() {
        return screen;
    }

    public SelenideElement getCreateBtn() {
        return createBtn;
    }

    public SelenideElement getProjectField() {
        return projectField;
    }

    public SelenideElement getIssueTypeField() {
        return issueTypeField;
    }

    public SelenideElement getSummaryField() {
        return summaryField;
    }
}
