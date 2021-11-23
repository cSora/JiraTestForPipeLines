package com.example.tw3.tests;

import com.example.tw3.utility.LoginLogOut;
import com.example.tw3.utility.LogoutTestUtility;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LogoutTest {
    private LogoutTestUtility logoutMethods = new LogoutTestUtility();

    @BeforeEach
    private void login() {
        LoginLogOut.loginPrimary();
    }

    @Test
    public void logout() {
        logoutMethods.logout();
        Assertions.assertTrue(logoutMethods.isMessageVisible());
        Assertions.assertFalse(logoutMethods.isProfilePageAvailable());
    }

    /* TODO: implement methods
    @Test
    public void multiTabLogout() {
        logoutMethods.openNewTab();
        logoutMethods.switchTab();
        logoutMethods.logout();
        Assertions.assertTrue(logoutMethods.isMessageVisible());
        Assertions.assertFalse(logoutMethods.isProfilePageAvailable());
        logoutMethods.switchTab();
        Assertions.assertFalse(logoutMethods.isProfilePageAvailable());
    }

     */
}
