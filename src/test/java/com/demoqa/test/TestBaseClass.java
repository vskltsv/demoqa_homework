package com.demoqa.test;

import com.codeborne.selenide.logevents.SelenideLogger;
import com.demoqa.attachments.Attachments;
import com.demoqa.config.WebConfig;
import com.demoqa.pages.RegistrationPage;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBaseClass {
    static WebConfig config = ConfigFactory.create(WebConfig.class, System.getProperties());
    public RegistrationPage registrationPage = new RegistrationPage();

    @BeforeAll
    static void beforeAll() {

        baseUrl = config.baseUrl();
        browser = config.browser();
        browserVersion = config.browserVersion();
        pageLoadStrategy = "eager";
        browserSize = config.browserSize();
        if (config.isRemote()) {
            remote = config.remoteUrl();
        }

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of("enableVNC", true, "enableVideo", true));

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
