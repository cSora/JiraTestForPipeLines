package com.example.tw3.utility;

import com.codeborne.selenide.WebDriverRunner;
import com.example.tw3.pages.BrowseIssuePage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.codeborne.selenide.Selenide.open;

public class BrowseIssueUtility {
    WebDriverWait wait;

    BrowseIssuePage browseIssuePage = new BrowseIssuePage();

    private void browsePreSetIssue(){
        open(browseIssuePage.preSetIssueUrl);
        wait =  new WebDriverWait(WebDriverRunner.getWebDriver(),5);
    }

    public boolean validateValues(){
        browsePreSetIssue();
        wait.until(ExpectedConditions.visibilityOf(browseIssuePage.getIssueSummary()));
        return browseIssuePage.getIssueKey().text().equals("MTP-1188") &&
                browseIssuePage.getIssueSummary().text().equals("test summary for browse issue");
    }

    private void browseCustomIssue(String issueKey){
        browseIssuePage.setCustomIssueUrl(issueKey);
        open(browseIssuePage.getCustomIssueUrl());
        wait =  new WebDriverWait(WebDriverRunner.getWebDriver(),5);
    }

    public boolean validateValues(String issueKey){
        browseCustomIssue(issueKey);
        String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();

        //wait footer to display??? ensure page loaded?

        if(browseIssuePage.getIssueError().isDisplayed()){
            return false;
        } else {
            wait.until(ExpectedConditions.visibilityOf(browseIssuePage.getIssueSummary()));
            return browseIssuePage.getIssueKey().text().equals(issueKey) && currentUrl.equals(browseIssuePage.getCustomIssueUrl());
        }
    }
}
