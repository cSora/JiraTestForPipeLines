package com.example.tw3.tests;

import com.example.tw3.utility.BrowseProjectUtility;
import com.example.tw3.utility.Login;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
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

    @ParameterizedTest(name = "Test browse {0}")
    @MethodSource("com.example.tw3.utility.BrowseProjectUtility#provideProjectNamesAndKeys")
    public void test(String projectName, String projectKey){
        browseProjectUtility.setProjectUrl(projectKey);
        Assertions.assertTrue(browseProjectUtility.validateProjectKey(projectKey));
        Assertions.assertTrue(browseProjectUtility.validateProjectName(projectName));

    }
}
