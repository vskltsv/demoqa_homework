package com.demoqa.baseTestClass;
import org.junit.jupiter.api.BeforeAll;
import static com.codeborne.selenide.Configuration.*;

public class TestBase {

        @BeforeAll
        static void beforeAll() {
            baseUrl = "https://demoqa.com";
            browserSize = "1920x1080";
            holdBrowserOpen = true;
            pageLoadStrategy = "eager";
            screenshots = false;
            savePageSource = false;
        }
    }

