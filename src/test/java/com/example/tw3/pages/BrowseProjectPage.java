package com.example.tw3.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class BrowseProjectPage {
    public final String url = "https://jira-auto.codecool.metastage.net/secure/BrowseProjects.jspa";
    SelenideElement mainTestingProjectLink = $x("//a[href='/browse/MTP']");
}
