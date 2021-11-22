package com.example.tw3.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class LogoutPage {
    SelenideElement messageWindow = $x("//p[text()='You are now logged out. Any automatic login has also been stopped.']");

    public SelenideElement getMessageWindow() {
        return messageWindow;
    }
}
