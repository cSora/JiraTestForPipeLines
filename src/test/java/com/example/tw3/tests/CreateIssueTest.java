package com.example.tw3.tests;

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
        String project = Project.MTP.getFullNameWithKey();
        String issueType = IssueType.TASK.name();
        String summary = "test summary " + id;
        createIssueMethods.fillForm(project, issueType, summary);
        Assertions.assertTrue(createIssueMethods.validateInForm(project, issueType, summary));
    }
}
