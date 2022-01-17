package com.example.tw3.utility;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.example.tw3.pages.DashBoardPage;
import com.example.tw3.pages.LoginPage;
import com.example.tw3.pages.LogoutPage;
import com.example.tw3.pages.SecondaryLoginPage;
import com.example.tw3.pages.dropdowns.ProfileOptionsDropDown;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Time;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

import static com.codeborne.selenide.Selenide.open;

public interface LoginLogOut {
    LoginPage loginPage = new LoginPage();
    LogoutPage logOutPage = new LogoutPage();
    SecondaryLoginPage secondaryLoginPage = new SecondaryLoginPage();
    DashBoardPage dashBoardPage = new DashBoardPage();
    ProfileOptionsDropDown profileOptionsDropDown = new ProfileOptionsDropDown();

    static void setDriver(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String gridUrl = "https://" + System.getProperty("gridUser") + ":"
                + System.getProperty("gridPassword") + "@seleniumhub.codecool.metastage.net/wd/hub";
        try {
            // Here we'll write our data into a file called
            // output.txt, this is the output.
            File file = new File("properties.txt");
            // We'll write the string below into the file
            String data = System.getProperty("browser") + "---->browser\n " +
                   gridUrl + "---->grid url\n " +
                    System.getProperty("baseUrl") +"---->base url\n" +
                    dtf.format(now)+"---->Current time";

            // To write a file called the writeStringToFile
            // method which require you to pass the file and
            // the data to be written.
            FileUtils.writeStringToFile(file, data, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        Configuration.baseUrl = System.getProperty("baseUrl");
//        Configuration.browserCapabilities = Objects.equals(System.getProperty("browser"), "chrome") ? new ChromeOptions() : new FirefoxOptions();
        Configuration.browser = System.getProperty("browser");
        Configuration.timeout = Long.parseLong(System.getProperty("timeout"));
        Configuration.remote = gridUrl;

    }


    static void loginPrimary(){
        setDriver();
        open(loginPage.url);
        if(System.getenv("username") == null) {
            loginPage.getUsernameField().sendKeys(System.getProperty("username"));
        } else {
            loginPage.getUsernameField().sendKeys(System.getenv("username"));
        }
        if (System.getenv("password") == null) {
            loginPage.getPasswordField().sendKeys(System.getProperty("password"));
        } else {
            loginPage.getPasswordField().sendKeys(System.getenv("password"));
        }
        loginPage.getLoginForm().submit();
    }

    static void loginSecondary(){
        setDriver();
        open(secondaryLoginPage.url);
        secondaryLoginPage.getUsernameField().sendKeys(System.getProperty("username"));
        secondaryLoginPage.getPasswordField().sendKeys(System.getProperty("password"));
        secondaryLoginPage.getLoginForm().submit();
    }

    static void logInWithWrongPassword(String password) {
        setDriver();
        open(loginPage.url);
        loginPage.getUsernameField().sendKeys(System.getProperty("username"));
        loginPage.getPasswordField().sendKeys(password == null ? "" : password);
        loginPage.getLoginForm().submit();
    }

    static void closeDriver(){
        WebDriverRunner.getWebDriver().close();
    }

    static void logout() {
        WebDriverWait wait = new WebDriverWait(WebDriverRunner.getWebDriver(), 5);
        dashBoardPage.getProfileBtn().click();
        wait.until(ExpectedConditions.visibilityOf(profileOptionsDropDown.getLogoutOption()));
        profileOptionsDropDown.getLogoutOption().click();
        wait.until(ExpectedConditions.visibilityOf(logOutPage.getAtlasssianLogo()));
        if(logOutPage.getMessageWindow1().isDisplayed()){
            logOutPage.getAltLogOutBtn().click();
        }
    }
}
