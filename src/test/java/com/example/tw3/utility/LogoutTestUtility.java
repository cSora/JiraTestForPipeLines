package com.example.tw3.utility;

import com.codeborne.selenide.WebDriverRunner;
import com.example.tw3.pages.DashBoardPage;
import com.example.tw3.pages.LogoutPage;
import com.example.tw3.pages.ProfilePage;
import com.example.tw3.pages.dropdowns.ProfileOptionsDropDown;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;

import static com.codeborne.selenide.Selenide.open;

public class LogoutTestUtility {
    WebDriverWait wait;

    private final DashBoardPage dashBoardPage = new DashBoardPage();
    private final ProfileOptionsDropDown profileOptionsDropDown = new ProfileOptionsDropDown();
    private final LogoutPage logoutPage = new LogoutPage();
    private final ProfilePage profilePage = new ProfilePage();
    private final String[] multipleTab = new String[2];

    public void logout() {
        LoginLogOut.logout();
        }

    public boolean isMessageVisible() {
        wait = new WebDriverWait(WebDriverRunner.getWebDriver(), 5);
        wait.until(ExpectedConditions.visibilityOf(logoutPage.getAtlasssianLogo()));
        return logoutPage.getMessageWindow().isDisplayed();
    }

    public boolean isProfilePageAvailable() {
        open(profilePage.url);
        wait.withTimeout(Duration.ofSeconds(5));
        String expectedUrl = profilePage.url;
        String actualUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        System.out.println(expectedUrl.equals(actualUrl));
        return WebDriverRunner.getWebDriver().getCurrentUrl().equals(profilePage.url);
    }

    public void openNewTab(){
        multipleTab[0] = WebDriverRunner.getWebDriver().getCurrentUrl();
        multipleTab[1] = profilePage.url;

        try {
            Robot robot = new Robot();
            robot.setAutoDelay(250); // Never remove this! This is what makes the whole thing work
            robot.keyPress(KeyEvent.VK_ALT);
            robot.keyPress(KeyEvent.VK_D);
            robot.keyRelease(KeyEvent.VK_D);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ALT);
        } catch (AWTException e) {
            e.printStackTrace();
        }

        //Get all the handles currently available
        Set<String> allHandles = WebDriverRunner.getWebDriver().getWindowHandles();
        for(String actual: allHandles) {
            if(!actual.equalsIgnoreCase(WebDriverRunner.getWebDriver().getWindowHandle())) {
                //Switch to the opened tab
                WebDriverRunner.getWebDriver().switchTo().window(actual);
                //opening the URL saved.
                WebDriverRunner.getWebDriver().get(multipleTab[1]);
            }
        }
        WebDriverRunner.getWebDriver().navigate().to(multipleTab[1]);
    }

    public void switchToTab(int tab) {
        ArrayList<String> tabs2 = new ArrayList<> (WebDriverRunner.getWebDriver().getWindowHandles());
        WebDriverRunner.getWebDriver().switchTo().window(tabs2.get(tab));
    }

    public void refreshPage() {
        try {
            Robot robot = new Robot();
            robot.setAutoDelay(250); // Never remove this!
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_R);
            robot.keyRelease(KeyEvent.VK_R);
            robot.keyRelease(KeyEvent.VK_CONTROL);
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }
}
