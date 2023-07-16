package com.demoqa.test;

import com.codeborne.selenide.logevents.SelenideLogger;
import com.demoqa.attachments.Attachments;
import com.demoqa.pages.RegistrationPage;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBaseClass {
    TestData testData = new TestData();
    public RegistrationPage registrationPage = new RegistrationPage();
    @BeforeAll
    static void beforeAll() {

        browser = System.getProperty("browser", "chrome");
        browserSize = System.getProperty("browserSize", "1920x1080");
        browserVersion = System.getProperty("browserVersion", "100.0");
        baseUrl = System.getProperty("baseUrl", "https://demoqa.com");
        pageLoadStrategy = "eager";
        remote = System.getProperty("selenoid");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));

        browserCapabilities = capabilities;
    }
    @BeforeEach
    void addListener() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterEach
    void addAttachments() {
        Attachments.screenshotAs("Last screenshot");
        Attachments.pageSource();
        Attachments.browserConsoleLogs();
        Attachments.addVideo();

        closeWebDriver();
    }
}
