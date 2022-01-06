package com.example.tw3.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class IssuePage {
    private final SelenideElement detailsSection = $x("//ul[@id='issuedetails']");
    private final SelenideElement summaryValue = $x("//h1[@id='summary-val']");
    private final SelenideElement projectNameValue = $x("//a[@id='project-name-val']");
    private final SelenideElement typeValue = $x("//span[@id='type-val']");
    private final String username = System.getenv("username") == null ? System.getProperty("username") : System.getenv("username");
    private final SelenideElement reporterValue = $x("//span[@id='issue_summary_reporter_" + username + "']");
    private final SelenideElement moreBtn = $x("//a[@id='opsbar-operations_more']");
    private final SelenideElement cantViewIssueMessage = $x("//span[@class='error-image error-image-canNotBeViewed']");


    public SelenideElement getDetailsSection() {
        return detailsSection;
    }

    public SelenideElement getSummaryValue() {
        return summaryValue;
    }

    public SelenideElement getProjectNameValue() {
        return projectNameValue;
    }

    public SelenideElement getTypeValue() {
        return typeValue;
    }

    /** only use if you set an environment variable 'user'! (It's different from 'username') */
    public SelenideElement getReporterValue() {
        return reporterValue;
    }

    public SelenideElement getMoreBtn() {
        return moreBtn;
    }

    public SelenideElement getCantViewIssueMessage() {
        return cantViewIssueMessage;
    }

}
