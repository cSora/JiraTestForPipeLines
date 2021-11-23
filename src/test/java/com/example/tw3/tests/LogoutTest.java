package com.example.tw3.tests;

import com.example.tw3.utility.LoginLogOut;
import com.example.tw3.utility.LogoutTestUtility;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LogoutTest {
    private LogoutTestUtility logoutMethods = new LogoutTestUtility();

    @Test
    public void logout() {
        LoginLogOut.loginPrimary();
        logoutMethods.logout();
        Assertions.assertTrue(logoutMethods.isMessageVisible());
        Assertions.assertFalse(logoutMethods.isProfilePageAvailable());
    }
}
