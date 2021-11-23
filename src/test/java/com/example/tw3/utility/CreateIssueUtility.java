package com.example.tw3.utility;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import com.example.tw3.pages.DashBoardPage;
import com.example.tw3.pages.IssuePage;
import com.example.tw3.pages.dropdowns.MoreOptionsDropDown;
import com.example.tw3.pages.screens.CreateIssueScreen;
import com.example.tw3.pages.screens.DeleteIssueScreen;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.codeborne.selenide.Selenide.open;

public class CreateIssueUtility {
    private DashBoardPage dashBoardPage = new DashBoardPage();
    private CreateIssueScreen createIssueScreen = new CreateIssueScreen();
    private IssuePage issuePage = new IssuePage();

    private WebDriverWait wait;
    private String issueUrl;

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
        field.sendKeys(Keys.ENTER);
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
        wait.until(ExpectedConditions.visibilityOf(issuePage.getDetailsSection()));
        issueUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
    }

    public boolean validateIssuePage(String project, String type, String summary) { // TODO: debug
        if (!issuePage.getProjectNameValue().getText().equals(project)) { return false; }
        if (!issuePage.getTypeValue().getText().equals(type)) { return false; }
        if (!issuePage.getSummaryValue().getText().equals(summary)) { return false; }
        // if (!issuePage.getReporterValue().getText().equals(System.getenv("user"))) { return false; }
        return true;
    }

    public void deleteIssue() {
        issuePage.getMoreBtn().click();
        MoreOptionsDropDown more = new MoreOptionsDropDown();
        while (!more.getDeleteOption().isDisplayed()) {
            more.getMenu().sendKeys(Keys.DOWN);
        }
        more.getDeleteOption().click();
        DeleteIssueScreen delete = new DeleteIssueScreen();
        wait.until(ExpectedConditions.visibilityOf(delete.getDialog()));
        wait.until(ExpectedConditions.visibilityOf(delete.getMessage()));
        delete.getDeleteBtn().click();
    }

    public boolean validateDeleted() {
        open(issueUrl);
        String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        return !currentUrl.equals(issueUrl);
    }
}
