package com.example.tw3.tests;

import com.example.tw3.utility.LoginLogOut;
import com.example.tw3.utility.LogoutTestUtility;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LogoutTest {
    private final LogoutTestUtility logoutMethods = new LogoutTestUtility();

    @BeforeEach
    public void login() {
        LoginLogOut.loginPrimary();
    }

    @Test
    public void logout() {
        logoutMethods.logout();
        Assertions.assertTrue(logoutMethods.isMessageVisible());
        Assertions.assertFalse(logoutMethods.isProfilePageAvailable());
    }

//    @Test
//    public void multiTabLogout() {
//        logoutMethods.openNewTab();
//        logoutMethods.switchToTab(0);
//        logoutMethods.logout();
//        Assertions.assertTrue(logoutMethods.isMessageVisible());
//        Assertions.assertFalse(logoutMethods.isProfilePageAvailable());
//        logoutMethods.switchToTab(1);
//        logoutMethods.refreshPage();
//        Assertions.assertFalse(logoutMethods.isProfilePageAvailable());
//    }

    @AfterAll
    public  static void tearDown(){
        LoginLogOut.closeDriver();
    }
}
