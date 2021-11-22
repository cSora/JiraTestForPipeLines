package com.example.tw3.tests;

import com.example.tw3.utility.Login;
import org.junit.jupiter.api.Test;

public class LoginPageTest implements Login {

    @Test
    public void login(){
        Login.loginPrimary();
    }
    @Test
    public void secondaryLogin(){
        Login.loginSecondary();
    }
}
