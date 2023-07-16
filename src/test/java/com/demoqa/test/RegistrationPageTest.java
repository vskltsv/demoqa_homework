package com.demoqa.test;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;


import static com.demoqa.test.TestData.*;
import static io.qameta.allure.Allure.step;

@Tag("remote")
public class RegistrationPageTest extends TestBaseClass {



    @Test
    @Owner("Vladimir Sokoltsov")
    @DisplayName("Successful registration")
    void successfulRegistrationTest() {

        step("Fill results", () -> {
            registrationPage
                    .openPage()
                    .closeBanners()
                    .setFirsName(firstName)
                    .setLastName(lastName)
                    .setUserEmail(email)
                    .setGender(gender)
                    .setUserNumber(phoneNumber)
                    .setBirthDay(day, month, year)
                    .setSubject(subject)
                    .setHobbies(hobbies)
                    .selectPicture(picture)
                    .setAddress(address)
                    .setState(state)
                    .setCity(city)
                    .submitForm();
        });

        step("Verify form", () -> {
            registrationPage
                    .verifyThanksText()
                    .verifyResult("Student Name", firstName + " " + lastName)
                    .verifyResult("Student Email", email)
                    .verifyResult("Gender", gender)
                    .verifyResult("Mobile", phoneNumber)
                    .verifyResult("Date of Birth", day + " " + month + "," + year)
                    .verifyResult("Subjects", subject)
                    .verifyResult("Hobbies", hobbies)
                    .verifyResult("Picture", picture)
                    .verifyResult("Address", address)
                    .verifyResult("State and City", state + " " + city);
        });

    }
}

