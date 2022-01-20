package com.example.tw3.smoketests;

import com.example.tw3.tests.*;
import com.example.tw3.utility.LoginLogOut;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SmokeTest {
    private final LoginTest login = new LoginTest();
    private final LogoutTest logout = new LogoutTest();
    private final BrowseIssueTest browseIssue = new BrowseIssueTest();
    private final BrowseProjectTest browseProject = new BrowseProjectTest();
    private final CreateIssueTest createIssue = new CreateIssueTest();
    private final EditIssueTest editIssue = new EditIssueTest();

    @BeforeEach
    public void setUp() {
        LoginLogOut.loginPrimary();
    }

    @AfterEach
    public void tearDown(){
        LoginLogOut.closeDriver();
    }

//    @Test
//    public void logout() {
//        logout.logout();
//        logout.login();
//        //logout.multiTabLogout();
//
//    }
//
//    @Test
//    public void login(){
//        logout.logout();
//        login.login();
//    }


    // NOTE: short Smoketests for testing.
    //

    // uncomment below to run full smoke testing.

//    @Test
//    public void browseIssue() {
//        browseIssue.preSetIssueTest();
//    }

    @Test
    public void browseProject() {
        browseProject.browseProject();
    }
//
//    @Test
//    public void createIssue(){
//        createIssue.createIssue();
//    }
//
//    @Test
//    public void editIssue(){
//        editIssue.editTest();
//    }
}
