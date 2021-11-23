package com.example.tw3.utility;

import com.codeborne.selenide.WebDriverRunner;
import com.example.tw3.pages.IssuePage;
import com.example.tw3.pages.dropdowns.IssueType;
import com.example.tw3.pages.dropdowns.Project;
import com.example.tw3.pages.screens.EditIssueScreen;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.UUID;

public class EditIssueUtility {
    WebDriverWait wait;

    IssuePage issuePage = new IssuePage();
    EditIssueScreen editIssueScreen = new EditIssueScreen();
    CreateIssueUtility createIssueUtility = new CreateIssueUtility();
    UUID id;

    private void createIssue(Project MTP, IssueType bug, String summary){
        wait =  new WebDriverWait(WebDriverRunner.getWebDriver(),5);
        this.id = UUID.randomUUID();
        createIssueUtility.openScreen();
        createIssueUtility.fillForm(MTP, bug, summary);
        createIssueUtility.createIssueAndOpenPage();
    }

    private void editIssue(String editedSummary) {
        issuePage.getEditIssueBtn().click();
        wait.until(ExpectedConditions.visibilityOf(editIssueScreen.getEditIssueDialog()));
        editIssueScreen.getIssueSummaryField().clear();
        editIssueScreen.getIssueSummaryField().sendKeys(editedSummary);
        editIssueScreen.getIssueUpdateBtn().click();


    }

    public boolean validateEdit() {
        Project MTP = Project.MTP;
        IssueType bug = IssueType.Bug;
        id = UUID.randomUUID();
        String summary = "issue summary "+id;
        String editedSummary = "issue summary edited";
        createIssue(MTP,bug,summary);
        editIssue(editedSummary);
        WebDriverRunner.getWebDriver().get(WebDriverRunner.getWebDriver().getCurrentUrl()); // thanks @Bori! :)
        System.out.println(issuePage.getSummaryValue().text());
        System.out.println(editedSummary);
        return issuePage.getSummaryValue().text().equals(editedSummary);
    }

    public void deleteIssue(){
        createIssueUtility.deleteIssue();
    }
}
