package com.demoqa.pages;

import com.codeborne.selenide.SelenideElement;
import com.demoqa.pages.components.CalendarComponent;
import com.demoqa.pages.components.VerifyResultsComponent;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    CalendarComponent calendar = new CalendarComponent();
    VerifyResultsComponent verifyResults = new VerifyResultsComponent();

    SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderValue = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            birthDayInput = $("#dateOfBirthInput"),
            hobbyCheckBox = $("#hobbiesWrapper"),
            subjectsInput = $("#subjectsInput"),
            subjectsMathInput = $("#react-select-2-option-0"),
            stateInput = $("#react-select-3-input"),
            cityInput = $("#react-select-4-input"),
            addressInput = $("#currentAddress"),
            selectPicture = $("#uploadPicture"),
            submitButton = $("#submit");


    public RegistrationPage openPage() {
        open("/automation-practice-form");
        return this;
    }

    public RegistrationPage closeBanners() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public RegistrationPage setFirsName(String name) {
        firstNameInput.setValue(name);
        return this;
    }

    public RegistrationPage setLastName(String lastName) {
        lastNameInput.setValue(lastName);
        return this;
    }

    public RegistrationPage setUserEmail(String email) {
        userEmailInput.setValue(email);
        return this;
    }

    public RegistrationPage setGender(String gender) {
        genderValue.$(byText(gender)).click();
        return this;
    }

    public RegistrationPage setUserNumber(String number) {
        userNumberInput.setValue(number);
        return this;
    }

    public RegistrationPage setHobbies(String hobby) {
        hobbyCheckBox.$(byText(hobby)).click();
        return this;
    }

    public RegistrationPage setBirthDay(String day, String month, String year) {
        birthDayInput.click();
        calendar.setDate(day, month, year);
        return this;
    }

    public RegistrationPage setSubject(String subject) {
        subjectsInput.setValue(subject);
        subjectsMathInput.click();
        return this;
    }

    public RegistrationPage setState(String state) {
        stateInput.setValue(state).pressEnter();
        return this;
    }

    public RegistrationPage setCity(String city) {
        cityInput.setValue(city).pressEnter();
        return this;
    }

    public RegistrationPage setAddress(String address) {
        addressInput.setValue(address);
        return this;
    }

    public RegistrationPage selectPicture(String filename) {
        selectPicture.uploadFromClasspath(filename);
        return this;
    }

    public RegistrationPage submitForm() {
        submitButton.click();
        return this;
    }

    public RegistrationPage verifyThanksText() {
        verifyResults.verifyThankText();
        return this;
    }

    public RegistrationPage verifyResult(String key, String value) {
        verifyResults.verifyResult(key, value);
        return this;
    }

}


