package com.example.tw3.tests;

import com.example.tw3.utility.BrowseIssueUtility;
import com.example.tw3.utility.LoginLogOut;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class BrowseIssueTest {
    BrowseIssueUtility browseIssueUtility = new BrowseIssueUtility();

    @BeforeAll
    public static void Login(){
        LoginLogOut.loginPrimary();
    }

    @Test
    public void preSetIssueTest(){
        Assertions.assertTrue(browseIssueUtility.validateValues());
    }
}
