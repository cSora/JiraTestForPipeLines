package com.example.tw3.tests;

import com.codeborne.selenide.WebDriverRunner;
import com.example.tw3.pages.dropdowns.IssueType;
import com.example.tw3.pages.dropdowns.Project;
import com.example.tw3.utility.CreateIssueUtility;
import com.example.tw3.utility.LoginLogOut;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.UUID;

public class CreateIssueTest {
    CreateIssueUtility createIssueMethods = new CreateIssueUtility();

    @Test
    public void createIssue() {
        LoginLogOut.loginPrimary();
        createIssueMethods.openScreen();
        Assertions.assertTrue(createIssueMethods.createScreenIsVisible());

        UUID id = UUID.randomUUID();
        Project project = Project.MTP;
        IssueType type = IssueType.Task;
        String summary = "test summary " + id;

        createIssueMethods.fillForm(project, type, summary);
        Assertions.assertTrue(createIssueMethods.validateInForm(project, type, summary));
        createIssueMethods.createIssueAndOpenPage();
        Assertions.assertTrue(createIssueMethods.validateIssuePage(project, type, summary));

        createIssueMethods.deleteIssue();
        Assertions.assertTrue(createIssueMethods.validateDeleted());
    }
}
