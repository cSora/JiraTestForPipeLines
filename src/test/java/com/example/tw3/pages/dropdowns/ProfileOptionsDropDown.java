package com.example.tw3.pages.dropdowns;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class ProfileOptionsDropDown {
    SelenideElement profileOption = $x("//a[@id='view_profile']");


    public SelenideElement getProfileOption() {
        return profileOption;
    }
}
