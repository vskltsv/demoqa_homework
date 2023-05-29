package com.demoqa.test;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;



import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTests {


    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;

    }

    @Test
    void successTest() {

        String thanksText = "Thanks for submitting the form";

        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        $("#firstName").setValue("Vladimir");
        $("#lastName").setValue("Sokoltsov");
        $("#userEmail").setValue("vs@mail.kz");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("8777009091");
        $("#dateOfBirth-wrapper").$("#dateOfBirthInput").click();
        $("#dateOfBirth-wrapper").$(".react-datepicker__month-select").click();
        $("#dateOfBirth-wrapper").$(byText("December")).click();
        $("#dateOfBirth-wrapper").$(".react-datepicker__year-select").click();
        $("#dateOfBirth-wrapper").$(byText("1995")).click();
        $(".react-datepicker__day--019").click();
        $("#subjectsWrapper").$("#subjectsInput").setValue("c");
        $("#subjectsWrapper").$(byText("Physics")).click();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#hobbiesWrapper").$(byText("Music")).click();
        $("#uploadPicture").uploadFromClasspath("picture.png");
        $("#currentAddress").setValue("Almaty 123");
        $("#stateCity-wrapper").$("#state").click();
        $("#state").$(byText("NCR")).click();
        $("#stateCity-wrapper").$("#city").click();
        $("#city").$(byText("Gurgaon")).click();
        $("#submit").click();

        $(byText(thanksText)).shouldBe(Condition.visible);
        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text("Vladimir Sokoltsov"));
        $(".table-responsive").$(byText("Student Email")).parent().shouldHave(text("vs@mail.kz"));
        $(".table-responsive").$(byText("Gender")).parent().shouldHave(text("Male"));
        $(".table-responsive").$(byText("Mobile")).parent().shouldHave(text("8777009091"));
        $(".table-responsive").$(byText("Date of Birth")).parent().shouldHave(text("19 December,1995"));
        $(".table-responsive").$(byText("Subjects")).parent().shouldHave(text("Physics"));
        $(".table-responsive").$(byText("Hobbies")).parent().shouldHave(text("Sports, Music"));
        $(".table-responsive").$(byText("Picture")).parent().shouldHave(text("picture.png"));
        $(".table-responsive").$(byText("Address")).parent().shouldHave(text("Almaty 123"));
        $(".table-responsive").$(byText("State and City")).parent().shouldHave(text("NCR Gurgaon"));

    }

}