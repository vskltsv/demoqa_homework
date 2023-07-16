package com.demoqa.test;

import static com.demoqa.utils.RandomUtils.*;

public class TestData {

  public static  String firstName = faker.name().firstName(),
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
}
