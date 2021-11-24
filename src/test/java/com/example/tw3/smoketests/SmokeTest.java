package com.example.tw3.smoketests;

import com.example.tw3.tests.*;
import com.example.tw3.utility.LoginLogOut;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SmokeTest {
    private LoginTest login = new LoginTest();
    private LogoutTest logout = new LogoutTest();
    private BrowseIssueTest browseIssue = new BrowseIssueTest();
    private BrowseProjectTest browseProject = new BrowseProjectTest();
    private CreateIssueTest createIssue = new CreateIssueTest();
    private EditIssueTest editIssue = new EditIssueTest();

    @BeforeEach
    public void setUp() {
        logout.login();
    }

    @AfterEach
    public void tearDown(){
        LoginLogOut.closeDriver();
    }

    @Test
    public void logout() {
        logout.logout();
        logout.login();
        logout.multiTabLogout();

    }

    @Test
    public void login(){
        logout.logout();
        login.login();
    }

    @Test
    public void browseIssue() {
        browseIssue.preSetIssueTest();
    }

    @Test
    public void browseProject() {
        browseProject.browseProject();
    }

    @Test
    public void createIssue(){
        createIssue.createIssue();
    }

    @Test
    public void editIssue(){
        editIssue.editTest();
    }
}
