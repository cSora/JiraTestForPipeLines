package com.example.tw3.tests;

import com.example.tw3.utility.EditIssueUtility;
import com.example.tw3.utility.LoginLogOut;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class EditIssueTest {
    EditIssueUtility editIssueUtility = new EditIssueUtility();

    @BeforeAll
    public static void setUp(){
        LoginLogOut.loginPrimary();
    }

    @AfterAll
    public static void tearDown(){
        LoginLogOut.closeDriver();
    }

    @Test
    public void editTest(){
        Assertions.assertTrue(editIssueUtility.validateEdit());
        editIssueUtility.deleteIssue();
    }

}
