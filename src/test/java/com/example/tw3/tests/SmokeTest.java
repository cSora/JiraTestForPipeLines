package com.example.tw3.tests;

import org.junit.jupiter.api.Test;

public class SmokeTest {
    private LoginTest login = new LoginTest();
    private LogoutTest logout = new LogoutTest();

    @Test
    public void smoke() {
        login.login();
        logout.logout();
    }
}
