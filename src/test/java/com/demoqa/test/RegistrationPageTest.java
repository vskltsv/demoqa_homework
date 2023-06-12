package com.demoqa.test;

import com.demoqa.baseTestClass.TestBase;

import org.junit.jupiter.api.Test;
import com.demoqa.pages.RegistrationPage;

public class RegistrationPageTest extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void successfulRegistrationTest() {


        registrationPage
                .openPage()
                .closeBanners()
                .setFirsName("Vladimir")
                .setLastName("Sokoltsov")
                .setUserEmail("vs@mail.kz")
                .setGender("Male")
                .setUserNumber("8777009091")
                .setBirthDay("19", "December", "1995")
                .setSubject("Physics")
                .setHobbies("Sports")
                .setHobbies("Music")
                .selectPicture("picture.png")
                .setAddress("Almaty 123")
                .setState("NCR")
                .setCity("Gurgaon")
                .submitForm();

        registrationPage
                .verifyThanksText()
                .verifyResult("Student Name", "Vladimir Sokoltsov")
                .verifyResult("Student Email", "vs@mail.kz")
                .verifyResult("Gender", "Male")
                .verifyResult("Mobile", "8777009091")
                .verifyResult("Date of Birth", "19 December,1995")
                .verifyResult("Subjects", "Physics")
                .verifyResult("Hobbies", "Sports, Music")
                .verifyResult("Picture", "picture.png")
                .verifyResult("Address", "Almaty 123")
                .verifyResult("State and City", "NCR Gurgaon");
    }
}
