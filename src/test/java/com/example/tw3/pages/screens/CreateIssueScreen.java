package com.example.tw3.pages.screens;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;

public class CreateIssueScreen {
    private final SelenideElement screen = $x("//section[@id='create-issue-dialog']");
    private final SelenideElement createBtn = $x("//input[@value='Create']");
    private final SelenideElement projectField = $x("//input[@id='project-field']");
    private final SelenideElement issueTypeField = $x("//input[@id='issuetype-field']");
    private final SelenideElement summaryField = $x("//input[@id='summary']");
    private final SelenideElement cancelBtn = $x("//button[text()='Cancel']");
    private final SelenideElement issueLink = $x("//a[@class='issue-created-key issue-link']");
    private final SelenideElement createIssueHeader = $x("//h2[contains(text(),'Create Issue')]");

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

    public SelenideElement getIssueLink() {
        return issueLink;
    }

    public SelenideElement getCancelBtn() {
        return cancelBtn;
    }

    public SelenideElement getCreateIssueHeader() {
        return createIssueHeader;
    }
}
