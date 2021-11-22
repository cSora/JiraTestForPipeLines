package com.example.tw3.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class LogoutPage {
    public String url = "jira-auto.codecool.metastage.net/secure/Logout!";

    private SelenideElement messageWindow = $x("//strong[text()='You are now logged out. Any automatic login has also been stopped.']");

    public SelenideElement getMessageWindow() {
        return messageWindow;
    }
}
