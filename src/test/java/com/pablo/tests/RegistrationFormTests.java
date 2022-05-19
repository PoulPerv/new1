package com.pablo.tests;

import com.codeborne.selenide.Configuration;
import com.pablo.data.Generator;
import com.pablo.pages.RegistrationFormPage;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static java.lang.String.format;

public class RegistrationFormTests {

    Generator gen = new Generator();
    String name = gen.getFirstName(),
            lastName = gen.getLastName(),
            email = gen.getEmail();
    LocalDate date = gen.getDate();
    String expectedMonth = StringUtils.capitalize(date.getMonth().toString().toLowerCase()); //Capitalized month name
    String expectedDate = format("%s %s,%s", date.getDayOfMonth(), expectedMonth, date.getYear());
    String      gender = gen.getGender(),
            hobby = gen.getHobby(),
            subject = gen.getSubject(),
            currentAddress = gen.getAddress();
    String state = gen.getState();
    String city = gen.getCity(state);
    String expectedFullName = format("%s %s", name, lastName);
    String mobile = gen.getPhoneNumber();
    String img = "cv.jpg";
    String expectedStateCity = format("%s %s", state, city);

    RegistrationFormPage registrationFormPage = new RegistrationFormPage();

    @BeforeAll
    static void setUp() {
        Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void fillFormTest() {

        registrationFormPage.openPage()
                .setFirstName(name)
                .setLastName(lastName)
                .setEmail(email)
                .setBirthDate(date)
                .setGender(gender)
                .setPhoneNumber(mobile)
                .setAddress(currentAddress)
                .setSubject(subject)
                .setHobby(hobby)
                .setStateAndCity(state, city)
                .uploadPicture(img)
                .submitForm();


        registrationFormPage.checkResult("Student Name", expectedFullName)
                .checkResult("Student Email", email)
                .checkResult("Gender", gender)
                .checkResult("Mobile", mobile)
                .checkResult("Date of Birth", expectedDate)
                .checkResult("Subjects", subject)
                .checkResult("Hobbies", hobby)
                .checkResult("Picture", img)
                .checkResult("Address", currentAddress)
                .checkResult("State and City", expectedStateCity);

    }
}

