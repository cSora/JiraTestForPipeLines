package com.example.tw3.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class DashBoardPage {
    SelenideElement profileBtn = $x("//a[@id='header-details-user-fullname']");


    public SelenideElement getProfileBtn() {
        return profileBtn;
    }
}
