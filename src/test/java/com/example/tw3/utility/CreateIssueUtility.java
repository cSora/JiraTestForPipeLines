package com.example.tw3.utility;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import com.example.tw3.pages.DashBoardPage;
import com.example.tw3.pages.screens.CreateIssueScreen;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateIssueUtility {
    DashBoardPage dashBoardPage = new DashBoardPage();
    CreateIssueScreen createIssueScreen = new CreateIssueScreen();

    WebDriverWait wait;

    public void openScreen() {
        dashBoardPage.getCreateBtn().click();
    }

    public boolean createScreenIsVisible() {
        wait = new WebDriverWait(WebDriverRunner.getWebDriver(), 5);
        wait.until(ExpectedConditions.visibilityOf(createIssueScreen.getScreen()));
        // I separated the two conditions so that it would be easier to debug
        if (!createIssueScreen.getScreen().isDisplayed()) {
            return createIssueScreen.getScreen().isDisplayed();
        }
        return createIssueScreen.getCreateBtn().isDisplayed();
    }

    public void fillForm(String project, String issueType, String summary) {
        fillField(createIssueScreen.getProjectField(), project);
        fillField(createIssueScreen.getIssueTypeField(), issueType);
        fillField(createIssueScreen.getSummaryField(), summary);
    }

    private void fillField(SelenideElement field, String value) {
        field.click();
        int textSize = field.text().length();
        for (int i = 0; i < textSize; i++) {
            field.sendKeys(Keys.BACK_SPACE);
        }
        field.sendKeys(value);
    }

    public boolean validateInForm(String project, String issueType, String summary) {
        if(!createIssueScreen.getProjectField().getValue().equals(project)) { return false; }
        if(!createIssueScreen.getIssueTypeField().getValue().equals(issueType)) { return false; }
        return createIssueScreen.getSummaryField().getValue().equals(summary);
    }

    public void createIssueAndOpenPage() {
        createIssueScreen.getCreateBtn().click();
        wait = new WebDriverWait(WebDriverRunner.getWebDriver(), 5);
        wait.until(ExpectedConditions.visibilityOf(createIssueScreen.getIssueLink()));
        createIssueScreen.getIssueLink().click();
    }
}
