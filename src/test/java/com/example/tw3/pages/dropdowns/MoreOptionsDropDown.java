package com.example.tw3.pages.dropdowns;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MoreOptionsDropDown {
    private SelenideElement menu = $x("//aui-dropdown-menu[@id='opsbar-operations_more_drop']");
    private SelenideElement deleteOption = $x("//span[text()='Delete']/..");

    public SelenideElement getMenu() {
        return menu;
    }

    public SelenideElement getDeleteOption() {
        return deleteOption;
    }
}
