package com.example.tw3.tests;

import com.example.tw3.pages.dropdowns.IssueType;
import com.example.tw3.pages.dropdowns.Project;
import com.example.tw3.utility.CreateIssueUtility;
import com.example.tw3.utility.LoginLogOut;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.util.UUID;

public class CreateIssueTest {
    CreateIssueUtility createIssueMethods = new CreateIssueUtility();

    @BeforeAll
    public static void openPage() {
        LoginLogOut.loginPrimary();
    }

    @BeforeEach
    public void openScreen() {
        createIssueMethods.openScreen();
    }

    @AfterAll
    public static void tearDown(){
        LoginLogOut.closeDriver();
    }

    @Test
    public void createIssue() {
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

    @ParameterizedTest (name = "Specific issue: {0} project {1} type")
    @CsvFileSource(resources = "/issues.csv", numLinesToSkip = 1, delimiter = ';')
    public void createSpecificIssues(String projectStr, String typeStr) {
        Assertions.assertTrue(createIssueMethods.validateFormData(projectStr, typeStr));
    }

    @ParameterizedTest (name = "Sub-task for {0} project")
    @CsvFileSource(resources = "/subtask.csv", numLinesToSkip = 1, delimiter = ';')
    public void createSubIssueForProject(String project, String issue, String url) {
        Assertions.assertTrue(createIssueMethods.validateIssuePage(issue, url));
        Assertions.assertTrue(createIssueMethods.validateSubTaskOptionPresent());
    }
}
