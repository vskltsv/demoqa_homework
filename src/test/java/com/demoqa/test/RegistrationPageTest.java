package com.demoqa.test;

import com.demoqa.basetest.TestBaseClass;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.demoqa.utils.RandomUtils.*;
import static io.qameta.allure.Allure.step;

@Tag("remote")
public class RegistrationPageTest extends TestBaseClass {

    String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            email = faker.internet().emailAddress(),
            gender = getRandomGender(),
            phoneNumber = faker.phoneNumber().subscriberNumber(10),
            day = String.format("%02d", faker.number().numberBetween(1, 31)),
            month = getRandomMonth(),
            year = String.valueOf(getRandomInt(1990, 2023)),
            subject = getRandomSubject(),
            hobbies = getRandomHobbies(),
            picture = "picture.png",
            address = faker.address().fullAddress(),
            state = getRandomState(),
            city = getRandomCity(state);

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

