package com.example.tw3.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class DashBoardPage {
    SelenideElement profileBtn = $x("//li[@id='user-options']");


    public SelenideElement getProfileBtn() {
        return profileBtn;
    }
}
