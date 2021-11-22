package com.example.tw3.tests;

import com.example.tw3.utility.Login;
import com.example.tw3.utility.LoginTestsUtility;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LoginTest implements Login {
    LoginTestsUtility loginMethods = new LoginTestsUtility();

    @Test
    public void login(){
        Login.loginPrimary();
        Assertions.assertTrue(loginMethods.isProfileButtonVisible());
        loginMethods.navigateToUserProfile();
        Assertions.assertTrue(loginMethods.isUserNameSame());
    }
    @Test
    public void secondaryLogin(){
        Login.loginSecondary();
    }
}
