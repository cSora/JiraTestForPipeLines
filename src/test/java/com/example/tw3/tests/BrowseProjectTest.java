package com.example.tw3.tests;

import com.example.tw3.utility.BrowseProjectUtility;
import com.example.tw3.utility.Login;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrowseProjectTest {

    BrowseProjectUtility browseProjectUtility = new BrowseProjectUtility();

    @BeforeAll
    public static void login(){
        Login.loginPrimary();
    }

    @Test
    public void browseProject(){
        browseProjectUtility.clickMainTestingProject();
        Assertions.assertTrue(browseProjectUtility.validateProjectKey());
        Assertions.assertTrue(browseProjectUtility.validateProjectName());
    }
}
