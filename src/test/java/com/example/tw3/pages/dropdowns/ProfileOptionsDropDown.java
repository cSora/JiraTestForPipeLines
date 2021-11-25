package com.example.tw3.pages.dropdowns;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class ProfileOptionsDropDown {
    private final SelenideElement profileOption = $x("//a[@id='view_profile']");
    private final SelenideElement logoutOption = $x("//a[@id='log_out']");


    public SelenideElement getProfileOption() {
        return profileOption;
    }

    public SelenideElement getLogoutOption() { return logoutOption; }
}
