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
}
